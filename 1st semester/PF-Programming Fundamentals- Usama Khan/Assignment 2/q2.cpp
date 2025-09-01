#include <stdio.h>
int main()
{
	int x, n, age;
	char area;
	printf("how many people are present? \n");
	scanf("%d", &n);
	for (x=1; x <= n; x=x+1)
	{
	printf("what is your age? \n");
	scanf("%d", &age);
	printf("which area are you from? r for rural, u for urban? \n");
	scanf(" %c", &area);
	if (age >= 18 && area == 'u')
	{
		printf("Eligible for the vaccine. Kindly proceed for the vaccination \n");}
	else if (age < 18 && area == 'r')
	{
	printf("Not Eligible for the vaccine. Kindly wait for the vaccination \n");}
	}
}
// we will check how many people are there and that many times the loop will run, we will check the age and area of the person to check if they are 
// elegible for the vaccine or not