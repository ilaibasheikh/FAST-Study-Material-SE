#include <stdio.h>
int main()
{
	int cnt;
	char ch;
	for (ch='A', cnt=1; ch<='L'&& cnt<=12; cnt++, ch++)
	{
		if (cnt<=4)
		{
			printf("%c\t", ch);
	}
	printf("\n");
		if(cnt>4 && cnt<=8)
			{
				printf("%c\t", ch);
			}
	printf("\n");
		if(cnt>8 && cnt<=12)
		{
			printf("%c\t", ch);	
		}
	}
	}