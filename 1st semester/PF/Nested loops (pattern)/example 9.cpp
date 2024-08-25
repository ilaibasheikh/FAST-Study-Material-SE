#include <stdio.h>
int main()
{
	int i, j;
	for (i=0;i<=2;i++)
	{
		for (j=0;j<=2;j++)
		{
			if ( j>=2-i && j<=2)
			printf("*");
		}
		printf("\n");
	}
	for (i=3;i<=4; i++)
	{
		for (j=0;j<=2;j++)
		{
			if (j>=4-i && j<=2)
			printf("*");
		}
		printf("\n");
	}
}