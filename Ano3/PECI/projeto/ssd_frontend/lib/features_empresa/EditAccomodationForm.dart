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

class EditAccommodationForm extends StatefulWidget {
  final AccommodationAd accommodationAd;

  EditAccommodationForm({required this.accommodationAd});

  @override
  _EditAccommodationFormState createState() => _EditAccommodationFormState();
}

class _EditAccommodationFormState extends State<EditAccommodationForm> {
  TextEditingController _nameController = TextEditingController();
  TextEditingController _latitudeController = TextEditingController();
  TextEditingController _longitudeController = TextEditingController();
  TextEditingController _bedroomTypeController = TextEditingController();
  TextEditingController _bedroomPricesController = TextEditingController();
  TextEditingController _servicesController = TextEditingController();
  TextEditingController _descriptionController = TextEditingController();
  TextEditingController _promoController = TextEditingController();

  List<File> _images = [];
  List<String> _imageStrings = [];

  @override
  void initState() {
    super.initState();
    _nameController.text = widget.accommodationAd.name;
    _latitudeController.text = widget.accommodationAd.latitude;
    _longitudeController.text = widget.accommodationAd.longitude;
    _bedroomTypeController.text = widget.accommodationAd.bedroomType;
    _bedroomPricesController.text = widget.accommodationAd.bedroomPrices;
    _servicesController.text = widget.accommodationAd.services;
    _descriptionController.text = widget.accommodationAd.description;
    _promoController.text = widget.accommodationAd.promo;
    widget.accommodationAd.images.forEach((imageString) {
      _imageStrings.add(imageString);
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Edit Accommodation"),
      ),
      body: Padding(
        padding: EdgeInsets.all(20.0),
        child: ListView(
          children: <Widget>[
            _buildNameInput(),
            SizedBox(height: 20.0),
            _buildLocationInputs(),
            SizedBox(height: 20.0),
            _buildBedroomTypeInput(),
            SizedBox(height: 20.0),
            _buildBedroomPricesInput(),
            SizedBox(height: 20.0),
            _buildServicesInput(),
            SizedBox(height: 20.0),
            _buildDescriptionInput(),
            SizedBox(height: 20.0),
            _buildPromoInput(),
            SizedBox(height: 20.0),
            _buildAccommodationImagesInput(),
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

  Widget _buildBedroomTypeInput() {
    return TextFormField(
      controller: _bedroomTypeController,
      decoration: InputDecoration(
        labelText: 'Bedroom Type',
      ),
    );
  }

  Widget _buildBedroomPricesInput() {
    return TextFormField(
      controller: _bedroomPricesController,
      decoration: InputDecoration(
        labelText: 'Bedroom Prices',
      ),
    );
  }

  Widget _buildServicesInput() {
    return TextFormField(
      controller: _servicesController,
      decoration: InputDecoration(
        labelText: 'Services',
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
        labelText: 'Promotion',
      ),
    );
  }


  Widget _buildAccommodationImagesInput() {
    return Column(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: <Widget>[
        Text(
          'Accommodation Images',
          style: TextStyle(fontSize: 16.0, fontWeight: FontWeight.bold),
        ),
        SizedBox(height: 8.0),
        if (widget.accommodationAd.images.isNotEmpty)
          GridView.count(
            shrinkWrap: true,
            crossAxisCount: 3,
            children: widget.accommodationAd.images.map((imageString) {
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
                          widget.accommodationAd.images.remove(imageString);
                        });
                      },
                    ),
                  ),
                ],
              );
            }).toList(),
          ),
        ElevatedButton(
          onPressed: _chooseAccommodationImage,
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
        String bedroomType = _bedroomTypeController.text;
        String bedroomPrices = _bedroomPricesController.text;
        String services = _servicesController.text;
        String description = _descriptionController.text;
        String promo = _promoController.text;

        // Prepare the data to send in the request payload
        Map<String, dynamic> requestData = {
          'name': name,
          'latitude': latitude,
          'longitude': longitude,
          'bedroomType': bedroomType,
          'bedroomPrices': bedroomPrices,
          'services': services,
          'description': description,
          'images': widget.accommodationAd.images,
          'user_email': widget.accommodationAd.userEmail,
          'imageDescriptions': widget.accommodationAd.imageDescriptions,
          'promo': promo,
          'id': widget.accommodationAd.id,
        };

        // Make an HTTP request to update the accommodation ad
        http
            .post(Uri.parse('http://127.0.0.1:8000/change_accommodation'),
                body: jsonEncode(requestData))
            .then((response) {
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

  void _chooseAccommodationImage() async {
    final picker = ImagePicker();
    final pickedFile =
        await picker.pickImage(source: ImageSource.gallery);

    if (pickedFile != null) {
      final bytes = await pickedFile.readAsBytes();
      final encodedImage = base64Encode(bytes);
      setState(() {
        widget.accommodationAd.images.add(encodedImage);
      });
    }
  }
}