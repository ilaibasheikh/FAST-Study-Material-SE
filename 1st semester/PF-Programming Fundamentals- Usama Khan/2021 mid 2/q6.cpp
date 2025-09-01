#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<time.h>
#include<windows.h>
int main(){
int i=0,j=0,k=0;	
	int hr=0,min=0,sec=0;
	
	printf("\n\tEnter Hour needle:\t");
	scanf("%d",&hr);
	
	printf("\n\tEnter MIN needle:\t");
	scanf("%d",&min);
	
	printf("\n\tEnter Sec needle:\t");
	scanf("%d",&sec);
	
	min=min*5;
	sec=sec*5;
	
	if ( min==60 )
	{
		min=00;
	}
	if ( sec == 60 )
	{
		sec=00;
	}
	if ( hr == 12)
	{
		hr=00;
	}
	Sleep(1);
	for(i=0;i<12;i++)
	{
		for (j=0;j<60;j++)
		{
			for (k=0;k<60;k++)
			{
				//printf("\n*********************\n");
				if((i==hr&&j==min)&&(k==sec))
				{
				//	printf("\n###################\n");
					printf("\n\n\t\t\t %d : %d : %d ",i,j,k);
				}
				
			}
		}
	}
	
	
}
