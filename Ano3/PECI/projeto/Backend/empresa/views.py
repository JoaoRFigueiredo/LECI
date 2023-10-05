from django.views.decorators.csrf import csrf_exempt
from django.http import JsonResponse
import json
from pymongo import MongoClient


#@csrf_exempt
def empresa_view(request):
    
    print(request)
    if request.method == 'POST':
    	
        try:
            data = json.loads(request.body)
            
            user_email = data['user_email']

            print(data)
            
            client = MongoClient('mongodb://localhost:27017/')
            db = client['mydatabase']
            
            # Insert the user data into the 'users' collection
            # users = db['Empresas']
            # users.insert_one(data)
            # print(user_email)
            
            users = db['users']
            # doc = users.find({'user_info.email': user_email})
            # for c in doc:
            #     print(c['user_info'])
            users.update_one({'user_info.email': user_email}, {'$set': {'empresa_details': data}})
                
            return JsonResponse({'status': 'success'})
        except Exception as e:
            return JsonResponse({'status': 'error', 'message': str(e)})
    else:
        return JsonResponse({'status': 'error', 'message': 'Invalid request method'})
