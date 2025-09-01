#include<stdio.h>
#include<string.h>
struct employee {
	char name[40],email[50],adress[50],*desgs[20];
	char phone[40],cnic[20];
	int age,experience,deg;
	float sal;
}emp[150];
int count;
void display(){
	if (count==0){
		printf("Zero Employee Data.\n");
	}
	else{
	int i;
	for (i=0; i<=count-1;i++){
	printf("\nName:%s \nAdress: %s \nCnic: %s \nEmail: %s \nPhone number: %s \nAge: %d \nExpereince: %d\nSalary: %.2f\nDesignation: %s\n******************************",emp[i].name,emp[i].adress,emp[i].cnic,emp[i].email,emp[i].phone,emp[i].age,emp[i].experience,emp[i].sal,*emp[i].desgs);
	}
}
}

void attendance()
{
	float BHA=2, MT=8, LP=4,sala=0;
	int i, j, T, c=0, ontime=0, late=0, absenses=0;
	char A;
	float x;
	if (count==0){
			printf("Zero Employee Data.\n");
	}
	else{
	for (i=0 ; i<=count-1 ; i++)
	{
		for(j=1 ; j<=20 ; j++)
		{
		printf("\nPlease Enter The Attendance Of Day %d For Employee ('P' for present and 'A' for absent) %s: ", j, emp[i].name);
		scanf(" %c", &A);
		if(A=='P' || A=='p')
		{
			c++;
			printf("Please Enter The Time Of Arrival\n");
			printf("Press '1' If The Person Arrives Between 8:00 AM To 8:20 AM\nPress '2' If The Person Arrives At 9:00 AM\nPress '3' If The Person Arrives After 10:00 AM: ");
			scanf("%d", &T);
			switch(T)
			{
				case 1:
					ontime++;
					break;
				case 2:
					late++;
					sala = emp[i].sal - (emp[i].sal*(LP/100));
					break;
				case 3:
					absenses++;
					c--;
					break;
				default:
					printf("Please Enter A Valid Number\n");
			}
		}
		}
		printf("****Results For Person %s****\n", emp[i].name);
		if (c>=18 && c<=20)
		{
			printf("%s Is Present For %d Days\n", emp[i].name, c);
			printf("%s Was %d Times Ontime\n", emp[i].name, ontime);
			printf("%s Was %d Times Late\n", emp[i].name, late);
			printf("%s Was %d Time Absent Due To Coming After 10:00 AM\n", emp[i].name, absenses);
			printf("The Net Salary Of %s Is %.2f\n", emp[i].name, sala);
		}
		else if (c<18)
		{
			x = (emp[i].sal*(BHA/100));
			sala= emp[i].sal-x;
			printf("%s Is Present For %d Days\n", emp[i].name, c);
			printf("%s Got A Cut Of %.2f Percentage Of Salary Which Is %.2f\n",emp[i].name, BHA, x);
			printf("%s Was %d Times Ontime\n", emp[i].name, ontime);
			printf("%s Was %d Times Late\n", emp[i].name, late);
			printf("%s Was %d Time Absent Due To Coming After 10:00 AM\n", emp[i].name, absenses);
			printf("The Net Salary Of %s Is %.2f\n", emp[i].name, sala);
		}
	}
}
}
void input(){
	int i=0,k,j;
     do{
		int l=0,f=0;
		fflush(stdin);
		printf("\nEnter the Name Of Employee:\n");
		 gets(emp[i].name);
	    l=0;	
		printf("Enter The CNIC Of Employee:\n");
		gets(emp[i].cnic);
		if(strlen(emp[i].cnic)!=13)
		{
		printf("Invalid Input\n");
		l++;
		}
		if(i>0){
		for(k=0;k<i;k++){
			if(strcmp(emp[i].cnic,emp[k].cnic)==0){
				printf("The Cnic Is Already Registered.\n");
				l++;
				break;
			
			}	
		}}
		if(l!=0)
		{
			i=i-1;
		}
		if(l==0){
		fflush(stdin);
		printf("Enter The Adress Of Employee:\n");
		gets(emp[i].adress);
		fflush(stdin);
	    f=0;	
		printf("Enter The Phone Number Of Employee:\n");
		gets(emp[i].phone);
		if(strlen(emp[i].phone)!=11)
		{
		printf("Invalid Input\n");
		f++;
		}
		if(i>0){
		for(k=0;k<i;k++){
			if(strcmp(emp[i].phone,emp[k].phone)==0){
				printf("The Phone Number Is Already Registered.\n");
				f++;
	
				break;
			}	
			
		}}
		if(f!=0)
		{
			i=i-1;
		}
		if(f==0){
		fflush(stdin);
		printf("Enter The Email Of Employee:\n");
		gets(emp[i].email);
		printf("Enter The Age Of Employee:\n");
		scanf("%d",&emp[i].age);
		if(emp[i].age<0 || emp[i].age>=80){
			printf("Error.\n");
			i--;
		}
		else{
		printf("Enter The Experience:\n");
		scanf("%d",&emp[i].experience);
		if(emp[i].experience<0 || emp[i].experience==emp[i].age)
		{
		}
		else{
        if(emp[i].experience>=10 && emp[i].age>=45){
		
		printf("\nEnter Employee Designation:\n[1]CEO\n[2]Manager\n");
		scanf("%d",&emp[i].deg);
	switch(emp[i].deg)
	    {
		case 1:
			emp[i].sal=500000;
			*emp[i].desgs= ("CEO");
			break;
		case 2:
			emp[i].sal=300000;
			*emp[i].desgs= ("Manager");
			break;
	}
}
   else 
   {
   if((emp[i].experience>=6 && emp[i].experience<=9)&& (emp[i].age>=35 && emp[i].age<45)){
		
		printf("\nEnter Employee Designation:\n[1]Manager\n[2]Assitant Manager\n");
		scanf("%d",&emp[i].deg);
	switch(emp[i].deg)
	    {
		case 1:
			emp[i].sal=300000;
			*emp[i].desgs= ("Manager");
			break;
		case 2:
			emp[i].sal=150000;
			*emp[i].desgs= ("Assitant Manager");
			break;
	}
}
    else
	{
	  if((emp[i].experience>=3 && emp[i].experience<=6) && (emp[i].age>=25 && emp[i].age<35)){
		
		printf("\nEnter Employee Designation:\n[1]Assitant Manager\n[2]Team Member\n");
		scanf("%d",&emp[i].deg);
	switch(emp[i].deg)
	    {
		case 1:
			emp[i].sal=150000;
			*emp[i].desgs= ("Assitant Manager");
			break;
		case 2:
			emp[i].sal=95000;
			*emp[i].desgs= ("Team Member");
			break;
	}
}
		else
		{
		  if((emp[i].experience>=0 && emp[i].experience<=2) && (emp[i].age>=18 && emp[i].age<25) )
		{
		
		printf("\nEnter Employee Designation:\n[1]Team Member\n[2]Staff\n");
		scanf("%d",&emp[i].deg);
	switch(emp[i].deg)
	    {
		case 1:
			emp[i].sal=95000;
			*emp[i].desgs= ("Team Member");
			break;
		case 2:
			emp[i].sal=45000;
			*emp[i].desgs= ("Staff");
			break;
	}
}}}}}}}}
		
		printf("Press\n[1] To Exit\n[2] To Continue\n");
		scanf("%d",&j);
		switch(j)
		{
			case 1:
				j=1;
				break;
			case 2:
				j=2;
				break;
		}
		i++;
	}while(j!=1);
	count=count+i;	
}
void search_cnic()
{
	if (count==0)
	{
		printf("Zero Employee Data.\n");
	}
	else
	{
	int j=count;
	char c[20];
	fflush(stdin);
	printf("Enter The CNIC Of The Employee:\n");
	gets(c);
	for(j=count; j>=0;j--){
		if(strcmp(c,emp[j].cnic)==0){
			printf("\nName:%s \nAdress: %s \nCnic: %s \nEmail: %s \nPhone number: %s \nAge: %d \nExpereince: %d\nSalary: %.2f\nDesignation: %s\n******************************",emp[j].name,emp[j].adress,emp[j].cnic,emp[j].email,emp[j].phone,emp[j].age,emp[j].experience,emp[j].sal,*emp[j].desgs);
		}
	} 
   }
}
void search_Phone()
{
	if (count==0)
	{
		printf("Zero Employee Data.\n");
	}
	else
	{
	int j=count;
	char c[20];
	fflush(stdin);
	printf("Enter The Phone Number Of The Employee:\n");
	gets(c);
	for(j=count; j>=0;j--){
		if(strcmp(c,emp[j].phone)==0){
			printf("\nName:%s \nAdress: %s \nCnic: %s \nEmail: %s \nPhone number: %s \nAge: %d \nExpereince: %d\nSalary: %.2f\nDesignation: %s\n******************************",emp[j].name,emp[j].adress,emp[j].cnic,emp[j].email,emp[j].phone,emp[j].age,emp[j].experience,emp[j].sal,*emp[j].desgs);
		}
	} 
   }
}
void dltemploye(){
	int k=0,j;
	if (count==0)
	{
		printf("Zero Employee Data.\n");
	}
	else {
		char c[25],d[5]="-";
	fflush(stdin);
	printf("Enter The CNIC Of The Employee:\n");
	gets(c);
	for(j=count; j>-1;j--){
		if((strcmp(c,emp[j].cnic))==0){
			fflush(stdin);
			strcpy(emp[j].email,d);
			fflush(stdin);
			strcpy(emp[j].adress,d);
			fflush(stdin);
			emp[j].age=0;
			fflush(stdin);
			strcpy(emp[j].cnic,d);
			fflush(stdin);
			emp[j].deg =0;
			fflush(stdin);
			emp[j].experience=0;
			strcpy(emp[j].name,d);
			fflush(stdin);
			strcpy(emp[j].phone,d);
			fflush(stdin);
			emp[j].sal=0;
			printf("Record Deleted \n");
			k++;
			break;
		}
		
		}
		if(k==0){
			printf("No CNIC Is Saved As Input.\n");
	}	
	}
}
int main(){
	int ch;
	int e;
    do
   {
   	    printf("\n\n\n\t\t\t########## Welcome To Office Management System ##########\n\n");
        printf("\n\t\t\t[1]:Enter The Employee Information\n");
        printf("\t\t\t[2]:Display Employees Information\n");
        printf("\t\t\t[3]:Search Employee\n");
        printf("\t\t\t[4]:Attendance\n");
        printf("\t\t\t[5]:Delete The Record of An Employee\n");
        printf("\t\t\t[6]:Exit\n");
        printf("\nEnter The Choice:\n");
        scanf("%d",&ch);
        if(ch>7 ||ch<1){
        	printf("Invalid Entery.\n");
		}
		else{
        switch(ch)
       {
            case 1:
                input();
                break;
                case 2:
                    display();
                    break;
                    case 3:
                    	printf("Search Employee By\n[1]CNIC\n[2]Phone Number\n");
                        scanf("%d",&e);
                        switch (e){
                        	case 1:
                        		search_cnic();
                        		break;
                        		case 2:
                        			search_Phone();
                        			break;
                        		default:
                        			printf("Invalid Value.\n");
                        			break;
						}
                        break;
                            case 4:
                            	attendance();
                                break;
                                    case 5:
                                    	dltemploye();
                                        break;
                                        	
                                    }
                                }
                                }while(ch!=6);
}

