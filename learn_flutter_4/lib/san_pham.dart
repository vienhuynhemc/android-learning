class SanPham {
  String tenSanPham;
  int giaSanPham;
  DateTime ngayTao;

  SanPham({
    required this.tenSanPham,
    required this.giaSanPham,
    required this.ngayTao,
  });

  String getNgayTaoString(){
    return '${ngayTao.day}/${ngayTao.month}/${ngayTao.year}';
  }
}
