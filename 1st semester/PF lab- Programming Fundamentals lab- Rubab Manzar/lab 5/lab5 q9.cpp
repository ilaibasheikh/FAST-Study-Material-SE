#include <stdio.h>
int main()
{
	char gender;
	float height;
	printf("what is your gender. write M for male and F for female?");
	scanf("%c",&gender);
	
	switch (gender)
	{
		case 'M':
			printf("What is your height?");
			scanf("%f", height);
			if (height<1.70)
			{
				printf("short");
			}
			else if (height>=1.70 && height< 1.85)
			{
				printf("normal");
			}
			else if (height>=1.85)
			{
				printf("tall");
			}
			break;
		case 'F':
			printf("What is your height?");
			scanf("%f", height);
			if (height<1.60)
			{
				printf("short");
			}
			else if (height>=1.60 && height< 1.75)
			{
				printf("normal");
			}
			else if (height>=1.75)
			{
				printf("tall");
			}
			break;
		default:
			printf("enter M or F");		
	}
}