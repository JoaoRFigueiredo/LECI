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
        primarySwatch: Colors.blue,
      ),
      home: HomePage(),
    );
  }
}

/*
void main() {
  runApp(MaterialApp(
    home: MainScreen(),
    debugShowCheckedModeBanner: false,
    routes: {
      '/restauracao': (context) => RestauracaoService('Vagos', 'Restauracao'),
      '/alojamento': (context) => AlojamentoService('Vagos', 'Alojamento'),
      '/edificiosculturais': (context) => EdificiosService('Vagos', 'Monumento'),
    },
  ));
}

class MainScreen extends StatelessWidget {
  final List<String> imagePaths = [
    'assets/main_images/Vagos.jpg',
    'assets/main_images/vagos1.jpeg',
    'assets/main_images/vagos2.jpg',
  ];
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Vagos, Aveiro'),
      ),
      body: Row(
        children: [
          Expanded(
            flex: 1,
            child: Container(
              padding: EdgeInsets.all(20.0),
              child: Column(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  Text(
                    'Venha conhecer Vagos!',
                    style: TextStyle(
                        fontSize: 30.0,
                      fontWeight: FontWeight.bold,
                    ),
                  ),

                  SizedBox(
                      height: 20
                  ),

                  CarouselSlider(
                    options: CarouselOptions(
                      autoPlay: true,
                      aspectRatio: 16 / 9,
                      viewportFraction: 0.8,
                      enlargeCenterPage: true,
                    ),
                    items: imagePaths.map((imagePath) {
                      return Builder(
                        builder: (BuildContext context) {
                          return Image.asset(
                            imagePath,
                            height: 500,
                            width: 800,
                            fit: BoxFit.cover,
                          );
                        },
                      );
                    }).toList(),
                  ),

              SizedBox(
                  height: 20
              ),

              Container(
                alignment: Alignment.topLeft,
                child: RichText(
                  textAlign: TextAlign.justify,
                  text: TextSpan(
                    style: TextStyle(fontSize: 21.0, color: Colors.black),
                    children: [
                      TextSpan(
                        text:
                        'D. Sancho I, o Rei Povoador, deu foral às terras de São Romão em 1190, e a 15 de Outubro de 1192 doou a antiga Vila de Soza à Ordem de Nossa Senhora do Rocamador, mais tarde extinta. '
                            'Soza foi sede do Concelho, com foral a 17 de Fevereiro de 1514. Foi extinta com a Reforma Administrativa de 31 de Dezembro de 1853, passando a integrar o concelho de Vagos. '
                            'A Vila de Vagos recebeu foral de D. Manuel, datado de Lisboa, a 12 de Agosto de 1514. '
                            'A importância de Vagos vem já desde a Idade Média, dado o facto de denominar-se de Vagos a única porta a Sul das Muralhas de Aveiro e ter pertencido à antiga Comarca de Esgueira.',
                      ),
                    ],
                  ),
                ),
              ),
                ],
              ),
            ),
          ),

          Expanded(
            flex: 1,
            child: Container(
              padding: EdgeInsets.all(20.0),
              child: Column(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [

                  Flexible(
                    fit: FlexFit.tight,
                    child: FractionallySizedBox(
                      widthFactor: 0.8,
                      child: ElevatedButton(
                        onPressed: () {
                          Navigator.push(context, MaterialPageRoute(builder: (context) => RestauracaoService('Vagos', 'Restauracao')));
                        },
                        style: ButtonStyle(
                          padding: MaterialStateProperty.all(
                            EdgeInsets.symmetric(vertical: 10, horizontal: 10),
                          ),
                        ),
                        child: Column(
                          mainAxisAlignment: MainAxisAlignment.center,
                          children: [
                            Icon(Icons.restaurant, size: 60),
                            SizedBox(height: 10),
                            Text('RESTAURAÇÃO',
                                style: TextStyle(fontSize: 30)
                            ),
                          ],
                        ),
                      ),
                    ),
                  ),

                  SizedBox(
                      height: 20
                  ),

                  Flexible(
                    fit: FlexFit.tight,
                    child: FractionallySizedBox(
                      widthFactor: 0.8,
                      child: ElevatedButton(
                        onPressed: () {
                          Navigator.push(context, MaterialPageRoute(builder: (context) => AlojamentoService('Vagos', 'Alojamento')));
                        },
                        style: ButtonStyle(
                          padding: MaterialStateProperty.all(
                            EdgeInsets.symmetric(vertical: 10, horizontal: 10),
                          ),
                        ),
                        child: Column(
                          mainAxisAlignment: MainAxisAlignment.center,
                          children: [
                            Icon(Icons.hotel, size: 60),
                            SizedBox(height: 10),
                            Text('ALOJAMENTO',
                                style: TextStyle(fontSize: 30)
                            ),
                          ],
                        ),
                      ),
                    ),
                  ),

                  SizedBox(
                      height: 20
                  ),

                  Flexible(
                    fit: FlexFit.tight, child: FractionallySizedBox(
                    widthFactor: 0.8,
                    child: ElevatedButton(
                      onPressed: () {
                        Navigator.push(context, MaterialPageRoute(builder: (context) => EdificiosService('Vagos', 'Monumento')));
                      },
                      style: ButtonStyle(
                        padding: MaterialStateProperty.all(
                          EdgeInsets.symmetric(vertical: 10, horizontal: 10),
                        ),
                      ),
                      child: Column(
                        mainAxisAlignment: MainAxisAlignment.center,
                        children: [
                          Icon(Icons.castle, size: 60),
                          SizedBox(height: 10),
                          Text('EDIFÍCIOS CULTURAIS',
                              style: TextStyle(fontSize: 30)
                          ),
                        ],
                      ),
                    ),
                  ),
                  ),

                ],
              ),
            ),
          ),
        ],
      ),
    );
  }
}

 */
