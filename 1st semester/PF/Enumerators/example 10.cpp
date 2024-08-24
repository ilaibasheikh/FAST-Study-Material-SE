#include <stdio.h>
enum week
{
	sunday,monday,tuesday,wednesday,thursday,friday,saturday
};
int main()
{
	enum week today;
	today= wednesday;
	printf("Day = %d", today +1); // by default sunday is 0
}