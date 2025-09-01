#include <stdio.h>
int main()
{
	int day;
	printf("how many days late is your fee \n");
	scanf("%d", &day);
	if (day <= 7)
	{
		printf("your fine is 500 rupees");
	}
	else if (7<day && day<14)
	{
		printf("your fine is 1000 rupees");
	}
	else if (day>14)
	{
		printf("your fine is 1500 rupees");
	}
}
