import 'dart:convert';
import 'package:ssd_frontend/features_empresa/servicos.dart';

class AlojamentosDetails extends Servicos {
  String name = '';
  String description = '';
  String bedroom_type = '';
  String bedroom_prices = '';
  String services = '';

  Map<String, dynamic> toMap() {
    return {
      'name': name,
      'description': description,
      'bedroom_type': bedroom_type,
      'bedroom_prices': bedroom_prices,
      'services': services,
    };
  }

  Map<String, dynamic> toJson() => toMap();

  static AlojamentosDetails fromJson(String source) => fromMap(json.decode(source));

  static AlojamentosDetails fromMap(Map<String, dynamic> map) {
    return AlojamentosDetails()
      ..name = map['name']
      ..description = map['description']
      ..bedroom_type = map['bedroom_typ']
      ..bedroom_prices = map['bedroom_prices']
      ..services = map['services'];
  }

  Map<String, dynamic> get alojamentos {
    return {
      'name': name,
      'description': description,
      'bedroom_type': bedroom_type,
      'bedroom_prices': bedroom_prices,
      'services': services,
    };
  }

  @override
  String toString() {
    return 'Alojamentos (name: $name, description: $description, bedroom_type: $bedroom_type, bedroom_prices: $bedroom_prices,'
        'services: $services)';
  }
}