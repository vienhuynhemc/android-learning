import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:learning_flutter_9/model/danh_muc.dart';
import 'package:learning_flutter_9/model/mon_an.dart';

List<DanhMuc> danhMucs = [
  DanhMuc(id: 1, ten: 'Japanese\'sMonAns', mau: Colors.deepOrange),
  DanhMuc(id: 2, ten: 'Pizza', mau: Colors.teal),
  DanhMuc(id: 3, ten: 'Humburgers', mau: Colors.pink),
  DanhMuc(id: 4, ten: 'Italian', mau: Colors.blueAccent),
  DanhMuc(id: 5, ten: 'Milk & Yoghurt', mau: Colors.deepPurple),
  DanhMuc(id: 6, ten: 'Vegetables', mau: Colors.green),
  DanhMuc(id: 7, ten: 'Fruits', mau: Colors.redAccent),
];

List<MonAn> monAns = [
  //array of food's objects
  MonAn(
    id: 0,
      ten: "sushi - 寿司",
      urlImage:
          "https://upload.wikimedia.org/wikipedia/commons/c/cf/Salmon_Sushi.jpg",
      timeCook: Duration(minutes: 25),
      complexity: Complexity.Medium,
      nguyenLieu: ['Sushi-meshi', 'Nori', 'Condiments'],
      idDanhMuc: 1),
  MonAn(
      id: 1,
      ten: "Pizza tonda",
      urlImage: "https://www.angelopo.com/filestore/images/pizza-tonda.jpg",
      timeCook: Duration(minutes: 15),
      complexity: Complexity.Hard,
      nguyenLieu: [
        'Tomato sauce',
        'Fontina cheese',
        'Pepperoni',
        'Onions',
        'Mushrooms',
        'pepperoncini'
      ],
      idDanhMuc: 2),
  MonAn(
      id: 2,
      ten: "Makizushi",
      urlImage:
          "https://upload.wikimedia.org/wikipedia/commons/0/0b/KansaiSushi.jpg",
      complexity: Complexity.Simple,
      timeCook: Duration(minutes: 20),
      idDanhMuc: 1),
  MonAn(
      id: 3,
      ten: "Tempura",
      urlImage:
          "https://upload.wikimedia.org/wikipedia/commons/a/ac/Peixinhos_da_horta.jpg",
      timeCook: Duration(minutes: 15),
      complexity: Complexity.Simple,
      idDanhMuc: 1),
  MonAn(
      id: 4,
      ten: "Neapolitan pizza",
      urlImage:
          "https://img-global.cpcdn.com/recipes/7f1a5380090f6300/1280x1280sq70/photo.jpg",
      timeCook: Duration(minutes: 20),
      complexity: Complexity.Medium,
      nguyenLieu: ['Fontina cheese', 'Tomato sauce', 'Onions', 'Mushrooms'],
      idDanhMuc: 2),
  MonAn(
      id: 5,
      ten: "Sashimi",
      urlImage:
          "https://upload.wikimedia.org/wikipedia/commons/thumb/1/14/Sashimi_-_Tokyo_-_Japan.jpg/2880px-Sashimi_-_Tokyo_-_Japan.jpg",
      timeCook: Duration(hours: 1, minutes: 5),
      complexity: Complexity.Medium,
      idDanhMuc: 1),
  MonAn(
      id: 6,
      ten: "Homemade Humburger",
      urlImage:
          "https://upload.wikimedia.org/wikipedia/commons/5/58/Homemade_hamburger.jpg",
      timeCook: Duration(minutes: 20),
      complexity: Complexity.Hard,
      idDanhMuc: 3),
];
