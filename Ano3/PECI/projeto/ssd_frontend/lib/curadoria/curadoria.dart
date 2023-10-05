import 'package:flutter/material.dart';
import 'package:ssd_frontend/features_empresa/Servicos.dart';
import 'package:http/http.dart' as http;
import 'dart:convert';

class CuradorPage extends StatefulWidget {
  const CuradorPage({Key? key}) : super(key: key);

  @override
  _CuradorPageState createState() => _CuradorPageState();
}

class _CuradorPageState extends State<CuradorPage> {
  List<Service> pendingServices = [];

  @override
  void initState() {
    super.initState();
    fetchServices();
  }

  Future<void> fetchServices() async {
    try {
      List<Service> services = await fetchPendingServices();
      setState(() {
        pendingServices = services;
      });
    } catch (e) {
      // Handle error
      print('Error fetching services: $e');
    }
  }

  Future<List<Service>> fetchPendingServices() async {
    var url = Uri.parse('http://127.0.0.1:8000/services/pending');
    var response = await http.get(url);
    //rint(response);
    if (response.statusCode == 200) {
      var data = jsonDecode(response.body);
      //print(data);
      List<Service> pendingServices = [];

      for (var serviceData in data['pending_services']) {
        var serviceType = serviceData['tipo_servico'];
        //print(serviceData);
        switch (serviceType) {
          case 'Restauracao':
            var restaurantAd = RestaurantAd(
              name: serviceData['name'],
              latitude: serviceData['latitude'],
              longitude: serviceData['longitude'],
              images: serviceData['images'].cast<String>(),
              imageDescriptions: serviceData['imageDescriptions'].cast<String>(),
              userEmail: serviceData['email'],
              serviceType: serviceData['tipo_servico'],
              district: serviceData['distrito'],
              county: serviceData['concelho'],
              parish: serviceData['freguesia'],
              street: serviceData['rua'],
              establishmentTypes: serviceData['tipoEstabelecimento'].cast<String>(),
              menu: serviceData['ementa'].cast<String>(),
              hours: serviceData['hours'],
              description: serviceData['description'],
              promo: serviceData['promo'],
              email: serviceData['email'],
              id: serviceData['_id'], // Add id here
            );
            pendingServices.add(restaurantAd);
            break;
          case 'Alojamento':
            var accommodationAd = AccommodationAd(
              name: serviceData['name'],
              latitude: serviceData['latitude'],
              longitude: serviceData['longitude'],
              images: List<String>.from(serviceData['images']),
              imageDescriptions: List<String>.from(serviceData['image_descriptions']),
              userEmail: serviceData['user_email'],
              serviceType: serviceType,
              district: serviceData['distrito'],
              county: serviceData['concelho'],
              parish: serviceData['freguesia'],
              street: serviceData['rua'],
              bedroomType: serviceData['bedroom_type'],
              bedroomPrices: serviceData['bedroom_prices'],
              services: serviceData['services'],
              promo: serviceData['promo'],
              description: serviceData['description'],
              id: serviceData['_id'], // Add id here
            );
            pendingServices.add(accommodationAd);
            break;
          case 'Monumento':
            var monumentAd = MonumentAd(
              name: serviceData['name'],
              latitude: serviceData['latitude'],
              longitude: serviceData['longitude'],
              images: List<String>.from(serviceData['images']),
              imageDescriptions: List<String>.from(serviceData['imageDescriptions']),
              userEmail: serviceData['user_email'],
              serviceType: serviceType,
              district: serviceData['distrito'],
              county: serviceData['concelho'],
              parish: serviceData['freguesia'],
              street: serviceData['rua'],
              story: serviceData['story'],
              style: serviceData['style'],
              accessibility: serviceData['accessability'],
              schedule: serviceData['schedule'],
              price: serviceData['price'],
              activity: serviceData['activity'],
              guideVisit: serviceData['guide_visit'],
              id: serviceData['_id'], // Add id here
            );
            pendingServices.add(monumentAd);
            break;
        }
      }
      return pendingServices;
    } else {
      throw Exception('Failed to load pending services');
    }
  }

  void approveService(Service service) async {
    var endpoint = "http://127.0.0.1:8000/services/approved";

  try {
    // Convert the service object to JSON
    var serviceJson = json.encode(service);

    // Send the POST request to the endpoint
    var response = await http.post(Uri.parse(endpoint),
        body: serviceJson,
        headers: {'Content-Type': 'application/json'});

    // Check the response status code
    if (response.statusCode == 200) {
      print('Service Approved: ${service.name}');
      // Update the service status, notify the user, etc.

      // Remove the denied service from the pendingServices list
      setState(() {
        pendingServices.remove(service);
      });
    } else {
      print('Failed to approve service: ${response.statusCode}');
    }
  } catch (error) {
    print('Error: $error');
  }
}







void denyService(Service service) async {
  var endpoint = "http://127.0.0.1:8000/services/denied";

  try {
    // Convert the service object to JSON
    var serviceJson = json.encode(service);

    // Send the POST request to the endpoint
    var response = await http.post(Uri.parse(endpoint),
        body: serviceJson,
        headers: {'Content-Type': 'application/json'});

    // Check the response status code
    if (response.statusCode == 200) {
      print('Service denied: ${service.name}');
      // Update the service status, notify the user, etc.

      // Remove the denied service from the pendingServices list
      setState(() {
        pendingServices.remove(service);
      });
    } else {
      print('Failed to deny service: ${response.statusCode}');
    }
  } catch (error) {
    print('Error: $error');
  }
}

  void inspectService(Service service) {
  showDialog(
    context: context,
    builder: (BuildContext context) {
      if (service is RestaurantAd) {
        return AlertDialog(
          title: Text(service.name),
          content: SingleChildScrollView(
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                Text('Latitude: ${service.latitude}'),
                Text('Longitude: ${service.longitude}'),
                SizedBox(height: 10),
                Text('Images:'),
                for (var i = 0; i < service.images.length; i++)
                  Column(
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: [
                      Image.memory(
                        base64Decode(service.images[i]),
                      ),
                      SizedBox(height: 5),
                      Text('Description: ${service.imageDescriptions[i]}'),
                      SizedBox(height: 10),
                    ],
                  ),
                Text('User Email: ${service.userEmail}'),
                Text('Service Type: ${service.serviceType}'),
                Text('District: ${service.district}'),
                Text('County: ${service.county}'),
                Text('Parish: ${service.parish}'),
                Text('Street: ${service.street}'),
                SizedBox(height: 10),
                Text('Establishment Types:'),
                for (var type in service.establishmentTypes)
                  Text(type),
                SizedBox(height: 10),
                Text('Menu:'),
                for (var item in service.menu)
                  Text(item),
                SizedBox(height: 10),
                Text('Hours: ${service.hours}'),
                Text('Description: ${service.description}'),
                Text('Promo: ${service.promo}'),
                Text('Email: ${service.email}'),
                Text('ID: ${service.id}'),
              ],
            ),
          ),
          actions: [
            TextButton(
              onPressed: () {
                approveService(service);
                Navigator.of(context).pop();
              },
              child: Text('Approve'),
            ),
            TextButton(
              onPressed: () {
                denyService(service);
                Navigator.of(context).pop();
              },
              child: Text('Deny'),
            ),
            TextButton(
              onPressed: () => Navigator.of(context).pop(),
              child: Text('Close'),
            ),
          ],
        );
      } else if (service is AccommodationAd) {
        return AlertDialog(
          title: Text(service.name),
          content: SingleChildScrollView(
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                Text('Latitude: ${service.latitude}'),
                Text('Longitude: ${service.longitude}'),
                SizedBox(height: 10),
                Text('Images:'),
                for (var i = 0; i < service.images.length; i++)
                  Column(
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: [
                      Image.memory(
                        base64Decode(service.images[i]),
                      ),
                      SizedBox(height: 5),
                      Text('Description: ${service.imageDescriptions[i]}'),
                      SizedBox(height: 10),
                    ],
                  ),
                Text('User Email: ${service.userEmail}'),
                Text('Service Type: ${service.serviceType}'),
                Text('District: ${service.district}'),
                Text('County: ${service.county}'),
                Text('Parish: ${service.parish}'),
                Text('Street: ${service.street}'),
                SizedBox(height: 10),
                Text('Bedroom Type: ${service.bedroomType}'),
                Text('Bedroom Prices: ${service.bedroomPrices}'),
                Text('Services: ${service.services}'),
                Text('Description: ${service.description}'),
                Text('Promotions: ${service.promo}'),
                Text('ID: ${service.id}'),
              ],
            ),
          ),
          actions: [
            TextButton(
              onPressed: () {
                approveService(service);
                Navigator.of(context).pop();
              },
              child: Text('Approve'),
            ),
            TextButton(
              onPressed: () {
                denyService(service);
                Navigator.of(context).pop();
              },
              child: Text('Deny'),
            ),
            TextButton(
              onPressed: () => Navigator.of(context).pop(),
              child: Text('Close'),
            ),
          ],
        );
      } else if (service is MonumentAd) {
        return AlertDialog(
          title: Text(service.name),
          content: SingleChildScrollView(
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                Text('Latitude: ${service.latitude}'),
                Text('Longitude: ${service.longitude}'),
                SizedBox(height: 10),
                Text('Images:'),
                for (var i = 0; i < service.images.length; i++)
                  Column(
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: [
                      Image.memory(
                        base64Decode(service.images[i]),
                      ),
                      SizedBox(height: 5),
                      Text('Description: ${service.imageDescriptions[i]}'),
                      SizedBox(height: 10),
                    ],
                  ),
                Text('User Email: ${service.userEmail}'),
                Text('Service Type: ${service.serviceType}'),
                Text('District: ${service.district}'),
                Text('County: ${service.county}'),
                Text('Parish: ${service.parish}'),
                Text('Street: ${service.street}'),
                SizedBox(height: 10),
                Text('Story: ${service.story}'),
                Text('Style: ${service.style}'),
                Text('Accessibility: ${service.accessibility}'),
                Text('Schedule: ${service.schedule}'),
                Text('Price: ${service.price}'),
                Text('Activity: ${service.activity}'),
                Text('Guide Visit: ${service.guideVisit}'),
                Text('ID: ${service.id}'),
              ],
            ),
          ),
          actions: [
            TextButton(
              onPressed: () {
                approveService(service);
                Navigator.of(context).pop();
              },
              child: Text('Approve'),
            ),
            TextButton(
              onPressed: () {
                denyService(service);
                Navigator.of(context).pop();
              },
              child: Text('Deny'),
            ),
            TextButton(
              onPressed: () => Navigator.of(context).pop(),
              child: Text('Close'),
            ),
          ],
        );
      }
      // Handle other types of services here
      // Add respective AlertDialogs for each service type
      return SizedBox.shrink();
    },
  );
}

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Curador Page'),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Text(
              'Welcome, Curator!',
              style: TextStyle(fontSize: 24, fontWeight: FontWeight.bold),
            ),
            SizedBox(height: 20),
            ElevatedButton(
              onPressed: () {
                // TODO: Implement service approval logic
                // You can navigate to a new page or show a dialog for approval/denial
              },
              child: Text('Approve Services'),
            ),
            SizedBox(height: 20),
            Expanded(
              child: ListView.builder(
                itemCount: pendingServices.length,
                itemBuilder: (context, index) {
                  final service = pendingServices[index];
                  return ListTile(
                    title: Text(service.name),
                    subtitle: Text(service.serviceType),
                    trailing: Row(
                      mainAxisSize: MainAxisSize.min,
                      children: [
                        IconButton(
                          onPressed: () => inspectService(service),
                          icon: Icon(Icons.info),
                          color: Colors.blue,
                        ),
                        IconButton(
                          onPressed: () => approveService(service),
                          icon: Icon(Icons.check),
                          color: Colors.green,
                        ),
                        IconButton(
                          onPressed: () => denyService(service),
                          icon: Icon(Icons.close),
                          color: Colors.red,
                        ),
                      ],
                    ),
                  );
                },
              ),
            ),
          ],
        ),
      ),
    );
  }
}