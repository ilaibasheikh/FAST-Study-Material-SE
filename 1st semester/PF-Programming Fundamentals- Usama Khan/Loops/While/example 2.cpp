#include <stdio.h>
int main()
{
	int ival=10;
	while(ival>0)
	{
		printf("%d/2=%d\n", ival,ival/2);
		ival=ival/2;
	}
}