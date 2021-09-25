import 'package:flutter/material.dart';
import 'package:learn_fullter_1/car.dart';

void main() {
  // for(int i =0; i < numbers.length;i++){
  //   print(numbers[i]);
  // }
  // numbers.forEach((element) {
  //   print(element);
  // });
  // var x = "${sqrt(9)}";
  // stringNumber.forEach((element) {
  //   print(element);
  // });
  // var car = Car(name: "ABC", year: 200);
  // print(car.name);
  List<Car> cars = [];
  cars.add(Car(name: "ABC",year: 2000));
  cars.add(Car(name: "ABCD",year: 2001));
  cars.add(Car(name: "ABCDE",year: 2002));
  cars.add(Car(name: "ABC",year: 2003));
  cars.sort((car1,car2){
    return -(car1.year-car2.year);
  });
  List<Car> filter = cars.where((element){
    return element.name == "ABC";
  }).toList();
  List<String> listName = cars.map((e){
    return e.name;
  }).toList();
  Map<String,String> map = Map();
  map['a'] = "b";
  print(map['a']);
  runApp(Center(
    child: Text(
      '$listName',
      style: TextStyle(fontSize: 30),
      textDirection: TextDirection.ltr,
    ),
  ));
}
