#include <stdio.h>
int main()
{
	int i, j;
	for (i=0;i<=2;i++)
	{
		for (j=0;j<=4;j++)
		{
			if ( (j=i) || (j=4-i))
			printf("*");
		}
		printf("\n");
	}
}