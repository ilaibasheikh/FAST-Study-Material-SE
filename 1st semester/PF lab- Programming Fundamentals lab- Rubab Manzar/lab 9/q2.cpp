#include <stdio.h>
#include <string.h>
int main()
{
	char name[180], c1[50], c2[50], c3[50];
	int freq[26], i, j, max, pos;
	max= -9999;
	printf("Enter your name");
	gets(name);
	printf("enter first course");
	gets(c1);
	printf("enter second course");
	gets(c2);
	printf("enter third course");
	gets(c3);
	strcat(name, c1);
	strcat(name, c2);
	strcat(name, c3);
	for (i=0; i<26; i++)
	{
		freq[i] = 0;
		if (name[i] > 64 && name[i]< 91)
		{
			freq[name[i] - 65]++;
		}
		else if(name[i] > 96 && name[i] <123)
		{
			freq[name[i] - 97]++;
		}
	}
	for (i=0;i<26;i++)
	{
		if (freq[i] > max)
		{
			max= freq[i];
			pos = i;
		}
	}
	printf("the most occuring character in your string is %c", pos+97);
}