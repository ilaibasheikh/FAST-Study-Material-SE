#include<stdio.h>
main()
{

int n,a,b,c,d;	
	
	printf("Enter number \n");
	scanf("%d",&n);
	
	a=n%10;
	b=n/10;
	c=a*2;
	d=b-c;
	if((d==7)||(d==0)||(d==-7))
	{
		
		printf("divisible by 7");
		
	}
	
	else if((d!=7)||(d!=0)||(d!=-7)){
		
	a=d%10;
	b=d/10;
	c=a*2;
	d=b-c;
	
	if((d==7)||(d==0)||(d==-7))
	{
		
		printf("divisible by 7");
		
	}
	
	else if((d!=7)||(d!=0)||(d!=-7)){
		
	a=d%10;
	b=d/10;
	c=a*2;
	d=b-c;
	
		
	}
	
	if((d==7)||(d==0)||(d==-7))
	{
		
		printf("divisible by 7");
		
	}
	
	else if((d!=7)||(d!=0)||(d!=-7)){
		
	a=d%10;
	b=d/10;
	c=a*2;
	d=b-c;
	
		
	}	
	
	if((d==7)||(d==0)||(d==-7))
	{
		
		printf("divisible by 7");
		
	}
	
	else if((d!=7)||(d!=0)||(d!=-7)){
		
	printf("Not divisible by 7");
	
		
	}
	
}
} 