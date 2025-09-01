#include<stdio.h>
int main()
{
	int size,i;
	printf("enter the number of elements to store in array: ");
	scanf("%d",&size);
	int a[size];
	printf("input %d number of elements in the array\n",size);
	for (i=0;i<size;i++)
	{
		printf("element %d :",i);
		scanf("%d",&a[i]);
	}
	printf("the values stored into the array are : \n");
	for (i=0;i<size;i++)
	{
		printf("%d\t",a[i]);		
	}
	printf("\nthe values stored into the array in reverse are : \n");
	for (i=size-1;i>=0;i--)
	{
		printf("%d\t",a[i]);
		
	}
}