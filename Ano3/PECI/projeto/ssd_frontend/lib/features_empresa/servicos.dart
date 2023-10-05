import 'dart:convert';
import 'dart:io';

Future<Directory> getTemporaryDirectory() async {
  Directory tempDir = await Directory.systemTemp.createTemp();
  return tempDir;
}

Future<List<File>> base64StringsToImageFiles(List<String> base64Strings) async {
  List<File> imageFiles = [];

  for (String base64String in base64Strings) {
    // Convert base64 string to bytes
    List<int> bytes = base64.decode(base64String);

    // Create image file
    Directory tempDir = await getTemporaryDirectory();
    String tempPath = tempDir.path;
    File file = File('$tempPath/${DateTime.now().millisecondsSinceEpoch}.jpg');

    // Write bytes to file
    await file.writeAsBytes(bytes);

    // Add file to list
    imageFiles.add(file);
  }

  return imageFiles;
}

class Servicos {

  String latitude = '';
  String longitude = '';
  String user_mail = '';
  String tipo_servico = '';
  String distrito = '';
  String concelho = '';
  String freguesia = '';
  String rua = '';

  List<String> imagePaths = [];
  List<String> img_description = [];

  Future<void> loadImages(List<String> base64Strings) async {
    List<File> images = await base64StringsToImageFiles(base64Strings);
    imagePaths = images.map((image) => image.path).toList();
  }

  Map<String, dynamic> toMap() {
    return {
      'user_mail': user_mail,
      'latitude': latitude,
      'longitude': longitude,
      'distrito': distrito,
      'concelho': concelho,
      'freguesia': freguesia,
      'rua': rua,
    };
  }

  Map<String, dynamic> toJson() => toMap();

  static Servicos fromJson(String source) => fromMap(json.decode(source));

  static Servicos fromMap(Map<String, dynamic> map) {
    return Servicos()
      ..user_mail = map['user_mail']
      ..latitude = map['latitude']
      ..longitude = map['longitude']
      ..distrito = map['distrito']
      ..concelho = map['concelho']
      ..freguesia = map['freguesia']
      ..rua = map['rua'];

  }

  Map<String, dynamic> get servicos {
    return {
      'user_mail': user_mail,
      'latitude': latitude,
      'longitude': longitude,
      'distrito': distrito,
      'concelho': concelho,
      'freguesia': freguesia,
      'rua': rua,
    };
  }

  @override
  String toString() {
    return 'Servicos (user_mail: $user_mail, latitude: $latitude, longitude: $longitude, distrito: $distrito, concelho: $concelho, '
        'freguesia: $freguesia, rua: $rua)';
  }

}

