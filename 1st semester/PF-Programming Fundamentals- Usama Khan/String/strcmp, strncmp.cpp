#include <stdio.h>
#include <string.h>
int main()
{
	char s1[20]="Happy New Year";
	char s2[20]="Happy New Year";
	char s3[20]="Happy Holidays";
	
	printf("s1 = %s\n", s1);
	printf("s2 = %s\n", s2);
	printf("s3 = %s\n", s3);
	
	printf("strcmp(s1,s2) = %d\n", strcmp(s1,s2));
	printf("strcmp(s1,s3) = %d\n", strcmp(s1,s3));
	printf("strcmp(s3,s1) = %d\n", strcmp(s3,s1));
	
	printf("strncmp(s1,s2,6) = %d\n", strncmp(s1,s2,6));
	printf("strncmp(s1,s3,7) = %d\n", strncmp(s1,s3,7));
	printf("strncmp(s3,s1,7) = %d\n", strncmp(s3,s1,7));
	
	
}