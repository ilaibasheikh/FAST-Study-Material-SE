#include <stdio.h>
int main( )
{
	int i= -7 , j, x;
	for (i;i<=7;i++)
	{
		for(j=0;j<3;j++)
		{
			printf("%d\t", i++);
		}
		printf("\n");
	}
}