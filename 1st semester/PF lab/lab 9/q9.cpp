#include <stdio.h>

void minMax(int arr[], int size)
{
	int i, min, max;
	min=9999;
	max=-9999;
	for(i=0; i<size;i++)
	{
		if (arr[i]>max)
		{
			max= arr[i];
		}
		else if (arr[i]<min)
		{
			min = arr[i];
		}
	}
	printf("maximum value id %d\n", max);
	printf("minimum value id %d\n", min);
}


int main()
{
	int i, size;
	printf("Enter no of values you want to store in array");
	scanf("%d", &size);
	if (size>0)
	{
		int array[size];
		for(i=0;i<size;i++)
		{
			printf("enter value %d", i+1);
			scanf("%d", &array[i]);
		}
		minMax(array, size);
	}
}