#include <stdio.h>
#include <string.h>
int main()
{
	char str1[] = "Hello";
	char *p = "Hello";
	printf("Str1 : \t %s \n", str1);
	printf("p : \t %s \n", p);

	
	
	strcpy(str1, "Bye");
	p = "Bye";
	
	printf("Str1 : \t %s \n", str1);
	printf("p : \t %s \n", p);
	
}