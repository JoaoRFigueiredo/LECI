import 'dart:convert';
import 'package:ssd_frontend/features_empresa/servicos.dart';

class MonumentosDetails extends Servicos {
  String story = '';
  String style = '';
  String accessibility = '';
  String schedule = '';
  String price = '';
  String activity = '';
  String visit_guide = '';

  Map<String, dynamic> toMap() {
    return {
      'story': story,
      'style': style,
      'accessibility': accessibility,
      'schedule': schedule,
      'price': price,
      'activity': activity,
      'visit_guide': visit_guide,
    };
  }

  Map<String, dynamic> toJson() => toMap();

  static MonumentosDetails fromJson(String source) => fromMap(json.decode(source));

  static MonumentosDetails fromMap(Map<String, dynamic> map) {
    return MonumentosDetails()
      ..story = map['story']
      ..style = map['style']
      ..accessibility = map['accessibility']
      ..schedule = map['schedule']
      ..price = map['price']
      ..activity = map['activity']
      ..visit_guide = map['visit_guide'];
  }

  Map<String, dynamic> get restaurantes {
    return {
      'story': story,
      'style': style,
      'accessibility': accessibility,
      'schedule': schedule,
      'price': price,
      'activity': activity,
      'visit_guide': visit_guide,
    };
  }

  @override
  String toString() {
    return 'Monumentos (story: $story, style: $style, accessibility: $accessibility, schedule: $schedule, price: $price,'
    'activity: $activity, visit_guide: $visit_guide)';
  }
}