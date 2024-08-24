#include <stdio.h>
main()
{
	int num1, num2, num3, ans;
	printf("enter the three sides of triangle ");
	scanf("%d%d%d", &num1, &num2, &num3);
	
	ans = ((num1 == num2 && num1 == num3) ? printf("Equilateral"): (num1 == num2 || num1 == num3) ? printf("Isosceles") : printf("scalene"));
}