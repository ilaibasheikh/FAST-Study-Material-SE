#include <stdio.h>
int main()
{
char grade;
printf("Enter your grade ");
scanf("%c",&grade);

switch (grade)
{
	case 'A':
		printf("you got 80 marks or above");
		break;
	case 'B':
		printf("your got between 60 or 80 marks");
		break;
	case 'C':
		printf("you got between 40 and 60 marks");
		break;
	case 'F':
		printf("you got below 40 marks");
		break;
	default:
		printf("enter valid choice");
		
}
return 0;
}