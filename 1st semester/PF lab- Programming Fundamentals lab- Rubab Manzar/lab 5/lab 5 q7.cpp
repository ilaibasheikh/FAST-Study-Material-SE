#include <stdio.h>
#include <math.h>
int main()
{
	char choice;
	float weight;
	printf("What is your class: A-economy, B-business, C-economy?");
	scanf("%c", &choice);
	
	switch (choice)
	{
		case 'A':
			printf("Whats your weight?");
			scanf("%f", &weight);
			if (weight <=25)
			{
				printf("no cost");
			}
			else if (weight > 25 && weight <=40)
			{
				printf("cost is 1.5 rs per kg over 25");
			}
			else if (weight>40)
			{
				printf("cost is 2 rs per kg over 40");
			}
			break;
		case 'B':
			printf("Whats your weight?");
			scanf("%f", &weight);
			if (weight <=35)
			{
				printf("no cost");
			}
			else if (weight>35 && weight<=50)
			{
				printf("cost is 1.25 rs per kg over 35");
			}
			else if (weight > 50)
			{
				printf("cost is 1.5 rs per kg over 50");
			}
			break;
		case 'C':
			printf("Whats your weight?");
			scanf("%f", &weight);
			if (weight <60)
			{
				printf("no cost");
			}
			else
			{
				printf("30 rs (fixed cost)");
			}
			break;
		default:
			printf("enter A B or C");
	}
}
