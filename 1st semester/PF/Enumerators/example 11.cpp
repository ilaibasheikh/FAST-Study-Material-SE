#include <stdio.h>
enum week
{
	sunday,monday,tuesday,wednesday,thursday,friday,saturday
};
int main()
{
	enum week day1, day2;
	 
	day1 = monday;
	day2 = thursday;
	
	int diff = day2 - day1;
	
	printf("Days between = %d\n", diff);
	
	if (day1<day2)
	{
		printf("Day 1 comes before day2");
	}
	

}