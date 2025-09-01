#include <stdio.h>
int main()
{
	int avg, sum, i;
	int marks[10];
	for (i=0;i<10;i++)
	{
		printf("%d . Enter marks:", i);
		scanf("%d", &marks[i]);
	}
	for (i=0;i<10;i++)
	{
		sum = sum + marks[i];
	}
	avg = sum / 10;
	printf("average marks : %d", avg);
}