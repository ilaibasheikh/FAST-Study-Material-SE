#include <stdio.h>
 #include <string.h>
 
 
int stringwordcount(char *s)
{
    static int i,words=0;
    if(!s[i])
    {
       if(i>0)
      words++;
      return words;
	}
	else
	{
	
    	if(s[i++]==32)
    	 words++;
    	 
        stringwordcount(s);
 	}
 	 
 	
}
int main()
{
    char s[1000];  
    int wordscount;
  
    printf("Enter  the string: ");
    gets(s);
    
 
    wordscount=stringwordcount(s);
    printf("no of words in string = %d\n",wordscount);
     
 
 }