import 'package:flutter/material.dart';

class IconBack extends StatelessWidget {
  final VoidCallback onPressed;

  IconBack({required this.onPressed});

  @override
  Widget build(BuildContext context) {
    return IconButton(
      icon: Icon(Icons.arrow_back),
      onPressed: onPressed,
    );
  }
}