#include <stdio.h>
int addtwodigits(int num);
int firstdigit(int x);
int seconddigit(int x);
int main()
{
	printf("Enter an integer");
	int num;
	scanf("%d", &num);
	
	int sum = addtwodigits(num);
	printf("Sum of the two digits is %d", sum);
	return 0;
}
int addtwodigits(int num)
{
	int res=firstdigit(num)+seconddigit(num);
	return res;
}
int firstdigit(int x)
{
	return (x%10);
}
int seconddigit(int x)
{
	int two = (x/10) %10;
	return two;
}