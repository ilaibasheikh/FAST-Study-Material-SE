#include <stdio.h>
int main()
{
	int n,i, d;
	d = 0;
	printf("Enter the number you want to find the factorials of");
	scanf("%d", &n);
	for (i=1 ; i<=n ; i++)
	{
		if (n % i == 0 ) 
		{
			printf("%d  ", i);
			d= d + i;
		}	
	}
	printf("\nThe sum of the factors is %d", d);
}