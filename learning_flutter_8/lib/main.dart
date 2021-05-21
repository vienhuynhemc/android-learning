import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: "Learning fultter 8",
      theme: ThemeData(
        primaryColor: Colors.red,
      ),
      home: MyAppHomePage(),
    );
  }
}

class MyAppHomePage extends StatefulWidget {
  @override
  State<StatefulWidget> createState() {
    return _MyAppState();
  }
}

class _MyAppState extends State<MyAppHomePage> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: SafeArea(
        child: Column(
          children: [
            ElevatedButton(
              style: ButtonStyle(
                backgroundColor:
                    MaterialStateProperty.all(Theme.of(context).primaryColor),
              ),
              onPressed: () {},
              child: Text(
                "Button",
                style: TextStyle(color: Colors.white),
              ),
            ),
            GridView(
              children: [

              ],
              gridDelegate: SliverGridDelegateWithMaxCrossAxisExtent(

              )          ),
          ],
        ),
      ),
    );
  }
}
