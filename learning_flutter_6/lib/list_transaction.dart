import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:learning_flutter_6/transaction.dart';

class ListTransaction extends StatelessWidget {
  List<Transaction> transactions;

  ListTransaction({this.transactions});

  ListView _buildListView() {
    return ListView.builder(
      itemCount: transactions.length,
      itemBuilder: (context, index) {
        return Card(
          color: index % 2 == 0 ? Colors.green : Colors.lightBlue,
          elevation: 5,
          shape: RoundedRectangleBorder(
            borderRadius: BorderRadius.circular(10),
          ),
          child: Row(
            children: [
              Container(
                child: Icon(
                  Icons.adb,
                  color: Colors.white,
                  size: 30,
                ),
                padding: EdgeInsets.all(20),
              ),
              Column(
                children: [
                  Text(
                    "${transactions[index].content}",
                    style: TextStyle(
                      fontWeight: FontWeight.bold,
                      fontSize: 20,
                      color: Colors.white,
                    ),
                  ),
                  Padding(
                    padding: EdgeInsets.only(top: 10),
                  ),
                  Text(
                    "${transactions[index].dateTime.toString()}",
                    style: TextStyle(
                      color: Colors.white,
                    ),
                  ),
                ],
              ),
              Expanded(
                  child: Row(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  Container(
                    child: Text(
                      "${transactions[index].amount} \$",
                      style: TextStyle(
                        color: Colors.white,
                      ),
                    ),
                    padding: EdgeInsets.symmetric(vertical: 10, horizontal: 15),
                    decoration: BoxDecoration(
                      border: Border.all(
                          color: Colors.white,
                          width: 2,
                          style: BorderStyle.solid),
                      borderRadius: BorderRadius.circular(10),
                    ),
                  ),
                ],
              )),
            ],
          ),
        );
      },
    );
  }

  @override
  Widget build(BuildContext context) {
    return Container(
      height: 350,
      child: _buildListView(),
    );
  }
}
