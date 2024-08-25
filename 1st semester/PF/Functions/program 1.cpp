#include <Stdio.h>
int multiply(int num1, int num2);
int main()
{
	int a,b;
	printf("enter two integers");
	scanf("%d", &a);
	scanf("%d", &b);
	
	int product=multiply(a, b);
	printf("Product of %d and %d is %d", a, b, product);
	return 0;
}
int multiply(int num1,int num2)
{;
	return num1 * num2;
}