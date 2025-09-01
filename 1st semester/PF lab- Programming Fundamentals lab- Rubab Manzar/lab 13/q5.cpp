#include<stdio.h>
#include<string.h>
#include<stdlib.h>
int main(){
	float f1,f2,f3;
	float t1=0,t2=0,t3=0;
	FILE *ptr;
	ptr=fopen("num.txt","w");
	fprintf(ptr,"%f\t\t%f\t\t%f\n",-462.13, 486.47 ,973.79 );
	fprintf(ptr,"%f\t\t%f\t\t%f\n",755.42, 843.04,-963.67 );
	fprintf(ptr,"%f\t\t%f\t\t%f\n",442.58 ,-843.02, -462.86 );
	fprintf(ptr,"%f\t\t%f\t\t%f\n",-233.93, -821.67, 399.59 );
	fprintf(ptr,"%f\t\t%f\t\t%f\n",-379.65 ,-556.37, 837.46 );
	fprintf(ptr,"%f\t\t%f\t\t%f\n",55.18 ,-144.93 ,-93.15 );
	fprintf(ptr,"%f\t\t%f\t\t%f\n",533.73, 804.64, -66.25 );
	fprintf(ptr,"%f\t\t%f\t\t%f\n",-922.12 ,914.68 ,-264.67 );
	fprintf(ptr,"%f\t\t%f\t\t%f\n",-600.27, -838.59, 747.02);
	fprintf(ptr,"%f\t\t%f\t\t%f\n", -962.97 ,49.96, -677.79 );
	fclose(ptr);
	ptr=fopen("num.txt","r");
	fscanf(ptr,"%f%f%f",&f1,&f2,&f3);
	while(!feof(ptr)){
		t1=t1+f1;
		t2=t2+f2;
		t3=t3+f3;
		fscanf(ptr,"%f%f%f",&f1,&f2,&f3);	
	}
	fclose(ptr);
	printf("%.2f  %.2f  %.2f\n",t1,t2,t3);
}
