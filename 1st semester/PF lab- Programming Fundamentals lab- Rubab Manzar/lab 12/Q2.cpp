#include<stdio.h>
#include<stdlib.h>
int main(){
int i;
int N;
printf("Enter total no. of elements: ");
scanf("%d",&N);
int A[N],B[N],Sum[N];
int *ptrA,*ptrB,*ptr;
ptrA=(int *)malloc(N*sizeof(int));
ptrB=(int *)malloc(N*sizeof(int));
ptr=(int *)malloc(N*sizeof(int));
printf("\nEnter all %d elements of list one:\n",N);
for(i=0;i<N;i++){
scanf("%d",(ptrA+i));
}
printf("\nEnter all %d elements of list two: \n",N);
for(i=0;i<N;i++){
scanf("%d",(ptrB+i));
}
for(i=0;i<N;i++){
*(ptr+i)=(*(ptrA+i))+(*(ptrB+i));
}
printf("\nResultant list is : \n");
for(i=0;i<N;i++){
printf("%d\n",*(ptr+i));
}
free(ptrA);
free(ptrB);
free(ptr);
}