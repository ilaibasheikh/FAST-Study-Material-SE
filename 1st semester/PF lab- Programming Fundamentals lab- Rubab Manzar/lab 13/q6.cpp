#include<stdio.h>
#include<string.h>
#include<stdlib.h>
struct student{
	int rollNo;
	char name[30];
	char dep[3]; 
	int batch;
	char sec;
    float cgpa;
};
void search(int num);
void display();
void search22();
int main(){
	int n,roll;
	struct student s1[3];
	FILE *ptr;
	ptr=fopen("record.txt","w");
	for(n=0;n<3;n++){
		printf("Enter roll no");
		scanf("%d",&s1[n].rollNo);
		printf("Enter name");
		scanf("%s",&s1[n].name);
		printf("Enter dep");
		scanf("%s",&s1[n].dep);
		printf("Enter batch");
		scanf("%d",&s1[n].batch);
		printf("Enter section");
		scanf(" %c",&s1[n].sec);
		printf("Enter cgpa");
		scanf(" %f",&s1[n].cgpa);	
		fwrite(&s1[n],sizeof(s1[n]),1,ptr);
	}	
	fclose(ptr);
	printf("Records of all students\n");
	display();
	printf("Enter roll number to view all details\n");
	scanf("%d",&roll);
	search(roll);
	printf("To veiw batch 22 students\n ");
	search22();
	
}
void search(int num){
	struct student s2;
	FILE *ptr;
	ptr=fopen("record.txt","r");
	while(fread(&s2,sizeof(s2),1,ptr)){
		if(s2.rollNo==num){
			printf("Roll number is %d\n",s2.rollNo);
			printf("Name is %s\n",s2.name);
			printf("Dep is %s\n",s2.dep);
			printf("Batch is %d\n",s2.batch);
			printf("Section is %c\n",s2.sec);
			printf("CGPA is %f\n",s2.cgpa);
		}
		
	}
	fclose(ptr);
}
void display(){
	struct student s2;
	FILE *ptr;
	ptr=fopen("record.txt","r");
	while(fread(&s2,sizeof(s2),1,ptr)){
			printf("Roll number is %d\n",s2.rollNo);
			printf("Name is %s\n",s2.name);
			printf("Dep is %s\n",s2.dep);
			printf("Batch is %d\n",s2.batch);
			printf("Section is %c\n",s2.sec);
			printf("CGPA is %f\n",s2.cgpa);	
	}
	fclose(ptr);	
}

void search22( ){
	struct student s2;
	FILE *ptr;
	ptr=fopen("record.txt","r");
	while(fread(&s2,sizeof(s2),1,ptr)){
		if(s2.batch==22){
			printf("Roll number is %d\n",s2.rollNo);
			printf("Name is %s\n",s2.name);
			printf("Dep is %s\n",s2.dep);
			printf("Batch is %d\n",s2.batch);
			printf("Section is %c\n",s2.sec);
			printf("CGPA is %f\n",s2.cgpa);
		}
		
	}
	fclose(ptr);
}







