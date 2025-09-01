#include<stdio.h>
main()
{
int pepsi , dew , coke ;

printf("Enter price of pepsi");
scanf("%d",&pepsi);
printf("Enter value of dew");
scanf("%d",&dew);
printf("Enter value of coke");
scanf("%d",&coke);
if(pepsi>dew){
if(pepsi>coke){
printf("The highest price is of pepsi = %d",pepsi);
}
else{
printf("The highest price is of coke =%d", coke);
}
}
else{
if(dew>coke){
printf("The highest price is of dew = %d",dew);
}
else{
printf("The highest price is of coke= %d",coke);
}
}
}