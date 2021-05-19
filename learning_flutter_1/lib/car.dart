import 'package:flutter/cupertino.dart';

class Car {
  String name;
  int tuoi;
  int _thamso = 3;

  Car({
    this.name = "Huynh Van Vien",
    @required this.tuoi,
  });

  int getThamSo(){
    return this._thamso;
  }

  @override
  String toString() {
    return "${this.name} ${this.tuoi}";
  }

  void _doSomething() {
    print("I do something");
  }

  void hello({String name}) {
    print('Hello $name');
    _doSomething();
  }
}
