import 'package:firebase_auth/firebase_auth.dart';
import 'package:flutter/material.dart';
import 'package:ssd_frontend/main.dart';
import 'package:ssd_frontend/features_empresa/Ad.dart';
import 'package:ssd_frontend/features_empresa/EditRestaurantForm.dart';
import 'package:ssd_frontend/features_empresa/EditAccomodationForm.dart';
import 'package:ssd_frontend/features_empresa/EditMonumentForm.dart';
import 'package:ssd_frontend/features_empresa/Servicos.dart';
import 'package:ssd_frontend/noticias/feature_noticias.dart';
import 'package:ssd_frontend/servicos/servicos.dart';
import 'package:firebase_auth/firebase_auth.dart';
import 'dart:convert';
import 'package:http/http.dart' as http;

class UserInformation {
  final String companyName;
  final String companyPhone;
  final int numServices;

  UserInformation({
    required this.companyName,
    required this.companyPhone,
    required this.numServices,
  });

  int get servicesCount => numServices;
  String get companyPhoneValue => companyPhone;
  String get companyNameValue => companyName;
}

class FeaturesEmpresa extends StatefulWidget {
  const FeaturesEmpresa({Key? key}) : super(key: key);

  @override
  _FeaturesEmpresaState createState() => _FeaturesEmpresaState();
}

class _FeaturesEmpresaState extends State<FeaturesEmpresa> {
  List<Ad> ads = [
    Ad(
      title: 'Ad 1',
      description: 'Description for Ad 1',
    ),
    Ad(
      title: 'Ad 2',
      description: 'Description for Ad 2',
    ),
  ];


  FirebaseAuth auth = FirebaseAuth.instance;
  User? currentUser;
  late Future<UserInformation> userInformation;

  @override
  void initState() {
    super.initState();
    currentUser = auth.currentUser;

    // Call fetchUserInformation method to get user information
    userInformation = fetchUserInformation(currentUser?.email ?? '');
  }

  Future<UserInformation> fetchUserInformation(String email) async {
    var url = Uri.parse('http://127.0.0.1:8000/user_info/?email=$email');
    var response = await http.get(url);
    if (response.statusCode == 200) {
      var data = jsonDecode(response.body);
      return UserInformation(
        companyName: data['company_name'],
        companyPhone: data['company_phone'],
        numServices: data['services_count'],
      );
    } else {
      throw Exception('Failed to load user information');
    }
  }

Future<List<Service>> fetchUserServices(String email) async {
  var url = Uri.parse('http://127.0.0.1:8000/user_services/?email=$email');
  var response = await http.get(url);
  if (response.statusCode == 200) {
    var data = jsonDecode(response.body);
    List<Service> userServices = [];

    for (var serviceData in data['user_services']) {
      var serviceType = serviceData['tipo_servico'];

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
          userServices.add(restaurantAd);
          break;
        case 'Alojamento':
        //print(serviceData);
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
            promo: serviceData['promo'] ?? 'Não existente',
            description: serviceData['description'],
            id: serviceData['_id'], // Add id here
          );
          userServices.add(accommodationAd);
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
          userServices.add(monumentAd);
          break;
      }
    }
    print(userServices.length);
    return userServices;
  } else {
    throw Exception('Failed to load user services');
  }
}




  String userEmail = "";
  String userPhoneNumber = "";

  @override
  Widget build(BuildContext context) {
    if (currentUser != null) {
      userEmail = currentUser!.email ?? "";
      userPhoneNumber = currentUser!.phoneNumber ?? "";
    }

    return Scaffold(
      appBar: AppBar(
        backgroundColor: Colors.blue,
        foregroundColor: Colors.white,
        shadowColor: Colors.transparent,
        title: const Text(
          "Área da Empresa",
          style: TextStyle(fontSize: 20, color: Colors.white),
        ),
      ),
      drawer: Drawer(
        child: Column(
          children: [
            Expanded(
              child: ListView(
                padding: EdgeInsets.zero,
                children: [
                  const DrawerHeader(
                    child: Image(
                      image: AssetImage(
                        "assets/icons/icon_app.png",
                      ),
                    ),
                  ),
                  ListTile(
                    leading: const Icon(Icons.home),
                    title: const Text(
                      "Voltar para a Página Principal",
                      style: TextStyle(
                        fontSize: 18,
                      ),
                    ),
                    onTap: () {
                      Navigator.push(
                        context,
                        MaterialPageRoute(builder: (context) => Destinos()),
                      );
                    },
                  ),
                  ListTile(
                    leading: const Icon(Icons.home),
                    title: const Text(
                      "Alertas", // CRIAR
                      style: TextStyle(
                        fontSize: 18,
                      ),
                    ),
                    onTap: () {
                      Navigator.push(
                        context,
                        MaterialPageRoute(builder: (context) => FeatureNoticias()),
                      );
                    },
                  ),
                  ListTile(
                    leading: const Icon(Icons.dataset_rounded),
                    title: const Text(
                      "Criação de Anúncios", // CRIAR
                      style: TextStyle(
                        fontSize: 18,
                      ),
                    ),
                    onTap: () {
                      Navigator.push(
                        context,
                        MaterialPageRoute(builder: (context) => ServicosDisponiveis()),
                      );
                    },
                  ),
                ],
              ),
            ),
            Align(
              alignment: FractionalOffset.bottomCenter,
              child: Container(
                child: Column(
                  children: const [
                    Divider(),
                    ListTile(
                      leading: Icon(
                        Icons.logout,
                      ),
                      title: Text(
                        "Terminar Sessão",
                        style: TextStyle(fontSize: 18),
                      ),
                    ),
                  ],
                ),
              ),
            ),
          ],
        ),
      ),
      body: Column(
        children: [
          const Expanded(flex: 2, child: _TopPortion()),
          Expanded(
            flex: 3,
            child: FutureBuilder<UserInformation>(
              future: userInformation,
              builder: (context, snapshot) {
                if (snapshot.connectionState == ConnectionState.waiting) {
                  return Center(child: CircularProgressIndicator());
                } else if (snapshot.hasData) {
                  return Padding(
                    padding: const EdgeInsets.all(8.0),
                    child: Column(
                      children: [
                        Text(
                          snapshot.data!.companyNameValue,
                          style: const TextStyle(
                            fontWeight: FontWeight.bold,
                            fontSize: 25,
                          ),
                        ),
                        SizedBox(height: 16,),
                        Text(
                          currentUser?.email ?? "",
                          style: const TextStyle(
                            fontWeight: FontWeight.bold,
                            fontSize: 18,
                          ),
                        ),
                        SizedBox(height: 10,),
                        Text(
                          snapshot.data!.companyPhoneValue,
                          style: const TextStyle(
                            fontWeight: FontWeight.bold,
                            fontSize: 18,
                          ),
                        ),
                        SizedBox(height: 16,),
                        _ProfileInfoRow(
                          servicesCount: snapshot.data!.servicesCount,
                        ),
                      ],
                    ),
                  );
                } else if (snapshot.hasError) {
                  return Center(child: Text("Error: ${snapshot.error}"));
                } else {
                  return Center(child: Text("No data found"));
                }
              },
            ),
          ),
          //const SizedBox(height: 2), // Add some spacing between the user's profile and ads
           Expanded(
          flex: 3,
          child: FutureBuilder<List<Service>>(
            future: fetchUserServices(currentUser?.email ?? ''),
            builder: (context, snapshot) {
              if (snapshot.connectionState == ConnectionState.waiting) {
                return Center(child: CircularProgressIndicator());
              } else if (snapshot.hasData) {
                List<Service> userServices = snapshot.data!;
                return Column(
                  children: [
                    const Text(
                      'Serviços',
                      style: TextStyle(
                        fontWeight: FontWeight.bold,
                        fontSize: 20,
                      ),
                    ),
                    const SizedBox(height: 5),
                    Expanded(
                      flex: 3,
                      child: ListView.builder(
                        itemCount: userServices.length,
                        itemBuilder: (context, index) {
                          final service = userServices[index];
                          return ListTile(
                            title: Text(service.name),
                            subtitle: Row(
                              children: [
                                Text(service.serviceType),
                                Spacer(), // Add spacer to separate text and trailing icons
                                IconButton(
                                  icon: Icon(Icons.edit),
                                  onPressed: () {
                                    // Perform edit operation for the service
                                    if (service.serviceType == "Restauracao") {
                                        Navigator.push(
                                          context,
                                            MaterialPageRoute(builder: (context) => EditRestaurantForm(restaurantAd: service as RestaurantAd)),
                                        );
                                      } 
                                      else if (service.serviceType == "Alojamento") {
                                        Navigator.push(
                                          context,
                                          MaterialPageRoute(builder: (context) => EditAccommodationForm(accommodationAd: service as AccommodationAd)),
                                        );
                                       } 
                                      else if (service.serviceType == "Monumento") {
                                        Navigator.push(
                                          context,
                                          MaterialPageRoute(builder: (context) => EditMonumentForm(monumentAd: service as MonumentAd)),
                                        );
                                      }
                                  },
                                ),
                                IconButton(
                                  icon: Icon(Icons.delete),
                                  onPressed: () async {
                                    // Perform the POST request to remove the service
                                    final response = await http.post(Uri.parse('http://127.0.0.1:8000/services/removed'),
                                      body: jsonEncode(service),
                                      headers: {'Content-Type': 'application/json'},
                                    );

                                    if (response.statusCode == 200) {
                                      // Delete operation successful, update the userServices array in your app
                                      setState(() {
                                        userServices.remove(service); // Remove the service from the userServices array
                                      });
                                    } else {
                                      // Handle the error if the delete operation fails
                                      print('Delete operation failed with status code: ${response.statusCode}');
                                    }
                                  },
                                ),

                              ],
                            ),
                          );
                        },
                      ),
                    ),

                  ],
                );
              } else if (snapshot.hasError) {
                return Center(child: Text("Error: ${snapshot.error}"));
              } else {
                return Center(child: Text("No data found"));
              }
            },
          ),
        ),
        ],
      ),
    );
  }
}

class _ProfileInfoRow extends StatelessWidget {
  final int servicesCount;

  const _ProfileInfoRow({required this.servicesCount, Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    final List<ProfileInfoItem> items = [
      ProfileInfoItem("Anúncios", servicesCount),
      ProfileInfoItem("Visitantes", 666),
    ];

    return Container(
      height: 80,
      constraints: const BoxConstraints(maxWidth: 400),
      child: Row(
        mainAxisAlignment: MainAxisAlignment.spaceEvenly,
        children: items.map(
          (item) => Expanded(
            child: Row(
              children: [
                if (items.indexOf(item) != 0) const VerticalDivider(),
                Text(item.label),
                const SizedBox(width: 8),
                Text(
                  item.value.toString(),
                  style: const TextStyle(
                    fontWeight: FontWeight.bold,
                  ),
                ),
              ],
            ),
          ),
        ).toList(),
      ),
    );
  }
}

class ProfileInfoItem {
  final String title;
  final int value;

  const ProfileInfoItem(this.title, this.value);

  String get label => title;
}

class _TopPortion extends StatelessWidget {
  const _TopPortion({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Stack(
      fit: StackFit.expand,
      children: [
        Container(
          margin: const EdgeInsets.only(bottom: 50),
          decoration: const BoxDecoration(
            gradient: LinearGradient(
              begin: Alignment.bottomCenter,
              end: Alignment.topCenter,
              colors: [Colors.blueAccent, Colors.blue],
            ),
            borderRadius: BorderRadius.only(
              bottomLeft: Radius.circular(50),
              bottomRight: Radius.circular(50),
            ),
          ),
        ),
        Align(
          alignment: Alignment.bottomCenter,
          child: SizedBox(
            width: 150,
            height: 150,
            child: Stack(
              fit: StackFit.expand,
              children: [
                Container(
                  decoration: const BoxDecoration(
                    color: Colors.black,
                    shape: BoxShape.circle,
                    image: DecorationImage(
                      fit: BoxFit.cover,
                      image: AssetImage("assets/json_profiles/profile1.png"),
                    ),
                  ),
                ),
              ],
            ),
          ),
        ),
      ],
    );
  }
}
