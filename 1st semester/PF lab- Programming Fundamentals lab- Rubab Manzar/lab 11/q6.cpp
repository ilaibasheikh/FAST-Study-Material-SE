#include<stdio.h>
#include<string.h>
void SentenceCase(char *Text, int size);
int main(){
	char string[50];
	printf("Enter string");
	gets(string);
	
	SentenceCase(string,strlen(string));
	
	printf("%s",string);	
}
void SentenceCase(char *Text, int size){
	if(*(Text)>='a' && *(Text)<='z')
	*(Text)=*(Text)-32;
    *(Text+size)='.';
    
    
	
}
