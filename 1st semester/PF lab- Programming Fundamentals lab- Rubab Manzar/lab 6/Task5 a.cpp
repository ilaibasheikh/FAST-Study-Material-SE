#include <stdio.h>
main()
{
	int num , ans;
	printf("enter your marks");
	scanf("%d", &num);
	
	ans = ((num > 74 && num < 101) ? printf("A") : ((num > 49 && num < 75 ) ? printf("B"): ( (num > 0 && num < 50 ) ? printf("fail") :printf("Invalid input"))));
}