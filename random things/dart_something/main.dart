import 'dart:io';

void main() {
  double weight = double.parse(stdin.readLineSync()!);
  double height = double.parse(stdin.readLineSync()!);

  weight = weight;
  height = height;

  double BMI = weight / (height * height);

  print("bmi is : ${BMI}");
}
