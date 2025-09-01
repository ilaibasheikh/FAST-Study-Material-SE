#include<stdio.h>
int main()
{
	int size,i,j,sum,avg;
	printf("enter the size of array: ");
	scanf("%d",&size);
	int a[size];
	for (i=0;i<size;i++)
	{
		printf("Enter (%d) number in array:",i);
		scanf("%d",&a[i]);
	}
	printf("elements in array are: ");
	for (j=0;j<size;j++)
	{
	printf("%d ,",a[j]);
	sum+=a[j];
	avg=sum/size;
	}
	printf("\nsum of all elements: %d\n",sum);
	printf("Average: %d\n",avg);
}