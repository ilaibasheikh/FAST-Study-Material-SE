#include <stdio.h>
#include <string.h>
int main()
{
char x[6] = "high";
char c; 
for (c=x[0];c<strlen(x);c++)
printf("%c\n", x[c]);

}