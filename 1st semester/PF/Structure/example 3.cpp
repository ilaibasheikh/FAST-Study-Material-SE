#include <stdio.h>
struct numbers
{
	int n1;
	int n2;
	int sum;
};
int main()
{
	struct numbers num;
	num.n1 =5;
	num.n2 = 10;
	
	num.sum = num.n1 + num.n2;
	
	printf("%d + %d = %d\n", num.n1, num.n2, num.sum);
}