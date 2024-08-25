#include <stdio.h>
#include <stdlib.h>
int main()
{
	double* ptr = (double*)calloc(2,sizeof(double));
	ptr = (double*)realloc(ptr,3*sizeof(double));
	
	if (ptr == 0)
	{
		printf("Sorry! Unable to allocate memory");
		return 0;
	}
	int i; double sum = 0;
	for (i=0;i<3;i++)
	{
		scanf("%lf", ptr + i);
		sum += *(ptr +i);
	}
	printf("Sum = %f", sum);
	
	free(ptr);
}