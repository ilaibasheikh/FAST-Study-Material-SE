#include <stdio.h>
int main()
{
	int i;
	int arraysize= 5;
	int sqarray[arraysize];
	for (i=0;i<arraysize;i++)
		sqarray[i]=i*i;
		
	printf("Element\t Square\n");
	printf("----\t-----\n");
	for (i=0;i<arraysize;i++)
	{
		printf("%d\t%d\n", i,sqarray[i]);
	}
}