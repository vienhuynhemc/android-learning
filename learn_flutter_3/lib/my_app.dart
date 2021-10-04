import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:learn_flutter_3/bean/my_object.dart';

class MyApp extends StatelessWidget {
  GlobalKey<ScaffoldMessengerState> _scaffoldKey = GlobalKey();
  MyObject _myObject = MyObject(
    name: "",
    gia: 0,
  );

  MyAppInputGia _myAppInputGia = MyAppInputGia(myObject: MyObject(name:"",gia:0));
  MyAppInputName _myAppInputName = MyAppInputName(myObject: MyObject(name:"",gia:0));

  MyApp({Key? key}) : super(key: key) {
    _myAppInputGia = MyAppInputGia(myObject:_myObject);
    _myAppInputName = MyAppInputName(myObject: _myObject);
  }

  List<MyObject> list = [];

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      scaffoldMessengerKey: _scaffoldKey,
      title: "Learn 3",
      home: SafeArea(
        child: Scaffold(
          body: Container(
            margin: EdgeInsets.all(30),
            child: Column(
              children: [
                _myAppInputName,
                _myAppInputGia,
                TextButton(
                  onPressed: () {
                    list.add(
                        new MyObject(name: _myObject.name, gia: _myObject.gia));
                    _myObject.name = '';
                    _myObject.gia = 0;
                    _myAppInputGia.reset();
                    _myAppInputName.reset();
                    _scaffoldKey.currentState!.showSnackBar(
                      SnackBar(
                        content: Text(
                          '${this.list}',
                        ),
                        duration: Duration(seconds: 3),
                      ),
                    );
                  },
                  child: Container(
                    padding: EdgeInsets.symmetric(horizontal: 40, vertical: 20),
                    color: Colors.red,
                    child: const Text(
                      "Lấy kết quả",
                      style: TextStyle(
                        color: Colors.white,
                        fontSize: 20,
                        fontWeight: FontWeight.bold,
                      ),
                    ),
                  ),
                ),
              ],
            ),
          ),
        ),
      ),
    );
  }
}

class MyAppInputName extends StatefulWidget {
  MyObject _myObject = MyObject(name: "", gia: 0);
  _MyAppInputNameState state = _MyAppInputNameState();
  MyAppInputName({Key? key, required MyObject myObject}) : super(key: key) {
    _myObject = myObject;
  }

  void reset(){
    state.reset();
  }

  @override
  State<StatefulWidget> createState() {
    return state;
  }
}

class _MyAppInputNameState extends State<MyAppInputName> {

  TextEditingController _controller = TextEditingController();
  void reset(){
    setState(() {
      _controller.text = '';
    });
  }
  void updateState(String value) {
    setState(() {
      widget._myObject.name = value;
    });
  }

  @override
  Widget build(BuildContext context) {
    return TextField(
      controller: _controller,
      onChanged: (value) {
        updateState(value);
      },
      decoration: const InputDecoration(
        border: OutlineInputBorder(
          borderRadius: BorderRadius.all(
            Radius.circular(10),
          ),
        ),
        labelText: "Tên sản phẩm",
      ),
    );
  }
}

class MyAppInputGia extends StatefulWidget {
  MyObject _myObject = MyObject(name: "", gia: 0);
  _MyAppInputGiaState state = _MyAppInputGiaState();

  MyAppInputGia({Key? key, required MyObject myObject}) : super(key: key) {
    _myObject = myObject;
  }

  void reset(){
    state.reset();
  }

  @override
  State<StatefulWidget> createState() {
    return state;
  }

}

class _MyAppInputGiaState extends State<MyAppInputGia> {

  TextEditingController _controller = TextEditingController();
  void reset(){
    setState(() {
      _controller.text = '';
    });
  }

  void updateState(String value) {
    double gia = double.tryParse(value) ?? 0;
    setState(() {
      widget._myObject.gia = gia;
    });
  }

  @override
  Widget build(BuildContext context) {
    return TextField(
      controller: _controller,
      onChanged: (value) {
        updateState(value);
      },
      decoration: const InputDecoration(
        border: OutlineInputBorder(
          borderRadius: BorderRadius.all(
            Radius.circular(10),
          ),
        ),
        labelText: "Giá sản phẩm",
      ),
    );
  }
}
