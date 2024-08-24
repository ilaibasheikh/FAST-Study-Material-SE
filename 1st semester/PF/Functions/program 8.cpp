#include <stdlib.h>
#include <stdio.h>
int main()
{
	srand(997);
	// rand is through 3 to 7
	int a = rand()%5 +3; // 8 - 3 = 5
	// rand is through 20  to 50
	int b = rand() % 31+20; // 51 - 20 =31
	// rand is through -6 to 15
	int c = rand() %22 -6; // 16 ( -6) = 22
	
	printf("Range 3 to 7 : %d\n", a);
	printf("Range 20  to 50 : %d\n", b);
	printf("Range -6 to 15 : %d\n", c);
}
