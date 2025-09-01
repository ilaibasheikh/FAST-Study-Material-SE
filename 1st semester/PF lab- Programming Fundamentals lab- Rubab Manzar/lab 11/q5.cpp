#include<stdio.h>
void SortFunction(int *arr, int size, int order);
int main(){
	int n,i,ord;
	printf("Enter size of array");
	scanf("%d",&n);
	int arr[n];
	printf("Enter order 1 for asc 2 for dsn");
	scanf("%d",&ord);
	for(i=0;i<n;i++){
		printf("Enter element");
		scanf("%d",&arr[i]);
		
	}
	for(i=0;i<n;i++){
		printf("%d\n",*(arr+i));
	}
	printf("After sorting\n");
	SortFunction(arr,n,ord);
		
}
void SortFunction(int *arr, int size, int order){
	int temp,i,j;
	if(order==1){
		for(i=0;i<size-1;i++){
			for(j=0;j<size-1-i;j++){
				if (*(arr+j)>*(arr+j+1)){
					temp=*(arr+j);
					*(arr+j)=*(arr+j+1);
					*(arr+j+1)=temp;
				}
			}
		}
	}else{
		for(i=0;i<size-1;i++){
			for(j=0;j<size-1-i;j++){
				if (*(arr+j)<*(arr+j+1)){
					temp=*(arr+j);
					*(arr+j)=*(arr+j+1);
					*(arr+j+1)=temp;
				}
			}
		}	
		
	}
	for(i=0;i<size;i++){
		printf("%d\n",*(arr+i));
	}
}
