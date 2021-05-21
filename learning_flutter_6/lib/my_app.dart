import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:learning_flutter_6/list_transaction.dart';
import 'package:learning_flutter_6/transaction.dart';

class MyApp extends StatefulWidget {
  List<Transaction> _transactions;

  @override
  State<StatefulWidget> createState() {
    _transactions = [];
    return _MyAppState();
  }
}

class _MyAppState extends State<MyApp> {
  TextEditingController _contentController;
  TextEditingController _amountController;
  Transaction _transactionState;

  @override
  void initState() {
    super.initState();
    _contentController = TextEditingController();
    _amountController = TextEditingController();
    _transactionState = Transaction();
  }

  void _addNewTransaction() {
    setState(() {
      if (_transactionState.amount.isNaN ||
          _transactionState.amount == 0.0 ||
          _transactionState.content.isEmpty) {
        return;
      }
      _transactionState.dateTime = DateTime.now();
      widget._transactions.add(_transactionState);
      _transactionState = Transaction();
      _contentController.text = "";
      _amountController.text = "";
    });
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: "Learning flutter 6",
      home: Scaffold(
        backgroundColor: Colors.white,
        appBar: AppBar(
          title: Text("Transaction Manager"),
          actions: [
            IconButton(
              icon: Icon(Icons.add),
              onPressed: () {
                _addNewTransaction();
              },
              tooltip: "Thêm một transaction mới",
            ),
            Padding(padding: EdgeInsets.only(right: 40)),
          ],
        ),
        floatingActionButton: FloatingActionButton(
          tooltip: "Thêm một transaction mới",
          child: Icon(Icons.add),
          onPressed: () {
            _addNewTransaction();
          },
        ),
        body: SafeArea(
          minimum: EdgeInsets.only(left: 20, top: 20, bottom: 10, right: 20),
          child: SingleChildScrollView(
            child: Column(
              children: [
                Card(
                  shape: RoundedRectangleBorder(
                    borderRadius: BorderRadius.circular(10),
                  ),
                  color: Colors.white,
                  elevation: 10,
                  child: TextField(
                    controller: _contentController,
                    decoration: InputDecoration(
                        border: OutlineInputBorder(
                          borderRadius: BorderRadius.circular(10),
                        ),
                        enabledBorder: OutlineInputBorder(
                          borderSide: BorderSide(
                            width: 0,
                            color: Colors.white,
                          ),
                          borderRadius: BorderRadius.circular(10),
                        ),
                        labelText: "Điền content"),
                    onChanged: (value) {
                      setState(() {
                        _transactionState.content = value;
                      });
                    },
                  ),
                ),
                Padding(padding: EdgeInsets.only(top: 20)),
                Card(
                  shape: RoundedRectangleBorder(
                    borderRadius: BorderRadius.circular(10),
                  ),
                  color: Colors.white,
                  elevation: 10,
                  child: TextField(
                    controller: _amountController,
                    decoration: InputDecoration(
                        border: OutlineInputBorder(
                          borderRadius: BorderRadius.circular(10),
                        ),
                        enabledBorder: OutlineInputBorder(
                          borderSide: BorderSide(
                            width: 0,
                            color: Colors.white,
                          ),
                          borderRadius: BorderRadius.circular(10),
                        ),
                        labelText: "Điền amount"),
                    onChanged: (value) {
                      setState(() {
                        _transactionState.amount = double.tryParse(value) ?? 0;
                      });
                    },
                  ),
                ),
                Padding(padding: EdgeInsets.only(top: 20)),
                TextButton(
                  onPressed: () {
                    _addNewTransaction();
                  },
                  child: Text(
                    "Lấy dữ liêu",
                    style: TextStyle(
                      color: Colors.white,
                    ),
                  ),
                  style: ButtonStyle(
                    backgroundColor: MaterialStateProperty.all(Colors.red),
                    padding: MaterialStateProperty.all(
                        EdgeInsets.symmetric(vertical: 20, horizontal: 40)),
                    elevation: MaterialStateProperty.all(10),
                  ),
                ),
                Padding(padding: EdgeInsets.only(top: 20)),
                ListTransaction(
                  transactions: widget._transactions,
                ),
              ],
            ),
          ),
        ),
      ),
    );
  }
}
