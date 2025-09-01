#include <stdio.h>
int main()
{
	int i = 2, k=1;
	while (i< 5)
	{
		for (int j = 1;j <= i;++j)
			do
			{
			printf("i=%d,j=%d,k=%d\n",i,j,k);
			k++;
			}
			while(k<2);
		++i;
	}
}