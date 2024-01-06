import json
import jsonschema
import os
from concurrent.futures import ThreadPoolExecutor


def validate_json(file_path, schema):
    with open(file_path, 'r') as json_file:
        json_data = json.load(json_file)

    try:
        jsonschema.validate(json_data, schema)
        print(f"Validation passed for {file_path}")
    except jsonschema.ValidationError as e:
        print(f"Validation failed for {file_path}: {e}")


def main():
    json_files_directory = '/path/to/json/files/'

    # Specify the JSON schema for validation
    schema = {
        "type": "object",
        "properties": {
            "key1": {"type": "string"},
            "key2": {"type": "number"}
            # Add your JSON schema properties here
        },
        "required": ["key1", "key2"]
    }

    # Get a list of JSON files in the directory
    json_files = [f for f in os.listdir(json_files_directory) if f.endswith('.json')]

    # Use ThreadPoolExecutor to parallelize the validation process
    with ThreadPoolExecutor() as executor:
        # Pass each file path and the JSON schema to the thread pool
        executor.map(lambda file: validate_json(os.path.join(json_files_directory, file), schema), json_files)


if __name__ == "__main__":
    main()
