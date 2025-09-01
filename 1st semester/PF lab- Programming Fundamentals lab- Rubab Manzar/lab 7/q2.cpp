#include <stdio.h>
int main()
{
	int num, count, x;
	printf("enter an integer: ");
	scanf("%d", &num);

	while (num>0)
	{
		
		x = 1;
		while (x <= num)
		{
		printf("CL1002 Exam is in week 09 \n");
		x = x +1;
		count = count +1;
		}
		printf("enter an integer: ");
		scanf("%d", &num);
	}	

	printf("the total number of times message was displayed is %d \n", count);
}