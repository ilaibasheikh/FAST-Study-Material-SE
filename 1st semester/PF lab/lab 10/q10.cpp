#include<stdio.h>
#include<string.h>
struct registers{
	int Cid;
	char Cname[30];
	
};
struct student{
	int id;
	char fname[30];
	char lname[30];
	char cell[20];
	char email[30];
	struct registers data;
};

int main(){
	int a;
	struct student record[5];
	for(a=0;a<4;a++){
		printf("Enter your id");
		scanf("%d",&record[a]);
		printf("Enter first name");
		scanf("%s",&record[a].fname);
		printf("Enter second name");
		scanf("%s",&record[a].lname);
		
		printf("Enter cell");
		scanf(" %s",&record[a].cell);
		printf("Enter email");
		scanf(" %s",&record[a].email);
		printf("Enter course id");
		scanf("%d",&record[a].data.Cid);
		printf("Enter course name");
		scanf(" %s",&record[a].data.Cname);
		
		
		
	}
	for(a=0;a<4;a++){
		printf("%d %s %s %s %s %d %s\n",record[a].id,record[a].fname,record[a].lname,record[a].cell,record[a].email,record[a].data.Cid,record[a].data.Cname);
	}
	}
	
	



