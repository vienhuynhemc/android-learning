import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:learning_flutter_9/data/fake_data.dart';
import 'package:learning_flutter_9/model/danh_muc.dart';
import 'package:learning_flutter_9/model/mon_an.dart';
import 'package:learning_flutter_9/view/food_page.dart';

class DanhMucItem extends StatelessWidget {
  DanhMuc danhMuc;

  DanhMucItem({this.danhMuc});

  Map<String, DanhMuc> getDataSend() {
    Map<String, DanhMuc> result = Map();
    result["data"] = danhMuc;
    return result;
  }

  @override
  Widget build(BuildContext context) {
    return InkWell(
      onTap: () {
        Navigator.pushNamed(
          context,
          FoodPage.routerName,
          arguments: getDataSend(),
        );
      },
      splashColor: danhMuc.mau.withOpacity(0.3),
      child: Card(
        elevation: 10,
        shape: RoundedRectangleBorder(
          borderRadius: BorderRadius.circular(20),
        ),
        child: Container(
          decoration: BoxDecoration(
            borderRadius: BorderRadius.circular(20),
            gradient: LinearGradient(
                colors: [danhMuc.mau.withOpacity(0.7), danhMuc.mau],
                begin: Alignment.centerLeft,
                end: Alignment.centerRight),
          ),
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            crossAxisAlignment: CrossAxisAlignment.center,
            children: [
              Text(
                "${danhMuc.ten}",
                style: TextStyle(
                  color: Colors.white,
                  fontWeight: FontWeight.bold,
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
