#include <stdio.h>
int main()
{

	int i, j;
	for (i=0;i<=2;i++)
	{
		for (j =0; j<=2; j++)
		{
			if ( j <=i)
			{
				printf("*\t");	
			}
		}
		printf("\n");
		}
	for ( i =3;i<=4;i++)
	{
		for (j=0; j<=2; j++)
		{
			if (j<=4-i)
			{
				printf("*\t");
			}
		}
		printf("\n");	
	}
	}