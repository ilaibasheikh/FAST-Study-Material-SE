#include <Stdio.h>
int main()
{
	int test[3][2]={ {2,3}, {5,4},{3,5}};
	int i ,j;
	for(i=0;i<3;i++)
	{
		for (j=0;j<2;j++)
		{
			printf("test[%d][%d]=%d",i,j,test[i][j]);
			printf("\n");
		}
	}
}