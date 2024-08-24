#include <stdio.h>
int main()
{
	int x= 7;
	int y;
	
	const int *const ptr =&x;
	
printf("%p\n", ptr);
printf("%d\n", *ptr);
printf("%d\n", x);
printf("%p\n", &x);

}