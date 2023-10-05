import 'package:flutter/material.dart';
import 'package:flutter_image_slideshow/flutter_image_slideshow.dart';

import 'AlojamentoService.dart';
import 'EdificiosCulturaisService.dart';
import 'RestauracaoService.dart';
import 'main_AppBar.dart';

class HomePage extends StatelessWidget {
  HomePage({Key? key}) : super(key: key);

  final Shader iphoneShader = LinearGradient(
    colors: [Color(0xFF070D14), Color(0xFF85D1EE)],
  ).createShader(Rect.fromLTWH(0, 0, 750, 100));


  @override
  Widget build(BuildContext context) {
    final List<String> images = [
      'assets/main_images/lhavo.jpg',
      'assets/main_images/Ilhavo2.jpg',
      'assets/main_images/Ilhavo3.jpg',
      'assets/main_images/ilhavo7.jpeg',
    ];

    final List<String> images1 = [
      'assets/main_images/ilhavo4.jpg',
      'assets/main_images/ilhavo5.jpg',
      'assets/main_images/ilhavo6.jpg',
      'assets/main_images/ilhavo8.jpg',
      'assets/main_images/ilhavo9.jpg',
    ];

    final double width = MediaQuery.of(context).size.width;
    final double height = MediaQuery.of(context).size.height;

    return Scaffold(
      appBar: AppBar(
        toolbarHeight: 75,
        backgroundColor: Colors.white,
        elevation: 0,
        title: Padding(
          padding: EdgeInsets.symmetric(horizontal: 16),
          child: Row(
            children: [
              Image.asset(
                'assets/main_images/logo.png',
                height: 75,
              ),
              SizedBox(width: 10),
              Text(
                'Câmara Municipal de Ílhavo',
                style: TextStyle(fontSize: 18),
              ),
            ],
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
      ),



      body: Container(
        decoration: BoxDecoration(
          color: Color(0xFFD6E4F0),
        ),
        child: Padding(
          padding: EdgeInsets.symmetric(horizontal: 20),
          child: ListView(
            physics: NeverScrollableScrollPhysics(),
            children: [
              SizedBox(height: 10),
              Text(
                'Bem vindo a Ílhavo',
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
              SizedBox(height: 50),
              Row(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  Expanded(
                    flex: 1,
                    child: Text(
                      'Intrinsecamente ligado à Ria e inevitavelmente voltado para o Mar, o Município de Ílhavo tem nesta ligação a sua principal característica, que o distingue dos demais quer pela sua geografia, quer pela sua História. Com cerca de nove séculos e meio de vida documentada, Ílhavo é apontada por vários autores como sendo descendente de lendários navegadores, possivelmente fenícios, gregos ou então antigos navegadores dos mares do Norte e até Romanos, que entraram pela foz do Vouga e estabeleceram-se nas suas margens, sendo os próprios ilhavenses, já muito cruzados com várias raças, igualmente invocados como os míticos fundadores de numerosas povoações marítimas. A primeira referência escrita à “villa iliauo”, que consta do cartulário do Arquivo Nacional da Torre do Tombo, designado por Livro Preto da Sé de Coimbra, remonta ao século XI, mais concretamente entre 1037 e 1065, sendo a sua doação mencionada aquando da tomada definitiva de Coimbra, em plena Reconquista Cristã.',
                      textAlign: TextAlign.justify,
                      style: TextStyle(
                        color: Colors.black,
                        fontSize: 18,
                        fontFamily: 'Montserrat',
                      ),
                    ),
                  ),
                  SizedBox(width: 20),
                  Expanded(
                    flex: 1,
                    child: ImageSlideshow(
                      width: width * 0.4,
                      height: height * 0.3,
                      initialPage: 0,
                      indicatorColor: Colors.blue,
                      indicatorBackgroundColor: Colors.grey,
                      children: images
                          .map((image) => Image.asset(
                        image,
                        fit: BoxFit.cover,
                      ))
                          .toList(),
                      autoPlayInterval: 3000,
                      isLoop: true,
                    ),
                  ),
                ],
              ),
              SizedBox(height: 50),
              Row(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  SizedBox(width: 20),
                  Expanded(
                    flex: 1,
                    child: ImageSlideshow(
                      width: width * 0.4,
                      height: height * 0.3,
                      initialPage: 0,
                      indicatorColor: Colors.blue,
                      indicatorBackgroundColor: Colors.grey,
                      children: images1
                          .map((image) => Image.asset(
                        image,
                        fit: BoxFit.cover,
                      ))
                          .toList(),
                      autoPlayInterval: 3000,
                      isLoop: true,
                    ),
                  ),
                  SizedBox(width: 20),
                  Expanded(
                    flex: 1,
                    child: Text(
                      'Com raízes históricas que remontam à Idade Média, os Forais, também denominados de Cartas de Foral, são documentos concedidos unilateralmente por um Rei ou senhorio aos habitantes de uma povoação que se queria libertar do poder senhorial, atribuindo-lhes foro jurídico próprio. Neles consagravam-se direitos, privilégios e obrigações económicas, sociais e políticas de uma determinada comunidade que, com o passar do tempo, deram origem a muitos conflitos e injustiças, dada a grande fragmentação dos municípios no que respeita à aplicação das suas leis.'
                          'Já bastante povoado por esta altura, Ílhavo recebe a Inquirição a 13 de outubro de 1296, pela mão de El-Rei D. Dinis, que concedeu à sua povoação várias regalias expressas na Carta Régia.',
                      textAlign: TextAlign.justify,
                      style: TextStyle(
                        color: Colors.black,
                        fontSize: 18,
                        fontFamily: 'Montserrat',
                      ),
                    ),
                  ),
                ],
              ),
            ],
          ),
        ),
      ),
    );
  }
}
