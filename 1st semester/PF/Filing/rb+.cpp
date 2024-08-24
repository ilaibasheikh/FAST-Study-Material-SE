#include <stdio.h>
int main()
{
	FILE *fp;
	struct product
	{
		int cat_num;
		float cost;
	};
	
	int i;
	struct product a[3]={{2, 0.1},{3,4.3},{5,9.0}};
	struct product k, *p = &k;
	
	fp = fopen("fread1.txt", "r");
	if (fp == NULL)
	{
		printf("File not found");
	}
	fwrite(a, sizeof(struct product), 3, fp);
	rewind(fp);
	for(i=0;i<3;i++)
	{
		fread(p,sizeof(struct product), 1, fp);
		printf("Product %d, Cat_num= %d, cost = %f\n", i, p->cat_num , p->cost);
	}
	fclose(fp);
}