import java.util.Scanner;

public class q2 {
    public static void main(String[] args){
        int marks[] = new int[5];
        int i=0;
        Scanner a= new Scanner(System.in);
        System.out.println("Enter marks of 5 subjects");
        int total=0;
        int max=-999;
        int min=999;
        for(i=0;i<5;i++){
            marks[i]=a.nextInt();
            if(marks[i]>50 || marks[i]<0){
                i=i-1;
                continue;
            }
            total=total+marks[i];
            if(marks[i]>max){
                max=marks[i];
            }
            else if(marks[i]<min){
                min=marks[i];
            }
        }
        int avg= total/5;
        System.out.println("Maximum: "+ max);
        System.out.println("Minimum: "+ min);
        System.out.println("Average: "+ avg);
    }
}