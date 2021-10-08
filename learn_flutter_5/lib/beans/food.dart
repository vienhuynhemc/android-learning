import 'package:learn_flutter_5/beans/complexity.dart';

class Food {
  String name;
  String urlImage;
  Duration duration;
  List<String> ingredients;
  int categoryId;
  Complexity complexity;

  Food(
      {required this.name,
      required this.urlImage,
      required this.duration,
      required this.ingredients,
      required this.categoryId,
      required this.complexity});
}
