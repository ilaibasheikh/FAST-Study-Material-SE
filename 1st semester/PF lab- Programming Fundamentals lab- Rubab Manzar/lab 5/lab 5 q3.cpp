#include <stdio.h>  
#include <math.h>
int main()  
{   
    char opt;  
    int n1, n2;   
    float res;  
    printf (" Choose an operator(+, -, *, /) \n ");  
    scanf ("%c", &opt); 
    printf (" \n Enter the first number: ");  
    scanf(" %d", &n1); 
    printf (" Enter the second number: ");  
    scanf (" %d", &n2);  
      
    switch(opt)  
    {  
        case '+':  
            res = n1 + n2;
            printf (" Addition of %d and %d is: %.2f", n1, n2, res);  
            break;  
          
        case '-':  
            res = n1 - n2;  
            printf (" Subtraction of %d and %d is: %.2f", n1, n2, res);  
            break;  
              
        case '*':  
            res = n1 * n2;  
            printf (" Multiplication of %d and %d is: %.2f", n1, n2, res);  
            break;            
          
        case '/':  
            res = n1 / n2; 
            printf (" Division of %d and %d is: %.2f", n1, n2, res);  
            break;  
        default:   
            printf (" Something is wrong!! Please check the options ");               
    }  
    return 0;  
}  