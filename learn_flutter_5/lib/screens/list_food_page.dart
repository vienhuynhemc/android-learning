import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:learn_flutter_5/beans/category.dart';
import 'package:learn_flutter_5/beans/complexity.dart';
import 'package:learn_flutter_5/beans/food.dart';
import 'package:learn_flutter_5/datas/data.dart';

class ListFoodPage extends StatelessWidget {
  Category _getCategory(BuildContext context) {
    Map<String, dynamic>? map =
        ModalRoute.of(context)!.settings.arguments as Map<String, dynamic>?;
    return map!['category'];
  }

  @override
  Widget build(BuildContext context) {
    Category category = _getCategory(context);
    return Scaffold(
      body: SafeArea(
        child: Column(
          children: [
            ListFoodPageHeader(
              name: category.content,
            ),
            ListFoodPageContent(
              category: category,
            ),
          ],
        ),
      ),
    );
  }
}

class ListFoodPageHeader extends StatelessWidget {
  String name;

  ListFoodPageHeader({required this.name});

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
            child: Stack(
              children: [
                Center(
                  child: Text(
                    "Foods from $name",
                    style: TextStyle(
                      fontWeight: FontWeight.bold,
                      fontSize: 20,
                    ),
                  ),
                ),
                Positioned(
                  left: 20,
                  top: -10,
                  child: InkWell(
                    onTap: () {
                      Navigator.of(context).pop();
                    },
                    child: Icon(
                      Icons.arrow_back,
                      size: 40,
                    ),
                  ),
                ),
              ],
            ),
          ),
        ),
      ],
    );
  }
}

class ListFoodPageContent extends StatelessWidget {
  Category category;
  List<Food> foodList = [];

  ListFoodPageContent({required this.category}) {
    foodList = foods.where((element) {
      return element.categoryId == category.id;
    }).toList();
  }

  @override
  Widget build(BuildContext context) {
    if (foodList.length == 0) {
      return Expanded(
        child: Container(
          decoration: BoxDecoration(
            color: Colors.white,
          ),
          child: Center(
            child: Text(
              "No food found",
              style: TextStyle(fontWeight: FontWeight.bold, fontSize: 20),
            ),
          ),
        ),
      );
    } else {
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
            itemCount: foodList.length,
            itemBuilder: (context, index) {
              return Row(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  InkWell(
                    child: Container(
                      margin: EdgeInsets.fromLTRB(
                          0, 20, 0, index == foodList.length - 1 ? 20 : 0),
                      width: 900,
                      child: Card(
                        clipBehavior: Clip.hardEdge,
                        shape: RoundedRectangleBorder(
                          borderRadius: BorderRadius.all(
                            Radius.circular(10),
                          ),
                        ),
                        elevation: 10,
                        child: Stack(
                          children: [
                            FadeInImage.assetNetwork(
                              fit: BoxFit.fitWidth,
                              width: MediaQuery.of(context).size.width,
                              placeholder: "assets/images/loading.gif",
                              image: foodList[index].urlImage,
                            ),
                            Positioned(
                              top: 30,
                              left: 30,
                              child: Container(
                                padding: EdgeInsets.fromLTRB(15, 10, 20, 10),
                                decoration: BoxDecoration(
                                  color: Colors.black.withOpacity(0.5),
                                  borderRadius: BorderRadius.all(
                                    Radius.circular(10),
                                  ),
                                  border: Border.all(
                                    color: Colors.white,
                                    width: 2,
                                  ),
                                ),
                                child: Row(
                                  children: [
                                    Icon(
                                      Icons.timer,
                                      size: 30,
                                      color: Colors.white,
                                    ),
                                    Padding(
                                        padding:
                                        EdgeInsets.fromLTRB(10, 0, 0, 0)),
                                    Text(
                                      "${foodList[index].duration.inMinutes} minutes",
                                      style: TextStyle(
                                          color: Colors.white,
                                          fontWeight: FontWeight.bold,
                                          fontSize: 20),
                                    ),
                                  ],
                                ),
                              ),
                            ),
                            Positioned(
                              bottom: 30,
                              right: 30,
                              child: Container(
                                padding: EdgeInsets.fromLTRB(20, 10, 20, 10),
                                decoration: BoxDecoration(
                                  color: Colors.black.withOpacity(0.5),
                                  borderRadius: BorderRadius.all(
                                    Radius.circular(10),
                                  ),
                                ),
                                child: Row(
                                  children: [
                                    Text(
                                      "${foodList[index].name}",
                                      style: TextStyle(
                                          color: Colors.white,
                                          fontWeight: FontWeight.bold,
                                          fontSize: 30),
                                    ),
                                  ],
                                ),
                              ),
                            ),
                            Positioned(
                              top: 30,
                              right: 30,
                              child: Container(
                                padding: EdgeInsets.fromLTRB(20, 10, 20, 10),
                                decoration: BoxDecoration(
                                  color: Colors.greenAccent,
                                  borderRadius: BorderRadius.all(
                                    Radius.circular(10),
                                  ),
                                ),
                                child: Row(
                                  children: [
                                    Text(
                                      "${foodList[index].complexity.toString().split(".").last}",
                                      style: TextStyle(
                                          fontWeight: FontWeight.bold,
                                          fontSize: 20),
                                    ),
                                  ],
                                ),
                              ),
                            ),
                          ],
                        ),
                      ),
                    ),
                    onTap: (){
                      Navigator.of(context).pushNamed(
                        "/detail_food",
                        arguments: {
                          "food":foodList[index],
                        }
                      );
                    },
                  ),
                ],
              );
            },
          ),
        ),
      );
    }
  }
}
