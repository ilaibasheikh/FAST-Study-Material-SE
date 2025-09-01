#include <stdio.h>
int main ()
{
	int num;
	printf("how many years have you served for? \n");
	scanf("%d", &num);
	if (num>=1)
		printf("You are eligible for earned leave");
	else
		printf("You are not eligible for earned leave");
	return 0;
}