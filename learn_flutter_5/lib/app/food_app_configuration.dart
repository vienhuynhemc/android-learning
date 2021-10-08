import 'package:flutter/cupertino.dart';
import 'package:learn_flutter_5/screens/category_page.dart';
import 'package:learn_flutter_5/screens/detail_food_page.dart';
import 'package:learn_flutter_5/screens/list_food_page.dart';

Map<String, Widget Function(BuildContext)> routes = {
  "/category": (context) {
    return CategoryPage();
  },
  "/list_food":(context){
    return ListFoodPage();
  },
  "/detail_food":(context){
    return DetailFoodPage();
  }
};
