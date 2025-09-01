#include <stdio.h>
 
int main()
{
    float amount,rate,time,si;
    
   
    printf("Enter principal (Amount) :\n");
    printf("value should be between 100 rs to 1000000 rs");
    scanf("%f",&amount);
 
    printf("Enter rate :\n");
    printf("value should be between 5% to 10%");
    scanf("%f",&rate);
 
    printf("Enter time (in years) :\n");
    printf("value should be between 1 to 10 years");
    scanf("%f",&time);
 
    si=(amount*rate*time)/100;
 
    printf("\nSimple Interest is = %f",si);
 
    return 0;
}

