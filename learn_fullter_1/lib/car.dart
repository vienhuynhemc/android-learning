class Car {
  String _name;
  int _year;

  Car({String name, int year}) {
    this._year = year;
    this._name = name;
  }

  void _doSomeThing(){
    print("I do something");
  }

  @override
  String toString() {
    return '${this._name} ${this._year}';
  }

  // GETTER và SETTER
  int get year => _year;

  set year(int value) {
    _year = value;
  }

  String get name => _name;

  set name(String value) {
    _name = value;
  }
  //--------------------------
}
