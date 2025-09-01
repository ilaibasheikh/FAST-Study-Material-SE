#include <stdio.h>
int main()
{
	int ival, linecount;
	printf("Enter a number");
	scanf("%d", &ival);
	
	while(ival>0)
	{
		if (linecount<10)
		{
			linecount++;
		}
		else 
		{
			printf("\n");
			linecount=1;
		}
		printf("%d\n",ival--);
	}
}