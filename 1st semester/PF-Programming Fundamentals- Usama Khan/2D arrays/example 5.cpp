#include <stdio.h>
int main()
{
	int A[3][2]={ {3,3},{1,1}, {2,0} };
	int B[3][2]={ {3,0},{3,0}, {0,1} };
	int C[3][2];
	int  r,c;
	for (r=0;r<3;r++){
		for(c=0;c<2;c++)
		C[r][c]= A[r][c] + B[r][c];
	
}
	for (r=0;r<3;r++){
		for(c=0;c<2;c++)
		{
		printf("%4d", C[r][c]);	
		}
		printf("\n");
}
}