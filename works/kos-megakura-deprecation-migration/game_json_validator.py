import jsonschema as validator
import directory_utils as dir_utils
from concurrent.futures import ThreadPoolExecutor

game_specification_schema = {
    'type': 'object',
    'properties': {
        # 'schema': {'type': 'string'},
        # 'timestamp': {'type': 'string'},
        'appVersion': {'type': 'string'},
        'code': {'type': 'string'},
        'entitlementIds': {
            'type': 'array',
            'items': {'type': 'string'},
        },
        'hardwareType': {'type': 'string'},
        'inputTypes': {
            'type': 'array',
            'items': {'type': 'string'},
        },
        'minBandwidth': {'type': 'number'},
        'minFirmwareVersion': {'type': 'string'},
        'sdkVersion': {'type': 'string'},
        'minFps': {'type': 'number'},
        'parentalLevel': {'type': 'number'},
        'region': {'type': 'string'},
        'resolutions': {
            'type': 'array',
            'properties': {
                'height': {'type': 'string'},
                'width': {'type': 'string'}
            },
            'required': ['height', 'width']
        },
        'title': {'type': 'string'},
        'titleId': {'type': 'string'},
        'version': {'type': 'number'},
        'virtualizationType': {'type': 'string'},
        'deploymentEnvironment': {'type': 'string'},
    },
    'required': ['appVersion', 'code', 'entitlementIds', 'hardwareType', 'inputTypes', 'minBandwidth',
                 'minFirmwareVersion', 'sdkVersion', 'minFps', 'parentalLevel', 'region', 'resolutions', 'title',
                 'titleId', 'version', 'virtualizationType', 'deploymentEnvironment'],
}


def validate(data):
    try:
        validator.validate(instance=data, schema=game_specification_schema)
        return True
    except validator.exceptions.ValidationError as e:
        return False


def validate_json(f_path):
    game_json_str = dir_utils.get_json_file_data(path=f_path)
    result = validate(game_json_str)
    if result:
        return f'Success: {f_path}'
    else:
        return f'Error: {f_path}'


def main(json_files_directory):
    print('Started to process data validation...')
    # Get a list of JSON files in the directory
    json_files = [f for f in dir_utils.list_files(filepath=json_files_directory, filetype='.json') if
                  f.endswith('.json')]
    print(f'Total documents {len(json_files)}')
    # Use ThreadPoolExecutor to parallelize the validation process
    with ThreadPoolExecutor() as executor:
        # Pass each file path and the JSON schema to the thread pool
        result = executor.map(lambda file: validate_json(file), json_files)
        for r in result:
            if r.startswith('Error:'):
                print(r)
    print('Done..')


if __name__ == '__main__':
    PATH = '/Users/ravichandran/programs/gamejson/kos/kos/data'
    main(PATH)
