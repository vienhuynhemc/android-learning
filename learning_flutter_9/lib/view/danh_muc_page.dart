import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:learning_flutter_9/data/fake_data.dart';
import 'package:learning_flutter_9/view/danh_muc_item.dart';

class DanhMucPage extends StatelessWidget {
  GridView _createGridView() {
    return GridView.builder(
      itemCount: danhMucs.length,
      padding: EdgeInsets.all(15),
      gridDelegate: SliverGridDelegateWithMaxCrossAxisExtent(
        mainAxisSpacing: 10,
        crossAxisSpacing: 10,
        mainAxisExtent: 150,
        maxCrossAxisExtent: 300,
      ),
      itemBuilder: (context, index) {
        return DanhMucItem(
          danhMuc: danhMucs[index],
        );
      },
    );
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        centerTitle: true,
        title: Text("Food's Category"),
      ),
      body: SafeArea(
        child: _createGridView(),
      ),
    );
  }
}
