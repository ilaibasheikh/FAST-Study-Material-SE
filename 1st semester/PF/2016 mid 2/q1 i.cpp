#include <stdio.h>
void swap(int *a, int *b);
int main()
{
	int p, q;
	printf("Enter num1:\n");
	scanf("%d", &p);
	printf("\nEnter num2:\n");
	scanf("%d", &q);

	printf("Before swapping, num 1 = %d, num 2 = %d\n", p , q);

	swap(&p, &q);
	
	printf("After swapping, num 1 = %d, num 2 = %d\n", p , q);
	return 0;
}
void swap(int*a, int *b)
{
	int temp;
	temp = *a;
	*a= *b;
	*b = temp;
	
}
