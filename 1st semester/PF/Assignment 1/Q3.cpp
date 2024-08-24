#include <stdio.h>
int main()
{
	int num;
	int n;
	int digit;
	int sum;
	int cube;
	printf("enter integer");
	scanf("%d", &num);
	n = num;
	while(n>0)
	{
		digit = n % 10;
		cube = digit * digit * digit;
		sum = sum + cube;
		n= n / 10;
}
	if (cube == num)
	{
		printf("The number is cuboid");
	}
}