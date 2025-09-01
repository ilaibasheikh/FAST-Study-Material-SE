#include <stdio.h>
int main()
{
	int id, hour;
	float amount, salary;
	printf("Input the Employees ID:");
	scanf("%d", &id);
	printf("\nInput the working hrs: ");
	scanf("%d", &hour);
	printf("\nSalary amount/hr: ");
	scanf("%f", &amount);
	salary = amount * hour;
	printf("\nEmployees ID = %d \nSalary = %.2f\n", id,salary);
	return 0;
}