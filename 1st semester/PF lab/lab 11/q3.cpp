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
	int max=0;
	int *ptr;
	ptr = arr;
	for(i=0;i<n;i++){
		if(*(ptr+i)>max){
			max=*(ptr+i);
		}
		
	}
	int smax=0;
	for(i=0;i<n;i++){
		if(*(ptr+i)>smax && *(ptr+i)<max ){
			smax=*(ptr+i);
		}
	}
	for(i=0;i<n;i++){
		printf("Element[%d]=%d\n",i,arr[i]);
	}
	printf("Second highest element is %d",smax);
	
	
	
	
	
}
