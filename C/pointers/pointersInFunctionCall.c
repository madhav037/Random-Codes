#include<stdio.h>

void square(int n);
void _square(int *n);

int main() {
    int num = 5;

    square(num);
    printf("the number is %d\n", num);

    _square(&num);
    printf("the number is %d\n", num);

}

//call by value : we pass value of variable as argument
void square(int n) {
    n = n * n;
    printf("square is %d\n", n);
}

//call by reference : we pass address of variable as argument
void _square(int *n) {
    (*n) = (*n) * (*n);
    printf("square is %d\n", *n);
}