#include <stdio.h>
enum color { red, green, blue
};
int main()
{
	enum color r = red;
	printf("%d - ", r);
	switch(r)
	{
		case red:
			printf("Red");
			break;
		case green:
			printf("green");
			break;
		case blue:
			printf("blue");
			break;
		default:
			printf("Poop");
	}
}