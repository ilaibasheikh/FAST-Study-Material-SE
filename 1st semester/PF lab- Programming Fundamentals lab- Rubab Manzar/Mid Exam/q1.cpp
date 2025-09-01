#include <stdio.h>
int main()
{
	char category;
	int id, total, var;
	printf("Enter your emplyee id ");
	scanf("%d", &id);
	printf("Enter your category ");
	scanf(" %c" , &category);
	
	switch(category)
	{
		case 'A':
			printf("enter your medical expenses");
			scanf("%d", &total);
			printf("expenses paid by insurance: 400000\n");
			var = total - 400000;
			printf("expenses paid by the employee: %d", var);
			break;
		case 'B':
			printf("enter your medical expenses");
			scanf("%d", &total);
			printf("expenses paid by insurance: 300000\n");
			var = total - 300000;
			printf("expenses paid by the employee: %d", var);
			break;
		case 'C':
			printf("enter your medical expenses");
			scanf("%d", &total);
			printf("expenses paid by insurance: 250000\n");
			var = total - 250000;
			printf("expenses paid by the employee: %d", var);
			break;
		default:
			printf("enter valid category");

	}
}