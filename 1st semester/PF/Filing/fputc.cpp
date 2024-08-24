#include <stdio.h>
int main(){
FILE *filepoint;
filepoint = fopen("3.txt", "w");
fputc('T',filepoint);
fclose(filepoint);
}