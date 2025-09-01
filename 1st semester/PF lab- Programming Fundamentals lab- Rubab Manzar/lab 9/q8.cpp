#include <stdio.h>
int largest(int arr[], int size)
{
	int i, max;
	max = -9999;
	for (i=0; i<size; i++)
	{
		if (arr[i]> max)
		{
			max = arr[i];
		}
	}
	return max;
}

int main()
{
	int size, max, i;
	printf("Enter the number of elemens to be stored in the array:");
	scanf("%d", &size);
	if (size>0)
	{
		int array[size];
		for (i=0; i<size; i++)
		{
			printf("Enter element %d.\n", i +1);
			scanf("%d", &array[i]);
		}
		max= largest(array, size);
		printf("The largest element in the array is%d.", max);
	}
	return 0;
}