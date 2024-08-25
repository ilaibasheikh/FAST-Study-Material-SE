#include <stdio.h>
int  main()
{
	int *arr[4];
	int i=31, j =5, k= 19, l=71, m;
	arr[0]= &i;
	arr[1]= &j;
	arr[2]= &k;
	arr[3]= &l;
	for (m=0;m<4;m++)
	{
		printf("%d \n", *(arr[m]));
	}
}