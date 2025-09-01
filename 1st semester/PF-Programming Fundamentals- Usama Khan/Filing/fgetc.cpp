#include <stdio.h>
int main(){
FILE *ptr;
char read;
if (ptr = fopen("TechVidvan.txt", "r")){
while((read=fgetc(ptr))!=EOF)
printf("Content of the file is: %c",read);
}
fclose(ptr);
return 0;
}