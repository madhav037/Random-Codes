#include<stdio.h>

void printHello(int n);
int sumOfNum(int n);
int factorial(int n);
int fib(int n);

int main() {
    //printHello(5);
    //printf("sum is : %d", sumOfNum(5));
    //printf("factorial is : %d", factorial(5));
    printf("%d",fib(6));
    return 0;
}

//recursive function
void printHello(int n) {
    if(n == 0)
    {
        return;
    }
    printf("HELLO!!\n");
    printHello(n-1);
}

//for sum of 1st n natural num
int sumOfNum(int n) {
    if (n==1)
    {
        return 1;
    }
    
    int sumN1 = sumOfNum(n-1); //sum of 1 to n numbers
    int sumN = sumN1 + n;
    return sumN;
}

//for factorial of n
int factorial(int n) {

    if (n==1)
    {
        return 1;
    }
    
    int multi1 = factorial(n-1);
    int multi = multi1 * n;
    return multi;
}

//for fibonacci sequences's nth term
int fib(int n) {
    if (n==0)
    {
        return 0;
    }
    if (n==1)
    {
        return 1;
    }
    
    int fibNm1 = fib(n-1);
    int fibNm2 = fib(n-2);
    int fibN = fibNm1 + fibNm2;
    return fibN;   
}