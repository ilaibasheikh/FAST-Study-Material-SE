#include <stdio.h>
enum seasons
{
	spring =1,summer,autumn,winter
};
int main()
{
	enum seasons s;
	s= summer;
	printf("Summer = %d", s);
}