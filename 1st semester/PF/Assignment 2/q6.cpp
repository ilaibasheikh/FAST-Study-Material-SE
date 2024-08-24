#include<stdio.h>
int main(){
	int a,i,j;
	char c;
	printf("Who do you want drone to communicate with (m,s): ");
	scanf(" %c",&c);
	printf("Enter iterations: ");
	scanf("%d",&a);
	if(c=='m'){
		for(i=0;i<a;i++){
			printf("\n**");
		for(j=0;j<6;j++){
			printf("Mobile is in the city zone\n");
		}
		printf("**");
	}
	}
	else if(c=='s'){
		for(i=0;i<a;i++){
			printf("\n***");
		for(j=0;j<6;j++){
			printf("Move straight\n");
		}
		printf("***");
	}
	}
}