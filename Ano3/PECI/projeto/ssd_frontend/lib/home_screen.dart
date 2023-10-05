import 'package:flutter/material.dart';
import 'body_main.dart';
import 'appbar_main.dart';

class HomeScreen extends StatelessWidget {
  const HomeScreen({super.key});

  @override
  Widget build (BuildContext context) {

    Size size = MediaQuery.of(context).size;

    return Scaffold(
      body: Container(
        height: size.height,
        width: size.width,
        decoration: const BoxDecoration(
          image: DecorationImage(
            image: AssetImage("assets/main_images/Main_image1.jpg"),
            fit: BoxFit.fill,
          ),
        ),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: const [
              CustomAppBar(),
              Spacer(),
              Body(),
              Spacer(
              flex: 2,
            ),
          ],
        ),
      ),
    );
  }
}