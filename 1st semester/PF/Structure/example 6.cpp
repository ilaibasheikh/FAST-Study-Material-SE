#include <stdio.h>
#include <string.h>
struct book
{
	char name[10];
	char author[10];
	int call;
};
void display(char name[], char author[], int call);
int main()
{
	struct book b1 = {"C++", "frozen", 101};
	char name[10], aut[10];
	
	strcpy(name,b1.name);
	strcpy(aut,b1.author);
	int callno = b1.call;
	
	display(name,aut,callno);
}
void display(char name[], char author[], int call)
{
	printf("%s, %s, %d", name, author, call);
}