#include <stdio.h>
int main()
{
	int a[6]={5,1,6,2,4,3};
	int i, current, walker;
	for(current=0;current<6;current++)
	{
		int smallest = current;
		printf("%d\n", a[smallest]);
		for (walker=current+1; walker<6;walker++)
		{
		if (a[walker]< a[smallest])
		smallest = walker;
	}
	int temp = a[current];
	a[current]=a[smallest];
	a[smallest] = temp;
	}
	for ( i = 0; i<6; i++)
	{
		printf("%d", a[i]);
	}
}