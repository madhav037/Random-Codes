#include<stdio.h>     //gcc .\fileName.c, ./a.exe to compile and run 

int main()
{
        int h;
        printf("enter no.");
        scanf("%d", &h);

        for (int i = 1; i <= h; i++)
        {
              for (int j = 1; j <= h; j++)
              {
                if (j >= i)
                {
                    printf("1");
                }
                else
                {
                    printf(" ");
                }
                
              }
              
              printf("\n");
        }     
        return 0;
}
