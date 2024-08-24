#include <stdio.h>
int main()
{
	int table[3][3]={ {30,40,50},{20,70,90}, {30,40,50} };
	int  r,c;
	for (r=3-1;r>=0;r--){
		for(c=3-1;c>=0;c--){
			printf("%4d", table[r][c]);
		}
	printf("\n");		
	
}
}