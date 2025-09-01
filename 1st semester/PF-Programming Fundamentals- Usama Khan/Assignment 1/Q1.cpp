#include <stdio.h>
int main()
{
	int num, factor, x, sum;
	printf("Enter an integer:\n");
	scanf("%d", &num);
	
	for(x=1;x<=num;x++)
	{
		if (num%x == 0)
		{
			factor = x;
			printf("%d\n", factor);
			sum = sum + factor;
		}
	}
	printf("Sum of series is: %d", sum);
	return 0;
}