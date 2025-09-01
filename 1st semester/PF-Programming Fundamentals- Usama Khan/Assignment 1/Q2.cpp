#include <stdio.h>
int main()
{
	int num, sum, factor, x;
	printf("enter an integer:");
	scanf("%d", &num);
	for (x=1; x<num;x++)
	{
		if (num%x == 0)
		{
			sum = sum + x;
		}
	}
	if (sum == num)
	{
		printf("%d is a perfect number", num);
	}
	else 
	{
		printf("%d is not a perfect num", num);
	}
	return 0;
}