#include <stdlib.h>
#include <stdio.h>
int main()
{
	printf("Enter random number seed");
	int seed;
	scanf("%d", &seed);
	srand(seed);
	printf("Random number with seed %d : %d, %d", seed, rand(), rand());
	
}