import 'dart:convert';
import 'package:ssd_frontend/features_empresa/servicos.dart';

class RestaurantesDetails extends Servicos {
  String name = '';
  String description = '';
  List<String> tipoEstabelecimento = [];
  List<String> ementa = [];
  String hours = '';


  Map<String, dynamic> toMap() {
    return {
      'name': name,
      'tipoEstabelecimento': tipoEstabelecimento,
      'ementa': ementa,
      'hours': hours,
      'description': description,
    };
  }

  Map<String, dynamic> toJson() => toMap();

  static RestaurantesDetails fromJson(String source) => fromMap(json.decode(source));

  static RestaurantesDetails fromMap(Map<String, dynamic> map) {
    return RestaurantesDetails()
      ..name = map['name']
      ..tipoEstabelecimento = map['tipoEstabelecimento']
      ..ementa = map['ementa']
      ..hours = map['hours']
      ..description = map['description'];
  }

  Map<String, dynamic> get restaurantes {
    return {
      'name': name,
      'tipoEstabelecimento': tipoEstabelecimento,
      'ementa': ementa,
      'hours': hours,
      'description': description,
    };
  }

  @override
  String toString() {
    return 'Restaurantes (name: $name, tipoEstabelecimento: $tipoEstabelecimento, ementa: $ementa, hours: $hours, '
        'description: $description)';
  }
}