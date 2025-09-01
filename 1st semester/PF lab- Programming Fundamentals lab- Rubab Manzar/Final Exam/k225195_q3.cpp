#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct department{
	int depart_id;
	char depart_name[20];
};

struct employee{
	int emp_id;
	char emp_name[20];
	float salary;
	int age;
	struct department d;
	
} *ptr ;

void Del();
void Modify();

int main()
{
	printf("My student id is 22k-5195\n");
	FILE *fp;
	fp = fopen("Employee.txt", "w+");
	
	if (fp== NULL)
	{
		printf("Error! File can not be opened");
	}
	
	fprintf(fp, "S.no\tEmp.No\t\tEmp_name\tSalary\tAge\tDepart_id\tDepart_name\n");
	
		int i;
	for ( i = 1; i<=5;i++)
	{
		fprintf(fp,  " %d \t ", i);
		printf("Enter employee id:\n");
		scanf("%d", ptr->emp_id);
		//fprintf(fp, "%d", ptr->emp_id);
		//	printf("Enter employee name:\n");
		//scanf("%s", ptr->emp_name);
	}
	
	fclose(fp);

	
	char ch;
	do{
		printf("\nSelect from the following task menu:b) Delete a record \nc) Modify an existing record \nf) End \n");
		fflush(stdin);
		scanf("%c", &ch);
		switch(ch){
			case 'a':
				Del();
				break;
			case 'b':
				Modify();
				break;
			case 'f':		
				break;
			default:
				printf("Invalid input");	
		printf("\n\n======================================================\n");
		}
	}while(ch!='f');
	
	fclose(fp);
}
void Delete(){
	
	int find;
	printf("Enter the id of employee you want to delete: ");
	scanf("%d", &find);
	
	FILE *fp= fopen("employee.txt", "r");
	FILE *fp2= fopen("temp.txt", "w");
	if(fp1==NULL || fp2==NULL){
		printf("Error");
		exit;
	}
	
void Modify(){
	struct employee p , add;
	char find[20];
	
	printf("Enter the id of employee you want to modify: ");
	scanf("%d", &emp_id);
	printf("Modification:\n");
	printf("Enter employee name: ");
	scanf("%s",);
	printf("Enter employee salary: ");
	scanf("%d", );

	
	FILE *fp1= fopen("employee.txt", "r");
	FILE *fp2= fopen("temp.txt", "w");
	if(fp1==NULL || fp2==NULL){
		printf("Error");
		exit;
	}
	

}
	

}