#include <Stdio.h>
void printOne(int x);
int main()
{
	int a=5;
	printOne(a);
	return 0;
}
void printOne(int x)
{
	printf("%d", x);
	return;
}