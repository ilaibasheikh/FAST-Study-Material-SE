#include <stdio.h>
int main()
{
	int x, y;
	
int *const ptr = &x;

*ptr = 7;
printf("%p\n", ptr);
printf("%d\n", *ptr);
printf("%d\n", x);
printf("%p\n", &x);
}