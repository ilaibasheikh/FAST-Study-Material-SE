#include <stdio.h>
int main()
{
	int n;
	int great = 0000; int small=9999;
	printf("Enter an integer\n");
	scanf("%d", &n);
	int digits, digit;
	while(n>0)
	{
		digits++;
		digit= n%10;
		printf("%d\n", digit);
	
			if (digit > great)
			{
				great = digit;
			}
			if (digit < small)
			{
				small = digit;
			}
	
		n=n/10;
	}
	
	printf("The digits are %d\n", digits);
	printf("The maximum number is %d\n",great);
	printf("The minimum number is %d\n",small);
	
	if (digits%2 == 0)
	{
		printf("The digits are even\n");
		printf("Output : %d%d", great,small);
	}
	else 
	{
		printf("The digits are odd\n");
		printf("Output : %d%d", small,great);	
	}
		
}