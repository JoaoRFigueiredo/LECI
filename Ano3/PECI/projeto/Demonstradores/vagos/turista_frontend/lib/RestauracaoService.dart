import 'package:carousel_slider/carousel_slider.dart';
import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'package:photo_view/photo_view.dart';
import 'dart:convert';

import 'AppBar_Restauracao.dart';
import 'IconBack.dart';


class RestauracaoService extends StatefulWidget{
  final String regiao;
  final String tipo;

  RestauracaoService(this.regiao , this.tipo);

  @override
  _RestauracaoServiceState createState() => _RestauracaoServiceState();

}

class _RestauracaoServiceState extends State<RestauracaoService>{
  late Future<List<dynamic>> _futureData;

  @override
  void initState() {
    super.initState();
    _futureData = fetchData(widget.regiao , widget.tipo);
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(

      body: Container(
        decoration: BoxDecoration(
          image: DecorationImage(
              image: AssetImage('assets/main_images/cortegaca.jpeg'),
              fit: BoxFit.cover
          ),
        ),
        child: Column(
          children: [

            CustomAppBarRestauracao(),


            Expanded(
              child: FutureBuilder<List<dynamic>>(
                future: _futureData,
                builder: (context, snapshot) {
                  if (snapshot.hasData) {
                    final List alojamentos = snapshot.data!;
                    return ListView.builder(
                      itemCount: alojamentos.length,
                      itemBuilder: (context, index) {
                        final alojamento = alojamentos[index];

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
                                title: Text(alojamento['name'],
                                  style: TextStyle(
                                      fontFamily: 'Romelio',
                                      fontSize: 18
                                  ),
                                ),
                                subtitle: Text(alojamento['description'],
                                  style: TextStyle(
                                    fontSize: 17,
                                  ),
                                ),
                                trailing: Icon(Icons.arrow_forward),
                                onTap: () {
                                  Navigator.push(
                                    context,
                                    MaterialPageRoute(
                                      builder: (context) => DetalhesServicoWidget(service: alojamento),
                                    ),
                                  );
                                },
                              ),
                            ],
                          ),
                        );


                        /*
                      return ListTile(
                        title: Text(alojamento['name'],
                          style: TextStyle(
                              fontFamily: 'Romelio',
                              fontSize: 18
                          ),
                        ),
                        subtitle: Text(alojamento['description'],
                          style: TextStyle(
                            fontSize: 17,
                          ),
                        ),
                        trailing: Icon(Icons.arrow_forward),
                        onTap: () {
                          Navigator.push(
                            context,
                            MaterialPageRoute(
                              builder: (context) => DetalhesServicoWidget(service: alojamento),
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



    );
  }
}

// VAI REPRESENTAR OS DETALHES TODOS DO SERVIÇO, OU SEJA OS DADOS TODOS
class DetalhesServicoWidget extends StatelessWidget {
  final Map<String, dynamic> service;

  const DetalhesServicoWidget({Key? key, required this.service}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(


      body: Container(
        decoration: BoxDecoration(
          image: DecorationImage(
              image: AssetImage('assets/main_images/Sky.jpg'),
              fit: BoxFit.cover
          ),
        ),
        child: ListView(
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
                        fontFamily: 'Hellishy'
                    ),
                  ),

                  const Spacer(),

                ],
              ),
            ),


            //////////////////////////////////////////////////////
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
                            service['description'],
                            style: TextStyle(
                              fontSize: 30.0,
                              fontWeight: FontWeight.bold,
                            ),
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
                                        text: '👉 Horário: ',
                                        style: TextStyle(
                                            fontWeight: FontWeight.bold,
                                            fontSize: 18
                                        )
                                    ),

                                    TextSpan(
                                        text: '${service['hours']}',
                                        style: TextStyle(
                                            fontSize: 18
                                        )
                                    )
                                  ]
                              )
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
                                        text: '👉 Promoções: ',
                                        style: TextStyle(
                                            fontWeight: FontWeight.bold,
                                            fontSize: 18
                                        )
                                    ),

                                    TextSpan(
                                        text: '${service['promo']}',
                                        style: TextStyle(
                                            fontSize: 18
                                        )
                                    )
                                  ]
                              )
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
                                        text: '🌍 Coordenadas: ',
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


                        CarouselSlider.builder(
                          options: CarouselOptions(
                            enableInfiniteScroll: true,
                            autoPlay: true,
                            autoPlayAnimationDuration: Duration(milliseconds: 500),
                            enlargeCenterPage: true, // Amplia a imagem central
                            aspectRatio: 4, // Proporção de aspecto da imagem
                          ),
                          itemCount: service['ementa'] != null ? service['ementa'].length : 0,
                          itemBuilder: (context, index, realIndex) {
                            final imageData = service['ementa'][index];
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
                        fontFamily: 'Hellishy'
                    ),
                  ),

                  const Spacer(),

                ],
              ),
            ),

            Text(
              service['description'],
              style: TextStyle(
                fontSize: 18.0,
                fontWeight: FontWeight.bold,
              ),
            ),
            SizedBox(height: 16.0),
            Text(
              'Horário: ${service['hours']}',
              style: TextStyle(
                fontSize: 16.0,
              ),
            ),
            SizedBox(height: 8.0),
            Text(
              'Promoções: ${service['promo']}',
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

            SizedBox(height: 8.0),
            Text(
              'Coordenadas: ${service['latitude']}, ${service['longitude']}',
              style: TextStyle(
                fontSize: 16.0,
              ),
            ),
            SizedBox(height: 8.0),
            Text(
              'Entre em contacto através do email: ${service['email']}',
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
            SizedBox(height: 8.0),
            GridView.builder(

              shrinkWrap: true,
              physics: NeverScrollableScrollPhysics(),
              itemCount: service['ementa'] != null ? service['ementa'].length : 0,

              gridDelegate: SliverGridDelegateWithFixedCrossAxisCount(
                crossAxisCount: 3,
                mainAxisSpacing: 8.0,
                crossAxisSpacing: 8.0,
              ),
              itemBuilder: (context, index) {
                final imageData = service['ementa'][index];
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
    );
  }
}




// FUNCAO COM METODO GET PARA IR BUSCAR OS DADOS AO BACKEND
Future<List<Map<String, dynamic>>> fetchData(String regiao , String tipo) async {
  final response = await http.get(Uri.parse('http://127.0.0.1:8000/services_concelho/$regiao/$tipo/'));

  if (response.statusCode == 200) {

    final decodedData = json.decode(response.body);
    // print(decodedData);
    final List<Map<String, dynamic>> alojamentos = List<Map<String, dynamic>>.from(decodedData['district_services']);
    //print(alojamentos);
    return alojamentos;
  } else {
    throw Exception('Failed to load data');
  }
}



class ImageFromBase64String extends StatelessWidget {
  final String base64String;

  ImageFromBase64String(this.base64String);

  @override
  Widget build(BuildContext context) {
    return Image.memory(
      base64Decode(base64String),
      fit: BoxFit.cover,
    );
  }
}
