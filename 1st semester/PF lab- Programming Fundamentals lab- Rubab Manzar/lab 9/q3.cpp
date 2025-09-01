#include <stdio.h>
#include <string.h>
int main()
{
	char s1[100], s2 [100];
	puts("Enter first string.");
	gets(s1);
	puts("Enter second string."); 
	gets(s2);
	if (strcmp(s1, s2) == 0)
	{ puts("Both strings are equal.");

} 
	else if (strcmp(s1, s2) < 0) 
	{	
	puts("Second is string is greater.");

} 
else {
 puts("First is string is greater."); }
}
