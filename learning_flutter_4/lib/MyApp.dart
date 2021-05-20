import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:learning_flutter_4/transaction.dart';

class MyApp extends StatefulWidget {
  @override
  State<StatefulWidget> createState() {
    return _MyAppState();
  }
}

class _MyAppState extends State<MyApp> with WidgetsBindingObserver {
  TextEditingController _contentController = TextEditingController();
  TextEditingController _amountController = TextEditingController();
  GlobalKey<ScaffoldMessengerState> _messengerKey = GlobalKey();
  Transaction transaction = Transaction();
  List<Transaction> list = [];

  @override
  void initState() {
    super.initState();
    WidgetsBinding.instance.addObserver(this);
  }

  @override
  void dispose() {
    super.dispose();
    WidgetsBinding.instance.removeObserver(this);
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: "Learning Fultter 4",
      home: ScaffoldMessenger(
        key: _messengerKey,
        child: Scaffold(
          body: SafeArea(
            minimum: EdgeInsets.only(left: 20, right: 20),
            child: Column(
              children: [
                TextField(
                  onChanged: (value) => {
                    this.setState(() {
                      transaction.content = value;
                    })
                  },
                  controller: _contentController,
                  decoration: InputDecoration(
                    labelText: "Content",
                    hoverColor: Colors.white,
                    border: OutlineInputBorder(
                      borderRadius: BorderRadius.all(
                        Radius.circular(15),
                      ),
                    ),
                  ),
                ),
                Padding(
                  padding: EdgeInsets.only(top: 10),
                ),
                TextField(
                  onChanged: (value) {
                    this.setState(() {
                      transaction.amount = double.tryParse(value) ?? 0;
                    });
                  },
                  controller: _amountController,
                  decoration: InputDecoration(
                    labelText: "Amount (money)",
                    border: OutlineInputBorder(
                      borderRadius: BorderRadius.all(
                        Radius.circular(15),
                      ),
                    ),
                  ),
                ),
                Container(
                  margin: EdgeInsets.fromLTRB(0, 40, 0, 0),
                  child: ButtonTheme(
                    height: 100,
                    minWidth: 1000,
                    child: TextButton(
                      onPressed: () {
                        setState(() {
                          _messengerKey.currentState.showSnackBar(SnackBar(
                            content: Text(
                                "Thêm thành công ${transaction.toString()}"),
                            duration: Duration(seconds: 3),
                          ));
                          _contentController.text = "";
                          _amountController.text = "";
                          list.add(transaction);
                          transaction = Transaction();
                        });
                      },
                      style: ButtonStyle(
                        backgroundColor:
                            MaterialStateProperty.all(Colors.yellow),
                        padding: MaterialStateProperty.all(
                            EdgeInsets.fromLTRB(40, 20, 40, 20)),
                        elevation: MaterialStateProperty.all(20),
                        shadowColor:
                            MaterialStateProperty.all(Colors.tealAccent),
                      ),
                      child: Text(
                        "Lấy dữ liêu",
                        style: TextStyle(
                          color: Colors.white,
                        ),
                      ),
                    ),
                  ),
                ),
                Column(children: _createListWidgets()),
              ],
            ),
          ),
        ),
      ),
    );
  }

  List<Widget> _createListWidgets() {
    int count = 0;
    return list.map((e) {
      count++;
      Color c;
      count % 2 == 0 ? c = Colors.tealAccent : c= Colors.green;
      return Card(
        elevation: 10,
        color: c,
        shape: RoundedRectangleBorder(
            borderRadius: BorderRadius.all(Radius.circular(10))),
        child: ListTile(
          title: Text("${e.content}"),
          subtitle: Text("${e.amount}"),
          leading: Icon(Icons.ac_unit),
          onTap: () {
            _messengerKey.currentState.showSnackBar(SnackBar(
              content: Text("${e.toString()}"),
              duration: Duration(seconds: 2),
            ));
          },
        ),
      );
    }).toList();
  }
}
