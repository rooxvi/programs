import pymongo.errors

import mongo_client

DATABASE_NAME = 'tdms-poa'
COLLECTIONS_NAME = 'catalogue'
MONGO_URI = "mongodb://localhost:27017?retryWrites=true&w=majority"
mongo_singleton = mongo_client.MongoClientSingleton(MONGO_URI)

client = mongo_singleton.get_client()
db = client[DATABASE_NAME]
catalogue_collection = db[COLLECTIONS_NAME]


def update_catalogue_deployment_strategy():
    filter_criteria = {"hwType": "KRATOS", "deploymentStrategy": "PUSH"}
    update_operation = {"$set": {"deploymentStrategy": "PULL"}}
    result = update_catalogue_many(filter_criteria=filter_criteria, update_operation=update_operation)
    print(f'{result} documents are updated successfully')
    return result


def count_documents():
    filter_criteria = {"hwType": "KRATOS", "deploymentStrategy": "PUSH"}
    result = document_count_catalogue_pull(filter_criteria=filter_criteria)
    return result


def update_catalogue_many(filter_criteria, update_operation):
    try:
        result = catalogue_collection.update_many(filter=filter_criteria, update=update_operation)
        return result.modified_count
    except pymongo.errors.PyMongoError as e:
        print('Something went wrong while updating catalogue collections')
        print(str(e))


def document_count_catalogue_pull(filter_criteria):
    try:
        result = catalogue_collection.count_documents(filter=filter_criteria)
        return result
    except pymongo.errors.PyMongoError as e:
        print('Something went wrong while updating catalogue collections')
        print(str(e))


if __name__ == '__main__':
    print(f'Total document count is {count_documents()}')
   # update_catalogue_deployment_strategy()
    # print(f'Total document count is {count_documents()}')
    pass
