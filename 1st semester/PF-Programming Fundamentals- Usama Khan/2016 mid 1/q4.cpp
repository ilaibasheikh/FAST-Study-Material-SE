#include <stdio.h>
int main()
{
	char op;
	int op1, op2;
	printf("enter + - * / ");
	scanf("%c", &op);
	printf("Enter the two values");
	scanf(" %d %d", &op1, &op2);
	
	switch(op)
	{
		case '+':
			printf("%d + %d = %d",op1, op2, op1+op2);
			break;
		case '-':
			printf("%d + %d = %d",op2, op1, op2-op1);
			break;
		case '*':
			printf("%d + %d = %d",op1, op2, op1*op2);
			break;
		case '/':
			printf("%d + %d = %d", op2, op1, op2/op1);
			break;	
		default:
		printf("invalid");	
	}
}