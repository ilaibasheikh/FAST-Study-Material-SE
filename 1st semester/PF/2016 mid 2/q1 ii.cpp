#include <stdio.h>
int isVowel(char ch);
int isConsonant(char ch);
int main()
{
	char a;
	printf("Enter a lowercase english letter");
	scanf("%c", a);
	int b;
	b = isVowel(a);
	printf("%d", b); 
	
}
int isVowel(char ch)
{
	int c;
	if (ch == 'a' ||ch == 'e' || ch == 'i'|| ch == 'o' || ch == 'u')
	{
		c =1;
	}
	else 
		c = 0;
	return c;
}