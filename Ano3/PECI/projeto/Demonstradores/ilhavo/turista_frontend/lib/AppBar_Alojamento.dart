import 'package:flutter/material.dart';
import 'AlojamentoService.dart';
import 'EdificiosCulturaisService.dart';
import 'IconBack.dart';
import 'RestauracaoService.dart';
import 'homePage.dart';

class CustomAppBarAlojamento extends StatelessWidget {
  const CustomAppBarAlojamento({super.key});

  @override
  Widget build(BuildContext context) {
    return AppBar(
      toolbarHeight: 75,
      backgroundColor: Colors.white,
      elevation: 0,
      title: Padding(
        padding: EdgeInsets.symmetric(horizontal: 16),
        child: GestureDetector(
          onTap: () {
            Navigator.push(
              context,
              MaterialPageRoute(
                builder: (context) => HomePage(),
              ),
            );
          },
          child: Row(
            children: [
              Image.asset(
                'assets/main_images/logo.png',
                height: 75,
              ),
              SizedBox(width: 10),
              Text(
                'Câmara Municipal de Ílhavo - Alojamento',
                style: TextStyle(fontSize: 18),
              ),
            ],
          ),
        ),
      ),
      actions: [
        SizedBox(width: 16),
        TextButton.icon(
          onPressed: () {
            Navigator.push(
              context,
              MaterialPageRoute(
                builder: (context) => RestauracaoService('Ílhavo', 'Restauracao'),
              ),
            );
          },
          icon: Icon(Icons.restaurant),
          label: Text('Restauração'),
          style: ButtonStyle(
            foregroundColor: MaterialStateProperty.all<Color>(Colors.black),
          ),
        ),
        SizedBox(width: 16),
        TextButton.icon(
          onPressed: () {
            Navigator.push(
              context,
              MaterialPageRoute(
                builder: (context) => AlojamentoService('Ílhavo', 'Alojamento'),
              ),
            );
          },
          icon: Icon(Icons.hotel),
          label: Text('Alojamento'),
          style: ButtonStyle(
            foregroundColor: MaterialStateProperty.all<Color>(Colors.black),
          ),
        ),
        SizedBox(width: 16),
        TextButton.icon(
          onPressed: () {
            Navigator.push(
              context,
              MaterialPageRoute(
                builder: (context) => EdificiosService('Ílhavo', 'Monumento'),
              ),
            );
          },
          icon: Icon(Icons.castle),
          label: Text('Cultura'),
          style: ButtonStyle(
            foregroundColor: MaterialStateProperty.all<Color>(Colors.black),
          ),
        ),
      ],
    );
  }
}