#include <stdio.h>
int main()
{
	int num, count, sum, mod;
	printf("enter num:");
	scanf("%d", &num);
	
	while (num>0)
	{
		count=count+1;
		sum+=(num%10);
		num = num/10;
	}
	printf("the number of digits are: %d\n", count);
	printf("the sum of the digits is: %d", sum);
}