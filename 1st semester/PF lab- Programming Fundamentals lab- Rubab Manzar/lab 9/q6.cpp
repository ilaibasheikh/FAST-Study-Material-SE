#include<stdio.h>
#include<string.h>
#include<math.h>

float volumeCal(int h, int a)
{
	return (pow(a,2)) * ((1.0/3.0) * h);
}

float getData()
{
	int h, a;
	float V;
	
	printf("Enter the height: ");
	scanf("%d", &h);
	
	printf("Enter the base: ");
	scanf("%d", &a);
	
	V = volumeCal(h,a);
	return V;
}

int main ()
{
	printf("The volume of the pyramid is %.2f.", getData());
}