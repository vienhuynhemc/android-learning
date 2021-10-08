import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:learn_flutter_5/datas/data.dart';

class CategoryPage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: SafeArea(
        child: Column(
          children: [
            CategoryPageHeader(),
            CategoryContent(),
          ],
        ),
      ),
    );
  }
}

class CategoryPageHeader extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Row(
      children: [
        Expanded(
          flex: 1,
          child: Container(
            padding: EdgeInsets.fromLTRB(
              0,
              20,
              0,
              20,
            ),
            decoration: BoxDecoration(
              color: Colors.lightBlueAccent.withOpacity(0.8),
            ),
            child: Center(
              child: Text(
                "Food's Categories",
                style: TextStyle(
                  fontWeight: FontWeight.bold,
                  fontSize: 20,
                ),
              ),
            ),
          ),
        ),
      ],
    );
  }
}

class CategoryContent extends StatelessWidget {

  @override
  Widget build(BuildContext context) {
    return Expanded(
      child: Container(
        padding: EdgeInsets.fromLTRB(
          0,
          0,
          0,
          20,
        ),
        decoration: BoxDecoration(color: Colors.white),
        child: ListView.builder(
          itemCount: (categories.length / 2).round(),
          itemBuilder: (context, index) {
            int position = index == 0 ? 0 : index * 2;
            if (position < categories.length - 2) {
              return Row(
                children: [
                  Expanded(
                    flex: 5,
                    child: InkWell(
                      onTap: (){
                        Navigator.of(context).pushNamed("/list_food",arguments: {"category":categories[position]});
                      },
                      child: Card(
                        margin: EdgeInsets.fromLTRB(
                          20,
                          position == 0 || position == 1 ? 20 : 10,
                          10,
                          position == categories.length - 1 ||
                                  position == categories.length - 2
                              ? 30
                              : 10,
                        ),
                        elevation: 10,
                        shadowColor:
                            categories[position].color.withOpacity(0.5),
                        color: categories[position].color,
                        child: Container(
                          height: 250,
                          child: Center(
                            child: Text(
                              "${categories[position].content}",
                              style: TextStyle(
                                fontWeight: FontWeight.bold,
                                fontSize: 20,
                              ),
                            ),
                          ),
                        ),
                      ),
                    ),
                  ),
                  Expanded(
                    flex: 5,
                    child: InkWell(
                      onTap: (){
                        Navigator.of(context).pushNamed("/list_food",arguments: {"category":categories[position+1]});
                      },
                      child: Card(
                        margin: EdgeInsets.fromLTRB(
                          10,
                          position == 0 || position == 1 ? 20 : 10,
                          20,
                          position == categories.length - 1 ||
                                  position == categories.length - 2
                              ? 30
                              : 10,
                        ),
                        elevation: 10,
                        shadowColor:
                            categories[position + 1].color.withOpacity(0.5),
                        color: categories[position + 1].color,
                        child: Container(
                          height: 250,
                          child: Center(
                            child: Text(
                              "${categories[position + 1].content}",
                              style: TextStyle(
                                fontWeight: FontWeight.bold,
                                fontSize: 20,
                              ),
                            ),
                          ),
                        ),
                      ),
                    ),
                  ),
                ],
              );
            }
            return Row(
              children: [
                Expanded(
                  flex: 5,
                  child: InkWell(
                    onTap:(){
                      Navigator.of(context).pushNamed("/list_food",arguments: {"category":categories[position]});
                    },
                    child: Card(
                      margin: EdgeInsets.fromLTRB(
                        20,
                        position == 0 || position == 1 ? 20 : 10,
                        10,
                        position == categories.length - 1 ||
                                position == categories.length - 2
                            ? 30
                            : 10,
                      ),
                      elevation: 10,
                      shadowColor: categories[position].color.withOpacity(0.5),
                      color: categories[position].color,
                      child: Container(
                        height: 250,
                        child: Center(
                          child: Text(
                            "${categories[position].content}",
                            style: TextStyle(
                              fontWeight: FontWeight.bold,
                              fontSize: 20,
                            ),
                          ),
                        ),
                      ),
                    ),
                  ),
                ),
                Expanded(
                    flex: 5,
                    child: Text(
                      "",
                    )),
              ],
            );
          },
        ),
      ),
    );
  }
}
