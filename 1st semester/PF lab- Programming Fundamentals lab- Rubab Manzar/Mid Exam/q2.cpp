#include <stdio.h>
int main()
{
	int person, i, rating, num1, num2, num3, num4, num5;
	printf("*****Welcome to rating System*****\n");
	printf("Rating scale is as follows:\n");
	printf("1: Unacceptable/poor\n2: Weak\n3: Good\n4: Very good\n5: Excellent\n");
	printf("Enter number of persons: ");
	scanf("%d", &person);
	i = 1;
	num1 = 0;
	num2 = 0;
	num3 = 0;
	num4 = 0;
	num5 = 0;
	for (i; i<=person ; i++)
	{
		printf("Please enter [%d] rating: ", i);
		scanf("%d", &rating);
		if (rating == 1)
		{
			num1 = num1 + 1;
		}
		else if (rating == 2)
		{
			num2 = num2 + 1;
		}
		else if (rating == 3)
		{
			num3 = num3 + 1;
		}
		else if (rating == 4)
		{
			num4 = num4 + 1;
		}
		else if (rating == 5)
		{
			num5 = num5 + 1;
		}
		
	}
	printf("Summary of rating is:\n");
	printf("1: %d\n", num1);
	printf("2: %d\n", num2);
	printf("3: %d\n", num3);
	printf("4: %d\n", num4);
	printf("5: %d\n", num5);
}