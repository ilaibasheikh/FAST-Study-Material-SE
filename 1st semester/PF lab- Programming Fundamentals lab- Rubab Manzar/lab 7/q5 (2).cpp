#include <stdio.h>
#include <stdlib.h>
int main()
{
	int ans, fails, pass, correct;
	int randomnumber1, randomnumber2;
    randomnumber1 = rand() % 11;
    randomnumber2 = rand() % 11;
    printf("%d x %d = ", randomnumber1, randomnumber2);
	correct = randomnumber1 * randomnumber2;
	scanf("%d", &ans);
	fails = 0;
	pass = 0;
	while (ans != -1)
	{
	
	if (ans == correct)
	{
		printf("correct\n");
		pass = pass + 1;
	}
	else 
	{
		printf("Wrong!\n%d\n", correct);
		fails = fails + 1;
	}

		randomnumber1 = rand() % 11;
    	randomnumber2 = rand() % 11;
    	printf("%d x %d = ", randomnumber1, randomnumber2);
		correct = randomnumber1 * randomnumber2;
		scanf("%d", &ans);
}

	printf("fails = %d, Pass = %d", fails, pass);
	
	return 0;
}