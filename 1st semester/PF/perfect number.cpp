#include <stdio.h>
int main()
{
	int n,i, d;
	d = 0;
	printf("Enter the number");
	scanf("%d", &n);
	
	for (i=1 ; i<n ; i++)
	{
		if (n % i == 0 ) 
		{
			printf("%d  ", i);
			d= d + i;
		}	
	}
	if (d==n)
	{
	printf("\n %d is a perfect number", n);	
	}
	else 
	{
		printf("\n %d is not a perfect number", n);
	}
	
}