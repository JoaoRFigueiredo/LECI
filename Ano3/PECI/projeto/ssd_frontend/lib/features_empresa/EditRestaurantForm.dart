import 'package:flutter/material.dart';
import 'package:ssd_frontend/features_empresa/Servicos.dart';
import 'package:ssd_frontend/features_empresa/features_empresa.dart';
import 'dart:convert';
import 'dart:io';
import 'package:file_picker/file_picker.dart';
import 'package:flutter/material.dart';
import 'dart:typed_data';
import 'package:image_picker/image_picker.dart';
import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;

import 'package:flutter/rendering.dart';

class EditRestaurantForm extends StatefulWidget {
  final RestaurantAd restaurantAd;

  EditRestaurantForm({required this.restaurantAd});

  @override
  _EditRestaurantFormState createState() => _EditRestaurantFormState();
}

class _EditRestaurantFormState extends State<EditRestaurantForm> {
  TextEditingController _nameController = TextEditingController();
  TextEditingController _latitudeController = TextEditingController();
  TextEditingController _longitudeController = TextEditingController();
  TextEditingController _establishmentTypesController = TextEditingController();
  TextEditingController _menuController = TextEditingController();
  TextEditingController _hoursController = TextEditingController();
  TextEditingController _descriptionController = TextEditingController();
  TextEditingController _promoController = TextEditingController();

  List<File> _menuImages = []; // List to store the menu images as files
  List<String> _menuImageStrings = []; // List to store the menu images as base64 strings

  @override
  void initState() {
    super.initState();
    _nameController.text = widget.restaurantAd.name;
    _latitudeController.text = widget.restaurantAd.latitude;
    _longitudeController.text = widget.restaurantAd.longitude;
    _establishmentTypesController.text =
        widget.restaurantAd.establishmentTypes.join(', ');
    //_menuController.text = widget.restaurantAd.menu;
    widget.restaurantAd.menu.forEach((imageString) {
      _menuImageStrings.add(imageString);
    });
    _hoursController.text = widget.restaurantAd.hours;
    _descriptionController.text = widget.restaurantAd.description;
    _promoController.text = widget.restaurantAd.promo;
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Edit Restaurant"),
      ),
      body: Padding(
        padding: EdgeInsets.all(20.0),
        child: ListView(
          children: <Widget>[
            _buildNameInput(),
            SizedBox(height: 20.0),
            _buildLocationInputs(),
            SizedBox(height: 20.0),
            _buildEstablishmentTypesInput(),
            SizedBox(height: 20.0),
            _buildMenuInput(),
            SizedBox(height: 20.0),
            _buildHoursInput(),
            SizedBox(height: 20.0),
            _buildDescriptionInput(),
            SizedBox(height: 20.0),
            _buildPromoInput(),
            SizedBox(height: 20.0),
            _buildRestaurantImagesInput(),
            SizedBox(height: 20.0),
            _buildSubmitButton(),
         
          ],
        ),
      ),
    );
  }

  Widget _buildNameInput() {
    return TextFormField(
      controller: _nameController,
      decoration: InputDecoration(
        labelText: 'Name',
      ),
    );
  }

  Widget _buildLocationInputs() {
    return Column(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: <Widget>[
        Text(
          'Location',
          style: TextStyle(fontSize: 16.0, fontWeight: FontWeight.bold),
        ),
        SizedBox(height: 8.0),
        Row(
          children: [
            Expanded(
              child: TextFormField(
                controller: _latitudeController,
                decoration: InputDecoration(
                  labelText: 'Latitude',
                ),
              ),
            ),
            SizedBox(width: 16.0),
            Expanded(
              child: TextFormField(
                controller: _longitudeController,
                decoration: InputDecoration(
                  labelText: 'Longitude',
                ),
              ),
            ),
          ],
        ),
      ],
    );
  }

Widget _buildEstablishmentTypesInput() {
  final List<String> _restaurantTypes = [
    "Restaurante",
    "Café",
    "Bar",
    "Snack-Bar",
    "Salão de chá",
    "Food Truck",
    "Self-service"
  ];

  return Column(
    crossAxisAlignment: CrossAxisAlignment.start,
    children: <Widget>[
      Text(
        'Establishment Types',
        style: TextStyle(fontSize: 16.0, fontWeight: FontWeight.bold),
      ),
      SizedBox(height: 8.0),
      ListView(
        shrinkWrap: true,
        children: _restaurantTypes.map((type) {
          final bool isChecked = widget.restaurantAd.establishmentTypes.contains(type);
          return CheckboxListTile(
            title: Text(type),
            value: isChecked,
            onChanged: (bool? value) {
              setState(() {
                if (value != null) {
                  if (value) {
                    widget.restaurantAd.establishmentTypes.add(type);
                  } else {
                    widget.restaurantAd.establishmentTypes.remove(type);
                  }
                }
              });
            },
          );
        }).toList(),
      ),
    ],
  );
}



Widget _buildMenuInput() {
  return Column(
    crossAxisAlignment: CrossAxisAlignment.start,
    children: <Widget>[
      Text(
        'Menu',
        style: TextStyle(fontSize: 16.0, fontWeight: FontWeight.bold),
      ),
      SizedBox(height: 8.0),
      if (_menuImageStrings.isNotEmpty)
        GridView.count(
          shrinkWrap: true,
          crossAxisCount: 3,
          children: _menuImageStrings.map((imageString) {
            return Stack(
              children: [
                Image.memory(
                  base64Decode(imageString),
                  fit: BoxFit.cover,
                ),
                Positioned(
                  top: 0,
                  right: 0,
                  child: IconButton(
                    icon: Icon(Icons.delete),
                    onPressed: () {
                      setState(() {
                        _menuImageStrings.remove(imageString);
                        widget.restaurantAd.menu.remove(imageString);
                      });
                    },
                  ),
                ),
              ],
            );
          }).toList(),
        ),
      ElevatedButton(
        onPressed: _chooseMenuImage,
        child: Text('Choose Image'),
      ),
    ],
  );
}


  Widget _buildHoursInput() {
    return TextFormField(
      controller: _hoursController,
      decoration: InputDecoration(
        labelText: 'Hours',
      ),
    );
  }

  Widget _buildDescriptionInput() {
    return TextFormField(
      controller: _descriptionController,
      decoration: InputDecoration(
        labelText: 'Description',
      ),
    );
  }

  Widget _buildPromoInput() {
    return TextFormField(
      controller: _promoController,
      decoration: InputDecoration(
        labelText: 'Promo',
      ),
    );
  }

  Widget _buildRestaurantImagesInput() {
  return Column(
    crossAxisAlignment: CrossAxisAlignment.start,
    children: <Widget>[
      Text(
        'Restaurant Images',
        style: TextStyle(fontSize: 16.0, fontWeight: FontWeight.bold),
      ),
      SizedBox(height: 8.0),
      if (widget.restaurantAd.images.isNotEmpty)
        GridView.count(
          shrinkWrap: true,
          crossAxisCount: 3,
          children: widget.restaurantAd.images.map((imageString) {
            return Stack(
              children: [
                Image.memory(
                  base64Decode(imageString),
                  fit: BoxFit.cover,
                ),
                Positioned(
                  top: 0,
                  right: 0,
                  child: IconButton(
                    icon: Icon(Icons.delete),
                    onPressed: () {
                      setState(() {
                        widget.restaurantAd.images.remove(imageString);
                      });
                    },
                  ),
                ),
              ],
            );
          }).toList(),
        ),
      ElevatedButton(
        onPressed: _chooseRestaurantImage,
        child: Text('Choose Image'),
      ),
    ],
  );
}


Widget _buildSubmitButton() {
  return ElevatedButton(
    onPressed: () {
      String name = _nameController.text;
      String latitude = _latitudeController.text;
      String longitude = _longitudeController.text;
      List<String> establishmentTypes =
          _establishmentTypesController.text.split(',').map((e) => e.trim()).toList();
      List<String> menu =
          _menuController.text.split(',').map((e) => e.trim()).toList();
      String hours = _hoursController.text;
      String description = _descriptionController.text;
      String promo = _promoController.text;

      // Prepare the data to send in the request payload
      Map<String, dynamic> requestData = {
        'name': name,
        'latitude': latitude,
        'longitude': longitude,
        'establishmentTypes': establishmentTypes,
        'menu': widget.restaurantAd.menu,
        'images': widget.restaurantAd.images,
        'hours': hours,
        'description': description,
        'promo': promo,
        'user_email': widget.restaurantAd.userEmail,
        'imageDescriptions' : widget.restaurantAd.imageDescriptions,
        'id': widget.restaurantAd.id,
      };

      // Make an HTTP request to update the restaurant ad
      http.post(Uri.parse('http://127.0.0.1:8000/change_restaurant'),
          body: jsonEncode(requestData)).then((response) {
        if (response.statusCode == 200) {
          // Update was successful

          // Navigate to the new page
          Navigator.push(
            context,
            MaterialPageRoute(builder: (context) => FeaturesEmpresa()),
          );
        } else {
          // Update failed
          // Handle the error or display an error message
        }
      }).catchError((error) {
        // Handle the error or display an error message
      });
    },
    child: Text('Submit'),
  );
}

void _chooseMenuImage() async {
  final picker = ImagePicker();
  final pickedFile = await picker.pickImage(source: ImageSource.gallery);

  if (pickedFile != null) {
    final bytes = await pickedFile.readAsBytes();
    final encodedImage = base64Encode(bytes);
    setState(() {
      _menuImages.add(File(pickedFile.path));
      _menuImageStrings.add(encodedImage);
      widget.restaurantAd.menu.add(encodedImage);
    });
  }
}

void _chooseRestaurantImage() async {
  final picker = ImagePicker();
  final pickedFile = await picker.pickImage(source: ImageSource.gallery);

  if (pickedFile != null) {
    final bytes = await pickedFile.readAsBytes();
    final encodedImage = base64Encode(bytes);
    setState(() {
      widget.restaurantAd.images.add(encodedImage);
    });
  }
}

  File base64ToFile(String base64String) {
    final decodedBytes = base64Decode(base64String);
    final tempDir = Directory.systemTemp;
    final tempPath = tempDir.path;
    final file = File('$tempPath/menu_image_${DateTime.now().millisecondsSinceEpoch}.png');
    file.writeAsBytesSync(decodedBytes);
    return file;
  }
}
