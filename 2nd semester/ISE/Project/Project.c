#include<stdio.h>
#include<string.h>
#include<math.h>
#include<time.h>
#include<stdlib.h>
//Declaration of student structure to store details, and mark attendance
struct student{
	char name[30];
	int id;
	struct course{
		char subject[20];
		int attn;
	};
	struct course data[5];
};

//Function to check the login details of students, the program will only proceed when correct ID and password is entered
int studentlogindetails(){
	int id, pw, fid, fpw, found, var;
	printf("Login Details \n");
	printf("Enter login ID: ");
	scanf("%d",&id);
	printf("\nEnter password: ");
	scanf("%d",&pw);
	FILE *ptr;
	ptr=fopen("studentlogin.txt", "r");
	//Checking the entered ID and password with the FILE already stored with the data
	if (ptr==NULL){
		printf("File could not be opened\n");
      }
   else{
		fscanf(ptr,"%d %d",&fid,&fpw);
		found=0;
		while(!feof(ptr)){
			//Comparing the entered ID with the stored ID in the file
			if(id==fid){
				found=1;
				if(pw==fpw){
					//Comparing the entered password with the stored password
					printf("\nValid ID and password");
					var=1;
					//Checking variable (var) updated to 1, as both conditions have been met
				}
				else{
					printf("\nIncorrect password entered");
					var=0;
					//Checking variable remains 0, as entered password is incorrect
				}
			}
		fscanf(ptr, "%d %d", &fid, &fpw);
		}
		if(found==0){
			if(id==fid){
				found=1;
				if(pw==fpw){
					printf("\nValid ID and password");
					var=1;
				}
				else{
					printf("\nInvalid ID or password");
					var=0;
				}
			}
			else{
				printf("\nInvalid ID or password");
				var=0;
			}
		}
	}
	fclose(ptr);
	return var;
	}
	
//Function to mark the attendances of the students	
void markattendance(struct student record[]){
	int d,uid,s;
	char cn[10];
	char ans;
	printf("\nEnter your id ");
	scanf("%d",&uid);
	//Loop to check the ID entered with all 10 students
	for(d=0;d<10;d++){
		if(record[d].id==uid){
			printf("\nEnter the course name to mark attendance for: \n Physics, Calculus, ICT, Programming, English: ");
			scanf(" %s",&cn);
			//Loop to check the subject name entered with all 5 subjects
			for(s=0;s<5;s++){
				if(strcmp(record[d].data[s].subject,cn)==0){
					record[d].data[s].attn++;
					printf("\nYour attendance has been marked successfully!");
					break;
					}
				}
				
			}
		}	
	}
	
//Function to view any student's attendance
void viewattendance(struct student record[]){
	int d, s;
	//Loop to print the attendances 
	for(d=0;d<10;d++){
		for(s=0;s<5;s++){
			printf("Id: %d ",record[d].id);
			printf("%s attendance: ",record[d].data[s].subject);
			printf("%d\n",record[d].data[s].attn);
		}	
	}	
}

//Main body begins here
int main(){

	int a, b, sid;
	float pay;
	char ans;
	struct student record[10];
	
	//Storing the data in the structure Student
	//Initialising the names, IDs, and attendance of each subject
	strcpy(record[0].name,"Amna");
	record[0].id=2000;
	strcpy(record[0].data[0].subject,"Physics");
	record[0].data[0].attn=0;
	strcpy(record[0].data[1].subject,"Calculus");
	record[0].data[1].attn=0;
	strcpy(record[0].data[2].subject,"Programming");
	record[0].data[2].attn=0;
	strcpy(record[0].data[3].subject,"English");
	record[0].data[3].attn=0;
	strcpy(record[0].data[4].subject,"ICT");
	record[0].data[4].attn=0;
	strcpy(record[1].name,"Bharti");
	record[1].id=2001;
	strcpy(record[1].data[0].subject,"Physics");
	record[1].data[0].attn=0;
	strcpy(record[1].data[1].subject,"Calculus");
	record[1].data[1].attn=0;
	strcpy(record[1].data[2].subject,"Programming");
	record[1].data[2].attn=0;
	strcpy(record[1].data[3].subject,"English");
	record[1].data[3].attn=0;
	strcpy(record[1].data[4].subject,"ICT");
	record[1].data[4].attn=0;
	strcpy(record[2].name,"Maham");
	record[2].id=2002;
	strcpy(record[2].data[0].subject,"Physics");
	record[2].data[0].attn=0;
	strcpy(record[2].data[1].subject,"Calculus");
	record[2].data[1].attn=0;
	strcpy(record[2].data[2].subject,"Programming");
	record[2].data[2].attn=0;
	strcpy(record[2].data[3].subject,"English");
	record[2].data[3].attn=0;
	strcpy(record[2].data[4].subject,"ICT");
	record[2].data[4].attn=0;
	strcpy(record[3].name,"Amal");
	record[3].id=2003;
	strcpy(record[3].data[0].subject,"Physics");
	record[3].data[0].attn=0;
	strcpy(record[3].data[1].subject,"Calculus");
	record[3].data[1].attn=0;
	strcpy(record[3].data[2].subject,"Programming");
	record[3].data[2].attn=0;
	strcpy(record[3].data[3].subject,"English");
	record[3].data[3].attn=0;
	strcpy(record[3].data[4].subject,"ICT");
	record[3].data[4].attn=0;
	strcpy(record[4].name,"Fatima");
	record[4].id=2004;
	strcpy(record[4].data[0].subject,"Physics");
	record[4].data[0].attn=0;
	strcpy(record[4].data[1].subject,"Calculus");
	record[4].data[1].attn=0;
	strcpy(record[4].data[2].subject,"Programming");
	record[4].data[2].attn=0;
	strcpy(record[4].data[3].subject,"English");
	record[4].data[3].attn=0;
	strcpy(record[4].data[4].subject,"ICT");
	record[4].data[4].attn=0;
	strcpy(record[5].name,"Alizah");
	record[5].id=2005;
	strcpy(record[5].data[0].subject,"Physics");
	record[5].data[0].attn=0;
	strcpy(record[5].data[1].subject,"Calculus");
	record[5].data[1].attn=0;
	strcpy(record[5].data[2].subject,"Programming");
	record[5].data[2].attn=0;
	strcpy(record[5].data[3].subject,"English");
	record[5].data[3].attn=0;
	strcpy(record[5].data[4].subject,"ICT");
	record[5].data[4].attn=0;
	strcpy(record[6].name,"Faiza");
	record[6].id=2006;
	strcpy(record[6].data[0].subject,"Physics");
	record[6].data[0].attn=0;
	strcpy(record[6].data[1].subject,"Calculus");
	record[6].data[1].attn=0;
	strcpy(record[6].data[2].subject,"Programming");
	record[6].data[2].attn=0;
	strcpy(record[6].data[3].subject,"English");
	record[6].data[3].attn=0;
	strcpy(record[6].data[4].subject,"ICT");
	record[6].data[4].attn=0;
	strcpy(record[7].name,"Hafsah");
	record[7].id=2007;
	strcpy(record[7].data[0].subject,"Physics");
	record[7].data[0].attn=0;
	strcpy(record[7].data[1].subject,"Calculus");
	record[7].data[1].attn=0;
	strcpy(record[7].data[2].subject,"Programming");
	record[7].data[2].attn=0;
	strcpy(record[7].data[3].subject,"English");
	record[7].data[3].attn=0;
	strcpy(record[7].data[4].subject,"ICT");
	record[7].data[4].attn=0;
	strcpy(record[8].name,"Hafsa");
	record[8].id=2008;
	strcpy(record[8].data[0].subject,"Physics");
	record[8].data[0].attn=0;
	strcpy(record[8].data[1].subject,"Calculus");
	record[8].data[1].attn=0;
	strcpy(record[8].data[2].subject,"Programming");
	record[8].data[2].attn=0;
	strcpy(record[8].data[3].subject,"English");
	record[8].data[3].attn=0;
	strcpy(record[8].data[4].subject,"ICT");
	record[8].data[4].attn=0;
	strcpy(record[9].name,"Sabina");
	record[9].id=2009;
	strcpy(record[9].data[0].subject,"Physics");
	record[9].data[0].attn=0;
	strcpy(record[9].data[1].subject,"Calculus");
	record[9].data[1].attn=0;
	strcpy(record[9].data[2].subject,"Programming");
	record[9].data[2].attn=0;
	strcpy(record[9].data[3].subject,"English");
	record[9].data[3].attn=0;
	strcpy(record[9].data[4].subject,"ICT");
	record[9].data[4].attn=0;
	
	int count1, count2, choice, code, id, hours, check;
	char subject[40];
	char day[20], category;
	//initialsing the arrays
	
	struct student data[10];
	int teacher[5][2]={100,0,101,0,102,0,103,0,104,0};
	
	//Function to display the current date and time
	time_t t;
	time(&t);
	printf("The day and time is: %s",ctime(&t));
	printf("\nAttendance Management System\n");
	printf("-------------------------------");
	
	do{
	printf("\nEnter s for student, and t for teaching faculty: \n");
	scanf(" %c",&category);
	
	//Main switch - divided into teachers and students
	switch(category){
			case 's':
				//Function to check the login details for students
				check=studentlogindetails();
				if(check!=0){
					
				
					printf("Menu: \n 1: Mark Attendance \n 2: View Attendance \n 3: Exam eligibility \n");
					scanf("%d",&choice);
					//Nested switch for different options in the student category
					switch(choice){
						case 1:
							//Calling the mark attendance function
							markattendance(record);
							break;
							
						case 2:
							//calling the view attendance functio
							viewattendance(record);
							break;
							
						case 3:
							//Code or checking the exam eligibility of a student
 							a = 10;
						 	int i, d;
						 	char course[20];
						    printf("The mimimum attendance for giving the examination is 80 percent. \n");
						    printf("enter details to check eligibility:\n");
						    printf("Enter id");
						    scanf("%d", &sid);
						    printf("Enter course name");
						    scanf("%s",&course);
						    printf("the total no. of classes held were 10 .\n");
						    for (i=0; i<10; i++){
						   	 	if(record[i].id==sid){
						   			for(d=0; d<5; d++){
						   	 			if(strcmp(record[i].data[d].subject,course)==0){	
						   	 				printf("Your attendance for %s is %d", record[i].data[d].subject, record[i].data[d].attn);
						   	 				b=record[i].data[d].attn;
						   	 				if((b/a) * 100 < 80){
						       					printf("your attendance is less than 80%.\n");
						       				}
										else{
											printf("\nAttendance is more than 80%. You are eligible to sit in the exam");
											}
										break;	
										}
									}
								 }
							}
						break;
						
					default:
						printf("\nIncorrect option entered!");
						break;
					}
				break;
				
				//Student category ends here
				
			case 't':
				printf("Enter your faculty code: \n");
				scanf("%d",&code);
				if(code!=100 && code!=101 && code!=102 && code!=103 && code!=104){
					printf("\nInvalid code entered");
				}else{
				
				printf("\nMenu: \n 1: Mark Attendance \n 2: View Work Hours \n 3: View Attendance \n 4: Generate Pay \n");
				scanf(" %d",&choice);
				//Nested switch for different options in the teacher category
				switch(choice){
					case 1:
						for(count1=0;count1<5;count1++){
							if(code==teacher[count1][0]){
								teacher[count1][1]++;
								printf("Your attendance has been marked successfully. \n");
								
								break;
							}
						}
						break;
						
					case 2:
							for(count1=0;count1<5;count1++){
							if(code==teacher[count1][0]){
								printf("Your hours are %d\n",teacher[count1][1]);
								break;
							}
						}
						break;
					
					case 3:
						
							for(count1=0;count1<5;count1++){
							if(code==teacher[count1][0]){
								printf("Your attendance is  %d\n",teacher[count1][1]);
								break;
							}
						  }
						  break;
						
						
					case 4:
						for(count1=0;count1<5;count1++){
							if(code==teacher[count1][0]){
								pay=teacher[count1][1]*5000;
								printf("\nThe pay is: %.2f Rupees.",pay);
								break;
							}
						}
						break;
						
					default:
						printf("You have entered a wrong input. Please try again! \n");
						break;
					}
				break;
				}}}
				
			//Option to continue, or end the program
			printf("\nEnter y for yes to continue, and any other key to exit:");
			scanf(" %c",&ans);
			if(ans!='y'){
				printf("\nProgram has been exited. Thankyou! ");
				}
			else{
					system("CLS");
			}
			}
		while(ans=='y');
 return 0;
}
