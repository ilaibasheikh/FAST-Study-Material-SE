#include <stdio.h>
int sqr(int x);
int main()
{
	int a;
	scanf("%d", &a);
	int b=sqr(a);
	printf("%d squared: %d", a, b);
}
int sqr(int x)
{
	x*=x;
	return x;
}