import json
import os


def list_files(filepath, filetype):
    paths = []
    for root, dirs, files in os.walk(filepath):
        for file in files:
            if file.lower().endswith(filetype.lower()) and root.endswith('gameJson'):
                paths.append(os.path.join(root, file))
    return paths


def list_game_titles(path):
    titles = []
    if not is_empty(path):
        titles = os.listdir(path)
    return titles


def get_json_file_data(path):
    if os.path.isfile(path):
        try:
            with open(path, 'r') as f:
                return json.load(f)
        except Exception as e:
            print(str(e))
    return None


def is_empty(directory):
    for root, d_names, f_names in os.walk(directory):
        if (len(d_names)) > 0:
            return False
    return True
