#include<stdio.h>
main(){
int i=0,j=0,k=0;
int size;
int count;
printf("Enter Size of array : ");
scanf("%d",&size);
int arr[size];
int b[size];
printf("\nEnter elements in array: ");
for(i=0;i<size;i++){
scanf("%d",&arr[i]);
b[i]=0;
}
printf("\nFrequency of all elements in the array :\n");
for(j=0;j<size-1;j++){
count=1;
for(k=j+1;k<size;k++){
if(arr[j]==arr[k] && b[k]==0){
count=count+1;
b[k]=1;
}
}
if(b[j]==0){
printf("element %d occurs %d times\n",arr[j],count);
}
// else if(b[j]!=0&&count==1)
//{

//}
}
 if(b[size-1]==0)
{
count=1;
printf("element %d occurs %d times\n",arr[size-1],count);

}

}
