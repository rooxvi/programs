import pymongo.errors

import mongo_client

DATABASE_NAME = 'kos_mk_deprecation'
COLLECTIONS_NAME = 'gamejson_migration'
MONGO_URI = "mongodb://localhost:27017?retryWrites=true&w=majority"
mongo_singleton = mongo_client.MongoClientSingleton(MONGO_URI)

client = mongo_singleton.get_client()
db = client[DATABASE_NAME]
game_json = db[COLLECTIONS_NAME]


def update_many(docs: dict):
    if len(docs) == 0:
        return 0
    try:
        return game_json.insert_many(docs)
    except pymongo.errors.PyMongoError as e:
        print(str(e))


def update_status(docs: dict):
    update_operation = {"$set": {"status": "Processed"}}
    result = game_json.update_many({"_id": {"$in": [doc["_id"] for doc in docs]}}, update_operation)
    return result.modified_count


def get_count(filter_criteria):
    return game_json.count_documents(filter=filter_criteria)


def get_docs(filter_criteria, offset, limit):
    batch_documents = game_json.find(filter_criteria).skip(offset).limit(limit)
    return batch_documents
