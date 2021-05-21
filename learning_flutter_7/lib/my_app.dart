import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: "Learning 7",
      home: MyAppHomePage(),
    );
  }
}

class MyAppHomePage extends StatefulWidget {
  @override
  State<StatefulWidget> createState() {
    return _MyAppHomePageState();
  }
}

class _MyAppHomePageState extends State<MyAppHomePage> {
  void _showModalBottommSheet() {
    showModalBottomSheet(
      context: context,
      builder: (context) {
        return Card(
          shape: RoundedRectangleBorder(
            borderRadius: BorderRadius.circular(10),
          ),
          child: Column(
            children: [
              ElevatedButton(
                onPressed: () {
                  Navigator.of(context).pop();
                },
                child: Text("Ẩn"),
              )
            ],
          ),
        );
      },
    );
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.white,
      body: SafeArea(
        minimum: EdgeInsets.symmetric(horizontal: 20, vertical: 30),
        child: Column(
          children: [
            Row(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                ElevatedButton(
                  onPressed: () {
                    _showModalBottommSheet();
                  },
                  child: Text("Show modal bottom sheet"),
                  style: ButtonStyle(
                    backgroundColor: MaterialStateProperty.all(Colors.red),
                  ),
                ),
              ],
            ),
          ],
        ),
      ),
    );
  }
}
