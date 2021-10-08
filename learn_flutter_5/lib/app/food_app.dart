import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:learn_flutter_5/app/food_app_configuration.dart';
import 'package:learn_flutter_5/screens/category_page.dart';

class FoodApp extends StatelessWidget {

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: "Food App",
      initialRoute: "/",
      routes: routes,
      home: CategoryPage(),
    );
  }
}
