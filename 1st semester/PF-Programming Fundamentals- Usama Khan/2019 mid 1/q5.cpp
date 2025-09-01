#include <stdio.h>
#include <stdlib.h>
int main()
{
	int n;
	printf("enter a number:\n");
	scanf("%d", &n);
	if (n<1)
	{
		printf("Error");
		exit(0);
	}
	printf("Initial value is %d\n", n);
	int count;
	while(n>1)
	{
		count++;
		if (n%2==0)
		{
			n = n / 2;
			printf("next value is %d\n", n);
		}
		else if (n%2 ==1)
		{
			n = (n*3)+1;
			printf("next value is %d\n", n);
			
		}
		if (n==1)
		{
			printf("final value is %d and the number of steps was %d", n, count);
		}
	}
}