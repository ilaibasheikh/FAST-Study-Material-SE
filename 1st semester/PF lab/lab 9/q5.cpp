#include <stdio.h> 
#include <math.h>
void CountFrequency (int size, int arr[]) 
{
 	int i, j, occ, curr;
	for (i=0; i<size; i++) 
	{
	occ = 0;
	curr= arr[i]; 
	for (j=0; j<size; j++)
	{ 
	if (curr == arr[j])
{
	occ++;
	if (i != j)
{
 arr[j] = -1;
}

}
}

 if (arr[i] != -1) 
 {  printf("%d occured %d times.\n ", curr, occ);
}
 arr[i]= -1;

}

}

int main () {

int size, i, j, curr, occ; 
printf("Enter the number of elements to be stored in the array: "); 
scanf("%d", &size); 
if (size > 0) {

int array1[size];
 for (i=0; i<size; i++) 
 { array1[i]= (rand() % 9) + 1;

} 
CountFrequency(size, array1);
}

}