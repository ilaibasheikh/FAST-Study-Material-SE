#include <stdio.h>
int main()
{
	int sal;
	float tax;
	float taxrate;
	printf("enter the salary: " );
	scanf("%d", &sal);
	printf("enter the tax rate: ");
	scanf("%f", &taxrate);
	tax = sal * taxrate;
	sal = sal - tax;
	printf("this is your tax: %f\n", tax);
	printf("this is your salary: %d", sal);
}