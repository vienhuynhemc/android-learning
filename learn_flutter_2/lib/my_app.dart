import 'package:flutter/material.dart';
import 'package:flutter/cupertino.dart';

class MyApp extends StatelessWidget {
  String _name = "";
  int _age = 0;

  MyApp({
    required String name,
    required int age,
  }) {
    this._name = name;
    this._age = age;
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: "Learn 2",
      home: Scaffold(
        body: Center(
          child: Text(
            "${this._name} ${this._age}",
            textDirection: TextDirection.ltr,
            style: const TextStyle(
              fontSize: 20,
              fontWeight: FontWeight.bold,
              color: Colors.red,
            ),
          ),
        ),
      ),
    );
  }
}
