#include <stdio.h>
int main( )
{
	int i, j , k;
	for (i=1; i<=7;i=i+2)
	{
		printf("C%d\t",i);
	}
	printf("\n");
	for (j=1; j<=7;j=j+2)
	{
		printf("B%d\t",j);
	}
	printf("\n");
	for (k=1; k<=7;k=k+2)
	{
		printf("A%d\t",k);
	}
}