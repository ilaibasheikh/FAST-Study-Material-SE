#include <Stdio.h>
int getNum();
int sqr(int x);
int printOne(int x);
int main()
{
	int a=getNum();
	int b= sqr(a);
	int c= printOne(b);
	return 0;
}
int getNum()
{
	printf("Enter a number");
	int num;
	scanf("%d", &num);
	return num;
}
int sr(int x)
{
	return(x*x);
}
int printOne(int x)
{
	 return printf("%d", x);

}