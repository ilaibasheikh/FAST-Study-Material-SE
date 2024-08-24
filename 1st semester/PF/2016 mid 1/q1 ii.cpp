#include <stdio.h>
int main( )
{
int i = 1, j = 1 ;
for ( ; ; )
{
if ( i > 5 )
break ;
else
j += i ;
printf ( "\n%d", j ) ;
i += j ;
}
}