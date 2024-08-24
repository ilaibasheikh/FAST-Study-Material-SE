#include <stdio.h>
void printwithcomma(long num);
int main(){
	printf("Enter a number upto 6 digits");
	int num;
	scanf("%d", &num);
	
	printwithcomma(num);
	return 0;
}
void printwithcomma(long num){
	long thousand =num/1000;
	printf("%ld\n", thousand);
	long hundred = num%1000;
	printf("%ld\n", hundred);
	printf("The number you entered is\t");
	printf("%ld,%ld", thousand, hundred);
}