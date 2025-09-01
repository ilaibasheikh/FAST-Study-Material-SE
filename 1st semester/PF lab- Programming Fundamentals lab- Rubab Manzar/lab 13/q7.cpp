#include<stdio.h>
#include<stdlib.h>
#include<string.h>
int main(){
	FILE *ptr;
	char name[30]="";
	FILE *fptr;
	char c;
	int a,b;
	ptr=fopen("text4.txt","r");
	fptr=fopen("text5.txt","w");
	c=getc(ptr);
	while(c!=EOF){
		if(c!=' ' && c!='\n'){
			strncat(name,&c,1);
		}else{
			int f=0;
			char str[30]="";
			if(strlen(name)==3){
				for(a=0;a<strlen(name);a++){
					if(name[a]=='s'){
						f=1;
						strcpy(str,name);
						strcpy(str,"PF-Lab");
						break;
					}
				}
				
			}
			if(f==0){
			
			for(a=0;a<strlen(name);a++){
				if(name[a]=='A' || name[a]=='a' ||name[a]=='E' || name[a]=='e'||name[a]=='o' ||name[a]=='O' ||name[a]=='u' ||name[a]=='U' ||name[a]=='i' ||name[a]=='I' ){
					if(((a+1)%2)!=0){
						strcat(str,"vow");
					}else{
						strcat(str,"VOW");
					}
				}else{
					
					strncat(str,&name[a],1);
				}
			
				
			}
			
			}
			char move[30]="";
			char b;
			for(a=0;a<strlen(str);a++){
				b=str[a];
				if(b>=65 && b<=90){
					b=b+3;
					if(b>90){
						b=b-26;
					}
				}
				else{
					if(b>=97 && b<=122){
					b=b+3;
					if(b>122){
						b=b-26;
					}}
					
				}
				strncat(move,&b,1);
			
			}
			strcpy(str,move);
			
			if(c==' ')
			strcat(str," ");
			else
			strcat(str,"\n");
			fprintf(fptr,"%s",str);
			strcpy(name,"");
		}
		c=getc(ptr);
		
	}
	fclose(ptr);
	fclose(fptr);
	
	
	
	
}
