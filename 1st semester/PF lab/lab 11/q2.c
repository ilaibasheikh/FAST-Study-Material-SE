#include<stdio.h>
int main(){
	int n,i;
	printf("Enter number of elements");
	scanf("%d",&n);
	int arr[n];
	for(i=0;i<n;i++){
		printf("Enter element");
		scanf("%d",&arr[i]);
	}
	int *ptr;
	ptr = arr;
	int sum=0;
	for(i=0;i<n;i++){
		sum=sum+*(ptr+i);
	}
	printf("The sum of array %d",sum);
	
	
	
}
