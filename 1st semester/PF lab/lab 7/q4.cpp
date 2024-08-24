#include <stdio.h>
int main()
{
	int num, f, sq, pos, neg, hun;
	pos = 0; neg = 0; hun = 0;
	do {
		printf("enter a number \n");
		scanf("%d", &num);
		if (num%2 != 0)
		{
			sq = num * num;
			printf("square of number is %d \n", sq);
		}
		if (num > 0)
		{
			
		pos = pos +1;
		}
		if (num <0)
		{
			neg = neg -1;
		}
		if ( num >= 100 && num <= 200)
		{
			hun = hun +1;
		}
	}
	while (num< 15 || num > 25);
	printf("positive are %d negative are %d total count is %d", pos, neg, hun);
}