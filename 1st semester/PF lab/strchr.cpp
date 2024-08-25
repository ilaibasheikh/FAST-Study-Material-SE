#include <stdio.h>
#include <string.h>
int main()
{
char mystr[50] = "I am an example to use function strchr";
printf ("%s", strchr(mystr, 'e'));
return 0; }