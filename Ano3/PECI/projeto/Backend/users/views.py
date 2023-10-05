from django.shortcuts import render
from django.views.decorators.csrf import csrf_exempt
from django.http import JsonResponse
import json
from pymongo import MongoClient

# Create your views here.

@csrf_exempt
def register_user(request):
    if request.method == 'POST':
        # Parse the request body as JSON
        data = json.loads(request.body)

        print(data)

        
        # Connect to the MongoDB database
        client = MongoClient('mongodb://localhost:27017/')
        db = client['mydatabase']
        
        # Insert the user data into the 'users' collection
        users = db['users']
        user_id = users.insert_one({'user_info':data, 'empresa_details': {}, 'services':[]}).inserted_id
        
        # Return a JSON response with the user ID
        response_data = {'user_id': str(user_id)}
        return JsonResponse(response_data)
        
    
    # If the request is not a POST, return a 405 Method Not Allowed response
    return JsonResponse({'error': 'Method Not Allowed'}, status=405)



#função que devolve os dados do ultilizador
@csrf_exempt
def request_user_information(request):
    #print("estou cá")
    if request.method == 'GET':
        #data = json.loads(request.body)
        #print(request.GET.get('email'))



        email = request.GET.get('email')# let's use the person's email to perform a query on the db



        #db query
        client = MongoClient('mongodb://localhost:27017/')
        db = client['mydatabase']
        users = db['users']
        profile = users.find_one({"user_info.email": email})

        #print(profile)

        response_data = {
        'company_name': profile['empresa_details']['nome'],
        'company_phone': profile['empresa_details']['contacto'],
        'services_count': len(profile['services'])
        }

        return JsonResponse(response_data)


    return JsonResponse({'error': 'Method Not Allowed'}, status=405)