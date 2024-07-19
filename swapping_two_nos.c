#include <stdio.h>

int main(){
int a=7, b=5;

b= a+b;
a= b-a;
b= b-a;
printf("The swapped vale of a is: %d", a);
printf("The swapped vale of b is: %d", b);


    return 0;
}
