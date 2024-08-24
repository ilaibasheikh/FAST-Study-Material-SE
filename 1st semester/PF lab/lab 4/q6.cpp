#include <stdio.h>
#include <math.h>

int main()
 {
	float x1, y1, x2, y2, gdistance, xmidpoint, ymidpoint ;
	printf("Input x1: ");
	scanf("%f", &x1);
	
	printf("Input y1: ");
	scanf("%f", &y1);
	
    printf("Input x2: ");
	scanf("%f", &x2);
	
	printf("Input y2: ");
	scanf("%f", &y2);
	
	gdistance = ((x2-x1)*(x2-x1))+((y2-y1)*(y2-y1));
	
	xmidpoint = ((x1 + x2)/2);
	
	ymidpoint = ((y1 + y2)/2);
	
	printf("Distance between the said points: %.4f", sqrt(gdistance));
	printf("\n");
	
	printf("the x coordinate of the midpoint is: %.1f\n and the y coordinate of midpoint is: %.1f", xmidpoint, ymidpoint);
	return 0;
}