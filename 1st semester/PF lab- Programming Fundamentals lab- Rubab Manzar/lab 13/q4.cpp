#include<stdio.h>
#include<string.h>
#include<stdlib.h>
void reading();
void updating();
void deleting();
int main(){
	int n;
	int rec,quan,choice;
	float cost;
	char name[30];
	FILE *ptr;
	ptr=fopen("hardware.txt","w");
	for(n=0;n<5;n++){
		printf("Enter details");
		scanf("%d %s %d %f",&rec,name,&quan,&cost);
		fprintf(ptr,"%d %s %d %f\n",rec,name,quan,cost);
	}
	fclose(ptr);
	printf("Choose 1 for reading data 2 for deleting a record 3 for updating");
	scanf("%d",&choice);
	while (choice!=0){
	
	switch(choice){
		case 1:reading();
		       break;
		case 2:deleting();
		       break;
		case 3:updating();
		       break;
	}
	printf("Enter choice");
	scanf("%d",&choice);
	}
}
void reading(){
	int rec,quan,choice;
	float cost;
	char name[30];
	FILE *ptr;
	ptr=fopen("hardware.txt","r");
	if(ptr==NULL){
		printf("File not found\n");
		exit(1);
	}
	fscanf(ptr,"%d%s%d%f",&rec,name,&quan,&cost);
	while(!feof(ptr)){
		printf("%d\t%s\t%d\t%f\n",rec,name,quan,cost);
		fscanf(ptr,"%d%s%d%f",&rec,name,&quan,&cost);
	    }
	fclose(ptr);
}
void deleting(){
	int rec,quan,choice;
	float cost;
	char name[30];
	FILE *ptr;
	FILE *ftr;
	int record;
	ptr=fopen("hardware.txt","r");
	ftr=fopen("temp.txt","w");
	printf("Enter record you want to delete");
	scanf("%d",&record);
	fscanf(ptr,"%d%s%d%f",&rec,name,&quan,&cost);
	while(!feof(ptr)){
		if(rec!=record){
			fprintf(ftr,"%d %s %d %f\n",rec,name,quan,cost);
		}
		fscanf(ptr,"%d%s%d%f",&rec,name,&quan,&cost);	
	}
	fclose(ptr);
	fclose(ftr);
	remove("hardware.txt");	
	rename("temp.txt","hardware.txt");
}
void updating(){
	int rec,quan,choice;
	float cost;
	char name[30];
	FILE *ptr;
	FILE *ftr;
	int record;
	ptr=fopen("hardware.txt","r");
	ftr=fopen("temp.txt","w");
	printf("Enter record you want to update");
	scanf("%d",&record);
	fscanf(ptr,"%d %s %d %f",&rec,name,&quan,&cost);
	while(!feof(ptr)){
		
		if(rec==record){
			printf("Enter new details");
			scanf("%d %s %d %f",&rec,name,&quan,&cost);
			fprintf(ftr,"%d %s %d %f\n",rec,name,quan,cost);
		}else{
			fprintf(ftr,"%d %s %d %f\n",rec,name,quan,cost);
		}
		fscanf(ptr,"%d %s %d %f",&rec,name,&quan,&cost);	
	}
	fclose(ptr);
	fclose(ftr);
	remove("hardware.txt");	
	rename("temp.txt","hardware.txt");

}
	
	
	


	
	
	

