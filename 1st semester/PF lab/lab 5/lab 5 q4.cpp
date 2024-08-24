#include <stdio.h>

int main()
{
	int M;
	printf("enter month number \n");
	scanf("%d",&M);
	
	switch (M)
	{
		case 12:
		case 1:
		case 2:
			printf("\nWINTER");
			break;
		case 3:
		case 4:
		case 5:
			printf("\nSPRING");
			break;
		case 6:
		case 7:
		case 8:
			printf("\nSUMMER");
			break;
		case 9:
		case 10:
		case 11:
			printf("\nAUTUMN");
			break;
		default:
			printf("\nInvalid Month number");
			break;
	}
}
