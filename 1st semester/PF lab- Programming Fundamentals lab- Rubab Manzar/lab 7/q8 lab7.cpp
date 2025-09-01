#include <stdio.h>
#include <math.h>
int main()
{
	int count1, count2, mark, total, all, sub;
	float avg, totalavg;
	mark= 0;
	total = 0;
	all = 0;
	avg = 0;
	for (count1=1; count1<4; count1++)
	{
		printf("enter marks for subject %d \n", count1);
		for (count2=0; count2<11; count2++)
		{
			printf("enter marks\n");
			scanf("%d", &mark);
			total = total + mark;
			all = all + mark;
		}
		avg = total / 10;
		printf("the average marks for this class is %.2f \n", avg);
		
	}
	totalavg = all/30;
	printf("the average grade of all students in all courses %.2f", totalavg);
return 0;
}