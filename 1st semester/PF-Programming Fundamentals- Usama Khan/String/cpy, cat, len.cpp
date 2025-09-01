#include <stdio.h>
#include <string.h>
int main()
{
	char str1[10]="hello";
	char str2[10]="world";
	char str3[10];
	
	strcpy(str3,str1);
	printf("%s\n",str3);
	
	strcat(str1,str2);
	printf("%s\n", str1);
	
	int len;
	len = strlen(str1);
	printf("%d", len);
}