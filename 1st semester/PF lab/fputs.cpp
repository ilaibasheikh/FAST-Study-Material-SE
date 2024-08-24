#include<stdio.h>
#include<conio.h>
int main(){
	FILE *file;
	file=fopen("fputs.txt","w");
	fputs("TechVidvan Tutorial: Writing to a file in C!",file);
	fclose(file);
}