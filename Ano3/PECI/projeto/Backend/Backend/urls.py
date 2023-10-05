"""Backend URL Configuration

The `urlpatterns` list routes URLs to views. For more information please see:
    https://docs.djangoproject.com/en/4.1/topics/http/urls/
Examples:
Function views
    1. Add an import:  from my_app import views
    2. Add a URL to urlpatterns:  path('', views.home, name='home')
Class-based views
    1. Add an import:  from other_app.views import Home
    2. Add a URL to urlpatterns:  path('', Home.as_view(), name='home')
Including another URLconf
    1. Import the include() function: from django.urls import include, path
    2. Add a URL to urlpatterns:  path('blog/', include('blog.urls'))
"""


from django.contrib import admin
from django.urls import path, include, re_path
from . import views
from regions.views import *
from api.views import *
from empresa.views import *
from users.views import *
from services.views import *

urlpatterns = [
    re_path('admin/', admin.site.urls),
    re_path('services/restaurants', insert_restaurant, name='service_restaurant'),
    re_path('services/alojamento', insert_alojamento, name='service_restaurant'),
    re_path('services/monumentos', insert_monumentos, name='service_restaurant'),
    #request pending services
    re_path('services/pending', pending_services),

    #Approve services
    re_path('services/approved', service_approved),

    #Service denied
    re_path('services/denied', service_denied),

    #service was removed by user
    re_path('services/removed', service_removed),

    re_path('api/', include('api.urls')),
    re_path('users/register', register_user, name='user_register'),
    re_path(r'^user_info/$', request_user_information),
    re_path(r'^user_services/$', request_user_services),

    #change service - restaurant
    re_path(r'^change_restaurant', update_restaurant),

    #change service - accomodation
    re_path(r'^change_accommodation', update_accomodation),

    #change service - monuments
    re_path(r'^change_monument', update_monument),

    #by district and type
    re_path(r'^services_distrito/(?P<distrito>[\w-]+)/(?P<tipo>[\w-]+)/?$', services_by_distrito_tipo),
    #by district
    re_path(r'^services_distrito/(?P<distrito>[\w-]+)/?$', services_by_distrito),

    #by concelho and type
    re_path(r'^services_concelho/(?P<concelho>[\w-]+)/(?P<tipo>[\w-]+)/?$', services_by_concelho_tipo),
    #by concelho
    re_path(r'^services_concelho/(?P<concelho>[\w-]+)/?$', services_by_concelho),

    #by freguesia and type
    re_path(r'^services_freguesia/(?P<freguesia>[\w-]+)/(?P<tipo>[\w-]+)/?$', services_by_freguesia_tipo),
    #by district
    re_path(r'^services_freguesia/(?P<freguesia>[\w-]+)/?$', services_by_freguesia),

    
  #  path('regions/<int:district_id>/concelhos/', get_concelhos_by_district, name='get_concelhos_by_district'),
    #  path('regions/<int:concelhos_id>/freguesias/', get_freguesias_by_concelho, name='get_freguesias_by_concelho'),
    re_path('empresa', empresa_view, name='empresa'),
    re_path('regions', regions_view, name='regions'),
    re_path('', views.home, name='home'),

    #re_path('api-auth/', include('rest_framework.urls')),
    #re_path('rest-auth/', include('rest_auth.urls')),
    #re_path('rest-auth/registration/', include('rest_auth.registration.urls')),
    #re_path('api/', include('users.urls', namespace='api')),

]


