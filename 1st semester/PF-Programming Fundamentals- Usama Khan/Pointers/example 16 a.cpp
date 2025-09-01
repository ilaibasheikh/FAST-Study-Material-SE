#include <stdio.h>
#include <string.h>
int main()
{
	char str1[] = "Hello";
	char str2[10];
	char *s = "Good Morning";
	char *q;
	
	q = s;
	
	printf("Str1 : \t %s \n", str1);
	printf("q : \t %s \n", q);
	
	printf("s : \t %s \n", s);
	
	strcpy(str2, str1);
	printf("Str2 : \t %s \n", str2);
}