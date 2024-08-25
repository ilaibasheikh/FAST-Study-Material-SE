#include <stdio.h>
int main()
{
	int limit;
	printf("enter limit");
	scanf("%d", &limit);
	
	int linectrl, numctrl;
	
	for(linectrl=1; linectrl<=limit ; linectrl++)
	{
		for(numctrl=1; numctrl<=linectrl ; numctrl++)
		{
			printf("%d", numctrl);
		}	
		printf("\n");
	}
}