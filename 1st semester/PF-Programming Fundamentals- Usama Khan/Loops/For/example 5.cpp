#include <stdio.h>
int main()
{
	int limit, i;
	printf("enter limit");
	scanf("%d", &limit);
	
	for(i=1;i<=limit;i++)
	{
		printf("\t%d\n", i);
	}
}