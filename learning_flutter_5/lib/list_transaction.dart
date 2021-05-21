import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:learning_flutter_5/transaction.dart';

class ListTransaction extends StatelessWidget {
  List<Transaction> transactions;

  ListTransaction({this.transactions});

  ListView _buildListView() {
    return ListView.builder(
      itemBuilder: (context, index) {
        return Card(
          elevation: 10,
          shape: RoundedRectangleBorder(
            borderRadius: BorderRadius.all(Radius.circular(10)),
          ),
          color: index % 2 == 0 ? Colors.greenAccent : Colors.purpleAccent,
          child: ListTile(
            title: Text("Content: ${transactions[index].content}"),
            subtitle: Text("Amount: ${transactions[index].amount}"),
            leading: Icon(Icons.account_balance),
          ),
        );
      },
      itemCount: transactions.length,
    );
  }

  @override
  Widget build(BuildContext context) {
    return Container(
      height: 400,
      margin: EdgeInsets.only(top: 10),
      child: _buildListView(),
    );
  }
}
