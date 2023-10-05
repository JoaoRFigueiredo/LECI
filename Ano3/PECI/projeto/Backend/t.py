from pymongo import MongoClient

def delete_existing_services(latitude, longitude):
    client = MongoClient('mongodb://localhost:27017/')
    db = client['mydatabase']
    services = db['Servicos']

    try:
        result = services.delete_many({'latitude': str(latitude), 'longitude': str(longitude)})
        print(f"{result.deleted_count} service(s) deleted")
    except Exception as e:
        print(f"An error occurred during deletion: {str(e)}")

# Call the function with latitude and longitude values
delete_existing_services(40.67898180609411, -7.904348731239755)

