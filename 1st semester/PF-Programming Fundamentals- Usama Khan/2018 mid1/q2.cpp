#include <stdio.h>
int main()
{
	char breakfast;
	printf("What did you have for breakfast?\n");
	printf("p for porridge, c for cornflakes\n");
	scanf("%c", &breakfast);
	if (breakfast== 'p')
	{
		printf("You will have cornflakes tomorrow");
	}
	else {
		printf("You will have porridge tomorrow");
	}
}