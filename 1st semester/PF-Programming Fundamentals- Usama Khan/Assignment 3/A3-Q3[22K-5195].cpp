#include<string.h>
#include<stdio.h>

struct details{
		char StudentID[20];
		char Name[50];
		int Mid1;
		int Mid2;
		int Quiz;
		int Assignment;
		int Final;
		int Total;
		float GPA;
	};

void smartFind(struct details Students){
	printf("\n\nName: %s", Students.Name);
	printf("\nStudent ID: %s", Students.StudentID);
	printf("\nMid 1 marks: %d", Students.Mid1);
	printf("\nMid 2 marks: %d", Students.Mid2);
	printf("\nQuiz marks: %d", Students.Quiz);
	printf("\nFinal marks: %d", Students.Final);
	printf("\nTotal marks: %d", Students.Total);
	printf("\nGPA: %.1f", Students.GPA);
}

int accumalateEvaluations(int A, int B, int C, int D, int E){
	return(A+B+C+D+E);
}

float getGPA(int A, int B, int C, int D, int E){
	int T=accumalateEvaluations(A,B,C,D,E);
	if(T>=86){
		return (4.0);
	}
	else if(86>T && T>=82){
		return (3.6);
	}
	else if(82>T && T>=78){
		return (3.0);
	}
	else if(78>T && T>=74){
		return (2.6);
	}
	else if(74>T && T>=70){
		return (2.3);
	}
	else if(70>T && T>=66){
		return (2.0);
	}
	else if(66>T && T>=62){
		return (1.6);
	}
	else if(58>T && T>=50){
		return (1.0);
	}
	else {
		return (0);
	}
}

main(){
	int ID;
	printf("Enter student ID number only: ");
	scanf("%d", &ID);
	int i,j,N=10;
	
	int Mode;
	
	struct details Students[N];
	
	for(;;){
		printf("\n\n1. Input data\n2. Print data\n3. Finding a specific individual\n4. Printing Class Average\n5. Exit\n");
		printf("Enter mode: ");
		scanf("%d", &Mode);
		switch(Mode){
			case 1:{
				for(i=0;i<N;){
					if(i==7){
						printf("Enter your name: ");
						scanf("%s", &Students[i].Name);
						
						printf("Enter your Roll Number: ");
						scanf("%s", &Students[i].StudentID);
						
						printf("Enter your Mid 1 Marks out of 15: ");
						scanf("%d", &Students[i].Mid1);
						
						printf("Enter your Mid 2 Marks out of 15: ");
						scanf("%d", &Students[i].Mid2);
						
						printf("Enter your Quiz Marks out of 10: ");
						scanf("%d", &Students[i].Quiz);
						
						printf("Enter your Assignment Marks out of 10: ");
						scanf("%d", &Students[i].Assignment);
						
						printf("Enter your Final Marks out of 50: ");
						scanf("%d", &Students[i].Final);
						
						Students[i].Total=accumalateEvaluations(Students[i].Mid1, Students[i].Mid2, Students[i].Quiz, Students[i].Assignment, Students[i].Final);
						Students[i].GPA=getGPA(Students[i].Mid1, Students[i].Mid2, Students[i].Quiz, Students[i].Assignment, Students[i].Final);
						i++;
					}
					char TempID[20]={"\0"};
					printf("\nEnter Roll No. of student %d: ",i+1);
					scanf("%s",&TempID);
					for(j=0;j<N;j++){
						if(strcmp(TempID,Students[j].StudentID)==0){
							printf("Roll Number already exist. Enter new roll number.");
							break;
						}
						else{
							strcpy(Students[i].StudentID,TempID);
							
							printf("Student Name: ");
							scanf("%s", &Students[i].Name);
							
							printf("Mid 1 Marks out of 15: ");
							scanf("%d", &Students[i].Mid1);
							
							printf("Mid 2 Marks out of 15: ");
							scanf("%d", &Students[i].Mid2);
							
							printf("Quiz out of 10: ");
							scanf("%d", &Students[i].Quiz);
							
							printf("Assignment out of 10: ");
							scanf("%d", &Students[i].Assignment);
							
							printf("Final Marks out of 50: ");
							scanf("%d", &Students[i].Final);
							
							Students[i].Total=accumalateEvaluations(Students[i].Mid1, Students[i].Mid2, Students[i].Quiz, Students[i].Assignment, Students[i].Final);
							Students[i].GPA=getGPA(Students[i].Mid1, Students[i].Mid2, Students[i].Quiz, Students[i].Assignment, Students[i].Final);
							i++;
							break;
						}
					}
				}
				break;
			}
			case 2:{
				printf("\n");
				printf("\n\tStudent ID\tName\t\tGPA");
				for(i=0;i<N;i++){
					printf("\n\t%s\t%s\t", Students[i].StudentID, Students[i].Name);
					if(Students[i].GPA==0){
						printf("Fail");
					}
					else{
						printf("%.1f",Students[i].GPA);
					}
				}
				break;
			}
			case 3:{
				char Input[100];
				printf("\nEnter name or roll no. of person you want to find in correct format: ");
				scanf("%s", &Input);
				int Found=0;
				for(i=0;i<N;i++){
					if( strcmp(Students[i].Name, Input)==0 || strcmp(Students[i].StudentID, Input)==0 ){
						smartFind(Students[i]);
						Found=1;
					}
				}
				if(Found==0){
					printf("\nSorry, ID doesnot exist.");
				}
				break;
			}
			case 4:{
				int SumMid1=0, SumMid2=0, SumFinal=0, SumTotal=0;
				for(i=0;i<N;i++){
					SumMid1+=Students[i].Mid1;
					SumMid2+=Students[i].Mid2;
					SumFinal+=Students[i].Final;
					SumTotal+=Students[i].Total;
				}
				float avgMid1=SumMid1/N;
				float avgMid2=SumMid2/N;
				float avgFinal=SumFinal/N;
				float avgTotal=SumTotal;
				printf("\nAverage marks of all in Mid 1: %.2f",avgMid1);
				printf("\nAverage marks of all in Mid 2: %.2f",avgMid2);
				printf("\nAverage marks of all in Final: %.2f",avgFinal);
				printf("\nAverage total score of all: %.2f",avgTotal);
				
				int IMax;
				for(i=0;i<N;i++){
					if(Students[i].Total>Students[IMax].Total){
						IMax=i;
					}
				}
				printf("\n\nStudent ID %s has the maximum score of %d in the whole class.", Students[IMax].StudentID, Students[IMax].Total);
				
				printf("\n\nList of students who didn't pass the course:");
				for(i=0;i<N;i++){
					if(Students[i].GPA==0){
						printf("\n%s\t%s", Students[i].Name, Students[i].StudentID);
					}
				}
				break;
			}
			case 5:{
				printf("\n\nThank you for using!");
				return 0;
				break;
			}
		}
	}
}


