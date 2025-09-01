#include <stdio.h>
int main()
{
	int a , b , c;
	float d;
	printf("enter the values of a and b: \n");
	scanf("%d", &a);
	scanf("%d", &b);
	
	c = a + b;
	printf(" a + b = %d \n", c);
	
	c = a - b;
	printf(" a - b = %d \n", c);
	
	c = a * b;
	printf("a * b = %d \n", c);
	
	d = a / b;
	printf("a / b = %f \n", d);
	
	c = a % b;
	printf("remainder when a is divided by b = %d \n", c);
	
	return 0;
}