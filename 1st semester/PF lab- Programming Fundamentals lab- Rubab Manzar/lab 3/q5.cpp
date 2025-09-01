#include <stdio.h>
int main()
{
	float t, d1, d2, d3, d4, d5, speed;
	printf("the time should not be negative, and it should be between 1 to 5 hours\n");
	printf("whats the total time?");
	scanf("%f", &t);
	printf("distance should not be negative\n");
	printf("what the distance for first hour?");
	scanf("%f", &d1);
	printf("what the distance for second hour?");
	scanf("%f", &d2);
	printf("what the distance for third hour?");
	scanf("%f", &d3);
	printf("what the distance for fourth hour?");
	scanf("%f", &d4);
	printf("what the distance for fifth hour?");
	scanf("%f", &d5);
	
	speed=(d1=d2=d3=d4=d5)/t;
	
	printf("your average speed in miles per hour is: %f", speed);
}
