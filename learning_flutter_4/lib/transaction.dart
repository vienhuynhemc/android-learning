class Transaction {
  String content;
  double amount;

  Transaction({this.content, this.amount});

  @override
  String toString() {
    return "$content $amount";
  }
}
