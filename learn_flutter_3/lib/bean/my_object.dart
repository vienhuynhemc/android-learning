class MyObject {
  String _name = "";
  double _gia = 0;

  MyObject({
    required String name,
    required double gia,
  }) {
    _name = name;
    _gia = gia;
  }

  String get name => _name;

  set name(String value) {
    _name = value;
  }

  double get gia => _gia;

  set gia(double value) {
    _gia = value;
  }

  @override
  String toString() {
    return '${this._name} ${this.gia}';
  }

}
