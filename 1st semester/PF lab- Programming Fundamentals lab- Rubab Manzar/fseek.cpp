#include <stdio.h>
int main(){
FILE *filepoint;
filepoint = fopen("2.txt","w+");
fputs("TechVidvan TutorialHi", filepoint);
fseek(filepoint,18 , SEEK_SET);
fputs(": Using fseek() in C!", filepoint);
fclose(filepoint);
}