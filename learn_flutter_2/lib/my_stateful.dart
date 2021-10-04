import 'package:flutter/material.dart';
import 'package:flutter/cupertino.dart';

class MyStateFul extends StatefulWidget {
  String _name = "";
  int _age = 0;

  MyStateFul({
    required String name,
    required int age,
  }) {
    _name = name;
    _age = age;
  }

  @override
  State<StatefulWidget> createState() {
    return _MyStateFulState();
  }
}

class _MyStateFulState extends State<MyStateFul> with WidgetsBindingObserver {
  String _email = "";
  DateTime now = DateTime.now();
  DateTime someDay = DateTime(2020);

  @override
  void initState() {
    super.initState();
    WidgetsBinding.instance!.addObserver(this);
  }

  @override
  void dispose() {
    super.dispose();
    WidgetsBinding.instance!.removeObserver(this);
  }

  @override
  void didChangeAppLifecycleState(AppLifecycleState state) {
    super.didChangeAppLifecycleState(state);
    if (state == AppLifecycleState.paused) {
    } else if (state == AppLifecycleState.resumed) {}
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
        title: "Stateful Widget",
        home: Scaffold(
            body: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          crossAxisAlignment: CrossAxisAlignment.center,
          children: [
            Container(
              margin: const EdgeInsets.fromLTRB(10, 10, 10, 10),
              child: TextField(
                onChanged: (value) {
                  setState(() {
                    _email = value;
                  });
                },
                decoration: const InputDecoration(
                  border: OutlineInputBorder(
                    borderRadius: BorderRadius.only(
                      bottomLeft: Radius.circular(15),
                    ),
                  ),
                  hintText: "ABC",
                ),
              ),
            ),
            const Text(
              "Nhìn kết quả ở đây:",
              style: TextStyle(
                color: Colors.blue,
                fontSize: 20,
              ),
            ),
            Text(
              _email,
              style: const TextStyle(
                color: Colors.greenAccent,
                fontSize: 20,
              ),
            ),
            Text(
              '${widget._name} ${widget._age}',
              style: const TextStyle(
                color: Colors.greenAccent,
                fontSize: 20,
              ),
            ),
            Text(
              now.toString(),
              style: const TextStyle(
                color: Colors.greenAccent,
                fontSize: 20,
              ),
            ),
            Text(
              someDay.toString(),
              style: const TextStyle(
                color: Colors.greenAccent,
                fontSize: 20,
              ),
            ),
          ],
        )));
  }
}
