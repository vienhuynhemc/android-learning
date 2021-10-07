import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class SanPham {
  String tenSanPham;
  int giaSanPham;
  DateTime ngayTao;

  SanPham({
    required this.tenSanPham,
    required this.giaSanPham,
    required this.ngayTao,
  });

  String getNgayTaoString() {
    return '${ngayTao.day}/${ngayTao.month}/${ngayTao.year}';
  }
}

class KeySnackbar {
  static KeySnackbar key = KeySnackbar();

  GlobalKey<ScaffoldMessengerState> globalKey = GlobalKey();

  static KeySnackbar getInstance() {
    return key;
  }
}
