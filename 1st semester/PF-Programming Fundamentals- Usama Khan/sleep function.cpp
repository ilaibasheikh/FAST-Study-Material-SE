// C program to demonstrate
// use of sleep function
// till 10 seconds in Windows.
#include <stdio.h>

int main()
{
int n;
	printf("Program to sleep for 10 second in Windows.\n");
	printf("Enter n");
	scanf("%d", &n);

	sleep(20);

	printf("This line will be executed after 10 second.");

	return 0;
}
