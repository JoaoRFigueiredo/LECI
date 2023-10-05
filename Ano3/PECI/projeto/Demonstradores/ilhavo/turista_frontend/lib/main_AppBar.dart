import 'package:flutter/material.dart';

class CustomAppBar extends StatelessWidget {
  const CustomAppBar({super.key});

  @override
  Widget build(BuildContext context) {
    return Container(
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

          /*
          Image.asset(
            "assets/icons/icon_app.png",
            height: 40,
            alignment: Alignment.topCenter,
          ),*/


          Text(
            "LusiTravel".toUpperCase(),
            style: const TextStyle(fontSize: 22, fontWeight: FontWeight.bold),
          ),

          const Spacer(),

          /*
          ElevatedButton(
              onPressed: () {
                Navigator.push(context, MaterialPageRoute(
                    builder: (context) => RegistoEmpresaPage())
                );
              },
              child: Text("Registo de Empresa",
                style: TextStyle(
                    fontSize: 18
                ),
              )
          ),
          SizedBox(
            width: 5,
          ),

          ElevatedButton(
              onPressed: () {
                Navigator.push(context, MaterialPageRoute(
                    builder: (context) => LoginTurista())
                );
              },
              child: Text("Login",
                style: TextStyle(
                    fontSize: 18
                ),
              )
          ),

          SizedBox(
            width: 5,
          ),

          ElevatedButton(
              onPressed: () {
                Navigator.push(context, MaterialPageRoute(
                    builder: (context) => FeaturesEmpresa())
                );
              },
              child: Text("Área da Empresa",
                style: TextStyle(
                    fontSize: 18
                ),
              )
          ),
          */

          /*
          ElevatedButton(
              onPressed: () {
                Navigator.push(context, MaterialPageRoute(
                    builder: (context) => RegistoEmpresaPage())
                );
              },
              child: Text("Sobre",)
          ),*/


          /*
          MenuItem(
            title: "Registo de Empresa",
            press: () {
              Navigator.push(context, MaterialPageRoute(
                  builder: (context) => RegistoEmpresaPage())
              );
            },
          ),
          const Spacer(),
          MenuItem(
            title: "Login",
            press: () {
              Navigator.push(context, MaterialPageRoute(
                  builder: (context) => LoginTurista())
              );
            },
          ),
          const Spacer(),
          MenuItem(
            title: "Área da Empresa",
            press: () {
              Navigator.push(context, MaterialPageRoute(
                  builder: (context) => FeaturesEmpresa())
              );
            },
          ),
          const Spacer(),
          MenuItem(
            title: "Sobre",
            press: () {},
          ),
          const Spacer(),*/
        ],
      ),
    );
  }
}