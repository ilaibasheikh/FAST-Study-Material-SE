#include <stdio.h>
int main()
{
	int count, count1, num, sum, negative;
	
	for (count =0; ; count++)
	{
		printf("enter any integer");
		scanf("%d", &num);
		
		if (num<0)
		{
			negative = num;
			printf("the negative number is %d\n", negative);
			break;
		}
		if (num>=11 && num<=19)
		{
			for (count1 = 1; count1<= num ;count1++)
			{
				printf("welcome to C1002\n");
			}
		}
		else 
		{
			sum = sum + num;
		}
	}
	printf("the sum of positive numbers are %d", sum);
}
