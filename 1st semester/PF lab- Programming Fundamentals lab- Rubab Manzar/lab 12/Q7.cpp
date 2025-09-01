#include <stdio.h>
#include <stdlib.h>

int main() 
{ 
    FILE *fptr; 
    char ch; 
    int word=0,character=0;
    char fname[20];

	printf(" Input the filename to be opened : ");
	scanf("%s",&fname);    

    fptr=fopen(fname,"r"); 
    if(fptr==NULL) 
     { 
         printf(" File does not exist or can not be opened."); 
      } 
    else 
        { 
          ch=fgetc(fptr); 
          printf(" The content of the file %s are : ",fname); 
          while(ch!=EOF) 
            { 
                printf("%c",ch); 
                if(ch==' '||ch=='\n')
                    { 
                        word++; 
                    }
                    else
                    {
                        character++; 
                    }
                ch=fgetc(fptr); 
            }
        printf("\n The number of words in the  file %s are : %d\n",fname,word-1); 
        printf(" The number of characters in the  file %s are : %d\n\n",fname,character);         
        } 
    fclose(fptr); 
}
