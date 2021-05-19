import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class MyApp extends StatefulWidget {
  String _name;
  int _age;

  MyApp({String name, int age}) {
    this._name = name;
    this._age = age;
  }

  @override
  State<StatefulWidget> createState() {
    return _MyAppState();
  }
}

class _MyAppState extends State<MyApp> {
  final textController = TextEditingController();
  String email = "";

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: "Learning_2",
      home: Scaffold(
        body: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              Container(
                padding: EdgeInsets.fromLTRB(40, 20, 40, 20),
                child: TextField(
                  controller: textController,
                  onChanged: (value) => {
                    setState(() {
                      email = value;
                    })
                  },
                  decoration: InputDecoration(
                    labelText: "Điền tên bạn vô",
                    border: OutlineInputBorder(
                      borderRadius: BorderRadius.all(
                        Radius.circular(20),
                      ),
                    ),
                  ),
                ),
              ),
              Text(
                email,
                textDirection: TextDirection.ltr,
                style: TextStyle(
                  fontSize: 20,
                  color: Colors.amber,
                ),
              ),
              Text(
                widget._name,
                textDirection: TextDirection.ltr,
                style: TextStyle(
                  fontSize: 20,
                  color: Colors.black45,
                ),
              ),
              Text(
                "${widget._age}",
                textDirection: TextDirection.ltr,
                style: TextStyle(
                  fontSize: 20,
                  color: Colors.blue,
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
