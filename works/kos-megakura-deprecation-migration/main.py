# Collect all titles from directory and store it in file
# Read all titles and move json to game_specification
import uuid

import directory_utils as dir_utils
import game_json_validator as validator
import game_specification as game_spec
import game_json_migration as gs


def collect_titles(path, jobid):
    titles: list = []
    try:
        for f_path in dir_utils.list_files(filepath=path, filetype='.json'):
            title = {"job_id": jobid, "file_path": f_path, "status": "Pending"}
            titles.append(title)
            if len(titles) == 100:
                gs.update_many(docs=titles)
                titles = {}

        if len(titles) > 0:
            gs.update_many(docs=titles)
        print(f'Data migration started: job id {jobid}')
    except Exception as e:
        print(str(e))


def source_validate(titles):
    error_titles = []
    for title in titles:
        f_path = title['file_path']
        game_json_str = dir_utils.get_json_file_data(path=f_path)
        result = validator.validate(game_json_str)
        if not result:
            error_titles.append(f_path)
    if len(error_titles) > 0:
        for error_path in error_titles:
            print(f'Error file path: {error_path}')
        return False
    return True


def process(titles):
    batch_game_json: list = []
    ids: list = []
    for title in titles:
        f_path = title['file_path']
        game_json_dict = dir_utils.get_json_file_data(path=f_path)
        if game_json_dict is None:
            continue
        hw_type = game_json_dict['hardwareType']
        if hw_type is not None:
            game_json_dict['hardwareType'] = trans_hw_type(hw_type)
        vir_type = game_json_dict['virtualizationType']
        if vir_type is not None:
            game_json_dict['virtualizationType'] = vir_type.upper()
        if game_json_dict.get("streamState") is None or game_json_dict.get("streamState") == 'NORMAL':
            game_json_dict['streamState'] = 'STREAM_STATE_NORMAL'
        elif game_json_dict['streamState'] == 'RESTRICT':
            game_json_dict['streamState'] = 'STREAM_STATE_RESTRICTED'
        else:
            pass
        game_json_dict.pop('schema')
        game_json_dict.pop('timestamp')
        game_spec_json = {"game": game_json_dict}
        batch_game_json.append(game_spec_json)
        ids.append(title)
        if len(batch_game_json) == 100:
            game_spec.inset_many(batch_game_json)
            gs.update_status(ids)
            batch_game_json.clear()
            ids = []
    if len(batch_game_json) > 0:
        print('Insert remaining data...')
        game_spec.inset_many(batch_game_json)
        gs.update_status(ids)

    print("Processed")


def trans_hw_type(hw_type):
    hw_type_enum = []
    if hw_type:
        string_array = hw_type.split(',')
        hw_type_enum = [word.upper() for word in string_array]
    return hw_type_enum


if __name__ == '__main__':
    PATH = '/Users/ravichandran/programs/gamejson/kos/kos/data'
    job_id = str(uuid.uuid4())
    collect_titles(PATH, job_id)
    filter_criteria = {"job_id": job_id, "status": "Pending"}
    total_count = gs.get_count(filter_criteria)
    batch_size = 100
    for i in range(0, total_count, batch_size):
        batch_documents = gs.get_docs(filter_criteria=filter_criteria, offset=i, limit=batch_size)
        process(batch_documents)
    print(f'Done...')
