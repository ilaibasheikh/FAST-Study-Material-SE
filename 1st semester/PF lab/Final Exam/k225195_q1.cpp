#include <stdio.h>
int kaleidoscope( int a);
int main()
{
	printf("My student id is 22k-5195\n");
	int n;
	int SEED;
	printf("Enter value for N:\n");
	scanf("%d", &n);
	while (n % 2 == 0)
	{
		printf("N must me an odd value, please enter again:\n");
		scanf("%d", &n);
	}
	
	int GRID[n][n];
	float a , b;

	a = (n/2) + 0.5;
	b= (n / 2) + 0.5;
	
	printf("Enter value for SEED:\n");
	scanf("%d", &SEED);
	int i , j;
	
	for (i=0;i<n;i++)
	{
		for (j=0;j<n;j++)
		{
		
			if ( i==a && j==a);
			{
				printf("%d\t", SEED);
			}
			
		kaleidoscope(n);
		}
			printf("\n");
	}
}

int kaleidoscope(int a)
{
	for (i=1;i<4;i++)
	{
		for (j=1;j<n;j++)
		{
			

		}
			printf("\n");
	}	
}