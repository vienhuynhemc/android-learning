import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:learning_flutter_9/view/danh_muc_page.dart';
import 'package:learning_flutter_9/view/detail_food_page.dart';
import 'package:learning_flutter_9/view/food_page.dart';

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      initialRoute: "/",
      routes: {
        FoodPage.routerName: (content) => FoodPage(),
        DanhMucPage.routerName: (content) => DanhMucPage(),
        DetailFoodPage.routerName: (content) => DetailFoodPage(),
      },
      theme: ThemeData(),
      title: "Food Navigation",
      home: DanhMucPage(),
    );
  }
}
