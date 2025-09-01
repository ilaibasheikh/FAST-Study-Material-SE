#include <stdio.h>
void abc(int *j);
int main()
{
	int i = 0;
	int *p;
	p = &i;
	
	printf("p is : %p\n", p);
	printf("*p is: %d\n", *p);
	printf("i is : %d\n", i);
	
	abc(p);
	
	printf("p is : %p\n", p);
	printf("i is : %d\n", i);
}
void abc(int *j)
{
	*j = 100;
	printf("----------------------\n");
	printf("*j is : %d\n", *j);
	printf("j is: %p\n", j);
	j++;
	printf("j++ is: %p\n", j);
	printf("----------------------\n");
}