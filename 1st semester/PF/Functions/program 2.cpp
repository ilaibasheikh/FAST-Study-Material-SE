#include <stdio.h>
int printOne(int x);
int main()
{
	int a=5;
	printOne(a);
	
	a= 33;
	printOne(a);
	return 0;
}
int printOne(int x)
{
	printf("%d\n", x);
}