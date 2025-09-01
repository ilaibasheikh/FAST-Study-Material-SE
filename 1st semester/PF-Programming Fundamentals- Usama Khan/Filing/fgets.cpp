#include<stdio.h>
#include<conio.h>
int main(){
FILE *file;
char strings[300];
file=fopen("puts.txt","r");
printf("Content of the file is: %s",fgets(strings,200,file));
fclose(file);
getch();
}