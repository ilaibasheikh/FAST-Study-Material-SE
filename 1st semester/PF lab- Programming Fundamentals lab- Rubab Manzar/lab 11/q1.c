#include<stdio.h>
void swap(int *a,int *b, int *temp);
int main(){
	int n1,n2;
	int *temp = 0;
	printf("Enter n1");
	scanf("%d",&n1);
	printf("Enter n2");
	scanf("%d",&n2);
	printf("Before swapping n1=%d n2=%d\n",n1,n2);
	swap(&n1,&n2, &temp);
	printf("After swapping n1=%d n2=%d",n1,n2);
	
	
}
void swap(int *a,int *b, int *temp){
	*temp=*a;
	*a=*b;
	*b= *temp;
	
	
}
