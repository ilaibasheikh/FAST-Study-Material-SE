#include <stdio.h>
void printcharacters(const char *sptr);
int main()
{
	char string[] = "print characters of a string";
	
	printf("The string is :");
	printcharacters(string);

}
void printcharacters(const char *sptr)
{
	for (;*sptr!= '\0';++sptr)
	{
		printf("%c", *sptr);
	}
}