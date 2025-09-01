  #include <stdio.h>

    int main ()

    {

        int array[10][10];

        int x, j, m, n, a = 0, sum = 0;

        printf("Enter the order of the matix \n");

        scanf("%d %d", &m, &n);

        if (m == n )

        {

            printf("Enter the co-efficients of the matrix\n");

            for (x = 0; x < m; x++)

            {

                for (j = 0; j < n;j++)

                {

                    scanf("%d", &array[x][j]);

                }

            }

            printf("The given matrix is \n");

            for (x = 0; x < m; x++)

            {

                for (j = 0; j < n; j++)

                {

                    printf(" %d", array[x][j]);

                }

                printf("\n");

            }

            for (x = 0; x < m; x++)

            {

                sum = sum + array[x][x];

                a = a + array[x][m - x - 1];

            }

            printf("\nThe sum of the main diagonal elements is = %d\n", sum);

            printf("The sum of the off diagonal elemets is   = %d\n", a);

        }

        else

            printf("The given order is not square matrix\n");

    }