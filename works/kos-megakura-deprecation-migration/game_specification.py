import pymongo.errors

import mongo_client

DATABASE_NAME = 'tdms-poa'
COLLECTIONS_NAME = 'game_specification'
MONGO_URI = "mongodb://localhost:27017?retryWrites=true&w=majority"
mongo_singleton = mongo_client.MongoClientSingleton(MONGO_URI)

client = mongo_singleton.get_client()
db = client[DATABASE_NAME]
game_specification = db[COLLECTIONS_NAME]


def update_many(docs: dict):
    if len(docs) == 0:
        return 0
    try:
        return game_specification.update_many(docs)
    except pymongo.errors.PyMongoError as e:
        print(str(e))


def inset_many(docs: dict):
    if len(docs) == 0:
        return 0
    try:
        return game_specification.insert_many(docs)
    except pymongo.errors.PyMongoError as e:
        print(str(e))
