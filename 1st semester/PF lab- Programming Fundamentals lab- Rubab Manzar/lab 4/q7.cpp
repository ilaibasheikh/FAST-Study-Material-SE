#include <stdio.h>
#include <math.h>

int main()
 {
    float a, b, c, discriminant, root1, root2;
    printf("Enter coefficients a, b and c: ");
    scanf("%f %f %f", &a, &b, &c);

    discriminant = b * b - 4 * a * c;

    root1 = (-b + sqrt(discriminant)) / (2 * a);
	root2 = (-b - sqrt(discriminant)) / (2 * a);
	
    printf("root1 = %f and root2 = %f", root1, root2);
    
    
}