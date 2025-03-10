#include<stdio.h>

int main() {
  //  float price = 100.00;
  //  float *ptr = &price;
  //  float **ptr = &ptr; //this is pointer to pointer this stores the address of ptr

// question : print the value of 'i' from its  pointer to pointer
//answer
    int i = 5;
    int *ptr = &i;
    int **pptr = &ptr;

    printf("%d", **pptr);

//* = value 
//& = address 

    return 0;
}