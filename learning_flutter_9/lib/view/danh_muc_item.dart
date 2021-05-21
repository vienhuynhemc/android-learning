import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:learning_flutter_9/model/danh_muc.dart';
import 'package:learning_flutter_9/view/food_page.dart';

class DanhMucItem extends StatelessWidget {
  DanhMuc danhMuc;

  DanhMucItem({this.danhMuc});

  @override
  Widget build(BuildContext context) {
    return InkWell(
      onTap: () {
        Navigator.of(context).push(MaterialPageRoute(
          builder: (context) {
            return FoodPage(
              danhMuc: danhMuc,
            );
          },
        ));
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
