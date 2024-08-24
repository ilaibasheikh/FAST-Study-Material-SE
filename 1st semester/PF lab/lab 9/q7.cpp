#include <stdio.h>

void swap(int a, int b)
{
	int temp;
	printf("Values of a and b before swapping are %d and %d\n", a,b);
	temp=a;
	a=b;
	b= temp;
	printf("values of a and b after swapping are %d and %d\n", a,b);
}


int main()
{
	int a, b;
	printf("Enter value of a");
	scanf("%d", &a);
	printf("Enter value of b");
	scanf("%d", &b);
	swap(a,b);
}
