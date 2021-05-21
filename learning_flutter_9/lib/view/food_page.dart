import 'package:flutter/cupertino.dart';
import 'package:flutter/foundation.dart';
import 'package:flutter/material.dart';
import 'package:learning_flutter_9/model/danh_muc.dart';

class FoodPage extends StatelessWidget {
  DanhMuc danhMuc;

  FoodPage({this.danhMuc});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Food from ${danhMuc.ten}"),
      ),
      body: Column(
        children: [
          Text("${danhMuc.ten}"),
        ],
      ),
    );
  }
}
