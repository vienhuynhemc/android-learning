import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:learn_flutter_4/san_pham.dart';

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: "Learning Fluttter 4",
      home: MyHomePage(),
    );
  }
}

class MyHomePage extends StatefulWidget {
  @override
  State<StatefulWidget> createState() {
    return _MyHomePageState();
  }
}

class _MyHomePageState extends State<MyHomePage> {
  String _tenSanPham = "";
  int _giaSanPham = 0;
  TextEditingController tenSanPhamController = TextEditingController();
  TextEditingController giaSanPhamController = TextEditingController();
  List<SanPham> sanPhams = [
    SanPham(
      tenSanPham: "ABC",
      giaSanPham: 200,
      ngayTao: DateTime.now(),
    ),
    SanPham(
      tenSanPham: "ABC",
      giaSanPham: 200,
      ngayTao: DateTime.now(),
    ),
    SanPham(
      tenSanPham: "ABC",
      giaSanPham: 200,
      ngayTao: DateTime.now(),
    ),
  ];

  void _themSanPham() {
    setState(() {
      sanPhams.add(
        SanPham(
          tenSanPham: _tenSanPham,
          giaSanPham: _giaSanPham,
          ngayTao: DateTime.now(),
        ),
      );
    });
  }

  ListView _taoListView() {
    int count = 0;
    ListView listView = ListView.builder(
      itemCount: sanPhams.length,
      itemBuilder: (context, index) {
        count++;
        return Card(
          margin: EdgeInsets.fromLTRB(
            40,
            10,
            40,
            10,
          ),
          elevation: 10,
          shape: RoundedRectangleBorder(
            borderRadius: BorderRadius.all(
              Radius.circular(10),
            ),
          ),
          color: count % 2 == 0 ? Colors.red : Colors.amber,
          shadowColor: count % 2 == 0 ? Colors.redAccent : Colors.amberAccent,
          child: Row(
            children: [
              Container(
                margin: EdgeInsets.all(20),
                child: Column(
                  children: [
                    Text(
                      sanPhams[index].tenSanPham,
                      style: TextStyle(
                        color: Colors.white,
                        fontWeight: FontWeight.bold,
                        fontSize: 30,
                      ),
                    ),
                    Padding(
                      padding: EdgeInsets.all(5),
                    ),
                    Text(
                      sanPhams[index].getNgayTaoString(),
                      style: TextStyle(
                        color: Colors.white,
                        fontWeight: FontWeight.bold,
                        fontSize: 20,
                      ),
                    )
                  ],
                ),
              ),
              Expanded(
                child: Row(
                  mainAxisAlignment: MainAxisAlignment.end,
                  children: [
                    Container(
                      margin: EdgeInsets.fromLTRB(0, 0, 30, 0),
                      child: Container(
                        child: Text(
                          '${sanPhams[index].giaSanPham}',
                          style: TextStyle(
                              color: Colors.white,
                              fontWeight: FontWeight.bold,
                              fontSize: 30),
                        ),
                        margin: EdgeInsets.fromLTRB(
                          20,
                          10,
                          20,
                          10,
                        ),
                      ),
                      decoration: BoxDecoration(
                        borderRadius: BorderRadius.all(Radius.circular(10)),
                        border: Border.all(
                          color: Colors.white,
                          width: 4,
                        ),
                      ),
                    )
                  ],
                ),
              ),
            ],
          ),
        );
      },
    );
    return listView;
  }

  @override
  Widget build(BuildContext context) {
    return SafeArea(
      child: Scaffold(
        body: SingleChildScrollView(
          child: Column(
            children: [
              Container(
                margin: EdgeInsets.symmetric(
                  horizontal: 30,
                  vertical: 30,
                ),
                child: TextField(
                  controller: tenSanPhamController,
                  onChanged: (value) {
                    _tenSanPham = value;
                  },
                  decoration: InputDecoration(
                    border: OutlineInputBorder(
                      borderRadius: BorderRadius.all(
                        Radius.circular(10),
                      ),
                    ),
                    labelText: "Tên sản phẩm",
                  ),
                ),
              ),
              Container(
                margin: EdgeInsets.symmetric(
                  horizontal: 30,
                ),
                child: TextField(
                  controller: giaSanPhamController,
                  onChanged: (value) {
                    _giaSanPham = int.tryParse(value) ?? 0;
                  },
                  decoration: InputDecoration(
                    border: OutlineInputBorder(
                      borderRadius: BorderRadius.all(
                        Radius.circular(10),
                      ),
                    ),
                    labelText: "Giá sản phẩm",
                  ),
                ),
              ),
              Container(
                width: 300,
                child: Card(
                    shape: RoundedRectangleBorder(
                      borderRadius: BorderRadius.all(
                        Radius.circular(10),
                      ),
                    ),
                    shadowColor: Colors.greenAccent,
                    color: Colors.green,
                    elevation: 10,
                    margin: EdgeInsets.fromLTRB(
                      0,
                      30,
                      0,
                      0,
                    ),
                    child: Row(
                      mainAxisAlignment: MainAxisAlignment.center,
                      children: [
                        TextButton(
                          onPressed: _themSanPham,
                          child: Row(
                            children: [
                              Icon(
                                Icons.add,
                                color: Colors.white,
                                size: 30,
                              ),
                              Container(
                                margin: EdgeInsets.symmetric(
                                  vertical: 10,
                                  horizontal: 10,
                                ),
                                child: Text(
                                  "Thêm sản phẩm",
                                  style: TextStyle(
                                    color: Colors.white,
                                    fontSize: 20,
                                    fontWeight: FontWeight.bold,
                                  ),
                                ),
                              ),
                            ],
                          ),
                        ),
                      ],
                    )),
              ),
              Container(
                margin: EdgeInsets.fromLTRB(
                  0,
                  30,
                  0,
                  0,
                ),
                height: 1000,
                child: _taoListView(),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
