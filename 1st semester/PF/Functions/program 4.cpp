#include <stdio.h>
int firstdigit(int x);

int main()
{
	printf("Enter a number");
	int num;
	scanf("%d", &num);
	
	int digit =firstdigit(num);
	printf("least significant digit is %d", digit);
	return 0;
}

int firstdigit(int x){
	return(x%10);
}