import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class MyApp extends StatefulWidget {
  int _tuoi;
  String _ten;

  MyApp({String ten, int tuoi}) {
    this._ten = ten;
    this._tuoi = tuoi;
  }

  @override
  State<StatefulWidget> createState() {
    return _MyAppState();
  }
}

class _MyAppState extends State<MyApp> with WidgetsBindingObserver {
  var controllerChangeText = TextEditingController();
  String _email = "";
  DateTime dateTime;

  @override
  void didChangeAppLifecycleState(AppLifecycleState state) {
    super.didChangeAppLifecycleState(state);
    if (state == AppLifecycleState.paused) {
      print('pause');
    } else if (state == AppLifecycleState.resumed) {
      print('resumed');
    }
  }

  @override
  void initState() {
    super.initState();
    WidgetsBinding.instance.addObserver(this);
    print('initState');
    dateTime = DateTime.now();
  }

  @override
  void dispose() {
    super.dispose();
    controllerChangeText.dispose();
    WidgetsBinding.instance.removeObserver(this);
    print('dispose');
  }

  @override
  Widget build(BuildContext context) {
    print('build');
    return MaterialApp(
      title: "Learning_3",
      home: Scaffold(
        body: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.start,
            children: [
              Container(
                padding: EdgeInsets.fromLTRB(40, 20, 40, 20),
                child: TextField(
                  controller: controllerChangeText,
                  onChanged: (value) => {
                    this.setState(() {
                      _email = value;
                    })
                  },
                  decoration: InputDecoration(
                    labelText: "Điền trường học bạn tại đây",
                    border: OutlineInputBorder(
                      borderRadius: BorderRadius.all(
                        Radius.circular(15),
                      ),
                    ),
                  ),
                ),
              ),
              Text(
                "${this.widget._tuoi}",
                textDirection: TextDirection.ltr,
                style: TextStyle(
                    fontSize: 30,
                    fontWeight: FontWeight.bold,
                    color: Colors.blue),
              ),
              Text(
                "${this.widget._ten}",
                textDirection: TextDirection.ltr,
                style: TextStyle(
                    fontSize: 30,
                    fontWeight: FontWeight.bold,
                    color: Colors.amber),
              ),
              Text(
                "$_email",
                textDirection: TextDirection.ltr,
                style: TextStyle(
                    fontSize: 30,
                    fontWeight: FontWeight.bold,
                    color: Colors.deepOrangeAccent),
              ),
              Text(
                "${dateTime.toString()}",
                textDirection: TextDirection.ltr,
                style: TextStyle(
                    fontSize: 30,
                    fontWeight: FontWeight.bold,
                    color: Colors.deepOrangeAccent),
              )
            ],
          ),
        ),
      ),
    );
  }
}
