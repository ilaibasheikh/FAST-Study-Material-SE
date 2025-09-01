#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
int main()
{
FILE *in, *out ;
char c ;

in = fopen ("infile.txt", "r");
out = fopen ("outfile.txt", "w");

while ((c = getc (in)) != EOF)
{
	putc (toupper(c), out);
}
fclose (in);
fclose (out);
}