#include <stdio.h>
int main()
{
	int limit, i, n;
	printf("enter limit");
	scanf("%d", &limit);
	
	for(n=0, i=10 ;n!=limit;n++, i--)
	{
	printf("%d\t%d\n", n, i);
	}
}