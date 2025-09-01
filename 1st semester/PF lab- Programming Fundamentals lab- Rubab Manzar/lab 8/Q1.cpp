#include<stdio.h>
int main() {
	int num[5];
	int input,i;
	for (i=0;i<5;i++)
	{
		printf("Enter number to array:");
		scanf("%d",&num[i]);
	}
	printf("enter the number you want to search\n");
	scanf("%d",&input);
	for (i=0;i<5;i++)
	{
		if (input==num[i])
		{
			printf("Number Exists in Array\n");
			return 0;
		}
	}
	printf("number does not exists in array\n");
	
}