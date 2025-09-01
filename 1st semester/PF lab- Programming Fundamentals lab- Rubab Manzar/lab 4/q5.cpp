#include <stdio.h>
int main()
{
	int a, b, result;
	printf("enter two number a and b:");
	scanf("%d", &a);
	scanf("%d", &b);
	
	result = (a <= b) || (a != b);
	printf("(a <= b) || (a != b) is %d \n", result);
	
	result = (a < b) && (a==b);
	printf("(a < b) && (a==b) is %d \n", result);
	
	result = !((a < b) && (a==b));
	printf("!((a < b) && (a==b)) is %d \n", result);
	
	return 0;
}