#include <stdio.h>
int main( void )
{
int account; /* account number */ char name[ 30 ]; /* account name */ double balance; /*
account balance */
/* fopen opens file; exits program if file cannot be opened */ FILE *cfPtr;
cfPtr=fopen("text.txt","r");
if ( cfPtr == NULL )
{

printf( "File could not be opened\n" );

} /* end if */
else
{
/* read account, name and balance from file */
printf( "%-10s%-13s%s\n", "Account", "Name", "Balance" );
fscanf( cfPtr, "%d%s%lf", &account, name, &balance );
/* while not end of file */
while ( !feof(cfPtr) )
{

printf( "%-10d%-13s%7.2f\n", account, name, balance );
fscanf(cfPtr,"%d%s%lf",&account,name,&balance);

} /* end while */

} /* end else */
return 0;
} /* indicates successful termination */