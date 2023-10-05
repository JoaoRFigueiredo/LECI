from django.shortcuts import render
from django.views.decorators.csrf import csrf_exempt
from django.http import JsonResponse
import json
import requests
from pymongo import MongoClient
from bson.objectid import ObjectId  # Import ObjectId from bson

# Create your views here.

@csrf_exempt
def insert_restaurant(request):
    if request.method == 'POST':
        #print((request.body))
        data = json.loads(request.body)

        try:
            data = json.loads(request.body)
            # print(data)
            data['tipo_servico'] = 'Restauracao'
            

            
            latitude = float(data['latitude'])
            longitude = float(data['longitude'])
            #print('https://json.geoapi.pt/gps/'+str(latitude)+', '+str(longitude)+'/base')
            response = requests.get('https://json.geoapi.pt/gps/'+str(latitude)+', '+str(longitude))
            
            resposta = json.loads(response.text)
            print(resposta)
            
            data['distrito'] = resposta['distrito']
            data['concelho'] = resposta['concelho']
            data['freguesia'] = resposta['freguesia']
            data['rua'] = 'nao_existente'
            #resposta['rua'] # sometimes this doesn't exist so i have to handle that

            if ('rua' in resposta):
                data['rua'] = resposta['rua'] # sometimes this doesn't exist so i have to handle that
            

            

            user_email = data['email'] # user's email, this way I know which user to


            client = MongoClient('mongodb://localhost:27017/')
            db = client['mydatabase']
            collection = db['Pendente']

            collection.insert_one(data)



            
            # # Insert the user data into the 'users' collection
            # services = db['Servicos']
            # users = db['users']
            # services.insert_one(data)
            # users.update_one({'user_info.email': user_email}, {'$push': {'services': {'$each': [data]}}})
            

            return JsonResponse({'status': 'success'})
        except Exception as e:
            return JsonResponse({'status': 'error', 'message': str(e)})
    else:
        return JsonResponse({'status': 'error', 'message': 'Invalid request method'})
    
@csrf_exempt
def insert_alojamento(request):
    if request.method == 'POST':
    	
        try:
            data = json.loads(request.body)
            data['tipo_servico'] = 'Alojamento'
            

            print(data)
            latitude = float(data['latitude'])
            longitude = float(data['longitude'])
            #print('https://json.geoapi.pt/gps/'+str(latitude)+', '+str(longitude)+'/base')
            response = requests.get('https://json.geoapi.pt/gps/'+str(latitude)+', '+str(longitude))
            
            resposta = json.loads(response.text)
            print(resposta)
            
            data['distrito'] = resposta['distrito']
            data['concelho'] = resposta['concelho']
            data['freguesia'] = resposta['freguesia']
            data['rua'] = 'nao_existente'
            #resposta['rua'] # sometimes this doesn't exist so i have to handle that

            if ('rua' in resposta):
                data['rua'] = resposta['rua'] # sometimes this doesn't exist so i have to handle that
            

            user_email = data['user_email'] # user's email, this way I know which user to


            client = MongoClient('mongodb://localhost:27017/')
            db = client['mydatabase']
            collection = db['Pendente']

            collection.insert_one(data)


            
            # Insert the user data into the 'users' collection
            # services = db['Servicos']
            # users = db['users']
            # services.insert_one(data)
            # users.update_one({'user_info.email': user_email}, {'$push': {'services': {'$each': [data]}}})
            


                
            return JsonResponse({'status': 'success'})
        except Exception as e:
            return JsonResponse({'status': 'error', 'message': str(e)})
    else:
        return JsonResponse({'status': 'error', 'message': 'Invalid request method'})
    

@csrf_exempt
def insert_monumentos(request):
    if request.method == 'POST':
    	
        try:
            data = json.loads(request.body)
            data['tipo_servico'] = 'Monumento'
            

            print(data)
            latitude = float(data['latitude'])
            longitude = float(data['longitude'])
            #print('https://json.geoapi.pt/gps/'+str(latitude)+', '+str(longitude)+'/base')
            response = requests.get('https://json.geoapi.pt/gps/'+str(latitude)+', '+str(longitude))
            
            resposta = json.loads(response.text)
            
            data['distrito'] = resposta['distrito']
            data['concelho'] = resposta['concelho']
            data['freguesia'] = resposta['freguesia']
            data['rua'] = 'nao_existente'
            #resposta['rua'] # sometimes this doesn't exist so i have to handle that

            if ('rua' in resposta):
                data['rua'] = resposta['rua'] # sometimes this doesn't exist so i have to handle that
            
            #print(data)

            user_email = data['user_email'] # user's email, this way I know which user to


            client = MongoClient('mongodb://localhost:27017/')
            db = client['mydatabase']
            collection = db['Pendente']

            collection.insert_one(data)


            
            # Insert the user data into the 'users' collection
            # services = db['Servicos']
            # users = db['users']
            # services.insert_one(data)
            # users.update_one({'user_info.email': user_email}, {'$push': {'services': {'$each': [data]}}})
            


                
            return JsonResponse({'status': 'success'})
        except Exception as e:
            return JsonResponse({'status': 'error', 'message': str(e)})
    else:
        return JsonResponse({'status': 'error', 'message': 'Invalid request method'})


#function to retrieve services of a given user
@csrf_exempt
def request_user_services(request):
    if request.method == 'GET':
        email = request.GET.get('email')

        #db query
        client = MongoClient('mongodb://localhost:27017/')
        db = client['mydatabase']
        users = db['users']
        profile = users.find_one({"user_info.email": email})

        services = profile.get('services', []) # Get the services list from the profile, or an empty list if it's not present

        # Convert each service's ObjectId to a string for serialization
        for service in services:
            service['_id'] = str(service['_id'])
        
        response_data = {
            'user_services': services
        }

        return JsonResponse(response_data)

    return JsonResponse({'error': 'Method Not Allowed'}, status=405)


#function to to update the user's restaurant (crud)
@csrf_exempt
def update_restaurant(request):
    if request.method == 'POST':
        data = json.loads(request.body)
        service_id = data['id']
        print(data.keys())

        client = MongoClient('mongodb://localhost:27017/')
        db = client['mydatabase']
        users = db['users']

        # Find the user with the matching service ID
        user = users.find_one({'services._id': ObjectId(service_id)})

        #print(user['services'])

        if user is not None:
            # Find the index of the service within the user's services list
            service_index = next((index for index, s in enumerate(user['services']) if str(s['_id']) == service_id), None)
            print(service_index)
            print(user['services'][0].keys())

            nData = {}
            nData['name'] = data['name']
            nData['latitude'] = data['latitude']
            nData['longitude'] = data['longitude']
            nData['tipoEstabelecimento'] = data['establishmentTypes']
            nData['imageDescriptions'] = data['imageDescriptions']
            nData['ementa'] = data['menu']
            nData['images'] = data['images']
            nData['hours'] = data['hours']
            nData['description'] = data['description']
            nData['promo'] = data['promo']
            nData['email'] = data['user_email']

            print(nData.keys())
            

            if service_index is not None:
                # Delete the service from the user's services list
                del user['services'][service_index]
                users.save(user)
                insert_restaurant_manualy(nData)
                
                return JsonResponse({'delete': 'deleted'})
            else:
                return JsonResponse({'error': 'Service not found'}, status=404)
        else:
            return JsonResponse({'error': 'User not found'}, status=404)

    return JsonResponse({'error': 'Method Not Allowed'}, status=405)



def insert_restaurant_manualy(dados):
        # print((request.body))
        data = dados

       
        data['tipo_servico'] = 'Restauracao'

        latitude = float(data['latitude'])
        longitude = float(data['longitude'])
        #print('https://json.geoapi.pt/gps/'+str(latitude)+', '+str(longitude)+'/base')
        response = requests.get('https://json.geoapi.pt/gps/'+str(latitude)+', '+str(longitude))
        print(response)
        resposta = json.loads(response.text)
        
        data['distrito'] = resposta['distrito']
        data['concelho'] = resposta['concelho']
        data['freguesia'] = resposta['freguesia']
        data['rua'] = 'nao_existente'
            #resposta['rua'] # sometimes this doesn't exist so i have to handle that

        if ('rua' in resposta):
            data['rua'] = resposta['rua'] # sometimes this doesn't exist so i have to handle that
        delete_existing_services(latitude, longitude)

        user_email = data['email'] # user's email, this way I know which user to


        client = MongoClient('mongodb://localhost:27017/')
        db = client['mydatabase']

        
        # Insert the user data into the 'users' collection
        services = db['Servicos']
        users = db['users']
        services.insert_one(data)
        users.update_one({'user_info.email': user_email}, {'$push': {'services': {'$each': [data]}}})
            

def delete_existing_services(latitude, longitude):
    client = MongoClient('mongodb://localhost:27017/')
    db = client['mydatabase']
    services = db['Servicos']
    
    matching_services = []
    
    for service in services.find({'latitude': str(latitude)}):
        if service['longitude'].strip() == str(longitude):
            matching_services.append(service)
    
    # print("Matching services:")
    # for service in matching_services:
    #     print(service)
    # print(len(matching_services))
    
    try:
        if matching_services:
            for service in matching_services:
                result = services.delete_one({'_id': service['_id']})
            print(f"{len(matching_services)} service(s) deleted")
        else:
            print("No matching services found for deletion.")
    except Exception as e:
        print(f"An error occurred during deletion: {str(e)}")


#function to to update the user's accomodation (crud)
@csrf_exempt
def update_accomodation(request):
    if request.method == 'POST':
        data = json.loads(request.body)
        service_id = data['id']
        print(data.keys())
        print(data['promo'])

        client = MongoClient('mongodb://localhost:27017/')
        db = client['mydatabase']
        users = db['users']

        # Find the user with the matching service ID
        user = users.find_one({'services._id': ObjectId(service_id)})

        #print(user['services'])

        if user is not None:
            # Find the index of the service within the user's services list
            service_index = next((index for index, s in enumerate(user['services']) if str(s['_id']) == service_id), None)
            print(service_index)
            print(user['services'][0].keys())

            nData = {}
            nData['name'] = data['name']
            nData['latitude'] = data['latitude']
            nData['longitude'] = data['longitude']
            nData['bedroom_prices'] = data['bedroomPrices']
            nData['bedroom_type'] = data['bedroomType']
            nData['services'] = data['services']
            nData['image_descriptions'] = data['imageDescriptions']
            nData['images'] = data['images']
            nData['description'] = data['description']
            nData['user_email'] = data['user_email']
            nData['promo'] = data['promo']

            print(nData.keys())
            

            if service_index is not None:
                # Delete the service from the user's services list
                del user['services'][service_index]
                users.save(user)
                insert_alojamento_manualy(nData)
                
                return JsonResponse({'delete': 'deleted'})
            else:
                return JsonResponse({'error': 'Service not found'}, status=404)
        else:
            return JsonResponse({'error': 'User not found'}, status=404)

    return JsonResponse({'error': 'Method Not Allowed'}, status=405)


def insert_alojamento_manualy(dados):
        # print((request.body))
        data = dados
        print(dados.keys())
       
        data['tipo_servico'] = 'Alojamento'

        latitude = float(data['latitude'])
        longitude = float(data['longitude'])
        #print('https://json.geoapi.pt/gps/'+str(latitude)+', '+str(longitude)+'/base')
        response = requests.get('https://json.geoapi.pt/gps/'+str(latitude)+', '+str(longitude))
        print(response)
        resposta = json.loads(response.text)
        
        data['distrito'] = resposta['distrito']
        data['concelho'] = resposta['concelho']
        data['freguesia'] = resposta['freguesia']
        data['rua'] = 'nao_existente'
            #resposta['rua'] # sometimes this doesn't exist so i have to handle that

        if ('rua' in resposta):
            data['rua'] = resposta['rua'] # sometimes this doesn't exist so i have to handle that
        delete_existing_services_acc(latitude, longitude)

        user_email = data['user_email'] # user's email, this way I know which user to


        client = MongoClient('mongodb://localhost:27017/')
        db = client['mydatabase']

        
        # Insert the user data into the 'users' collection
        services = db['Servicos']
        users = db['users']
        services.insert_one(data)
        users.update_one({'user_info.email': user_email}, {'$push': {'services': {'$each': [data]}}})
            

def delete_existing_services_acc(latitude, longitude):
    client = MongoClient('mongodb://localhost:27017/')
    db = client['mydatabase']
    services = db['Servicos']
    
    matching_services = []
    
    for service in services.find({'latitude': str(latitude)}):
        if service['longitude'].strip() == str(longitude):
            matching_services.append(service)
    
    # print("Matching services:")
    # for service in matching_services:
    #     print(service)
    # print(len(matching_services))
    
    try:
        if matching_services:
            for service in matching_services:
                result = services.delete_one({'_id': service['_id']})
            print(f"{len(matching_services)} service(s) deleted")
        else:
            print("No matching services found for deletion.")
    except Exception as e:
        print(f"An error occurred during deletion: {str(e)}")


        #function to to update the user's accomodation (crud)
@csrf_exempt
def update_monument(request):
    if request.method == 'POST':
        data = json.loads(request.body)
        service_id = data['id']
        print(data.keys())

        client = MongoClient('mongodb://localhost:27017/')
        db = client['mydatabase']
        users = db['users']

        # Find the user with the matching service ID
        user = users.find_one({'services._id': ObjectId(service_id)})

        #print(user['services'])

        if user is not None:
            # Find the index of the service within the user's services list
            service_index = next((index for index, s in enumerate(user['services']) if str(s['_id']) == service_id), None)
            print(service_index)
            print(user['services'][0].keys())

            nData = {}
            nData['name'] = data['name']
            nData['latitude'] = data['latitude']
            nData['longitude'] = data['longitude']
            nData['story'] = data['story']
            nData['style'] = data['style']
            nData['accessability'] = data['accessibility']
            nData['imageDescriptions'] = data['imageDescriptions']
            nData['images'] = data['images']
            nData['price'] = data['price']
            nData['schedule'] = data['schedule']
            nData['activity'] = data['activity']
            nData['guide_visit'] = data['guideVisit']
            nData['user_email'] = data['user_email']

            print(nData.keys())
            

            if service_index is not None:
                # Delete the service from the user's services list
                del user['services'][service_index]
                users.save(user)
                insert_monument_manualy(nData)
                
                return JsonResponse({'delete': 'deleted'})
            else:
                return JsonResponse({'error': 'Service not found'}, status=404)
        else:
            return JsonResponse({'error': 'User not found'}, status=404)

    return JsonResponse({'error': 'Method Not Allowed'}, status=405)


def insert_monument_manualy(dados):
        # print((request.body))
        data = dados

       
        data['tipo_servico'] = 'Monumento'

        latitude = float(data['latitude'])
        longitude = float(data['longitude'])
        #print('https://json.geoapi.pt/gps/'+str(latitude)+', '+str(longitude)+'/base')
        response = requests.get('https://json.geoapi.pt/gps/'+str(latitude)+', '+str(longitude))
        print(response)
        resposta = json.loads(response.text)
        
        data['distrito'] = resposta['distrito']
        data['concelho'] = resposta['concelho']
        data['freguesia'] = resposta['freguesia']
        data['rua'] = 'nao_existente'
        #resposta['rua'] # sometimes this doesn't exist so i have to handle that

        if ('rua' in resposta):
            data['rua'] = resposta['rua'] # sometimes this doesn't exist so i have to handle that
        delete_existing_services_mon(latitude, longitude)

        user_email = data['user_email'] # user's email, this way I know which user to


        client = MongoClient('mongodb://localhost:27017/')
        db = client['mydatabase']

        
        # Insert the user data into the 'users' collection
        services = db['Servicos']
        users = db['users']
        services.insert_one(data)
        users.update_one({'user_info.email': user_email}, {'$push': {'services': {'$each': [data]}}})
            

def delete_existing_services_mon(latitude, longitude):
    client = MongoClient('mongodb://localhost:27017/')
    db = client['mydatabase']
    services = db['Servicos']
    
    matching_services = []
    
    for service in services.find({'latitude': str(latitude)}):
        if service['longitude'].strip() == str(longitude):
            matching_services.append(service)
    
    # print("Matching services:")
    # for service in matching_services:
    #     print(service)
    # print(len(matching_services))
    
    try:
        if matching_services:
            for service in matching_services:
                result = services.delete_one({'_id': service['_id']})
            print(f"{len(matching_services)} service(s) deleted")
        else:
            print("No matching services found for deletion.")
    except Exception as e:
        print(f"An error occurred during deletion: {str(e)}")



@csrf_exempt
def pending_services(request):
    if request.method == 'GET':
        try:
            # Connect to MongoDB
            client = MongoClient('mongodb://localhost:27017/')
            db = client['mydatabase']
            collection = db['Pendente']
            
            # Retrieve all documents from the "Pendente" collection
            services = list(collection.find())
            #print(services)
            # Convert ObjectId to string representation
            for service in services:
                service['_id'] = str(service['_id'])
            
            # Close the MongoDB connection
            client.close()
            
            #print(services)
            response_data ={'pending_services': services}
            # Return the retrieved services as JSON response
            return JsonResponse(response_data)
        
        except Exception as e:
            return JsonResponse({'error': str(e)}, status=500)
    
    return JsonResponse({'error': 'Invalid request method.'}, status=405)



from pymongo import MongoClient
from django.http import JsonResponse
import json

@csrf_exempt
def service_denied(request):
    if request.method == 'POST':
        # Connect to MongoDB
        client = MongoClient('mongodb://localhost:27017/')
        db = client['mydatabase']
        collection = db['Pendente']

        data = json.loads(request.body)

        # Service was denied, therefore, it's going to be removed from the Pendente collection
        object_id = ObjectId(data['id'])
        result = collection.delete_one({'_id': object_id})

        if result.deleted_count == 1:
            return JsonResponse({'answer': 'Object deleted successfully.'})
        else:
            return JsonResponse({'answer': 'Object not found.'})

    return JsonResponse({'error': 'Invalid request method.'}, status=405)



@csrf_exempt
def service_approved(request):
    if request.method == 'POST':
        # Connect to MongoDB
        client = MongoClient('mongodb://localhost:27017/')
        db = client['mydatabase']
        collection = db['Pendente']

        data = json.loads(request.body)
        print(data.keys())

        # Service was approved therefore it should be taken out of the Pendente collection 
        #nd added to the users'one and appened to it's list of services
        object_id = ObjectId(data['id'])
        result = collection.delete_one({'_id': object_id})


        newData = {}
        if data['serviceType'] == 'Restauracao':
            newData['name'] = data['name']
            newData['tipoEstabelecimento'] = data['establishmentTypes']
            newData['ementa'] = data['menu']
            newData['hours'] = data['hours']
            newData['description'] = data['description']
            newData['images'] = data['images']
            newData['imageDescriptions'] = data['imageDescriptions']
            newData['latitude'] = data['latitude']
            newData['longitude'] = data['longitude']
            newData['promo'] = data['promo']
            newData['email'] = data['email']
            newData['tipo_servico'] = data['serviceType']
            newData['distrito'] = data['district']
            newData['concelho'] = data['county']
            newData['freguesia'] = data['parish']
            newData['rua'] = data['street']

        elif data['serviceType'] == 'Alojamento':
            newData['name'] = data['name']
            newData['description'] = data['description']
            newData['bedroom_type'] = data['bedroomType']
            newData['bedroom_prices'] = data['bedroomPrices']
            newData['services'] = data['services']
            newData['latitude'] = data['latitude']
            newData['longitude'] = data['longitude']
            newData['images'] = data['images']
            newData['latitude'] = data['latitude']
            newData['longitude'] = data['longitude']
            newData['image_descriptions'] = data['imageDescriptions']
            newData['user_email'] = data['userEmail']
            newData['promo'] = data['promo']
            newData['tipo_servico'] = data['serviceType']
            newData['distrito'] = data['district']
            newData['concelho'] = data['county']
            newData['freguesia'] = data['parish']
            newData['rua'] = data['street']

        elif data['serviceType'] == 'Monumento':
            newData['name'] = data['name']
            newData['latitude'] = data['latitude']
            newData['longitude'] = data['longitude']
            newData['story'] = data['story']
            newData['style'] = data['style']
            newData['accessability'] = data['accessibility']
            newData['imageDescriptions'] = data['imageDescriptions']
            newData['images'] = data['images']
            newData['price'] = data['price']
            newData['schedule'] = data['schedule']
            newData['activity'] = data['activity']
            newData['guide_visit'] = data['guideVisit']
            newData['user_email'] = data['userEmail']
            newData['tipo_servico'] = data['serviceType']
            newData['distrito'] = data['district']
            newData['concelho'] = data['county']
            newData['freguesia'] = data['parish']
            newData['rua'] = data['street']
            
        # Insert the user data into the 'users' collection
        services = db['Servicos']
        users = db['users']
        services.insert_one(newData)
        users.update_one({'user_info.email': data['userEmail']}, {'$push': {'services': {'$each': [newData]}}})

        if result.deleted_count == 1:
            return JsonResponse({'answer': 'Object deleted successfully.'})
        else:
            return JsonResponse({'answer': 'Object not found.'})
    
        

    return JsonResponse({'error': 'Invalid request method.'}, status=405)


@csrf_exempt
def service_removed(request):
    if request.method == 'POST':
        # Connect to MongoDB
        client = MongoClient('mongodb://localhost:27017/')
        db = client['mydatabase']
        users = db['users']
        services = db['Servicos']
        data = json.loads(request.body)
        print(data)
        service_id = data['id']

        user_email = data.get('email') or data.get('userEmail', '')


        #remove from the user:
        # Find the user with the matching service ID
        user = users.find_one({'services._id': ObjectId(service_id)})
        print(user['services'])

        #print(user['services'])

        if user is not None:
            # Find the index of the service within the user's services list
            service_index = next((index for index, s in enumerate(user['services']) if str(s['_id']) == service_id), None)
            print(service_index)
            if service_index is not None:
                    # Delete the service from the user's services list
                    del user['services'][service_index]
                    users.save(user)
    
        #now remove from the servicos collection:
        latitude = data['latitude']
        longitude = data['longitude']
        matching_services = []
    
        for service in services.find({'latitude': str(latitude)}):
            if service['longitude'].strip() == str(longitude):
                matching_services.append(service)

        try:
                if matching_services:
                    for service in matching_services:
                        result = services.delete_one({'_id': service['_id']})
                    print(f"{len(matching_services)} service(s) deleted")
                else:
                    print("No matching services found for deletion.")
        except Exception as e:
            print(f"An error occurred during deletion: {str(e)}")
        
        return JsonResponse({'answer': 'Object deleted successfully.'})

    return JsonResponse({'error': 'Invalid request method.'}, status=405)