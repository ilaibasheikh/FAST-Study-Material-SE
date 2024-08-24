#include <stdio.h>
#include <string.h>
struct book
{
	char name[10];
	int pages;
	float price;
};
int main()
{
	int i;
	int size;
	printf("What  is the size of the array?");
	scanf("%d", &size);
	
	struct book b[size];
	
	for(i=0;i<size; i++)
	{
		printf("Enter name, pages and price of the book");
		scanf("%s", &b[i].name);
		scanf("%d", &b[i].pages);
		scanf("%f", &b[i].price);
	}
	
	printf("Name\tpages\tprice\n");
	for (i=0;i<size; i++)
	{
		printf("%s\t%d\t%2f\n", b[i].name,b[i].pages,b[i].price);
	}
	
}