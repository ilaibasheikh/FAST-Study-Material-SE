#include<stdio.h>
#include<string.h>
int main(){
	char str[30];
	FILE *ptr;
	ptr=fopen("text1","w");
	fprintf(ptr,"Hello how are you\n");
	fprintf(ptr,"We are doing good\n");
	fclose(ptr);
	ptr=fopen("text2","w");
	fprintf(ptr,"Today is not good day\n");
	fprintf(ptr,"Today is good day\n");
	fprintf(ptr,"Today is  bad day\n");
	fclose(ptr);
	FILE *tr;
	FILE *ppt;
	ptr=fopen("text3","w");
	tr=fopen("text1","r");
	ppt=fopen("text2","r");
	fgets(str,30,tr);
	while(!(feof(tr))){
	    fputs(str ,ptr);
	    fgets(str,30,tr);
	}
	fgets(str,30,ppt);
	while(!feof(ppt)){
	    fputs(str,ptr);
	    fgets(str,30,ppt);
	}
	
	
	
	
	fclose(ppt);
	fclose(tr);
	fclose(ptr);
}
