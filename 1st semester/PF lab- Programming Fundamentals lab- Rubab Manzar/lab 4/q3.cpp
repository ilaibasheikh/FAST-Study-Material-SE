#include <stdio.h>
int main()
{
	int x; 
	
	x = 7 + 3 * 6 / 2 - 1;
	printf("%d \n", x);
	// we will multiply 3 and 6, then we will divide by 2, then we will add left to right (7+ ((3 * 6) / 2) -1)
	
	x = 2 % 2 + 2 * 2 - 2 / 2;
	printf("%d \n",x);
	// we will take the mod first, then we will multiply and then we will add and subtract from left to right ((2%2)+(2*2)-(2/2))
	
	x = ( 3 * 9 * ( 3 + ( 9 * 3 / ( 3 ) ) ) );
	printf("%d \n",x);
	//we have embedded parenthesis so we will solve inner parenthesis first (3 * 9 * ( 3 + (27/3)
}