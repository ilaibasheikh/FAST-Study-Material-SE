#include <stdio.h>
int main()
{
	int i;
	for(i=10;i>0; i--){
	printf("%d\n",i);
	if (i==3){
		printf("coutdown");
		break;
	}
	}
}