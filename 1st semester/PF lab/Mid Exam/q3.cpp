#include <stdio.h>
int main()
{
	int option, hours, adhr, totalsalary, sal, adsal ;
	int sales, stax, ctax, totaltax;
	int month;
	printf("*******Payroll management system******\n");
	printf("Select 1 to calculate salary\n");
	printf("Select 2 to commision on sale\n");
	printf("Select 3 to calculate sales tax\n");
	scanf("%d", &option);
	
	switch(option)
	{
		case 1:
			printf("1.Calculate Salary:\n");
			printf("enter your work hours: ");
			scanf("%d", &hours);
			while (hours!=-1)
			{
				adhr = hours - 40;
				sal = 40 * 500;
				adsal = adhr * 100;
				totalsalary = sal + adsal;
				printf("salary is Rs.%d\n", totalsalary);
				printf("enter your work hours: ");
				scanf("%d", &hours);
			}
			break;
		case 2:
			printf("2. Calculate Commission on sale:\n");
			printf("enter sales:");
			scanf("%d", &sales);
			while (sales != -1)
			{
				sal = (1400 * 4) + (sales * 0.05);
				printf("salary is: %d\n", sal);
				printf("enter sales:");
				scanf("%d", &sales);	
			}
			break;	
		case 3:
			printf("3. Calculate sales tax\n");
			printf("enter number of months: ");
			scanf("%d", &month);
			while (month != -1)
			{
				printf("enter sales: ");
				scanf("%d", &sales);
				stax = sales * 0.04;
				ctax = sales * 0.05;
				totaltax = ctax + stax;
				printf("Country tax: %d\n", ctax);
				printf("Sales tax : %d\n", stax);
				printf("total tax: %d\n", totaltax);
				printf("enter number of months: ");
				scanf("%d", &month);	
			}
			break;
		default:
			printf("enter valid digit");	
	}
}