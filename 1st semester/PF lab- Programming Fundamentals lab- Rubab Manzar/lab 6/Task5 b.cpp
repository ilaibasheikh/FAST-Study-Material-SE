#include <stdio.h>
main()
{
	int num, ans;
	printf("enter your marks");
	scanf("%d", &num);
	
	if (num > 74 && num < 101)
		printf("A");
	else if (num > 49 && num < 75)
		printf("B");
	else if (num > 0 && num < 50 )
		printf("fail");
	else 
		printf("invalid input");	
}