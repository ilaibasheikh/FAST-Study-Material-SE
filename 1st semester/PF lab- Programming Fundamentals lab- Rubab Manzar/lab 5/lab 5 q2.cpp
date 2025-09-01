 #include<stdio.h>
 #include <math.h>
int main()
{
    int x,y,z;
    printf("enter pf marks: \n");
    scanf("%d",&x);
    printf("enter english marks: \n");
    scanf("%d", &y);
    printf("enter islamiat marks: \n");
    scanf("%d", &z);
    
  if (x <= y && y <= z){
    printf("%d, %d, %d",x,y,z);
  }
  else{

    if (x <= z && z <= y){
      printf("%d, %d, %d",x,z,y);
    }
    else{

      if (y <= x && x <= z){
        printf("%d, %d, %d",y,x,z);
      }
      else{

        if (y <= z && z <= x){
         printf("%d, %d, %d",y,z,x);
        }
        else{

          if (z <= x && x <= y){
            printf("%d, %d, %d",z,x,y);
          }
          else{
            if (x == y && y == z){
              printf("%d, %d, %d",x,y,z);
            }
            else{
              printf("%d, %d, %d",z,y,x);
            }
          }
        }
      }
    }
}
}
