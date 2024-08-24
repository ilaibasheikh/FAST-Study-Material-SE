#include <stdio.h>
int main()
{
	int i;
	for(i=10;i>0; i--){
	if (i==5){
		continue;
	}
	printf("%d\n",i);
	}
	printf("liftoff");
}