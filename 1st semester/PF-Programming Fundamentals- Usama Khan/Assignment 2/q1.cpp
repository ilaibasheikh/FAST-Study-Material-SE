#include<stdio.h>
#include<math.h>
int main()
{
	int d,i,n;
	printf("Enter the last digit of your phone number ");
	scanf("%d",&d);
	if ( d > 0 && d < 4)
	{
		n= pow( 2 , d) * 2;
	}
	else if ( d==0)
	{
		n= pow( 2 , d) * 4 + 3;
	}
	int rx= 1 , ry=3 ;
	float x , y , m , ax , ay , bx , by , cx ,cy;

	printf("Enter the x component of ROBOT A location ");
	scanf("%f",&ax);
	printf("Enter the y component of ROBOT A location ");
	scanf("%f",&ay);
	m= ((ax-rx)*(ax-rx))+((ay-ry)*(ay-ry));
	printf("Distance between UAV AND ROBOT : %.2f", sqrt(m));
	printf("\n");

	printf("Enter the x component of ROBOT B location ");
	scanf("%f",&bx);
	printf("Enter the y component of ROBOT B location ");
	scanf("%f",&by);
	m= ((bx-rx)*(bx-rx))+((by-ry)*(by-ry));
	printf("Distance between UAV AND ROBOT : %.2f", sqrt(m));
	printf("\n");
	
	printf("Enter the x component of ROBOT C location ");
	scanf("%f",&cx);
	printf("Enter the y component of ROBOT C location ");
	scanf("%f",&cy);
	m= ((cx-rx)*(cx-rx))+((cy-ry)*(cy-ry));
	printf("Distance between UAV AND ROBOT : %.2f", sqrt(m));
	printf("\n");
	printf("LOCATION FOR OTHER OF ROBOTS \n");
	for ( i=0 ; i < n ; i++)
	{
		printf("Enter the x component of ROBOT's location ");
		scanf("%f",&x);
		printf("Enter the y component of ROBOT's location ");
		scanf("%f",&y);
		m= ((x-rx)*(x-rx))+((y-ry)*(y-ry));
		printf("Distance between UAV AND ROBOT : %.2f", sqrt(m));
		printf("\n");
	
	}
}