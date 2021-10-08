import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:learn_flutter_5/beans/food.dart';

class DetailFoodPage extends StatelessWidget {
  Food _getFood(context) {
    Map<String, dynamic>? arguments =
        ModalRoute.of(context)!.settings.arguments as Map<String, dynamic>?;
    return arguments!['food'];
  }

  @override
  Widget build(BuildContext context) {
    Food food = _getFood(context);
    return Scaffold(
      backgroundColor: Colors.white,
      body: SafeArea(
        child: Column(
          children: [
            DetailFoodPageHeader(
              name: food.name,
            ),
            DetailFoodPageContent(
              food: food,
            ),
          ],
        ),
      ),
    );
  }
}

class DetailFoodPageHeader extends StatelessWidget {
  String name;

  DetailFoodPageHeader({required this.name});

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

class DetailFoodPageContent extends StatelessWidget {
  Food food;

  DetailFoodPageContent({required this.food}) {}

  @override
  Widget build(BuildContext context) {
    return Expanded(
      child: Column(
        children: [
          Row(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              Container(
                margin: EdgeInsets.fromLTRB(0, 20, 0, 20),
                width: 900,
                child: Card(
                  clipBehavior: Clip.hardEdge,
                  shape: RoundedRectangleBorder(
                    borderRadius: BorderRadius.all(
                      Radius.circular(10),
                    ),
                  ),
                  elevation: 10,
                  child: FadeInImage.assetNetwork(
                    fit: BoxFit.fitWidth,
                    width: MediaQuery.of(context).size.width,
                    placeholder: "assets/images/loading.gif",
                    image: food.urlImage,
                  ),
                ),
              )
            ],
          ),
          Text(
            "Ingredients",
            style: TextStyle(
              fontWeight: FontWeight.bold,
              fontSize: 30,
            ),
          ),
          Expanded(
            child: ListView.builder(
              itemCount: food.ingredients.length,
              itemBuilder: (context, index) {
                return Container(
                  margin: EdgeInsets.fromLTRB(0, 0, 0, 20),
                  child: Row(
                    children: [
                      Container(
                        margin: EdgeInsets.fromLTRB(10, 0, 20, 0),
                        child: Card(
                          color: Colors.lightBlueAccent,
                          shape: CircleBorder(),
                          child: Container(
                            padding: EdgeInsets.all(10),
                            child: Text(
                              "#$index",
                              style: TextStyle(
                                fontWeight: FontWeight.bold,
                                fontSize: 20,
                              ),
                            ),
                          ),
                        ),
                      ),
                      Text(
                        "${food.ingredients[index]}",
                        style: TextStyle(
                          fontWeight: FontWeight.bold,
                          fontSize: 20,
                        ),
                      ),
                    ],
                  ),
                );
              },
            ),
          )
        ],
      ),
    );
  }
}
