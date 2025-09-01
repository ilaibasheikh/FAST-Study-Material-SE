#include<stdio.h>
#include<string.h>
#include<stdlib.h>
int main(){
	int n,a,n1;
	printf("Enter size of string");
	scanf("%d",&n);
	
	char *ptr;
	ptr=(char*)malloc(n*sizeof(char));
	for(a=0;a<n;a++){
		printf("Enter element[%d]",a);
		scanf(" %c",ptr+a);	
		
	}
	
	for(a=0;a<n;a++){
		printf("%c",*(ptr+a));
	}
	printf("\n");
	printf("Enter how many more space is required");
	scanf("%d",&n1);
	ptr=(char*)realloc(ptr,n1*sizeof(char));
	for(a=0;a<n1+n;a++){
		printf("Enter element[%d]",a);
		scanf(" %c",ptr+a);	
		
	}
	for(a=0;a<n1+n;a++){
		printf("%c",*(ptr+a));
	}

}
