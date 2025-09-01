#include <stdio.h>
main()
{
	
	int num, ans;
	printf("enter num");
	scanf("%d", &num);
	ans = (num > 0? printf("your number is positive") : (num < 0 ? printf("your number is negative") : printf("your number is zero")));
}



