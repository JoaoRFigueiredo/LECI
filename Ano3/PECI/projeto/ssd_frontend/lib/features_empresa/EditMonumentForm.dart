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


class EditMonumentForm extends StatefulWidget {
  final MonumentAd monumentAd;

  EditMonumentForm({required this.monumentAd});

  @override
  _EditMonumentFormState createState() => _EditMonumentFormState();
}

class _EditMonumentFormState extends State<EditMonumentForm> {
  TextEditingController _nameController = TextEditingController();
  TextEditingController _latitudeController = TextEditingController();
  TextEditingController _longitudeController = TextEditingController();
  TextEditingController _storyController = TextEditingController();
  TextEditingController _styleController = TextEditingController();
  TextEditingController _accessibilityController = TextEditingController();
  TextEditingController _scheduleController = TextEditingController();
  TextEditingController _priceController = TextEditingController();
  TextEditingController _activityController = TextEditingController();
  TextEditingController _guideVisitController = TextEditingController();

  List<File> _images = [];
  List<String> _imageStrings = [];

  @override
  void initState() {
    super.initState();
    _nameController.text = widget.monumentAd.name;
    _latitudeController.text = widget.monumentAd.latitude;
    _longitudeController.text = widget.monumentAd.longitude;
    _storyController.text = widget.monumentAd.story;
    _styleController.text = widget.monumentAd.style;
    _accessibilityController.text = widget.monumentAd.accessibility;
    _scheduleController.text = widget.monumentAd.schedule;
    _priceController.text = widget.monumentAd.price;
    _activityController.text = widget.monumentAd.activity;
    _guideVisitController.text = widget.monumentAd.guideVisit;
    widget.monumentAd.images.forEach((imageString) {
      _imageStrings.add(imageString);
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Edit Monument"),
      ),
      body: Padding(
        padding: EdgeInsets.all(20.0),
        child: ListView(
          children: <Widget>[
            _buildNameInput(),
            SizedBox(height: 20.0),
            _buildLocationInputs(),
            SizedBox(height: 20.0),
            _buildStoryInput(),
            SizedBox(height: 20.0),
            _buildStyleInput(),
            SizedBox(height: 20.0),
            _buildAccessibilityInput(),
            SizedBox(height: 20.0),
            _buildScheduleInput(),
            SizedBox(height: 20.0),
            _buildPriceInput(),
            SizedBox(height: 20.0),
            _buildActivityInput(),
            SizedBox(height: 20.0),
            _buildGuideVisitInput(),
            SizedBox(height: 20.0),
            _buildMonumentImagesInput(),
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

  Widget _buildStoryInput() {
    return TextFormField(
      controller: _storyController,
      decoration: InputDecoration(
        labelText: 'Story',
      ),
    );
  }

  Widget _buildStyleInput() {
    return TextFormField(
      controller: _styleController,
      decoration: InputDecoration(
        labelText: 'Style',
      ),
    );
  }

  Widget _buildAccessibilityInput() {
    return TextFormField(
      controller: _accessibilityController,
      decoration: InputDecoration(
        labelText: 'Accessibility',
      ),
    );
  }

  Widget _buildScheduleInput() {
    return TextFormField(
      controller: _scheduleController,
      decoration: InputDecoration(
        labelText: 'Schedule',
      ),
    );
  }

  Widget _buildPriceInput() {
    return TextFormField(
      controller: _priceController,
      decoration: InputDecoration(
        labelText: 'Price',
      ),
    );
  }

  Widget _buildActivityInput() {
    return TextFormField(
      controller: _activityController,
      decoration: InputDecoration(
        labelText: 'Activity',
      ),
    );
  }

  Widget _buildGuideVisitInput() {
    return TextFormField(
      controller: _guideVisitController,
      decoration: InputDecoration(
        labelText: 'Guide Visit',
      ),
    );
  }

  Widget _buildMonumentImagesInput() {
    return Column(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: <Widget>[
        Text(
          'Monument Images',
          style: TextStyle(fontSize: 16.0, fontWeight: FontWeight.bold),
        ),
        SizedBox(height: 8.0),
        if (widget.monumentAd.images.isNotEmpty)
          GridView.count(
            shrinkWrap: true,
            crossAxisCount: 3,
            children: widget.monumentAd.images.map((imageString) {
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
                          widget.monumentAd.images.remove(imageString);
                        });
                      },
                    ),
                  ),
                ],
              );
            }).toList(),
          ),
        ElevatedButton(
          onPressed: _chooseMonumentImage,
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
        String story = _storyController.text;
        String style = _styleController.text;
        String accessibility = _accessibilityController.text;
        String schedule = _scheduleController.text;
        String price = _priceController.text;
        String activity = _activityController.text;
        String guideVisit = _guideVisitController.text;

        // Prepare the data to send in the request payload
        Map<String, dynamic> requestData = {
          'name': name,
          'latitude': latitude,
          'longitude': longitude,
          'story': story,
          'style': style,
          'accessibility': accessibility,
          'schedule': schedule,
          'price': price,
          'activity': activity,
          'guideVisit': guideVisit,
          'images': widget.monumentAd.images,
          'imageDescriptions': widget.monumentAd.imageDescriptions,
          'user_email': widget.monumentAd.userEmail,
          'id': widget.monumentAd.id,
        };

        // Make an HTTP request to update the monument ad
        http
            .post(Uri.parse('http://127.0.0.1:8000/change_monument'),
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

  void _chooseMonumentImage() async {
    final picker = ImagePicker();
    final pickedFile = await picker.pickImage(source: ImageSource.gallery);

    if (pickedFile != null) {
      final bytes = await pickedFile.readAsBytes();
      final encodedImage = base64Encode(bytes);
      setState(() {
        widget.monumentAd.images.add(encodedImage);
      });
    }
  }
}
