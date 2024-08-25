#include <stdio.h>
#include <string.h>
int main()
{
	char firstname[100];
	char lastname[100];
	int len;
	int i;
	printf("enter first name");
	gets(firstname);
	printf("enter second name");
	gets(lastname);
	char combine[100];
	strcat(firstname,lastname);
	len =strlen(firstname);
	for (int i=len ; i>=0 ; i--)
	{
		printf("%c", firstname[i]);
	}
	
}
