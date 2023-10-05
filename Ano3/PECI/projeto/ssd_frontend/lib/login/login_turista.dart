import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:firebase_auth/firebase_auth.dart';
import 'package:firebase_core/firebase_core.dart';
import 'package:get/get.dart';
import 'package:get/get_core/src/get_main.dart';
import 'package:lottie/lottie.dart';
import 'package:ssd_frontend/registo_empresas/signUp_pessoa.dart';
import 'package:ssd_frontend/curadoria/curadoria.dart';
import '../componentes/constants.dart';
import '../componentes/simple_ui_controller.dart';
import '../features_empresa/features_empresa.dart';



class LoginTurista extends StatefulWidget {
  const LoginTurista({Key? key}) : super(key: key);

  @override
  State<LoginTurista> createState() => _LoginTuristaState();
}



class _LoginTuristaState extends State<LoginTurista> {

  //TextEditingController nameController = TextEditingController();
  TextEditingController emailController = TextEditingController();
  TextEditingController passwordController = TextEditingController();

  final _formKey = GlobalKey<FormState>();

  // Login function
static Future<User?> loginUsingEmailPassword({required String email, required String password, required BuildContext context}) async {
  FirebaseAuth auth = FirebaseAuth.instance;
  User? user;

  try {
    UserCredential userCredential = await auth.signInWithEmailAndPassword(email: email, password: password);
    user = userCredential.user;
    print('Login done');
    print("Login successful: ${user?.email}"); // Print a message with the logged-in user's email

    if (user != null) {
      print(user.email == 'curador@gmail.com');
      if (user.email == 'curador@gmail.com') {
        Navigator.pushReplacement(
          context,
          MaterialPageRoute(builder: (context) => CuradorPage()),
        );
      } else {
        Navigator.pushReplacement(
          context,
          MaterialPageRoute(builder: (context) => FeaturesEmpresa()),
        );
      }
    }
  } on FirebaseAuthException catch (e) {
    if (e.code == "user-not-found")
      print("Não há nenhum utilizador para este endereço de email");
  }
  return user;
}

  // Initialize Firebase App
  Future<FirebaseApp> _initializeFirebase () async {
    FirebaseApp firebaseapp = await Firebase.initializeApp();
    return firebaseapp;

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

  Widget _buildLargeScreen(
    Size size,
    SimpleUIController simpleUIController,
    ThemeData theme,
  ) {
    return Row(
      children: [
        Expanded(
          flex: 4,
          child: Stack(
            children: [
              Image(
                image: AssetImage('assets/images_servicos/turismo_portugal2.jpg'),
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

  Widget _buildSmallScreen(
    Size size,
    SimpleUIController simpleUIController,
    ThemeData theme,
  ) {
    return Center(
      child: Stack(
        children: [
          Image(
            image: AssetImage('assets/images_servicos/turismo_portugal2.jpg'),
            height: size.height * 0.5,
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
          _buildMainBody(size, simpleUIController, theme),
        ],
      ),
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
            'Login',
            style: kLoginTitleStyle(size),
          ),
        ),
        const SizedBox(
          height: 10,
        ),
        /*
        Padding(
          padding: const EdgeInsets.only(left: 20.0),
          child: Text(
            'Create Account',
            style: kLoginSubtitleStyle(size),
          ),
        ),*/

        SizedBox(
          height: size.height * 0.03,
        ),
        Padding(
          padding: const EdgeInsets.only(left: 20.0, right: 20),
          child: Form(
            key: _formKey,
            child: Column(
              children: [
              
                 

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
                    return 'Please enter your e-mail';
                    } 
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
                

                SizedBox(
                  height: size.height * 0.02,
                ),

                /// SignUp Button
                signUpButton(theme),
                SizedBox(
                  height: size.height * 0.03,
                ),

                Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [
                    const Text('Ainda não tem conta?'),
                    TextButton(
                      child: const Text(
                        'Registe-se aqui',
                        style: TextStyle(fontSize: 20),
                      ),
                      onPressed: () {
                        //signup screen
                        Navigator.push(context, MaterialPageRoute(
                            builder: (context) => const SignUpView())
                        );
                      },
                    )
                  ],
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
        onPressed: () async {
          User? user = await loginUsingEmailPassword(email: emailController.text, password: passwordController.text, context: context);
          print(user);
          print(emailController.text);
          print(passwordController.text);
          // if (user != null) {
          //   Navigator.push(context, MaterialPageRoute(
          //       builder: (context) => FeaturesEmpresa())
          //   );
          // }
        },
        child: const Text('Login'),
      ),
    );
  }
}
