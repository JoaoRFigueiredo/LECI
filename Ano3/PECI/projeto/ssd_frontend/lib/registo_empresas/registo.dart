import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'package:ssd_frontend/registo_empresas/regioes.dart';
import 'dart:convert';
import 'package:firebase_auth/firebase_auth.dart';

import 'package:ssd_frontend/servicos/servicos.dart';

// ...


class RegistoEmpresaPage extends StatefulWidget {
  const RegistoEmpresaPage({Key? key}) : super(key: key);

  @override
  _RegistoEmpresaPageState createState() => _RegistoEmpresaPageState();
}

class _RegistoEmpresaPageState extends State<RegistoEmpresaPage> {
  final _formKey = GlobalKey<FormState>();


  final Empresa _empresa = Empresa();


  @override
  Widget build(BuildContext context) {

    return Scaffold(
      appBar: AppBar(
        title: Text('Registo de Empresa'),
      ),
      body: SingleChildScrollView(

        child: Padding(
          padding: EdgeInsets.all(16),
          child: Form(
            key: _formKey,
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.stretch,
              children: [
                Text("Dados da Empresa",
                    style: TextStyle(fontSize: 24) ),
                TextFormField(
                  decoration: InputDecoration(labelText: 'Nome da Empresa'),
                  validator: (String? value) {
                    if (value!.isEmpty) {
                      return 'Por favor, insira o nome da empresa.';
                    }
                    return null;
                  },
                  onSaved: (String? value) {
                    _empresa.nome = value!;
                  },
                ),


                TextFormField(
                  decoration: InputDecoration(labelText: 'Morada'),
                  validator: (String? value) {
                    if (value!.isEmpty) {
                      return 'Por favor, insira a morada da empresa.';
                    }
                    return null;
                  },
                  onSaved: (value) {
                    _empresa.morada = value!;
                  },
                ),

                //CODIGO POSTAL
                TextFormField(
                  decoration: InputDecoration(labelText: 'Código Postal'),
                  validator: (String? value) {
                    final pattern = RegExp(r'^\d{4}-\d{3}$');
                    if (value!.isEmpty) {
                      return 'Por favor, insira o código postal da empresa.';
                    }
                    else if (!pattern.hasMatch(value)) {
                      return 'Digite um código postal no formato válido (Exemplo: 1234-123)';
                    }
                    return null;
                  },
                  onSaved: (value) {
                    _empresa.codigo = value!;
                  },
                ),

                //NIF
                // DEVO VALIDAR O NIF (O TER 9 NUMEROS ETC ETC)
                TextFormField(
                  decoration: InputDecoration(labelText: 'NIF'),
                  validator: (String? value) {
                    if (value!.isEmpty) {
                      return 'Por favor, insira o NIF da empresa.';
                    }
                    else if (!RegExp(r'^[0-9]+$').hasMatch(value)) {
                      return 'O NIF deve conter apenas números.';
                    }
                    else if(value.length != 9 ){
                      return 'NIF incorreto (9 números..)';
                    }
                    return null;
                  },
                  onSaved: (value) {
                    _empresa.nif = value!;
                  },
                ),

                TextFormField(
                  decoration: InputDecoration(labelText: 'CAE'),
                  validator: (String? value) {
                    if (value!.isEmpty) {
                      return 'Por favor, insira o CAE da empresa.';
                    }
                    else if (!RegExp(r'^[0-9]+$').hasMatch(value)) {
                      return 'O CAE deve conter apenas números.';
                    }
                    else if (value.length != 5) {
                      return 'O CAE tem sempre 5 números...';
                    }

                    return null;
                  },
                  onSaved: (value) {
                    _empresa.cae = value!;
                  },
                ),

                TextFormField(
                    decoration:
                    InputDecoration(labelText: 'Contacto telefónico'),
                    validator: (String? value) {
                      if (value!.isEmpty) {
                        return 'Por favor, insira o contacto telefónico da empresa.';
                      }
                      else if (!RegExp(r'^[0-9]+$').hasMatch(value)) {
                        return 'O contacto telefónico deve conter apenas números.';
                      }
                      return null;
                    },
                    onSaved: (value) {
                      _empresa.contacto = value!;
                    }
                ),

                // EMAIL
                TextFormField(
                  decoration: InputDecoration(labelText: 'E-mail'),
                  // The validator receives the text that the user has entered.
                  validator: (value) {
                    if (value == null || value.isEmpty) {
                      return 'Please enter an account';
                    }
                    return null;
                  },
                  onSaved: (value) {
                    _empresa.email = value!;
                  },
                ),


                TextFormField(
                  decoration: InputDecoration(labelText: 'Website da empresa'),
                  onSaved: (value) {
                    _empresa.website = value!;
                  },
                ),

                SizedBox(height: 30),

                ElevatedButton(
                  onPressed: () async {

                    // Esperar a conclusão da execução de `_submitForm`
                    bool success = await _submitForm();
                    if(success) {
                      // Navegar para a próxima tela
                      Navigator.push(
                        context,
                        MaterialPageRoute(builder: (context) =>
                            RegistoRegiao()),
                      );
                    } else{
                      // Tratar o erro
                      print('Erro ao enviar dados do formulário');
                    }
                  },
                  child: Text("Continuar registo"),
                ),
              ],
            ),
          ),
        ),
      ),
    );
  }

  Future<bool> _submitForm() async {
    if (_formKey.currentState!.validate()) {
      _formKey.currentState!.save();

      // Get the currently authenticated user's email
      String email = FirebaseAuth.instance.currentUser?.email ?? "";

      // Add the email to the _empresa object
      _empresa.user_email = email;

      print(_empresa);

      // Convert the _empresa object to a JSON string
      String empresaJson = jsonEncode(_empresa);

      // Send the JSON string to the Django back-end
      final response = await http.post(Uri.parse('http://127.0.0.1:8000/empresa'),
          body: jsonEncode(_empresa.toDict())
      );
      //headers: {'Content-Type': 'application/json'});

      // Handle the response from the Django back-end
      if (response.statusCode == 200) {
        /* Show a confirmation message
        ScaffoldMessenger.of(context).showSnackBar(
            SnackBar(content: Text('Empresa registada com sucesso!')));
          */
        print('Empresa object sent successfully');
        return true;
      } else {
        print('Failed to send Empresa object');
        return false;
      }
    }
    return false;
  }
}

class Empresa {
  late String nome;
  late String morada;
  late String nif;
  late String cae;
  late String contacto;
  late String email;
  late String user_email;
  late String website;
  late String codigo;

  Map<String, dynamic> toDict() {
    return {
      'nome': nome,
      'morada': morada,
      'nif': nif,
      'cae': cae,
      'contacto': contacto,
      'email': email,
      'user_email': user_email,
      'website': website,
      'codigo': codigo,
    };
  }

  String toJson() => jsonEncode(toDict());

  static Empresa fromJson(String source) => fromMap(json.decode(source));

  static Empresa fromMap(Map<String, dynamic> map) {
    return Empresa()
      ..nome = map['nome']
      ..morada = map['morada']
      ..nif = map['nif']
      ..cae = map['cae']
      ..contacto = map['contacto']
      ..email = map['email']
      ..user_email = map['user_email']
      ..website = map['website']
      ..codigo = map['codigo'];
  }

  Map<String, dynamic> get empresa {
    return {
      'nome': nome,
      'morada': morada,
      'nif': nif,
      'cae': cae,
      'contacto': contacto,
      'email': email,
      'user_email': user_email,
      'website': website,
      'codigo': codigo,
    };
  }

  @override
  String toString() {
    return 'Empresa(nome: $nome, morada: $morada, nif: $nif, cae: $cae, '
        'contacto: $contacto, email: $email,  '
        ' user_email: $user_email,  website: $website , codigo:$codigo , ';
  }
}
