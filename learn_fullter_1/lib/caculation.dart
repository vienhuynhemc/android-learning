String s = "How are you";
String s2 = 'I\'m fine';
var x = '$s - $s2';
int y = 5;
List<int> numbers = [1,2,3,4,5,6];
List<String> stringNumber = numbers.map((e) {
  return "value = $e";
}).toList();