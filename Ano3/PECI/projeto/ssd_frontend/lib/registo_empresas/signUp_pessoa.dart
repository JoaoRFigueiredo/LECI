import 'dart:convert';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

import 'package:http/http.dart' as http;

import 'package:get/get.dart';
import 'package:lottie/lottie.dart';
import 'package:ssd_frontend/registo_empresas/empresas.dart';

import '../login/login_turista.dart';
import 'package:ssd_frontend/componentes/constants.dart';
import 'package:ssd_frontend/componentes/simple_ui_controller.dart';

import 'package:firebase_auth/firebase_auth.dart';
import 'package:cloud_firestore/cloud_firestore.dart';


class SignUpView extends StatefulWidget {
  const SignUpView({Key? key}) : super(key: key);

  @override
  State<SignUpView> createState() => _SignUpViewState();
}

class _SignUpViewState extends State<SignUpView> {
  TextEditingController nameController = TextEditingController();
  TextEditingController emailController = TextEditingController();
  TextEditingController passwordController = TextEditingController();

  final _formKey = GlobalKey<FormState>();

  Users _user = new Users();

  final FirebaseAuth _auth = FirebaseAuth.instance;
  final FirebaseFirestore _firestore = FirebaseFirestore.instance;

  void _submitForm() async {
  try {
    UserCredential userCredential =
        await _auth.createUserWithEmailAndPassword(
      email: emailController.text.trim(),
      password: passwordController.text.trim(),
    );

    if (userCredential.user != null) {
      // Create a new map to store user details
      Map<String, dynamic> userData = {
        'name': nameController.text.trim(),
        'email': emailController.text.trim(),
        'password': passwordController.text.trim(),
      };

      // Convert the userData map to a JSON string
      String userJson = jsonEncode(userData);

      // Send the JSON string to the Django back-end
      final response = await http.post(
        Uri.parse('http://127.0.0.1:8000/users/register'),
        headers: {'Content-Type': 'application/json'},
        body: userJson,
      );

      // Handle the response from the Django back-end
      if (response.statusCode == 200) {
        print('User object sent successfully');
      } else {
        print('Failed to send User object');
      }
    }
  } catch (e) {
    print('Error creating user: $e');
  }
}




  @override
  void dispose() {
    //nameController.dispose();
    emailController.dispose();
    passwordController.dispose();
    super.dispose();
  }

  SimpleUIController simpleUIController = Get.put(SimpleUIController());

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
            return _buildLargeScreen(size, simpleUIController, theme);
          } else {
            return _buildSmallScreen(size, simpleUIController, theme);
          }
        },
      ),
    ),
  );
}

  /// For large screens
  Widget _buildLargeScreen(
  Size size, SimpleUIController simpleUIController, ThemeData theme) {
  return Row(
    children: [
      Expanded(
        flex: 4,
          child: Stack(
            children: [
              Image(
                image: AssetImage('assets/images_servicos/turismo_portugal4.jpg'),
                height: size.height,
                width: double.infinity,
                fit: BoxFit.fill,
              ),
              Positioned(
                top: 10,
                left: 10,
                child: IconButton(
                  icon: Icon(Icons.arrow_back),
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
        child: _buildMainBody(size, simpleUIController, theme),
      ),
    ],
  );
}

  


  /// For Small screens
  Widget _buildSmallScreen(
      Size size, SimpleUIController simpleUIController, ThemeData theme) {
    return Center(
      child: _buildMainBody(size, simpleUIController, theme),
    );
  }

  /// Main Body
  Widget _buildMainBody(
      Size size, SimpleUIController simpleUIController, ThemeData theme) {
    return Column(
      crossAxisAlignment: CrossAxisAlignment.start,
      mainAxisAlignment:
      size.width > 600 ? MainAxisAlignment.center : MainAxisAlignment.start,
      children: [
        size.width > 600
            ? Container()
            : Lottie.asset(
          'assets/icons/icon_app.png',
          height: size.height * 0.2,
          width: size.width,
          fit: BoxFit.fill,
        ),
        SizedBox(
          height: size.height * 0.03,
        ),
        Padding(
          padding: const EdgeInsets.only(left: 20.0),
          child: Text(
            'Sign Up',
            style: kLoginTitleStyle(size),
          ),
        ),
        const SizedBox(
          height: 10,
        ),
        Padding(
          padding: const EdgeInsets.only(left: 20.0),
          child: Text(
            'Crie a sua conta',
            style: kLoginSubtitleStyle(size),
          ),
        ),
        SizedBox(
          height: size.height * 0.03,
        ),
        Padding(
          padding: const EdgeInsets.only(left: 20.0, right: 20),
          child: Form(
            key: _formKey,
            child: Column(
              children: [
                /// username
                TextFormField(
                  style: kTextFormFieldStyle(),
                  decoration: const InputDecoration(
                    prefixIcon: Icon(Icons.person),
                    hintText: 'Username',
                    border: OutlineInputBorder(
                      borderRadius: BorderRadius.all(Radius.circular(15)),
                    ),
                  ),

                  controller: nameController,
                  // The validator receives the text that the user has entered.
                  validator: (value) {
                    if (value == null || value.isEmpty) {
                      return 'Please enter username';
                    } else if (value.length < 4) {
                      return 'at least enter 4 characters';
                    } else if (value.length > 13) {
                      return 'maximum character is 13';
                    }
                    return null;
                  },
                ),
                SizedBox(
                  height: size.height * 0.02,
                ),

                /// Email
                TextFormField(
                  style: kTextFormFieldStyle(),
                  controller: emailController,
                  decoration: const InputDecoration(
                    prefixIcon: Icon(Icons.email_rounded),
                    hintText: 'e-mail',
                    border: OutlineInputBorder(
                      borderRadius: BorderRadius.all(Radius.circular(15)),
                    ),
                  ),
                  // The validator receives the text that the user has entered.
                  validator: (value) {
                    if (value == null || value.isEmpty) {
                      return 'Please enter e-mail';
                    } //else if ((!value.endsWith('@gmail.com')) || (!value.endsWith('@outlook.pt'))) {
                      //return 'please enter valid e-mail';
                    //}
                    return null;
                  },
                ),

                SizedBox(
                  height: size.height * 0.02,
                ),

                /// password
                Obx(
                      () => TextFormField(
                      style: kTextFormFieldStyle(),
                      controller: passwordController,
                      obscureText: simpleUIController.isObscure.value,
                      decoration: InputDecoration(
                        prefixIcon: const Icon(Icons.lock_open),
                        suffixIcon: IconButton(
                          icon: Icon(
                            simpleUIController.isObscure.value
                                ? Icons.visibility
                                : Icons.visibility_off,
                          ),
                          onPressed: () {
                            simpleUIController.isObscureActive();
                          },
                        ),
                        hintText: 'Password',
                        border: const OutlineInputBorder(
                          borderRadius: BorderRadius.all(Radius.circular(15)),
                        ),
                      ),
                      // The validator receives the text that the user has entered.
                      validator: (value) {
                        if (value == null || value.isEmpty) {
                          return 'Please enter some text';
                        } else if (value.length < 7) {
                          return 'at least enter 6 characters';
                        } else if (value.length > 13) {
                          return 'maximum character is 13';
                        }
                        return null;
                    },
                  ),
                ),
                SizedBox(
                  height: size.height * 0.01,
                ),
                Text(
                  'Ao criar conta está a aceitar os nossos Termos de Serviços e as nossas Políticas de Privacidade.',
                  style: kLoginTermsAndPrivacyStyle(size),
                  textAlign: TextAlign.center,
                ),
                SizedBox(
                  height: size.height * 0.02,
                ),

                /// SignUp Button
                signUpButton(theme),
                SizedBox(
                  height: size.height * 0.03,
                ),

                /// Navigate To Login Screen
                GestureDetector(
                  onTap: () {
                    Navigator.push(
                        context,
                        CupertinoPageRoute(
                            builder: (ctx) => const LoginTurista()));
                    //nameController.clear();
                    emailController.clear();
                    passwordController.clear();
                    _formKey.currentState?.reset();

                    simpleUIController.isObscure.value = true;
                  },

                  child: RichText(
                    text: TextSpan(
                      text: 'Já tem conta?',
                      style: kHaveAnAccountStyle(size),
                      children: [
                        TextSpan(
                            text: " Faça login aqui",
                            style: kLoginOrSignUpTextStyle(size)),
                      ],
                    ),
                  ),

                ),
              ],
            ),
          ),
        ),
      ],
    );
  }

  // SignUp Button
  Widget signUpButton(ThemeData theme) {
    return SizedBox(
      width: double.infinity,
      height: 55,
      child: ElevatedButton(
        style: ButtonStyle(
          backgroundColor: MaterialStateProperty.all(Colors.deepPurpleAccent),
          shape: MaterialStateProperty.all(
            RoundedRectangleBorder(
              borderRadius: BorderRadius.circular(15),
            ),
          ),
        ),
        onPressed: () {
          
          if (_formKey.currentState!.validate()) {
            _submitForm();
            Navigator.push(context, MaterialPageRoute(builder: (context) => const RegistoEmpresaPage()));
          }
          
          // Validate returns true if the form is valid, or false otherwise.
          // if (_formKey.currentState!.validate()) {
          //   // ... Navigate To RegistoEmpresaPage()
          //   _submitForm();
          //   Navigator.push(context, MaterialPageRoute(
          //       builder: (context) => const RegistoEmpresaPage())
          //   );
          // }
        },
        child: const Text('Registar'),
      ),
    );
  }
}

/*
class Users {
  String nome;
  String email;
  String password;

  Users({required this.nome, required this.email, required this.password});

  Map<String, dynamic> toDict() {
    return {
      'nome': nome,
      'email': email,
    };
  }

  String toJson() => jsonEncode(toDict());

  static Empresa fromJson(String source) => fromMap(json.decode(source));

  static Empresa fromMap(Map<String, dynamic> map) {
    return Empresa()
      ..nome = map['nome']
      ..morada = map['morada'];
  }

  @override
  String toString() {
    return "Nome: $nome, Email: $email, Password: $password";
  }
}
*/

class Users {
  String name = '';
  String email = '';
  String password = '';

  Map<String, dynamic> toMap() {
    return {
      'name': name,
      'email': email,
      'password': password,
    };
  }

  Map<String, dynamic> toJson() => toMap();

  static Users fromJson(String source) => fromMap(json.decode(source));

  static Users fromMap(Map<String, dynamic> map) {
    return Users()
      ..name = map['name']
      ..email = map['email']
      ..password = map['password'];
  }

  Map<String, dynamic> get empresa {
    return {
      'nome': name,
      'morada': email,
    };
  }

  @override
  String toString() {
    return 'Users(name: $name, email: $email)';
  }
}


