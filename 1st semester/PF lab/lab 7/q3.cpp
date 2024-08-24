#include <stdio.h>
#include <stdlib.h>
int main()
{
	int choice, tick, sopho, total, juniors, sophop, juniorsp, seats;
	printf("menu selection \n");
	printf("1.Purchase ticket\n2.Display information\n3.Exit\n");
	printf("enter your choice\n");
	scanf("%d", &choice);
	seats = 500;
	while(!(choice>3))
	{
		switch(choice)
		{
			case 1 :
			printf("how many tickets would you like to buy?\n ");
			scanf("%d\n", &tick);
			if (tick >500)
			{
				printf("sorry all tickets are sold\n");
			}
			else {
				printf("how many sopho?\n");
				scanf("%d\n", &sopho);
			
				sophop = 100 * sopho;
				if (sopho > 3)
				{
					sophop = sophop * 0.8;
				 } 
				printf("how many juniors?");
				scanf("%d", &juniors);
				juniors = 50 * juniors;
				if ( juniors > 3 )
				{
					juniorsp = juniorsp * 0.8;
				}
				total = sophop + juniorsp;
				seats = seats - tick;
				break;
			}
			case 2:
				printf("free seats: %d \n", seats);
				printf("income: %d\n", total);
				break;
			case 3:
				exit(1);
			default:
				printf("Invalid choice\n");
		}
		printf("menu selection \n");
		printf("1. Purchase ticket\n2.Display information\n3.Exit\n");
		printf("enter your choice\n"); 
		scanf("%d\n", &choice);
	}
}