#include <stdio.h>

int main () {
	FILE *fptr;
	float price;
	
	fptr = fopen("price.txt", "w+");
	
	if (fptr==NULL) {
		printf("File not opened\n");
	}
	
	else {
		printf("Enter price : ");
		scanf("%f", &price);
		while (price != -1){
			
			if (price >= 100 && price <=200) {
				fprintf(fptr, "%f\n", price);
			}
			printf("Enter price : ");
			scanf("%f", &price);
		}
	}
	
	fclose(fptr);
	
}