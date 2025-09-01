#include <stdio.h>
int main()
{
	int option, totalhours, days, mins, hours, icecream, totalcost, cost8, cost16;
	totalhours = 0, days=0, mins=0, hours=0, icecream=0, totalcost=0, cost8=0, cost16=0;
	printf("enter 1 for operating the plant for 8 hours, and 2 for 16 hours\n");
	scanf("%d", &option);
	
	switch(option)
	{
		case 1:
			printf("enter the number of icecreams that have been ordered \n");
			scanf("%d", &icecream);
			hours = icecream /50;
			mins = icecream%50;
			days = 0;
			if (hours>8)
			{
				days=hours/8;
				hours = hours%8;
			}
			if (mins>0)
			{
				hours = hours +1;
			}
			totalhours = hours + (days*8);
			cost8 = icecream * 60;
			printf("cost to produce per icecream is 60 rs for 8 hours \n");
			printf("number of hours the plant was active was %d\n", totalhours);
			printf("number of days it took to produce ice cream %d\n", days);
			printf("number of remaining hours %d\n", hours);
			break;
			
		case 2:
			printf("enter the number of icecreams that have been ordered \n");
			scanf("%d", &icecream);
			hours = icecream /50;
			mins = icecream%50;
			days = 0;
			while (hours >16)
			{
				days = days +1;
				hours = hours -16;
			}
			if (mins>0)
			{
				hours = hours +1;
			}
			cost16 = ((days/2)*8*120);
			cost8 = (((days/2)*8)+hours)*60;
			totalcost = cost16+cost8;
			totalhours = (days*16)+hours;
			printf("cost to produce per icecream is 60 rs for 8 hours and 120 for the next 8 hours \n");
			printf("number of hours the plant was active was %d\n", totalhours);
			printf("number of days it took to produce ice cream %d\n", days);
			printf("number of remaining hours %d\n", hours);
			break;
		default:
			printf("please choose 1 or 2");		
	}
	printf("the total cost of icecream is %d\n", totalcost);	
}