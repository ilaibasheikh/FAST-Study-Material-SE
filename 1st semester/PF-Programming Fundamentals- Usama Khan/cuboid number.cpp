#include <stdio.h>
int main()
{
	int digit, i, n, s;
	int cube;
	cube = 0;
	printf("Enter the number");
	scanf("%d", &n);
	s = n;
	while(n>0)
	{
		digit= n % 10;
		printf("%d\n", digit);
		cube = cube + (digit*digit*digit);
		
		n = n/10;
	}
	printf("%d\n", cube);
	
	if (cube = s)
	{
		printf("The number is a cuboid");
	}
	else
	{
		printf("The number is not a cuboid");
	}
	
}