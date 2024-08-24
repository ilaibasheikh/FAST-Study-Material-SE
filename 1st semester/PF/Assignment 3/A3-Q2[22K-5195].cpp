#include<stdio.h>
#include<stdlib.h>
#include<string.h>
void find(char[5][6]);
main(){
	char id[8],name[20];
	char array[5][6];
	int i,j,k=4;
	printf ("Enter your name=");
	gets(name);
	printf ("Enter your id=");
	gets(id);
	printf ("Array:\n");
	for(i=0;i<5;i++){
		for(j=0;j<6;j++){
			if(i==4 && j>0){
				array[i][j]=id[k];
				k++;
				printf ("%c ",array[i][j]);
			}
            else{    
		    array[i][j]=(rand()%26)+65;
		    printf ("%c ",(array[i][j]));
			}
	   }
	   printf ("\n");
     }
     find(array);
}
void find(char arr[5][6]){
	int r,i,count=0,j,k,score=0,s,n=0,v,b=0,d;
	char str[30],end[3]={'E','N','D'};
	a:
	printf ("Enter string you want to search= ");
	gets(str);
	count=0;
	b=0;
	s=strlen(str);
	r=strcmp(str,end);
	if(r==0)
	exit(0);
    for(i=0;i<5;i++){
    	for(j=0;j<6;j++){
    		b=0;
    		if(arr[i][j]==str[b]){
    			b++;
    			count++;
    			if(arr[i][j+b]==str[b]){
    				b++;
    				count++;
    				for(d=b;str[d]!='\0';d++){
    					if(arr[i][j+d]==str[d]){
    						count++;
    						b++;
						}
					}
				}
				else if(arr[i+b][j]==str[b]){
					b++;
					count++;
					for(d=b;str[d]!='\0';d++){
						if(arr[i+d][j]==str[d]){
							count++;
							b++;
						}
					}
				}
				else{
					b=0;
					count=0;
				}
				
			}
			if(count==s){
				printf ("string is present\n");
				score++;
				printf ("your score is %d\n",score);
				goto a;
			}
		}
	}
	if(count!=s){
		printf ("string is not present\n");
		score--;
		printf ("your score is %d\n",score);
		goto a;
	}
}	

