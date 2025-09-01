#include <stdio.h>
#include <string.h>
struct movies
{
	char title[10];
	int year;
};
struct friends
{
	char name[10];
	char email[10];
	struct movies fvmovie;
};
int main()
{
	struct friends amir, areeb;
	strcpy(amir.name, "Amir");
	strcpy(amir.fvmovie.title, "FAST");
		
	amir.fvmovie.year = 2022;
	
	strcpy(areeb.name, "Areeb");
	strcpy(areeb.email, "email@nu.edu");
	strcpy(areeb.fvmovie.title, "Karachi");
	areeb.fvmovie.year = amir.fvmovie.year;
	
	printf("%s\n", amir.name);
	printf("%s\n", amir.fvmovie.title);
	
	printf("%s\n", areeb.name);
	printf("%s\n", areeb.email);
	printf("%s\n", areeb.fvmovie.title);
	printf("%d\n",areeb.fvmovie.year);
	
	
}