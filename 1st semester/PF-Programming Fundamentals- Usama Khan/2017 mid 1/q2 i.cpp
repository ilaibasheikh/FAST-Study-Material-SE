#include <stdio.h>
int main()
{
	int a, b, c, sum, sum2, sum3;
	printf("Input three integers: ");
	scanf("%d%d%d", &a, &b, &c);
	sum = a+b+c;
	sum2 = sum *2;
	sum3 = sum2 +7;
	printf("Twice the sum of your integers plus 7 is %d --- bye!", sum3);

}