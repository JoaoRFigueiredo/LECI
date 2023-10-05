from django.shortcuts import render
from django.views.decorators.csrf import csrf_exempt
from django.http import JsonResponse
import json
import requests
from pymongo import MongoClient


# Create your views here.

##############
###distrito###
##############
@csrf_exempt
def services_by_distrito_tipo(request, distrito, tipo=None):
    if request.method == 'GET':
        # distrito = request.GET.get('distrito')
        # tipo = request.GET.get('tipo')
        client = MongoClient('mongodb://localhost:27017/')
        db = client['mydatabase']
        services = db['Servicos']
        services_to_return = []
        
        query = {'distrito': distrito}
        if tipo:
            query['tipo_servico'] = tipo

        result = services.find(query)
        result_list = list(result)
        for x in result_list:
            x['_id'] = str(x['_id'])
            services_to_return.append(x)
        
        print(len(services_to_return))
        if len(services_to_return) == 0:
            response_data = {
                'Error': 'No services found'
            }
        else:
            response_data = {
                'district_services': services_to_return
            }

        return JsonResponse(response_data)
    return JsonResponse({'error': 'Method Not Allowed'}, status=405)

@csrf_exempt
def services_by_distrito(request, distrito):
    if request.method == 'GET':
        # distrito = request.GET.get('distrito')
        # tipo = request.GET.get('tipo')
        client = MongoClient('mongodb://localhost:27017/')
        db = client['mydatabase']
        services = db['Servicos']
        services_to_return = []
        
        query = {'distrito': distrito}
        

        result = services.find(query)
        result_list = list(result)
        for x in result_list:
            x['_id'] = str(x['_id'])
            services_to_return.append(x)
        
        print(len(services_to_return))
        if len(services_to_return) == 0:
            response_data = {
                'Error': 'No services found'
            }
        else:
            response_data = {
                'district_services': services_to_return
            }

        return JsonResponse(response_data)
    return JsonResponse({'error': 'Method Not Allowed'}, status=405)

##############
###Concelho###
##############
@csrf_exempt
def services_by_concelho_tipo(request, concelho, tipo=None):
    if request.method == 'GET':
        # distrito = request.GET.get('distrito')
        # tipo = request.GET.get('tipo')
        client = MongoClient('mongodb://localhost:27017/')
        db = client['mydatabase']
        services = db['Servicos']
        services_to_return = []
        
        query = {'concelho': concelho}
        if tipo:
            query['tipo_servico'] = tipo

        result = services.find(query)
        result_list = list(result)
        for x in result_list:
            x['_id'] = str(x['_id'])
            services_to_return.append(x)
        
        print(len(services_to_return))
        if len(services_to_return) == 0:
            response_data = {
                'Error': 'No services found'
            }
        else:
            response_data = {
                'district_services': services_to_return
            }

        return JsonResponse(response_data)
    return JsonResponse({'error': 'Method Not Allowed'}, status=405)

@csrf_exempt
def services_by_concelho(request, concelho):
    if request.method == 'GET':
        # distrito = request.GET.get('distrito')
        # tipo = request.GET.get('tipo')
        client = MongoClient('mongodb://localhost:27017/')
        db = client['mydatabase']
        services = db['Servicos']
        services_to_return = []
        
        query = {'concelho': concelho}
        

        result = services.find(query)
        result_list = list(result)
        for x in result_list:
            x['_id'] = str(x['_id'])
            services_to_return.append(x)
        
        print(len(services_to_return))
        if len(services_to_return) == 0:
            response_data = {
                'Error': 'No services found'
            }
        else:
            response_data = {
                'district_services': services_to_return
            }

        return JsonResponse(response_data)
    return JsonResponse({'error': 'Method Not Allowed'}, status=405)


##############
###Freguesia###
##############
@csrf_exempt
def services_by_freguesia_tipo(request, freguesia, tipo=None):
    if request.method == 'GET':
        # distrito = request.GET.get('distrito')
        # tipo = request.GET.get('tipo')
        client = MongoClient('mongodb://localhost:27017/')
        db = client['mydatabase']
        services = db['Servicos']
        services_to_return = []
        
        query = {'freguesia': freguesia}
        if tipo:
            query['tipo_servico'] = tipo

        result = services.find(query)
        result_list = list(result)
        for x in result_list:
            x['_id'] = str(x['_id'])
            services_to_return.append(x)
        
        print(len(services_to_return))
        if len(services_to_return) == 0:
            response_data = {
                'Error': 'No services found'
            }
        else:
            response_data = {
                'district_services': services_to_return
            }

        return JsonResponse(response_data)
    return JsonResponse({'error': 'Method Not Allowed'}, status=405)

@csrf_exempt
def services_by_freguesia(request, freguesia):
    if request.method == 'GET':
        # distrito = request.GET.get('distrito')
        # tipo = request.GET.get('tipo')
        client = MongoClient('mongodb://localhost:27017/')
        db = client['mydatabase']
        services = db['Servicos']
        services_to_return = []
        
        query = {'freguesia': freguesia}
        

        result = services.find(query)
        result_list = list(result)
        for x in result_list:
            x['_id'] = str(x['_id'])
            services_to_return.append(x)
        
        print(len(services_to_return))
        if len(services_to_return) == 0:
            response_data = {
                'Error': 'No services found'
            }
        else:
            response_data = {
                'district_services': services_to_return
            }

        return JsonResponse(response_data)
    return JsonResponse({'error': 'Method Not Allowed'}, status=405)

