#include <stdio.h>
int main ()
{
	
	int num1, num2;
	printf("enter first number: \n");
	scanf("%d", &num1);
	printf("enter second number: \n");
	scanf("%d", &num2);
	
	
	while(num1 != num2)
	{
		num1 = num1>>2;
		num2 = num2 * num2;
		printf("your first num is %d \n" , num1);
		printf("your second number is %d \n", num2);
	}	
		
}