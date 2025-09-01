#include <stdio.h>
#include <stdlib.h>
int main()
{
	double* ptr = (double*)calloc(4,sizeof(double));
	
	*(ptr + 0) = 5.5;
	*(ptr + 1) = 3.2;
	*(ptr + 2) = 7.1;
	*(ptr + 3) = 9;
	
	printf("%f\n", *ptr);
	printf("%f\n", *(ptr+1));
	printf("%f\n", *(ptr+2));
	printf("%f\n", *(ptr+3));
	
	free(ptr);
}