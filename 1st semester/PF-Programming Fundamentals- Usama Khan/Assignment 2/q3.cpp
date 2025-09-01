#include <stdio.h>
int main()
{
	int num;
	char option, word[4];
	int r;
	printf("do u want to encrypt or decrypt? e for encrypt d for decrypt \n");
	scanf("%c", &option);
	if (option== 'e')
	{
		printf("input the string num");
		scanf("%d", &num);
		while (num>0)
		{
			r=num%10;
			printf("%c", r + 65);
			num/=10;
		}
	}		
	else if (option == 'd')
	{
		printf("enter the cypher");
		scanf("%s", &word);
		for(int x=3; x>= 0; x--)
		{
			printf("%d", word[x]-65);
		}
	}
}