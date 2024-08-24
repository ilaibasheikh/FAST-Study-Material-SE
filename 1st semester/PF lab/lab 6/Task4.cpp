#include <stdio.h>
main()
{
	int pepsi , dew , coke, ans;

printf("Enter price of pepsi");
scanf("%d",&pepsi);
printf("Enter value of dew");
scanf("%d",&dew);
printf("Enter value of coke");
scanf("%d",&coke);

ans = ((pepsi < dew && pepsi < coke ) ? printf("The lowest price is of pepsi = %d",pepsi) : ( (dew < coke && dew < pepsi) ? printf("The highest price is of dew = %d",dew) :  printf("The highest price is of coke= %d",coke ) ) );
	
}