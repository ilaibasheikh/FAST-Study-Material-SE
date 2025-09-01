#include <stdio.h>
int main()
{
	int digit, age, gender, num, count, ans, verify, sum;
	printf("enter 4 digit number\n");
	scanf("%d", &digit);
	printf("enter age\n");
	scanf("%d", &age);
	printf("what is your gender? 1 for male, 0 for female");
	scanf("%d", &gender);
	
	num = digit + age + gender;
	
	count = 0;
	while (num>0)
	{
		count++;
		sum+=(num%10);
		num/=10;
	}
	
	ans = sum % 5;
	printf("enter verification code");
	scanf("%d", &verify);
	
	if (verify == ans)
		printf("correct");
	else
		printf("incorrect");
}