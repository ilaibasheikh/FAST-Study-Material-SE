#include <stdio.h>
int main()
{
	float weight, height, bmi;
	
	printf("input weight in kg = ");
	scanf("%f", &weight);
	
	printf("input height in metre = ");
	scanf("%f", &height);
	
	bmi = (weight/(height * height));
	
	printf("the bmi is = %f \n", bmi);
	
	if(bmi < 18.5)
	{
		printf("you are underweight");
	}
	
	if(18.5 < bmi < 24.9)
	{
		printf("you are normal");
	}
	
	if(25.0 < bmi < 29.9)
	{
		printf("you are overweight");
	}
	 
	 if(bmi > 30.0)
	 {
	 	printf("you are obese"); 
	 }
}