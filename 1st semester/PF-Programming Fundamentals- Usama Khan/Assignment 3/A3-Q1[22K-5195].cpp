#include<stdio.h>
#include<string.h>
#include<ctype.h>

void Encrypt(){
	char Input[100];
	char Code[100][100];
	char TempWord[16];
	char Temp;
	int i,j=0,k,l,m,o,len=0,len2=0,index=0,F=0,A,W=0;
	char StudentID[20];
	char Name[40];
	char Section[10];
	printf("\n\nEnter your Student ID: ");
	gets(StudentID);
	printf("Enter your Name: ");	
	gets(Name);
	printf("Enter section number: ");
	scanf("%s",Section);
	printf("Enter the string to be encrypted: ");
	getchar();
	gets(Input);
	
	len= strlen(Input);
	Input[len]='\0';
	for(i=0;i<len+1;i++){
		if (Input[i]==' '|| Input[i]=='\0'){
			A=0;
			for(;j<i;j++){
				TempWord[A]=Input[j];			
				A++;
			}
			W++;
			j=i+1;
			len2=strlen(TempWord);
			//vowel condition
			if(TempWord[0]=='A'||TempWord[0]=='a' || TempWord[0]=='E'||TempWord[0]=='e' || TempWord[0]=='I'||TempWord[0]=='i' ||
			   TempWord[0]=='O'||TempWord[0]=='o' || TempWord[0]=='U'||TempWord[0]=='u'){
				TempWord[len2]   ='w';
				TempWord[len2+1] ='a';
				TempWord[len2+2] ='y'; 
			}
			
			else{
				//normal consonant
				if(TempWord[0]!='y'||TempWord[0]!='Y'){		
					for(k=1;k<len2;k++){
							//checking if word contains y	
						if(TempWord[k]=='y'||TempWord[k]=='Y'){
							for(o=0;o<len2;o++){
								//checking if there is a vowel after y 
								if((((TempWord[o]=='A'||TempWord[o]=='a') ||
									 (TempWord[o]=='E'||TempWord[o]=='e')) ||
									 ((TempWord[o]=='I'||TempWord[o]=='i') ||
									 (TempWord[o]=='O'||TempWord[o]=='o')))||
									 (TempWord[o]=='U'||TempWord[o]=='u')){
								    index = len2-o;
									for(l=0;l<index;l++){
										Temp=TempWord[len2-1];
										for(m=len2-1;m>0;m--){
											TempWord[m]=TempWord[m-1];
										}		
										TempWord[0]= Temp;
									}
									TempWord[len2]  ='a';
									TempWord[len2+1]='y';				
									F=1;
								}
								else{
									F = 0;
									continue;
								}
								break;
							}
							break;		
						}
						else{
							continue;
						}
					}
				}
				else{
					F = 0;
				}
				
				if(F==0){ //applying the sch condition
					if(TempWord[0]=='s'||TempWord[0]=='S'){
						if(TempWord[1]=='c'){
							if(TempWord[2]=='h'){
								TempWord[1]='k';
								for(k=3;k<len2;k++){
									TempWord[k-1]=TempWord[k];
								}
								TempWord[len2-1]='\0';
								for(l=0;l<len2-2-1;l++){
									Temp=TempWord[len2-2];
									for(m=len2-2;m>0;m--){
										TempWord[m]=TempWord[m-1];
									}		
									TempWord[0]= Temp;
								}
								TempWord[len2-1]  ='a';
								TempWord[len2]='y';	
								
							}
							else{
								for(l=0;l<2;l++){
									Temp=TempWord[len2-1];
									for(m=len2-1;m>0;m--){
									TempWord[m]=TempWord[m-1];
									}		
									TempWord[0]= Temp;
								}
								TempWord[len2]  ='a';
								TempWord[len2+1]='y';
							}
						}
						else{
						
						for(l=0;l<2;l++){
							Temp=TempWord[len2-1];
							for(m=len2-1;m>0;m--){
								TempWord[m]=TempWord[m-1];
							}		
							TempWord[0]= Temp;
						}
						TempWord[len2]  ='a';
						TempWord[len2+1]='y';
						}
					}
					else{
					for(l=0;l<2;l++){
							Temp=TempWord[len2-1];
							for(m=len2-1;m>0;m--){
								TempWord[m]=TempWord[m-1];
							}		
							TempWord[0]= Temp;
					}
					TempWord[len2]  ='a';
					TempWord[len2+1]='y';									
					}
				}
			
			}//checking upper and lower case
			for(l=0;l<len2+4;l++){
				TempWord[l]=tolower(TempWord[l]);
			}
			if(W==1){
				TempWord[0]=toupper(TempWord[0]);
			}
			strcpy(Code[0],StudentID);
			for(k=W;k<W+1;k++){
				strcpy(Code[k],TempWord);
			}
			for(k=0;k<len2+4;k++){
				TempWord[k]='\0';
			}	
		}
		else{
			continue;
		}
	}
	printf("\nYour encrypted code is: \n\t");
	for(i=0;i<W+1;i++){
		printf("%s ",Code[i]);
	}
}
int main(){
	Encrypt();
}