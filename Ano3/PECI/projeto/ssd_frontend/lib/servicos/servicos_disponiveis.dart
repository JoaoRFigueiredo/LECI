import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:firebase_auth/firebase_auth.dart';
import 'package:firebase_core/firebase_core.dart';
import 'package:get/get.dart';
import 'package:get/get_core/src/get_main.dart';
import 'package:lottie/lottie.dart';
import 'package:ssd_frontend/formularios/forms_alojamento.dart';
import 'package:ssd_frontend/formularios/forms_monumentos.dart';
import 'package:ssd_frontend/registo_empresas/signUp_pessoa.dart';
import '../componentes/constants.dart';
import '../componentes/simple_ui_controller.dart';
import '../features_empresa/features_empresa.dart';
import '../formularios/forms_restauracao.dart';


class ServicosDisponiveis extends StatefulWidget {
  const ServicosDisponiveis ({Key? key}) : super(key: key);

  @override
  State<ServicosDisponiveis> createState() => _ServicosDisponiveisState();
}

class _ServicosDisponiveisState extends State<ServicosDisponiveis> {

  @override
  Widget build(BuildContext context) {
    var size = MediaQuery.of(context).size;
    var theme = Theme.of(context);

    return GestureDetector(
      onTap: () => FocusManager.instance.primaryFocus?.unfocus(),
      child: Scaffold(
        backgroundColor: Colors.white,
        resizeToAvoidBottomInset: false,
        body: LayoutBuilder(
          builder: (context, constraints) {
            if (constraints.maxWidth > 600) {
              return _buildLargeScreen(size, theme);
            } else {
              return _buildSmallScreen(size, theme);
            }
          },
        ),
      ),
    );
  }

  Widget _buildLargeScreen(Size size, ThemeData theme) {
    return Row(
      children: [
        Expanded(
          flex: 4,
          child: Stack(
            children: [
              Image(
                image: AssetImage('assets/images_servicos/turismo_portugal1.jpg'),
                height: size.height,
                width: double.infinity,
                fit: BoxFit.fill,
              ),
              Positioned(
                top: 16,
                left: 16,
                child: IconButton(
                  icon: Icon(Icons.arrow_back),
                  color: Colors.white,
                  onPressed: () {
                    Navigator.pop(context);
                  },
                ),
              ),
            ],
          ),
        ),
        SizedBox(width: size.width * 0.06),
        Expanded(
          flex: 5,
          child: _buildMainBody(size, theme),
        ),
      ],
    );
  }

  Widget _buildSmallScreen(Size size, ThemeData theme) {
    return Center(
      child: _buildMainBody(size, theme),
    );
  }

  /// Main Body
  Widget _buildMainBody(Size size, ThemeData theme) {

    final double width = MediaQuery.of(context).size.width;
    final double height = MediaQuery.of(context).size.height;

    return Column(
      //crossAxisAlignment: CrossAxisAlignment.start,
      mainAxisAlignment:MainAxisAlignment.center,
      children: [
        /*
        size.width > 600
            ? Container()
            : Lottie.asset(
          'assets/icons/icon_app.png',
          height: size.height * 0.2,
          width: size.width,
          fit: BoxFit.fill,
        ),*/
        /*
        SizedBox(
          height: size.height * 0.0,
        ),*/

        //Center(
          Padding(
            padding: const EdgeInsets.only(left: 20.0),
            child: Text(
              'Crie um serviço',
              style: kLoginTitleStyle(size),
            ),
          ),
        //),

        SizedBox(
          height: height* 0.05,
        ),

        Center(
          child: Row(
            mainAxisAlignment: MainAxisAlignment.spaceEvenly,
            children: [
              SizedBox(
                width: width*0.30,
                height: height*0.1,
                child: ElevatedButton(
                    onPressed: () {
                      Navigator.push(context, MaterialPageRoute(
                          builder: (context) => RestaurantForm())
                      );
                    },
                    style: ElevatedButton.styleFrom(
                      shadowColor: Colors.black,
                      elevation: 15,
                      backgroundColor: Colors.blueAccent,
                      shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(13.0)),
                    ),
                    child: Column(
                      mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                      children: const [
                        Icon(
                            Icons.food_bank_outlined,
                            size: 45,
                            color: Colors.white
                        ),

                        Text('RESTAURAÇÃO',
                          style: TextStyle(
                              fontSize: Checkbox.width,
                              fontFamily: 'Montserrat',
                              color: Colors.white
                          ),
                        ),
                      ],
                    )
                ),
              ),
            ],
          ),
        ),

        SizedBox(
          height: height* 0.02,
        ),

        Center(
          child: Row(
            mainAxisAlignment: MainAxisAlignment.spaceEvenly,
            children: [
              SizedBox(
                width: width*0.30,
                height: height*0.1,
                child: ElevatedButton(
                    onPressed: () {
                      Navigator.push(context, MaterialPageRoute(
                          builder: (context) => AlojamentoForm())
                      );
                    },
                    style: ElevatedButton.styleFrom(
                      shadowColor: Colors.black,
                      elevation: 15,
                      backgroundColor: Colors.blueAccent,
                      shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(13.0)),
                    ),
                    child: Column(
                      mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                      children: const [
                        Icon(
                            Icons.local_hotel,
                            size: 45,
                            color: Colors.white
                        ),

                        Text('ALOJAMENTO',
                          style: TextStyle(
                              fontSize: Checkbox.width,
                              fontFamily: 'Montserrat',
                              color: Colors.white
                          ),
                        ),
                      ],
                    )
                ),
              ),
            ],
          ),
        ),

        SizedBox(
          height: height* 0.02,
        ),

        Center(
          child: Row(
            mainAxisAlignment: MainAxisAlignment.spaceEvenly,
            children: [
              SizedBox(
                width: width*0.30,
                height: height*0.1,
                child: ElevatedButton(
                    onPressed: () {
                      Navigator.push(context, MaterialPageRoute(
                          builder: (context) => MonumentoForm())
                      );
                    },
                    style: ElevatedButton.styleFrom(
                      shadowColor: Colors.black,
                      elevation: 15,
                      backgroundColor: Colors.blueAccent,
                      shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(13.0)),
                    ),
                    child: Column(
                      mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                      children: const [
                        Icon(
                            Icons.castle,
                            size: 45,
                            color: Colors.white
                        ),

                        Text('EDIFÍCIOS CULTURAIS',
                          style: TextStyle(
                              fontSize: Checkbox.width,
                              fontFamily: 'Montserrat',
                              color: Colors.white
                          ),
                        ),
                      ],
                    )
                ),
              ),
            ],
          ),
        ),


        /*
        const SizedBox(
          height: 10,
        ),
        */

        /*
        Padding(
          padding: const EdgeInsets.only(left: 20.0),
          child: Text(
            'Create Account',
            style: kLoginSubtitleStyle(size),
          ),
        ),*/

    /*
        Expanded(
            child: Align(
              alignment: Alignment. topCenter,
              child: Wrap(
                runSpacing: (height+200)*0.02, //Space between Rows
                // PESQUISAR SOBRE FUNÇÃO PARA OCUPAR O RESTANTE ESPAÇO
                children: [

                  /*
                  Center(
                    child: Row(
                      mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                      children: [
                        SizedBox(
                          width: width*0.30,
                          height: height*0.1,
                          child: ElevatedButton(
                              onPressed: () {},
                              style: ElevatedButton.styleFrom(
                                shadowColor: Colors.black,
                                elevation: 15,
                                backgroundColor: Color.fromARGB(230, 152, 0, 1),
                                shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(13.0)),
                              ),
                              child: Column(
                                mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                                children: const [
                                  Icon(
                                      Icons.fire_truck,
                                      size: 45,
                                      color: Colors.white
                                  ),

                                  Text('OCORRÊNCIAS ATIVAS',
                                    style: TextStyle(
                                        fontSize: Checkbox.width,
                                        fontFamily: 'Montserrat',
                                        color: Colors.white
                                    ),
                                  ),
                                ],
                              )
                          ),
                        ),
                      ],
                    ),
                  ),

                   */


                  Center(
                    child: Row(
                      mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                      children: [
                        SizedBox(
                          width: width*0.30,
                          height: height*0.1,
                          child: ElevatedButton(
                              onPressed: () {},
                              style: ElevatedButton.styleFrom(
                                shadowColor: Colors.black,
                                elevation: 15,
                                backgroundColor: Color.fromARGB(230, 152, 0, 1),
                                shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(13.0)),
                              ),
                              child: Column(
                                mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                                children: const [
                                  Icon(
                                      Icons.fire_truck,
                                      size: 45,
                                      color: Colors.white
                                  ),

                                  Text('OCORRÊNCIAS ATIVAS',
                                    style: TextStyle(
                                        fontSize: Checkbox.width,
                                        fontFamily: 'Montserrat',
                                        color: Colors.white
                                    ),
                                  ),
                                ],
                              )
                          ),
                        ),
                      ],
                    ),
                  ),


                  Center(
                    child: Row(
                      mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                      children: [
                        SizedBox(
                          width: width*0.30,
                          height: height*0.1,
                          child: ElevatedButton(
                              onPressed: () {},
                              style: ElevatedButton.styleFrom(
                                shadowColor: Colors.black,
                                elevation: 15,
                                backgroundColor: Color.fromARGB(230, 152, 0, 1),
                                shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(13.0)),
                              ),
                              child: Column(
                                mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                                children: const [
                                  Icon(
                                    Icons.groups_rounded,
                                    size: 45,
                                    color: Colors.white,
                                  ),

                                  Text('REGISTO BIOMÉTRICO',
                                    style: TextStyle(
                                        fontSize: Checkbox.width,
                                        fontFamily: 'Montserrat',
                                        color: Colors.white
                                    ),
                                  ),
                                ],
                              )
                          ),
                        ),
                      ],
                    ),
                  ),

                  Center(
                    child: Row(
                      mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                      children: [
                        SizedBox(
                          width: width*0.30,
                          height: height*0.1,
                          child: ElevatedButton(
                              onPressed: () {},
                              style: ElevatedButton.styleFrom(
                                shadowColor: Colors.black,
                                elevation: 15,
                                backgroundColor: Color.fromARGB(230, 152, 0, 1),
                                shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(13.0)),
                              ),
                              child: Column(
                                mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                                children: const [
                                  Icon(
                                      Icons.fireplace_outlined,
                                      size: 45,
                                      color: Colors.white
                                  ),

                                  Text('PRO',
                                    style: TextStyle(
                                        fontSize: Checkbox.width,
                                        fontFamily: 'Montserrat',
                                        color: Colors.white
                                    ),
                                  ),
                                ],
                              )
                          ),
                        ),
                      ],
                    ),
                  ),




                  /*
                  Row(
                    mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                    children: [
                      SizedBox(
                        width: width*0.30,
                        height: height*0.1,
                        child: ElevatedButton(
                            onPressed: () {},
                            style: ElevatedButton.styleFrom(
                              shadowColor: Colors.black,
                              elevation: 15,
                              backgroundColor: Color.fromARGB(230, 152, 0, 1),
                              shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(13.0)),
                            ),
                            child: Column(
                              mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                              children: const [
                                Icon(
                                    Icons.language_outlined,
                                    size: 45,
                                    color: Colors.white
                                ),

                                Text('GESCORP',
                                  style: TextStyle(
                                      fontSize: Checkbox.width,
                                      fontFamily: 'Montserrat',
                                      color: Colors.white
                                  ),
                                ),
                              ],
                            )
                        ),
                      ),
                    ],
                  ),
                  */


                ],
              ),
            )
        ),
    */

      ],
    );

  }


}
