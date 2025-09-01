#include <stdio.h>
int main()
{
	int table [6][6];
	int  r,c;
	for (r=0;r<6;r++)
		for(c=0;c<6;c++)
	if (r==c)
		table[r][c]=0;
	else if (r>c)
		table[r][c]=-1;
	else
		table[r][c]=1;
	for (r=0;r<6;r++){
		for(c=0;c<6;c++)
		printf("%4d", table[r][c]);
		printf("\n");
	}
}