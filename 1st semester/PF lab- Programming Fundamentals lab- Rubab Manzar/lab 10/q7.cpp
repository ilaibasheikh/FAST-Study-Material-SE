#include<stdio.h>
#include <conio.h>

typedef struct
{
 int hours;
 int minutes;
 int seconds;
}TIME;


TIME add(TIME, TIME);
TIME subtract(TIME, TIME);

int main()
{
 TIME start, stop, sum, diff;

 printf("Enter hours, minutes and seconds of start time: ");
 scanf("%d%d%d", &start.hours, &start.minutes, &start.seconds);
 printf("Enter hours, minutes and seconds of stop time: ");
 scanf("%d%d%d", &stop.hours, &stop.minutes, &stop.seconds);

 sum = add(start, stop);
 diff = subtract(start, stop);

 printf("Sum: %d:%d:%d\n", sum.hours, sum.minutes, sum.seconds);
 printf("Difference: %d:%d:%d\n", diff.hours, diff.minutes, diff.seconds);

 getch();
 return 0;
}

TIME add(TIME x, TIME y)
{
 TIME sum;
 sum.seconds = x.seconds + y.seconds;
 sum.minutes = x.minutes + y.minutes;
 sum.hours = x.hours + y.hours;
 if(sum.seconds >= 60)
 {
  sum.minutes++;
  sum.seconds -= 60;
 }
 if(sum.minutes >= 60)
 {
  sum.hours ++;
  sum.minutes -= 60;
 }
 return sum;
}

TIME subtract(TIME x, TIME y)
{
 TIME diff;
 if(x.seconds > y.seconds)
 {
  y.seconds += 60;
  --y.minutes;
 }
 if(x.minutes > y.minutes)
 {
  y.minutes += 60;
  --y.hours;
 }

 diff.seconds = y.seconds - x.seconds;
 diff.minutes = y.minutes - x.minutes;
 diff.hours = y.hours - x.hours;
 return diff;
}