#include <stdio.h>
struct part
{
	int modelnumber;
	int partnumber;
	float cost;
};
int main()
{
	struct part p1;
	
	p1.modelnumber = 10;
	p1.partnumber=45;
	p1.cost =99;
	
	printf("Model number : %d \n",p1.modelnumber);
	printf("Part number : %d \n",p1.partnumber);
	printf("Cost: : %f \n",p1.cost );
}