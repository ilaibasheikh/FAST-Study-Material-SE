#include<stdio.h>
int main()
{
	int i,j;
	float array[5]={3.14,3.24,3.34,3.44,3.54};
	float temp;  
    for(i = 0; i<5; i++) {
   for(j = i+1; j<5; j++)
   {
      if(array[j] > array[i]) {
         temp = array[i];
         array[i] = array[j];
         array[j] = temp;
      }
   }
}
   for (i=0;i<5;i++)
   {
   	printf("%f\n",array[i]);
   }

}