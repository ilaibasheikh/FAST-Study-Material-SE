#include <stdio.h>
main()
{
	int marks;
	int grade;
	printf("enter your marks");
	scanf("%d", &marks);
	grade = (marks > 50 && marks < 100) ? printf("grade = %d", marks) : -1;

}