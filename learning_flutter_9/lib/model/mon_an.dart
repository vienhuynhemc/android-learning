class MonAn {

  int id;
  String ten;
  String urlImage;
  Duration timeCook;
  Complexity complexity;
  List<String> nguyenLieu;
  int idDanhMuc;

  MonAn({this.id, this.ten, this.urlImage, this.timeCook, this.complexity,
      this.nguyenLieu, this.idDanhMuc});
}

enum Complexity {
  Simple,
  Medium,
  Hard
}