import 'package:flutter/material.dart';
import 'package:flutter_image_slideshow/flutter_image_slideshow.dart';

import 'AlojamentoService.dart';
import 'EdificiosCulturaisService.dart';
import 'RestauracaoService.dart';
import 'main_AppBar.dart';

class HomePage extends StatelessWidget {
  HomePage({Key? key}) : super(key: key);

  final Shader iphoneShader =
  LinearGradient(colors: [Color(0xff070D14), Color(0xff85D1EE)])
      .createShader(Rect.fromLTWH(0, 100, 50, 2)
  );

  @override
  Widget build(BuildContext context) {

    final List<String> images = [
      'assets/main_images/Vagos.jpg',
      'assets/main_images/vagos1.jpeg',
      'assets/main_images/vagos2.jpg',
    ];

    final double width = MediaQuery.of(context).size.width;
    final double height = MediaQuery.of(context).size.height;

    return Container(

        decoration: BoxDecoration(
            gradient: LinearGradient(
                begin: Alignment.topRight,
                end: Alignment.bottomLeft,
                colors: [
                  Color(0xFF05182D),
                  Color(0xFF092A45),
                  Color(0xFF0D2339)
                ]
            )
        ),

        child: Scaffold(
          backgroundColor: Colors.transparent,
          body: Padding(
            padding: EdgeInsets.symmetric(horizontal: 130, vertical: 0),
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [

                    CustomAppBar(),
                    /*
                    Text(
                      'LusiTravel',
                      style: TextStyle(
                          color: Colors.white,
                          fontSize: 30,
                          fontWeight: FontWeight.bold),
                    ),*/

                    /*
                    Row(
                      children: [

                        /*
                        OutlinedButton(
                          onPressed: () {
                            debugPrint('Received click');
                          },
                            child: const Text('Restauração', style: TextStyle(color: Colors.white)),
                        ),

                        SizedBox(width: 30),

                        OutlinedButton(
                          onPressed: () {
                            debugPrint('Received click');
                          },
                          child: const Text('Alojamento', style: TextStyle(color: Color(0xFF6F92B6))),
                        ),

                        SizedBox(width: 30),

                        OutlinedButton(
                          onPressed: () {
                            debugPrint('Received click');
                          },
                          child: const Text('Cultura', style: TextStyle(color: Color(0xFF6F92B6))),
                        ),
                         */
                      ],
                    )
                    */

                SizedBox(height: 30),

                Row(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  mainAxisAlignment: MainAxisAlignment.spaceBetween,
                  children: [
                    Column(
                      crossAxisAlignment: CrossAxisAlignment.start,
                      children: [
                        SizedBox(height: 10),
                        Text('Venha descobrir...',
                            style: TextStyle(
                                color: Color(0xFFE6949B), fontSize: 18)),
                        SizedBox(height: 20),
                        Text(
                          'VAGOS',
                          style: TextStyle(
                              fontSize: 100,
                              fontWeight: FontWeight.bold,
                              foreground: Paint()..shader = iphoneShader,
                              shadows: [
                                Shadow(
                                    offset: Offset(10, 10),
                                    blurRadius: 20,
                                    color: Colors.black),
                                Shadow(
                                    offset: Offset(10, 10),
                                    blurRadius: 20,
                                    color: Colors.black12),
                              ]),
                        ),

                        SizedBox(height: 20),

                        Container(
                          width: 450,
                          child: Text(
                            'D. Sancho I, o Rei Povoador, deu foral às terras de São Romão em 1190, e a 15 de Outubro de 1192 doou a antiga Vila de Soza à Ordem de Nossa Senhora do Rocamador, mais tarde extinta. '
                                'Soza foi sede do Concelho, com foral a 17 de Fevereiro de 1514. Foi extinta com a Reforma Administrativa de 31 de Dezembro de 1853, passando a integrar o concelho de Vagos. '
                                'A Vila de Vagos recebeu foral de D. Manuel, datado de Lisboa, a 12 de Agosto de 1514. '
                                'A importância de Vagos vem já desde a Idade Média, dado o facto de denominar-se de Vagos a única porta a Sul das Muralhas de Aveiro e ter pertencido à antiga Comarca de Esgueira.',
                            textAlign: TextAlign.justify,
                            style: TextStyle(
                                color: Colors.white70,
                                fontSize: 20,
                                fontFamily: 'Montserrat',
                            ),
                          ),
                        ),
                        SizedBox(height: 20),

                        SizedBox(height: 30),

                        Container(
                          height: 50,
                          width: 250,
                          decoration: BoxDecoration(
                              border: Border.all(color: Color(0xFF21A3E2)),
                              borderRadius: BorderRadius.circular(50)),
                          child: TextButton(
                              onPressed: () {
                                Navigator.push(context, MaterialPageRoute(builder: (context) => RestauracaoService('Vagos', 'Restauracao')));
                              },
                              child: Row(
                                mainAxisAlignment: MainAxisAlignment.center,
                                children: [
                                  Icon(
                                    Icons.restaurant,
                                    color: Colors.white,
                                  ),
                                  SizedBox(width: 10),
                                  Text(
                                    'RESTAURAÇÃO',
                                    style: TextStyle(
                                        color: Colors.white,
                                        fontSize: 20,
                                    ),
                                  )
                                ],
                              ),
                          ),
                        ),

                        SizedBox(height: 10),

                        Container(
                          height: 50,
                          width: 250,
                          decoration: BoxDecoration(
                              border: Border.all(color: Color(0xFF21A3E2)),
                              borderRadius: BorderRadius.circular(50)),
                          child: TextButton(
                            onPressed: () {
                              Navigator.push(context, MaterialPageRoute(builder: (context) => AlojamentoService('Vagos', 'Alojamento')));
                            },
                            child: Row(
                              mainAxisAlignment: MainAxisAlignment.center,
                              children: [
                                Icon(
                                  Icons.hotel,
                                  color: Colors.white,
                                ),
                                SizedBox(width: 10),
                                Text(
                                  'ALOJAMENTO',
                                  style: TextStyle(
                                      color: Colors.white,
                                      fontSize: 20,
                                  ),
                                )
                              ],
                            ),
                          ),
                        ),

                        SizedBox(height: 10),

                        Container(
                          height: 50,
                          width: 250,
                          decoration: BoxDecoration(
                              border: Border.all(color: Color(0xFF21A3E2)),
                              borderRadius: BorderRadius.circular(50)),
                          child: TextButton(
                            onPressed: () {
                              Navigator.push(context, MaterialPageRoute(builder: (context) => EdificiosService('Vagos', 'Monumento')));
                            },
                            child: Row(
                              mainAxisAlignment: MainAxisAlignment.center,
                              children: [
                                Icon(
                                  Icons.castle,
                                  color: Colors.white,
                                ),
                                SizedBox(width: 10),
                                Text(
                                  'CULTURA',
                                  style: TextStyle(
                                      color: Colors.white,
                                      fontSize: 20
                                  ),
                                )
                              ],
                            ),
                          ),
                        ),


                      ],
                    ),

                    FittedBox(
                      fit: BoxFit.fitWidth,
                      alignment: Alignment.topRight,
                      child: ImageSlideshow(
                        width: width * 0.6,
                        height: width * 0.4,
                        indicatorColor: Colors.redAccent,
                        indicatorBackgroundColor: Colors.grey,
                        children: images.map((image) {
                          return Image.asset(image);
                        }).toList(),
                        autoPlayInterval: 5000,
                        isLoop: true,
                      ),
                    ),

                    /*
                    Image.asset(
                      'images/iPhone.png',
                      width: 600,
                    ),
                     */

                  ],
                )
              ],
            ),
          ),
        )
    );
  }
}