import 'package:flutter/cupertino.dart';
import 'package:flutter/foundation.dart';
import 'package:flutter/material.dart';
import 'package:learning_flutter_9/data/fake_data.dart';
import 'package:learning_flutter_9/model/danh_muc.dart';
import 'package:learning_flutter_9/model/mon_an.dart';
import 'package:learning_flutter_9/view/detail_food_page.dart';

class FoodPage extends StatelessWidget {
  static String routerName = "/FoodPage";

  @override
  Widget build(BuildContext context) {
    Map<String, dynamic> danhMucs = ModalRoute.of(context).settings.arguments;
    DanhMuc danhMuc = danhMucs['data'];
    List<MonAn> monAnsOfDanhMuc =
        monAns.where((element) => element.idDanhMuc == danhMuc.id).toList();
    return Scaffold(
      appBar: AppBar(
        title: Text("Food from ${danhMuc.ten}"),
      ),
      body: Container(
        margin: EdgeInsets.only(bottom: 20),
        child: monAnsOfDanhMuc.length == 0
            ? Center(
                child: Text(
                "Không tìm thấy món nào",
                style: TextStyle(
                  fontWeight: FontWeight.bold,
                  fontSize: 20,
                ),
              ))
            : ListView.builder(
                itemCount: monAnsOfDanhMuc.length,
                itemBuilder: (context, index) {
                  return InkWell(
                    child: Card(
                      clipBehavior: Clip.antiAlias,
                      elevation: 10,
                      shape: RoundedRectangleBorder(
                        borderRadius: BorderRadius.circular(15),
                      ),
                      margin: EdgeInsets.only(left: 20, right: 20, top: 20),
                      child: Stack(
                        children: [
                          FadeInImage(
                            placeholder: AssetImage("images/loader.gif"),
                            image:
                                NetworkImage(monAnsOfDanhMuc[index].urlImage),
                          ),
                          Positioned(
                            right: 15,
                            top: 15,
                            child: Card(
                              color: Colors.tealAccent,
                              shape: RoundedRectangleBorder(
                                  borderRadius: BorderRadius.circular(10)),
                              child: Container(
                                padding: EdgeInsets.all(10),
                                child: Text(
                                  "${monAnsOfDanhMuc[index].complexity.toString().split(".")[1]}",
                                  style: TextStyle(fontWeight: FontWeight.bold),
                                ),
                              ),
                            ),
                          ),
                          Positioned(
                            right: 15,
                            bottom: 15,
                            child: Card(
                              color: Colors.black45,
                              shape: RoundedRectangleBorder(
                                  borderRadius: BorderRadius.circular(10)),
                              child: Container(
                                padding: EdgeInsets.all(10),
                                child: Text(
                                  "${monAnsOfDanhMuc[index].ten}",
                                  style: TextStyle(
                                    fontWeight: FontWeight.bold,
                                    color: Colors.white,
                                  ),
                                ),
                              ),
                            ),
                          ),
                          Positioned(
                            left: 15,
                            top: 15,
                            child: Container(
                              decoration: BoxDecoration(
                                borderRadius: BorderRadius.circular(15),
                                border: Border.all(
                                    color: Colors.white,
                                    style: BorderStyle.solid,
                                    width: 2),
                                color: Colors.black45,
                              ),
                              child: Container(
                                  padding: EdgeInsets.all(10),
                                  child: Row(
                                    children: [
                                      Container(
                                          margin: EdgeInsets.only(right: 10),
                                          child: Icon(
                                            Icons.access_alarm,
                                            color: Colors.white,
                                          )),
                                      Text(
                                        "${monAnsOfDanhMuc[index].timeCook.inMinutes} minutes",
                                        style: TextStyle(
                                          fontWeight: FontWeight.bold,
                                          color: Colors.white,
                                        ),
                                      ),
                                    ],
                                  )),
                            ),
                          ),
                        ],
                      ),
                    ),
                    onTap: () {
                      Map<String, MonAn> map = Map();
                      map["data"] = monAnsOfDanhMuc[index];
                      Navigator.pushNamed(context, DetailFoodPage.routerName,
                          arguments: map);
                    },
                  );
                },
              ),
      ),
    );
  }
}
