#include <stdio.h>
int main()
{
	int i;
	int number[50];
	int readnum;
	printf("how many integer would you like to enter?");
	scanf("%d", &readnum);
	printf("Enter your numbers");
	for ( i = 0; i<readnum; i++)
	scanf("%d", &number[i]);
	
	printf("your reversed numbers are:\n");
	for (i=readnum-1;i>=0;i--)
	printf("%d",number[i]);
}