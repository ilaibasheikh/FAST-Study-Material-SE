#include <stdio.h>
int main()
{
	int ival, sum;
	printf("Enter a number");
	scanf("%d", &ival);
	while(ival!=0)
	{
		sum=sum+ival;
		printf("Enter a number");
		scanf("%d", &ival);
	}
	printf("Sum is %d", sum);
}