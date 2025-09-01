#include <stdio.h>
int main()
{
	int code;
	int currentcode;
	int newcode;
	int vercode;
	code= 1002;
	printf("enter the current code:");
	scanf("%d", &currentcode);
	if (currentcode == code)
	{
		printf("enter the new code:");
		scanf("%d", &newcode);
		printf("enter once more for verfication:");
		scanf("%d", &vercode);
		if (newcode == vercode)
		{
			printf("your pin is changed");
		}
		else 
		{
			printf("you have entered different code");
		}
	}
	else 
	{
		printf("this is the wrong code");
	}
}