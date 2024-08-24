#include <Stdio.h>
struct book{
	char name[10];
	char author[10];
	int call;
};
void display(struct book b);
int main()
{
	struct book b1 = {"java", "frozen", 992};
	display(b1);

}
void display(struct book b)
{
	printf("%s, %s, %d", b.name, b.author, b.call);
}