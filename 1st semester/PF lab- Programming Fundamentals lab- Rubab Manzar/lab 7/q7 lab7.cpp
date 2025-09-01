#include <stdio.h>
int main()
{
	int qs, difficult, moderate, easy, total, count, choice;
	difficult = 0;
	moderate= 0;
	easy = 0;
	total = 0;
	qs= 10;
	for (count = 0; count <= qs; count++)
	{
		printf("enter your choice [1-3]: ");
		scanf("%d" ,&choice);
		switch (choice)
		{
			case 1:
				difficult = difficult + 3;
				total= total + difficult;
				break;
			case 2:
				moderate = moderate +1;
				total = total + moderate;
				break;
			case 3:
				easy = easy +3;
				total = total + easy;
				break;
			default:
				printf("error: wrong number \n");
		}
	}
	printf("student got %d marks", total);
	
	
}