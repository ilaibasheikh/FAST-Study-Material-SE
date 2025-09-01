#include <stdio.h>
int main()
{
	char method;
	int quantity;
	int amount;
	float discount;
	printf("enter your choice as q for quantity or c for cash:");
	scanf("%c", &method);
	
	switch (method)
	{
		case 'q':
			printf("enter the quantity:");
			scanf("%d",&quantity);
			if (quantity>50 && quantity<155)
			{
				discount= quantity * 0.085;
				printf("discount is %f", discount);
			}
			else if (quantity>155)
			{
				discount = quantity * 0.25;
				printf("discount is %f", discount);
			}
			break;
		case 'c':
			printf("enter the amount:");
			scanf("%d", &amount);
			if (amount > 2000 && amount <4500)
			{
				discount= quantity * 0.085;
				printf("discount is %f", discount);	
			}
			else if (amount>4500)
			{
				discount = quantity * 0.25;
				printf("discount is %f", discount);
			}
			break;
		default:
			printf("enter c or q only");
	}
}