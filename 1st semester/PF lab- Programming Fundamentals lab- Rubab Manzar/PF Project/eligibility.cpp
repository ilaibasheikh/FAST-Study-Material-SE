#include <stdio.h>
#include <stdlib.h>

struct student
{
	char name[30];
	int id;
	struct course
	{
		char subject[20];
		int attn;
	};
	struct course data[5];
};
	
int main()
 {
 	struct student record[10];
 	int sid;
 	int a = 10 , b;
 	int i, d;
 	char course[20];
 	
    printf("The mimimum attendance for giving the examination is 80 percent. \n");
    printf("enter details to check eligibility:\n");
    printf("Enter id");
    scanf("%d", &sid);
    printf("Enter course name");
    scanf("%s",&course);
    
    for (i=0; i<10; i++)
    {
   	 printf("the total no. of classes held were 10 .\n");
   	 if(record[i].id==sid)
   	 {
   		for(d=0; d<5; d++)
   	 	{
   	 		printf("Your attedance for %s is %d", record[i].data[d].subject, record[i].data[d].attn);
   	 		if((b/a) * 100 < 80)
			{
       			printf("your attendance is less than 80%.\n");
			}
   	 		
		}
			
	 }
	}
}
    