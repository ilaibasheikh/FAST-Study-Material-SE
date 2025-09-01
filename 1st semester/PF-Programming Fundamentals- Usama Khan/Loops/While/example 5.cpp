#include <stdio.h>
int main()
{
	int num, c;
	printf("Enter a number");
	scanf("%d", &num);
	
	int  count,sum;
	
	while(num>0)
	{
		count++;
		c=num%10;
		sum=sum+c;
		num/=10;
	}
	printf("number of digits: %d\n", count);
	printf("sum of digits: %d", sum);
}