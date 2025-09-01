#include <stdio.h>
int main() {
  int a;
  int b;
  int temp;
  printf("Enter a: ");
  scanf("%d", &a);
  printf("Enter b: ");
  scanf("%d", &b);

  temp = a;   

  a = b;

  b = temp;

  printf("After swapping, a = %d\n", a);
  printf("After swapping, b = %d", b);

  return 0;
}