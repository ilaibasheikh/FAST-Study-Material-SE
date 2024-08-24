#include <stdio.h>
void divide(int divnd, int divsr, int *quot, int *rem);
int main()
{
	int a= 14, b=4,c,d;
	
	divide(a,b, &c, &d);
	printf("Dividend = %d\n", a);
	printf("Divisor = %d\n", b);
	printf("Quotient = %d\n", c);
	printf("Remainder = %d\n", d);
	
}
void divide(int divnd, int divsr, int *quot, int *rem)
{
	*quot = divnd / divsr;
	*rem = divnd % divsr;
}