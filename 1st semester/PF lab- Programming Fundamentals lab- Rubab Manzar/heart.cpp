#include<stdio.h>
#include<conio.h>
#include<math.h>
int main()
{
int a, b, c;
printf("Enter size (<20): \n");
scanf("%d",&c);
for (a=0; a<c; a++)
{
for (b=0; b<=4*c; b++)
{
int d = sqrt( pow(a-c,2) + pow(b-c,2) );
int e = sqrt( pow(a-c,2) + pow(b-3*c,2) );
if (d < c + 0.5 || e < c +0.5 )
printf("*");
else
printf(" ");
}
printf("\n");
}
for (a = 1; a <= 2*c; a++)
{
for (b=0; b<a; b++)
printf(" ");
for (b=0; b<4*c + 1 - 2*a; b++)
printf("*");
printf("\n");
}
return 0;
}