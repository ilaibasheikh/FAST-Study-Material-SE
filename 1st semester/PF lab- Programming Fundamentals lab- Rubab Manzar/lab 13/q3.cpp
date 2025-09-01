#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<ctype.h>

int main(){
	int n;
	int id,age,q1,q2,mid,fin,choice,total=0;
	char name[30],gen;
	FILE *ptr;
	ptr=fopen("record.txt","w");
	for(n=0;n<2;n++){
		printf("Enter details");
	    scanf("%d %s %d %c %d %d %d %d",&id,name,&age,&gen,&q1,&q2,&mid,&fin);
	    fprintf(ptr,"%d %s %d %c %d %d %d %d\n",id,name,age,gen,q1,q2,mid,fin);
	}
	fclose(ptr);
	ptr=fopen("record.txt","r");
	do{ total=0;
		fscanf(ptr,"%d %s %d %c %d %d %d %d",&id,name,&age,&gen,&q1,&q2,&mid,&fin);
		total=q1+q2+mid+fin;
		if(total<50){
			printf("%s score is less than 50\n",name);
		}
		else if(total<80){
			printf("%s score is less than 80\n",name);
		}
		else if(total<100){
			printf("%s score is less than 100\n",name);
		}
		printf("Continue\n");
		scanf(" %c",&choice);
		
	}while(choice!='e' && !(feof(ptr)));
	
	fclose(ptr);
	
	
}
