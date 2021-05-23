import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:learning_flutter_9/model/mon_an.dart';

class DetailFoodPage extends StatelessWidget {
  static String routerName = "/DetailFoodPage";

  @override
  Widget build(BuildContext context) {
    Map<String, MonAn> monAns = ModalRoute.of(context).settings.arguments;
    MonAn monAn = monAns["data"];
    return Scaffold(
      appBar: AppBar(
        centerTitle: true,
        title: Text("${monAn.ten}"),
      ),
      body: SingleChildScrollView(
        child: Column(
          children: [
            FadeInImage(
              placeholder: AssetImage("images/loader.gif"),
              image: NetworkImage("${monAn.urlImage}"),
            ),
            Container(
              child: Text(
                "Nguyên liệu",
                style: TextStyle(fontWeight: FontWeight.bold, fontSize: 20),
              ),
              padding: EdgeInsets.symmetric(vertical: 20),
            ),
            Container(
              height: 400,
              child: ListView.builder(
                itemCount: monAn.nguyenLieu.length,
                itemBuilder: (context, index) {
                  return ListTile(
                    leading: CircleAvatar(
                      child: Text("#${index + 1}"),
                    ),
                    title: Text(
                      "${monAn.nguyenLieu[index]}",
                      style: TextStyle(fontWeight: FontWeight.bold),
                    ),
                  );
                },
              ),
            ),
          ],
        ),
      ),
    );
  }
}
