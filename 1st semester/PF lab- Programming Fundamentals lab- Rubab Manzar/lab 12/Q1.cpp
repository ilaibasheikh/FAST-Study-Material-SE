#include <stdio.h>
#include <stdlib.h>

int main()
{
    int* ptr; 
    int limit; 
    int i; 
    int sum; 

    printf("Enter limit of the array: ");
    scanf("%d", &limit);
    
    ptr = (int*)malloc(limit * sizeof(int));
    
    for (i = 0; i < limit; i++) {
        printf("Enter element %02d: ", i + 1);
        scanf("%d", (ptr + i));
    }
    
    printf("\nEntered array elements are:\n");
    for (i = 0; i < limit; i++) {
        printf("%d\n", *(ptr + i));
    }

    sum = 0; 
    for (i = 0; i < limit; i++) {
        sum += *(ptr + i);
    }
    printf("Sum of array elements is: %d\n", sum);

    
    free(ptr); 

    return 0;
}
