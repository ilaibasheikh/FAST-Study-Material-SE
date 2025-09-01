#include <stdio.h>
int main()
{
	int s[4][3]= { {1234, 56},
					{1212, 33},
					{1434, 80},
					{1312, 78}};
	int i,j;
	
	for (i=0;i<4;i++)
	{
	
		for (j=0;j<2;j++)
		{
		
			printf("%d ", *(*(s + i)+ j));
		}
		printf("\n");
	}
}