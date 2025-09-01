#include <stdio.h>
#include <stdlib.h>

int main()
{
	FILE *f1, *f2, *f3;
	char ch, fname1[20], fname2[20], fname3[30];
	
	printf(" Input the 1st file name : ");
	scanf("%s",fname1);
	printf(" Input the 2nd file name : ");
	scanf("%s",fname2);
	printf(" Input the new file name where to merge the above two files : ");
	scanf("%s",fname3);
	f1=fopen(fname1, "r");
	f2=fopen(fname2, "r");
	if(f1==NULL || f2==NULL)
	{
		printf(" File does not exist or error in opening...!!\n");
		exit(EXIT_FAILURE);
	}
	f3=fopen(fname3, "w");
	if(f3==NULL)
	{

		printf(" File does not exist or error in opening...!!\n");
		exit(EXIT_FAILURE);
	}
	while((ch=fgetc(f1))!=EOF)
	{
		fputc(ch, f3);
	}
	while((ch=fgetc(f2))!=EOF)
	{
		fputc(ch, f3);
	}
	printf(" The two files merged into %s file successfully..!!\n\n", fname3);
	fclose(f1);
	fclose(f2);
	fclose(f3);
}
