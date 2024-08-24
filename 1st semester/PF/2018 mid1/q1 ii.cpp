#include <stdio.h>
int main()
{
int k;
for(int j = 1; j <= 5; ++j)
{ k=0;
do
{
printf("#");
k++;
if(k==j-1)
{ printf("-"); }
}while(k<j);
printf("\n");
}
}