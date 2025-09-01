#include <stdio.h>
int main()
{
	int x=25;
	int *p;
	p = &x;
	
	printf("%d\n", *p);
	printf("%d", p);
}