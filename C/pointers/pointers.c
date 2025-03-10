#include<stdio.h>

int main() {
    // int age = 22;
    // int *ptr = &age;
    // int _age = *ptr;

    // printf("%d", _age);

    // //address
    // printf("%p\n", &age);
    // printf("%u\n", &age);
    // printf("%u\n", ptr);
    // printf("%u\n", &ptr);

    // //value
    // printf("\n%d\n", age);
    // printf("%d\n", *ptr);
    // printf("%d\n", *(&age));

    //for more understanding
    int x;
    int *ptr;

    ptr = &x; //here ptr stores x's address
    *ptr = 0; //aya ptr ma j no address store karyo che ene 0 assign kari chi....that is x = 0

    printf("\nx is %d\n", x);
    printf("*ptr is %d\n", *ptr);

    *ptr += 5; //i.e. x = 5
    printf("\nx is %d\n", x);
    printf("*ptr is %d\n", *ptr);

    (*ptr)++; //i.e. x = 6
    printf("\nx is %d\n", x);
    printf("*ptr is %d\n", *ptr);

    return 0;
}