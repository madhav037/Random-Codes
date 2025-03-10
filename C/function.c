#include<stdio.h>

//declaration/prototype
void printHello();
int sum(int a, int b);
void printTable(int n);

int main() {
    printHello(); //function call

    // int a, b, answer;
    // printf("enter value of a : ");
    // scanf("%d", &a);
    // printf("enter value of b : ");
    // scanf("%d", &b);

    // answer = sum(a, b);
    // printf("sum is %d", answer);
    int n;
    printf("enter num :");
    scanf("%d", &n);

    printTable(n); //argument/actual parameter

    return 0;
}

//function defination
void printHello() {
    printf("Hello world\n");
}    

// function defination for sum of 2 nums
int sum(int a, int b) {
    return a + b;
}    

// function defination to print table of given num
void printTable(int n) {  //parameter/formal parameter
    for ( int i = 1; i <= 10; i++)
    {
        printf("%d * %d = %d\n", n,i,i*n);
    }
    
}