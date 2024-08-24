#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<ctype.h>

int main(){
	int count=0;
	int arr[26]={0},n;
	char c;
	FILE *ptr;
	ptr=fopen("text.txt","r");
	if(ptr==NULL){
		printf("File counld not be oprned");
	}
	c=getc(ptr);
	
	while(c!=EOF){
		c=toupper(c);
		printf("%c ",c);
		if(c>=65 && c<=91){
			arr[c-65]++;
			count++;
		}
		c=getc(ptr);
	}
	fclose(ptr);
	ptr=fopen("text1","w");
	for(n=0;n<26;n++){
		fprintf(ptr,"Occurence of %c/%c is %d\n",65+n,65+n+32,arr[n]);
	}
	fprintf(ptr,"Total characters read %d",count);
	fclose(ptr);
	
	
	
	
}
