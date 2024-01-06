from game_json_validator import validate


def source_validate(path, dir_utils=None):
    error_titles = []
    for f_path in dir_utils.list_files(filepath=path, filetype='.json'):
        game_json_str = dir_utils.get_json_file_data(path=f_path)
        result = validate(game_json_str)
        if not result:
            error_titles.append(f_path)
    if len(error_titles) > 0:
        for error_path in error_titles:
            print(f'Error file path: {error_path}')