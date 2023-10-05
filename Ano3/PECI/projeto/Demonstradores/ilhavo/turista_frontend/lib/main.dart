import 'package:flutter/material.dart';
import 'EdificiosCulturaisService.dart';
import 'AlojamentoService.dart';
import 'RestauracaoService.dart';
import 'package:carousel_slider/carousel_slider.dart';
import 'homePage.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'LusiTravel',
      theme: ThemeData(
        primarySwatch: Colors.lightGreen,
      ),
      home: HomePage(),
    );
  }
}
