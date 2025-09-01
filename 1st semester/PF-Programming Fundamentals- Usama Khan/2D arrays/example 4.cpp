#include <stdio.h>
int main()
{
	int table [3][4]={ {11,12,13,14},{21,22,23,24}, {31,32,33,34} };
	int  r,c;
	for (c=0;c<4;c++){
		for(r=0;r<3;r++)
		{
		printf("%4d", table[r][c]);	
		}
	printf("\n");
	}
}