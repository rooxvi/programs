import pymongo


class MongoClientSingleton:
    _instance = None

    def __new__(cls, connection_string):
        if cls._instance is None:
            cls._instance = super().__new__(cls)
            cls._instance.client = pymongo.MongoClient(connection_string)
        return cls._instance

    def get_client(self):
        return self.client
