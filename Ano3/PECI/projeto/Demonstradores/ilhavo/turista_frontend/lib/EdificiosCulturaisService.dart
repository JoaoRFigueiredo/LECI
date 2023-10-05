import 'package:carousel_slider/carousel_slider.dart';
import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'package:photo_view/photo_view.dart';
import 'dart:convert';

import 'AppBar_Monumentos.dart';
import 'IconBack.dart';


class EdificiosService extends StatefulWidget{
  final String regiao;
  final String tipo;

  EdificiosService(this.regiao , this.tipo);

  @override
  _EdificiosServiceState createState() => _EdificiosServiceState();

}

class _EdificiosServiceState extends State<EdificiosService>{
  late Future<List<dynamic>> _futureData;

  @override
  void initState() {
    super.initState();
    _futureData = fetchData(widget.regiao , widget.tipo);
  }
  final Shader iphoneShader = LinearGradient(
    colors: [Color(0xFF070D14), Color(0xFF85D1EE)],
  ).createShader(Rect.fromLTWH(0, 0, 750, 100));

  @override
  Widget build(BuildContext context) {
    return Scaffold(

      body: Container (
        decoration: BoxDecoration(
          image: DecorationImage(
              image: AssetImage('assets/main_images/monumento.jpeg'),
              fit: BoxFit.cover
          ),
        ),
        child: Column(
          children: [

            CustomAppBarMonumentos(),

    Expanded(
    child: Column(
    children: [
    SizedBox(height: 10),
    Text(
    'Edifícios Culturais em Ílhavo',
    style: TextStyle(
    fontSize: 80,
    fontWeight: FontWeight.bold,
    foreground: Paint()..shader = iphoneShader,
    shadows: [
    Shadow(
    offset: Offset(5, 5),
    blurRadius: 10,
    color: Colors.black.withOpacity(0.5),
    ),
    ],
    ),
    ),
            
            

            Expanded(
              child: FutureBuilder<List<dynamic>>(
                future: _futureData,
                builder: (context, snapshot) {
                  if (snapshot.hasData) {
                    final List monumentos = snapshot.data!;
                    return ListView.builder(
                      itemCount: monumentos.length,
                      itemBuilder: (context, index) {
                        final monumento = monumentos[index];

                        return Card(
                          margin: EdgeInsets.all(10),
                          elevation: 5,
                          shape: const RoundedRectangleBorder(
                            side: BorderSide(
                              color: Colors.blueAccent,
                            ),
                            borderRadius: BorderRadius.all(Radius.circular(15)),
                          ),
                          shadowColor: Colors.blueGrey,
                          child: Column(
                            children: [
                              ListTile(
                                title: Text(monumento['name'],
                                  style: TextStyle(
                                      fontFamily: 'Romelio',
                                      fontSize: 18
                                  ),
                                ),
                                subtitle: Text(monumento['story'],
                                  style: TextStyle(
                                    fontSize: 17,
                                  ),
                                ),
                                trailing: Icon(Icons.arrow_forward),
                                onTap: () {
                                  Navigator.push(
                                    context,
                                    MaterialPageRoute(
                                      builder: (context) => DetalhesServicoWidget(service: monumento),
                                    ),
                                  );
                                },
                              ),

                            ],
                          ),
                        );


                        /*
                      return ListTile(
                        title: Text(monumento['name'],
                          style: TextStyle(
                              fontFamily: 'Romelio',
                              fontSize: 18
                          ),
                        ),
                        subtitle: Text(monumento['story'],
                          style: TextStyle(
                            fontSize: 17,
                          ),
                        ),
                        trailing: Icon(Icons.arrow_forward),
                        onTap: () {
                          Navigator.push(
                            context,
                            MaterialPageRoute(
                              builder: (context) => DetalhesServicoWidget(service: monumento),
                            ),
                          );
                        },
                      );

                       */
                      },
                    );


                  } else if (snapshot.hasError) {
                    return Text("${snapshot.error}");
                  }
                  return CircularProgressIndicator();
                },
              ),
            ),
          ],
        ),
      ),


]
    )
    )
    );
  }
}

// VAI REPRESENTAR OS DETALHES TODOS DO SERVIÇO, OU SEJA OS DADOS TODOS

// !!!!!!!! FALTA TROCAR PARA OS DADOS DOS MONUMENTOS
class DetalhesServicoWidget extends StatelessWidget {
  final Map<String, dynamic> service;

  const DetalhesServicoWidget({Key? key, required this.service}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        body: Container(
        color: Color(0xFFD6E4F0),
    child: ListView(
    children: [
    CustomAppBarMonumentos(),
    Padding(
    padding: const EdgeInsets.all(8.0),
    child: Column(
    children: [
    Text(
    service['name'].toUpperCase(),
    style: const TextStyle(
    fontSize: 40,
    fontWeight: FontWeight.bold,
    fontFamily: 'Montserrat',
    ),
    ),

            Column(
              children: [
                CarouselSlider.builder(
                  options: CarouselOptions(
                    enableInfiniteScroll: true,
                    autoPlay: true,
                    autoPlayAnimationDuration: Duration(milliseconds: 500),
                    enlargeCenterPage: true, // Amplia a imagem central
                    aspectRatio: 4, // Proporção de aspecto da imagem
                  ),
                  itemCount: service['images'] != null ? service['images'].length : 0,
                  itemBuilder: (context, index, realIndex) {
                    final imageData = service['images'][index];
                    return GestureDetector(
                      onTap: () {
                        // Lógica para exibir a imagem ampliada
                        showDialog(
                          context: context,
                          builder: (BuildContext context) {
                            return Dialog(
                              child: Container(
                                child: PhotoView(
                                  imageProvider: MemoryImage(base64Decode(imageData)),
                                  initialScale: PhotoViewComputedScale.contained * 0.8,
                                  minScale: PhotoViewComputedScale.contained * 0.8,
                                  maxScale: PhotoViewComputedScale.covered * 2,
                                ),
                              ),
                            );
                          },
                        );
                      },
                      child: Card(
                        child: Image.memory(
                          base64Decode(imageData),
                          fit: BoxFit.cover,
                        ),
                      ),
                    );
                  },
                ),


                Padding(
                    padding: const EdgeInsets.all(8.0),
                    child: Column(
                      children: [

                        SizedBox(height: 30.0),

                        Align(
                          alignment: Alignment.topLeft,
                          child: Text(
                            service['story'],
                            style: TextStyle(
                              fontSize: 25.0,
                              fontWeight: FontWeight.bold,
                            ),
                            textAlign: TextAlign.center,
                          ),
                        ),

                        SizedBox(height: 16.0),

                        Align(
                          alignment: Alignment.topLeft,
                          child: RichText(
                              text: TextSpan(
                                // style: DefaultTextStyle.of(context).style,
                                  children: [
                                    TextSpan(
                                        text: '👉 Estilo do monumento: ',
                                        style: TextStyle(
                                            fontWeight: FontWeight.bold,
                                            fontSize: 18
                                        )
                                    ),

                                    TextSpan(
                                        text: '${service['style']}',
                                        style: TextStyle(
                                            fontSize: 18
                                        )
                                    )
                                  ]
                              )
                          ),
                        ),

                        SizedBox(height: 10.0),

                        Align(
                          alignment: Alignment.topLeft,
                          child: RichText(
                              text: TextSpan(
                                // style: DefaultTextStyle.of(context).style,
                                  children: [
                                    TextSpan(
                                        text: '👉 Acessibilidade:  ',
                                        style: TextStyle(
                                            fontWeight: FontWeight.bold,
                                            fontSize: 18
                                        )
                                    ),

                                    TextSpan(
                                        text: '${service['accessability']}',
                                        style: TextStyle(
                                            fontSize: 18
                                        )
                                    )
                                  ]
                              )
                          ),
                        ),

                        SizedBox(height: 10.0),

                        Align(
                          alignment: Alignment.topLeft,
                          child: RichText(
                              text: TextSpan(
                                // style: DefaultTextStyle.of(context).style,
                                  children: [
                                    TextSpan(
                                        text: '👉 Horário: ',
                                        style: TextStyle(
                                            fontWeight: FontWeight.bold,
                                            fontSize: 18
                                        )
                                    ),

                                    TextSpan(
                                        text: '${service['schedule']}',
                                        style: TextStyle(
                                            fontSize: 18
                                        )
                                    )
                                  ]
                              )
                          ),
                        ),

                        SizedBox(height: 10.0),


                        Align(
                          alignment: Alignment.topLeft,
                          child: RichText(
                              text: TextSpan(
                                // style: DefaultTextStyle.of(context).style,
                                  children: [
                                    TextSpan(
                                        text: '👉 Preço: ',
                                        style: TextStyle(
                                            fontWeight: FontWeight.bold,
                                            fontSize: 18
                                        )
                                    ),

                                    TextSpan(
                                        text: '${service['price']}',
                                        style: TextStyle(
                                            fontSize: 18
                                        )
                                    )
                                  ]
                              )
                          ),
                        ),


                        SizedBox(height: 10.0),


                        Align(
                          alignment: Alignment.topLeft,
                          child: RichText(
                              text: TextSpan(
                                // style: DefaultTextStyle.of(context).style,
                                  children: [
                                    TextSpan(
                                        text: '👉 Atividade: ',
                                        style: TextStyle(
                                            fontWeight: FontWeight.bold,
                                            fontSize: 18
                                        )
                                    ),

                                    TextSpan(
                                        text: '${service['activity']}',
                                        style: TextStyle(
                                            fontSize: 18
                                        )
                                    )
                                  ]
                              )
                          ),
                        ),

                        SizedBox(height: 10.0),


                        Align(
                          alignment: Alignment.topLeft,
                          child: RichText(
                              text: TextSpan(
                                // style: DefaultTextStyle.of(context).style,
                                  children: [
                                    TextSpan(
                                        text: '👉 Visita Guiada? ',
                                        style: TextStyle(
                                            fontWeight: FontWeight.bold,
                                            fontSize: 18
                                        )
                                    ),

                                    TextSpan(
                                        text: '${service['guide_visit']}',
                                        style: TextStyle(
                                            fontSize: 18
                                        )
                                    )
                                  ]
                              )
                          ),
                        ),

                        SizedBox(height: 10.0),


                        Align(
                          alignment: Alignment.topLeft,
                          child: RichText(
                              text: TextSpan(
                                // style: DefaultTextStyle.of(context).style,
                                  children: [
                                    TextSpan(
                                        text: '👉 Rua: ',
                                        style: TextStyle(
                                            fontWeight: FontWeight.bold,
                                            fontSize: 18
                                        )
                                    ),

                                    TextSpan(
                                        text: '${service['rua']}',
                                        style: TextStyle(
                                            fontSize: 18
                                        )
                                    )
                                  ]
                              )
                          ),
                        ),

                        SizedBox(height: 10.0),

                        Align(
                          alignment: Alignment.topLeft,
                          child: RichText(
                              text: TextSpan(
                                // style: DefaultTextStyle.of(context).style,
                                  children: [
                                    TextSpan(
                                        text: '🌍 Localização: ',
                                        style: TextStyle(
                                            fontWeight: FontWeight.bold,
                                            fontSize: 18
                                        )
                                    ),

                                    TextSpan(
                                        text: '${service['latitude']}, ${service['longitude']}',
                                        style: TextStyle(
                                            fontSize: 18
                                        )
                                    )
                                  ]
                              )
                          ),
                        ),

                        SizedBox(height: 20.0),

                        Align(
                          alignment: Alignment.topLeft,
                          child: RichText(
                              text: TextSpan(
                                // style: DefaultTextStyle.of(context).style,
                                  children: [
                                    TextSpan(
                                        text: '🤔 Ficou interessado? Entre em contacto através do email: ',
                                        style: TextStyle(
                                            fontWeight: FontWeight.bold,
                                            fontSize: 18
                                        )
                                    ),

                                    TextSpan(
                                        text: '${service['user_email']}',
                                        style: TextStyle(
                                            fontSize: 18
                                        )
                                    )
                                  ]
                              )
                          ),
                        ),




                      ],
                  ),
                ),

              ],
            ),


          ],

        ),
      ),



      /*
      Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [

            // APP BAR
            Container(
              margin: const EdgeInsets.all(20),
              padding: const EdgeInsets.all(20),
              decoration: BoxDecoration(
                color: Colors.white,
                borderRadius: BorderRadius.circular(46),
                boxShadow: [
                  BoxShadow(
                    offset: const Offset(0, -2),
                    blurRadius: 30,
                    color: Colors.black.withOpacity(0.16),
                  ),
                ],
              ),
              child: Row(
                children: [


                  IconBack(
                      onPressed: () {
                        Navigator.pop(context);
                      }
                  ),

                  SizedBox(
                    width: 5,
                  ),


                  Text(
                    service['name'].toUpperCase(),
                    style: const TextStyle(
                        fontSize: 40,
                        fontWeight: FontWeight.bold,
                        fontFamily: 'Montserrat'
                    ),
                  ),

                  const Spacer(),

                ],
              ),
            ),


            Text(
              service['story'],
              style: TextStyle(
                fontSize: 18.0,
                fontWeight: FontWeight.bold,
              ),
            ),
            SizedBox(height: 16.0),
            Text(
              'Estilo do monumento: ${service['style']}',
              style: TextStyle(
                fontSize: 16.0,
              ),
            ),
            SizedBox(height: 8.0),
            Text(
              'Acessibilidade:  ${service['accessability']}',
              style: TextStyle(
                fontSize: 16.0,
              ),
            ),
            SizedBox(height: 8.0),
            Text(
              'Horário: ${service['schedule']}',
              style: TextStyle(
                fontSize: 16.0,
              ),
            ),
            SizedBox(height: 8.0),
            Text(
              'Preço: ${service['price']}',
              style: TextStyle(
                fontSize: 16.0,
              ),
            ),
            SizedBox(height: 8.0),
            Text(
              'Atividade: ${service['activity']}',
              style: TextStyle(
                fontSize: 16.0,
              ),
            ),
            SizedBox(height: 8.0),
            Text(
              'Visita Guiada? ${service['guide_visit']}',
              style: TextStyle(
                fontSize: 16.0,
              ),
            ),
            SizedBox(height: 8.0),
            Text(
              'Localização: ${service['latitude']}, ${service['longitude']}',
              style: TextStyle(
                fontSize: 16.0,
              ),
            ),
            SizedBox(height: 8.0),
            Text(
              'Entre em contacto através do email: ${service['user_email']}',
              style: TextStyle(
                fontSize: 16.0,
              ),
            ),
            SizedBox(height: 8.0),
            Text(
              'Rua: ${service['rua']}',
              style: TextStyle(
                fontSize: 16.0,
              ),
            ),
            SizedBox(height: 16.0),
            Text(
              'Imagens:',
              style: TextStyle(
                fontSize: 18.0,
                fontWeight: FontWeight.bold,
              ),
            ),
            SizedBox(height: 8.0),
            GridView.builder(

              shrinkWrap: true,
              physics: NeverScrollableScrollPhysics(),
              itemCount: service['images'] != null ? service['images'].length : 0,

              gridDelegate: SliverGridDelegateWithFixedCrossAxisCount(
                crossAxisCount: 3,
                mainAxisSpacing: 8.0,
                crossAxisSpacing: 8.0,
              ),
              itemBuilder: (context, index) {
                final imageData = service['images'][index];
                return Card(
                  child: Column(
                    children: [
                      Expanded(
                        child: Image.memory(
                          base64Decode(imageData),
                          fit: BoxFit.cover,
                        ),
                      ),
                    ],
                  ),
                );
              },
            ),
          ],
        ),
      ),*/
    ]
    )
    )
    );
  }
}




// FUNCAO COM METODO GET PARA IR BUSCAR OS DADOS AO BACKEND
Future<List<Map<String, dynamic>>> fetchData(String regiao , String tipo) async {
  final response = await http.get(Uri.parse('http://127.0.0.1:8000/services_concelho/$regiao/$tipo/'));

  if (response.statusCode == 200) {
    print(response.body);
    final decodedData = json.decode(response.body);
    // print(decodedData);
    final List<Map<String, dynamic>> alojamentos = List<Map<String, dynamic>>.from(decodedData['district_services']);
    //print(alojamentos);
    return alojamentos;
  } else {
    throw Exception('Failed to load data');
  }
}
