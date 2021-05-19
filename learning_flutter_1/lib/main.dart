import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

void main() {
  Map<dynamic, dynamic> map = Map();
  map[1] = "abc";
  map[2] = 4;

  String a = map[1];
  int b = map[2] * 2;
  print(a);
  print(b);

  runApp(Center(
    child: Text(
      "Hello",
      textDirection: TextDirection.ltr,
      style: TextStyle(
        fontSize: 30,
      ),
    ),
  ));
}
