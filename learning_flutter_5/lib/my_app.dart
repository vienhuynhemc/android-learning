import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:learning_flutter_5/list_transaction.dart';
import 'package:learning_flutter_5/transaction.dart';

class MyApp extends StatefulWidget {
  List<Transaction> transactions;

  @override
  State<StatefulWidget> createState() {
    transactions = [];
    return _MyAppState();
  }
}

class _MyAppState extends State<MyApp> with WidgetsBindingObserver {
  GlobalKey<ScaffoldMessengerState> _messengerSateKey;
  TextEditingController _contentController = TextEditingController();
  TextEditingController _amountController;
  Transaction _transactionState;

  @override
  void initState() {
    super.initState();
    WidgetsBinding.instance.addObserver(this);
    _contentController = TextEditingController();
    _amountController = TextEditingController();
    _transactionState = Transaction();
    _messengerSateKey = GlobalKey();
  }

  @override
  void dispose() {
    super.dispose();
    WidgetsBinding.instance.removeObserver(this);
  }

  @override
  void didChangeAppLifecycleState(AppLifecycleState state) {
    super.didChangeAppLifecycleState(state);
    if (state == AppLifecycleState.paused) {
      print('App run background');
    } else if (state == AppLifecycleState.resumed) {
      print('App is running');
    }
  }

  void _addNewTransaction() {
    setState(() {
      if (_transactionState.content.isEmpty ||
          _transactionState.amount == 0.0 ||
          _transactionState.amount.isNaN) {
        return;
      }
      _amountController.text = "";
      _contentController.text = "";
      showSnackBar();
      widget.transactions.add(_transactionState);
      _transactionState = Transaction();
    });
  }

  void showSnackBar() {
    _messengerSateKey.currentState.showSnackBar(
      SnackBar(
        content: Text("Thêm thành công ${_transactionState.toString()}"),
        duration: Duration(seconds: 1),
      ),
    );
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: "Learning 5",
      home: ScaffoldMessenger(
        key: _messengerSateKey,
        child: Scaffold(
          appBar: AppBar(
            title: Text("Menu"),
            actions: [
              IconButton(
                icon: Icon(Icons.add),
                onPressed: () {
                  _addNewTransaction();
                },
                tooltip: "Add New Transaction",
              ),
              IconButton(
                icon: Icon(Icons.edit),
                onPressed: () {},
                tooltip: "Edit Transaction",
                padding: EdgeInsets.only(right: 50),
                color: Colors.purple,
                iconSize: 40,
              ),
            ],
          ),
          floatingActionButton: FloatingActionButton(
            child: Icon(Icons.add),
            elevation: 10,
            tooltip: "Add new transaction",
            onPressed: () {
              _addNewTransaction();
            },
          ),
          backgroundColor: Colors.white,
          body: SafeArea(
            minimum: EdgeInsets.only(left: 20, top: 30, right: 20, bottom: 30),
            child: SingleChildScrollView(
              child: Column(
                children: [
                  TextField(
                    onChanged: (value) {
                      setState(() {
                        _transactionState.content = value;
                      });
                    },
                    controller: _contentController,
                    decoration: InputDecoration(
                      labelText: "Nhập content",
                    ),
                  ),
                  TextField(
                    onChanged: (value) {
                      setState(() {
                        _transactionState.amount = double.tryParse(value) ?? 0;
                      });
                    },
                    controller: _amountController,
                    decoration: InputDecoration(
                      labelText: "Nhập amount",
                    ),
                  ),
                  Padding(padding: EdgeInsets.symmetric(vertical: 10)),
                  TextButton(
                    style: ButtonStyle(
                        backgroundColor:
                            MaterialStateProperty.all(Colors.brown),
                        padding: MaterialStateProperty.all(EdgeInsets.symmetric(
                            vertical: 20, horizontal: 40))),
                    onPressed: () {
                      _addNewTransaction();
                    },
                    child: Text(
                      "Lấy dữ liệu",
                      style: TextStyle(color: Colors.white),
                    ),
                  ),
                  ListTransaction(
                    transactions: widget.transactions,
                  ),
                ],
              ),
            ),
          ),
        ),
      ),
    );
  }
}
