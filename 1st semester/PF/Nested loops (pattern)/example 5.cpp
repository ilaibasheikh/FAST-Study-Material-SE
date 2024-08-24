#include <stdio.h>
int main()
{
	int i, j, r, c;
	printf("enter the number of rows:");
	scanf("%d", &r);
	c= (r*2)-1;
	for (i=0;i<=r;i++)
	{
		for (j=0;j<=c;j++)
		{
			if (j>=2-i && j<=2 +i)
			printf("*");
		}
		printf("\n");
	}
}