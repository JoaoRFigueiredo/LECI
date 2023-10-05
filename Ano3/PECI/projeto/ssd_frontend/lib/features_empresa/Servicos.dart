class Service {
  String name;
  String latitude;
  String longitude;
  List<String> images;
  List<String> imageDescriptions;
  String userEmail;
  String serviceType;
  String district;
  String county;
  String parish;
  String street;
  String id;

  Service({
    required this.name,
    required this.latitude,
    required this.longitude,
    required this.images,
    required this.imageDescriptions,
    required this.userEmail,
    required this.serviceType,
    required this.district,
    required this.county,
    required this.parish,
    required this.street,
    required this.id,
  });

  set setName(String value) {
    name = value;
  }

  set setLatitude(String value) {
    latitude = value;
  }

  set setLongitude(String value) {
    longitude = value;
  }

  set setImages(List<String> value) {
    images = value;
  }

  set setImageDescriptions(List<String> value) {
    imageDescriptions = value;
  }

  set setUserEmail(String value) {
    userEmail = value;
  }

  set setServiceType(String value) {
    serviceType = value;
  }

  set setDistrict(String value) {
    district = value;
  }

  set setCounty(String value) {
    county = value;
  }

  set setParish(String value) {
    parish = value;
  }

  set setStreet(String value) {
    street = value;
  }

  set setId(String value) {
    id = value;
  }

  Map<String, dynamic> toMap() {
    return {
      'name': name,
      'latitude': latitude,
      'longitude': longitude,
      'images': images,
      'imageDescriptions': imageDescriptions,
      'userEmail': userEmail,
      'serviceType': serviceType,
      'district': district,
      'county': county,
      'parish': parish,
      'street': street,
      'id': id,
    };
  }
}

class RestaurantAd extends Service {
  List<String> establishmentTypes;
  List<String> menu;
  String hours;
  String description;
  String promo;
  String email;

  RestaurantAd({
    required String name,
    required String latitude,
    required String longitude,
    required List<String> images,
    required List<String> imageDescriptions,
    required String userEmail,
    required String serviceType,
    required String district,
    required String county,
    required String parish,
    required String street,
    required this.establishmentTypes,
    required this.menu,
    required this.hours,
    required this.description,
    required this.promo,
    required this.email,
    required String id,
  }) : super(
          name: name,
          latitude: latitude,
          longitude: longitude,
          images: images,
          imageDescriptions: imageDescriptions,
          userEmail: userEmail,
          serviceType: serviceType,
          district: district,
          county: county,
          parish: parish,
          street: street,
          id: id,
        );

  set setEstablishmentTypes(List<String> value) {
    establishmentTypes = value;
  }

  set setMenu(List<String> value) {
    menu = value;
  }

  set setHours(String value) {
    hours = value;
  }

  set setDescription(String value) {
    description = value;
  }

  set setPromo(String value) {
    promo = value;
  }

  set setEmail(String value) {
    email = value;
  }

   @override
  Map<String, dynamic> toJson() {
    final map = super.toMap();
    map.addAll({
      'establishmentTypes': establishmentTypes,
      'menu': menu,
      'hours': hours,
      'description': description,
      'promo': promo,
      'email': email,
    });
    return map;
  }
}

class AccommodationAd extends Service {
  String bedroomType;
  String bedroomPrices;
  String services;
  String description;
  String promo;

  AccommodationAd({
    required String name,
    required String latitude,
    required String longitude,
    required List<String> images,
    required List<String> imageDescriptions,
    required String userEmail,
    required String serviceType,
    required String district,
    required String county,
    required String parish,
    required String street,
    required this.bedroomType,
    required this.bedroomPrices,
    required this.services,
    required String id,
    required this.promo,
    required this.description,
  }) : super(
          name: name,
          latitude: latitude,
          longitude: longitude,
          images: images,
          imageDescriptions: imageDescriptions,
          userEmail: userEmail,
          serviceType: serviceType,
          district: district,
          county: county,
          parish: parish,
          street: street,
          id: id,
        );

  set setBedroomType(String value) {
    bedroomType = value;
  }

  set setBedroomPrices(String value) {
    bedroomPrices = value;
  }

  set setServices(String value) {
    services = value;
  }

   @override
  Map<String, dynamic> toJson() {
    final map = super.toMap();
    map.addAll({
      'bedroomType': bedroomType,
      'bedroomPrices': bedroomPrices,
      'services': services,
      'description': description,
      'promo': promo,
    });
    return map;
  }
}

class MonumentAd extends Service {
  String story;
  String style;
  String accessibility;
  String schedule;
  String price;
  String activity;
  String guideVisit;

  MonumentAd({
    required String name,
    required String latitude,
    required String longitude,
    required List<String> images,
    required List<String> imageDescriptions,
    required String userEmail,
    required String serviceType,
    required String district,
    required String county,
    required String parish,
    required String street,
    required this.story,
    required this.style,
    required this.accessibility,
    required this.schedule,
    required this.price,
    required this.activity,
    required this.guideVisit,
    required String id,
  }) : super(
          name: name,
          latitude: latitude,
          longitude: longitude,
          images: images,
          imageDescriptions: imageDescriptions,
          userEmail: userEmail,
          serviceType: serviceType,
          district: district,
          county: county,
          parish: parish,
          street: street,
          id: id,
        );

  set setStory(String value) {
    story = value;
  }

  set setStyle(String value) {
    style = value;
  }

  set setAccessibility(String value) {
    accessibility = value;
  }

  set setSchedule(String value) {
    schedule = value;
  }

  set setPrice(String value) {
    price = value;
  }

  set setActivity(String value) {
    activity = value;
  }

  set setGuideVisit(String value) {
    guideVisit = value;
  }

   @override
  Map<String, dynamic> toJson() {
    final map = super.toMap();
    map.addAll({
      'story': story,
      'style': style,
      'accessibility': accessibility,
      'schedule': schedule,
      'price': price,
      'activity': activity,
      'guideVisit': guideVisit,
    });
    return map;
  }
}
