#include <stdio.h>
#include <ctype.h>
void convertToUppercase(char *sptr);
int main()
{
	char string[] = "chaRaCtErS and $324";
	
	printf("String before conversion is %s\n", string);
	convertToUppercase(string);
	printf("String after conversion is %s", string);
}

void convertToUppercase(char *sptr)
{
	while (*sptr != '\0')
	{
		*sptr = toupper(*sptr);
		++sptr;
	}
}