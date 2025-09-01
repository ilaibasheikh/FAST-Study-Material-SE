#include <stdio.h>
int main( )
{
	int account; /* account number*/
	char name[ 30 ]; /* account name */
	double balance; /* account balance */
/* fopen opens file. Exit program if unable to create file */
	FILE *cfPtr;
	cfPtr=fopen("text.txt","w");
	if ( cfPtr == NULL ) {

		printf( "File could not be opened\n" );

	} /* end if */
	else {
		printf( "Enter the account, name, and balance.\n" );
		printf( "Enter EOF to end input.\n" );
		printf( "? " );
		scanf( "%d%s%lf", &account, name, &balance );
/* write account, name and balance into file with fprintf */
	while (!feof(stdin))
	{
	fprintf(cfPtr,"%d %s %.2f\n",account,name,balance);
	printf( "? " );
	scanf( "%d%s%lf", &account, name, &balance );
	} /* end while */} /* end else */
}