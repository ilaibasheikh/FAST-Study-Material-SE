#include <stdio.h>
int main()
{
	int a[6]={5,1,6,2,4,3};
	int i,j,temp;
	for(j=0;j<6;j++)
	{
		for(i=0;i<6-j-1;i++)
		{
			if (a[i]>a[i+1])
			{
				temp=a[i];
				a[i]=a[i+1];
				a[i+1]= temp;
			}
		}
	}
	for (i=0;i<6;i++)
	{
		printf("%d\n", a[i]);
	}
}