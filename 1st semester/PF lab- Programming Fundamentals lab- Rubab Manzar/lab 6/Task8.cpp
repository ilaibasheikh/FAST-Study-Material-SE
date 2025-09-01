#include <stdio.h>
main()
{
	float totalcalories, fatgrams, fatcalories, percentcalories;
	printf("total calories and fat grams can not be less than zero \n");
	printf("enter total calories");
	scanf("%f", &totalcalories);
	printf("enter fat grams");
	scanf("%f", &fatgrams);
	
	fatcalories = fatgrams * 9;
	percentcalories = fatcalories / totalcalories;
	
	if (percentcalories < 0.3)
		printf("food is low in fat");
	else 
		printf("food is okay in fat");
}