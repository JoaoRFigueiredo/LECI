#
#from django.http import JsonResponse
#from django.views.decorators.http import require_GET
#from pymongo import MongoClient

#@require_GET
#def get_concelhos_by_district(request, district_id):
#    client = MongoClient('<mongodb_uri>')
#    db = client['<mongodb_database_name>']
#    concelhos = list(db.regions.find({'nivel': 3, 'distrito': district_id}, {'concelho': 1, '_id': 0}))
#    print(concelhos)
#    client.close()
#    return JsonResponse(concelhos, safe=False)



#@require_GET
#def get_freguesias_by_concelho(request, concelho_id):
#    client = MongoClient('<mongodb_uri>')
#    db = client['<mongodb_database_name>']
#    freguesias = list(db.regions.find({'nivel': 3, 'concelho': concelho_id}, {'freguesia': 1, '_id': 0}))
#    print(freguesias)
#    client.close()
#    return JsonResponse(freguesias, safe=False)

from django.views.decorators.csrf import csrf_exempt
from django.http import JsonResponse
import json
from pymongo import MongoClient
#from myapp.models import Empresa  # Import the Empresa model from your app models.py file

@csrf_exempt
def regions_view(request):
    
    print(request)
    if request.method == 'POST':
        try:
         
            data = json.loads(request.body)
         
            user_email = data['user_email']
          
            print(data)
            
            client = MongoClient('mongodb://localhost:27017/')
            db = client['mydatabase']
            
            
            users = db['users']
          
            users.update_one(
                {'user_info.email': user_email}, {'$set': {'regions_details': data}}
            )
            
            return JsonResponse({'status': 'success'})
        except Exception as e:
            return JsonResponse({'status': 'error', 'message': str(e)})
    else:
        return JsonResponse({'status': 'error', 'message': 'Invalid request method'})
