#include <stdio.h>

void pos(int marks, int exp)
{
	if (marks>=50 && marks<60)
	{
		puts("you have assigned the position of Trainee Engineer");
	}
	else if (marks>=60 && marks<=100 && exp>=1)
	{
		puts("you have assigned the position of Assistant Developer");
	}
	else if (marks>=70 && marks<=100 && exp>=2)
	{
		puts("you have assigned the position of Associate Developer");
	}
	else 
	{
		puts("you have not been assigned any position");
	}
}

int main()
{
	int marks, exp;
	puts("enter marks");
	scanf("%d", &marks);
	if (marks>=60)
	{
		puts ("enter your experience");
		scanf("%d", &exp);
	}
	pos(marks, exp);
}