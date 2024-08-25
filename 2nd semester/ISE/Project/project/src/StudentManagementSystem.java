import java.util.Scanner;

class Student{
    //defining the attributes of the Student class
    public String studentID;
    public String studentname;

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    private int password;
    //creation of array to store student information
    //total number of subjects = 5
    //column 1 = course code
    //column 2 = subject name
    //column 3 = attendance (out of 35)
    //column 4 = marks out of 100
    //column 5 = credit hours
    String[][] studentinfo=new String[5][5];
    //function for setting course code, course name and credit hours
    public void setcourseinfo(Student s){
        s.studentinfo[0][0]="SE-1001";
        s.studentinfo[0][1]="Introduction to Software Engineering";
        s.studentinfo[0][4]= String.valueOf(3);
        s.studentinfo[1][0]="CS-1002";
        s.studentinfo[1][1]="Object Oriented Programming";
        s.studentinfo[1][4]= String.valueOf(3);
        s.studentinfo[2][0]="CS-2005";
        s.studentinfo[2][1]="Discrete Structures";
        s.studentinfo[2][4]= String.valueOf(3);
        s.studentinfo[3][0]="NS-1001";
        s.studentinfo[3][1]="Applied Physics";
        s.studentinfo[3][4]= String.valueOf(2);
        s.studentinfo[4][0]="CS-1001";
        s.studentinfo[4][1]="ICT";
        s.studentinfo[4][4]= String.valueOf(1);
    }
    //constructor for the Student class objects
    Student(String id, String name, int pw){
        studentID=id;
        studentname=name;
        setPassword(pw);
    }
    //function for authentication of student password
    public boolean authenticationpassword(Student s, int input){
        boolean check;
        if(s.password==input){
            check=true;
        }
        else{
            check=false;
        }
        return(check);
    }
    //function for displaying registered courses
    public void displayregisteredcourses(Student s){
        System.out.println("Student ID: "+s.studentID);
        System.out.println("Student Name: "+s.studentname);
        System.out.println("\n\nRegistered Courses: ");
        int i;
        System.out.println("Course Code \t Course Name");
        for(i=0;i<5;i++){
            System.out.println(s.studentinfo[i][0]+" \t     "+s.studentinfo[i][1]);
        }
    }
    //function for viewing attendance
    public void displayattendance(Student s){
        System.out.println("Choose the course code you want to view attendance for: ");
        int i;
        System.out.println("Course Code \t Course Name");
        for(i=0;i<5;i++){
            System.out.println(s.studentinfo[i][0]+" \t     "+s.studentinfo[i][1]);
        }
        Scanner code=new Scanner(System.in);
        String option;
        option=code.next();
        int attendance = 0, check = 0;
        float percentage, att;
        if(option.equals(s.studentinfo[0][0])){
            System.out.println("Displaying Attendance for "+s.studentinfo[0][0]+"  "+s.studentinfo[0][1]);
            attendance= Integer.parseInt(s.studentinfo[0][2]);
            check=1;
        }
        else if(option.equals(s.studentinfo[1][0])){
            System.out.println("Displaying Attendance for "+s.studentinfo[1][0]+"  "+s.studentinfo[1][1]);
            attendance= Integer.parseInt(s.studentinfo[1][2]);
            check=1;
        }
        else if(option.equals(s.studentinfo[2][0])){
            System.out.println("Displaying Attendance for "+s.studentinfo[2][0]+"  "+s.studentinfo[2][1]);
            attendance= Integer.parseInt(s.studentinfo[2][2]);
            check=1;
        }
        else if(option.equals(s.studentinfo[3][0])){
            System.out.println("Displaying Attendance for "+s.studentinfo[3][0]+"  "+s.studentinfo[3][1]);
            attendance= Integer.parseInt(s.studentinfo[3][2]);
            check=1;
        }
        else if(option.equals(s.studentinfo[4][0])){
            System.out.println("Displaying Attendance for "+s.studentinfo[4][0]+"  "+s.studentinfo[4][1]);
            attendance= Integer.parseInt(s.studentinfo[4][2]);
            check=1;
        }
        else{
            System.out.println("ERROR!");
            System.out.println("Wrong input entered. Please enter a valid option!");
        }
        if(check==1){
            System.out.println("Total number of classes: 35");
            System.out.println("Classes attended: "+attendance);
            att=attendance;
            percentage=(att/35)*100;
            System.out.printf("Percentage: %.1f",percentage);
            System.out.println("\n");
        }
    }
    //function for viewing course marks
    public void viewcoursemarks(Student s){
        System.out.println("Choose the course code you want to view marks for: ");
        int i;
        System.out.println("Course Code \t Course Name");
        for(i=0;i<5;i++){
            System.out.println(s.studentinfo[i][0]+" \t     "+s.studentinfo[i][1]);
        }
        Scanner code=new Scanner(System.in);
        String option;
        option=code.next();
        if(option.equals(s.studentinfo[0][0])){
            System.out.println("Displaying Course Marks for "+s.studentinfo[0][0]+"  "+s.studentinfo[0][1]);
            System.out.println("Total Marks: 100");
            System.out.println("Marks obtained: "+s.studentinfo[0][3]);
        }
        else if(option.equals(s.studentinfo[1][0])){
            System.out.println("Displaying Course Marks for "+s.studentinfo[1][0]+"  "+s.studentinfo[1][1]);
            System.out.println("Total Marks: 100");
            System.out.println("Marks obtained: "+s.studentinfo[1][3]);
        }
        else if(option.equals(s.studentinfo[2][0])){
            System.out.println("Displaying Course Marks for "+s.studentinfo[2][0]+"  "+s.studentinfo[2][1]);
            System.out.println("Total Marks: 100");
            System.out.println("Marks obtained: "+s.studentinfo[2][3]);
        }
        else if(option.equals(s.studentinfo[3][0])){
            System.out.println("Displaying Course Marks for "+s.studentinfo[3][0]+"  "+s.studentinfo[3][1]);
            System.out.println("Total Marks: 100");
            System.out.println("Marks obtained: "+s.studentinfo[3][3]);
        }
        else if(option.equals(s.studentinfo[4][0])){
            System.out.println("Displaying Course Marks for "+s.studentinfo[4][0]+"  "+s.studentinfo[4][1]);
            System.out.println("Total Marks: 100");
            System.out.println("Marks obtained: "+s.studentinfo[4][3]);
        }
        else{
            System.out.println("ERROR!");
            System.out.println("Wrong input entered. Please enter a valid option!");

        }
    }
    //function for calculating individual GPA
    public void individualGPA(Student s){
        int marks, i, check;
        marks=0;
        check=0;
        float gpa;
        String grade;
        System.out.println("Choose the course code you want to calculate GPA for: ");
        System.out.println("Course Code \t Course Name");
        for(i=0;i<5;i++){
            System.out.println(s.studentinfo[i][0]+" \t     "+s.studentinfo[i][1]);
        }
        Scanner code=new Scanner(System.in);
        String option;
        option=code.next();
        if(option.equals(s.studentinfo[0][0])){
            marks= Integer.parseInt(s.studentinfo[0][3]);
            check=0;
        }
        else if(option.equals(s.studentinfo[1][0])){
            marks= Integer.parseInt(s.studentinfo[1][3]);
            check=1;
        }
        else if(option.equals(s.studentinfo[2][0])){
            marks= Integer.parseInt(s.studentinfo[2][3]);
            check=2;
        }
        else if(option.equals(s.studentinfo[3][0])){
            marks= Integer.parseInt(s.studentinfo[3][3]);
            check=3;
        }
        else if(option.equals(s.studentinfo[4][0])){
            marks= Integer.parseInt(s.studentinfo[4][3]);
            check=4;
        }
        else{
            System.out.println("ERROR!");
            System.out.println("Wrong input entered. Please enter a valid option!");
        }
        if((marks>=90)&&(marks<=100)){
            gpa=4.00F;
            grade="A+";
            System.out.println("Displaying GPA for "+s.studentinfo[check][0]+"  "+s.studentinfo[check][1]);
            System.out.println("GPA: "+gpa);
            System.out.println("Grade: "+grade);
        }
        else if((marks>=86)&&(marks<90)){
            gpa=4.00F;
            grade="A";
            System.out.println("Displaying GPA for "+s.studentinfo[check][0]+"  "+s.studentinfo[check][1]);
            System.out.println("GPA: "+gpa);
            System.out.println("Grade: "+grade);
        }
        else if((marks>=82)&&(marks<86)){
            gpa=3.67F;
            grade="A-";
            System.out.println("Displaying GPA for "+s.studentinfo[check][0]+"  "+s.studentinfo[check][1]);
            System.out.println("GPA: "+gpa);
            System.out.println("Grade: "+grade);
        }
        else if((marks>=78)&&(marks<82)){
            gpa=3.33F;
            grade="B+";
            System.out.println("Displaying GPA for "+s.studentinfo[check][0]+"  "+s.studentinfo[check][1]);
            System.out.println("GPA: "+gpa);
            System.out.println("Grade: "+grade);
        }
        else if((marks>=74)&&(marks<78)){
            gpa=3.00F;
            grade="B";
            System.out.println("Displaying GPA for "+s.studentinfo[check][0]+"  "+s.studentinfo[check][1]);
            System.out.println("GPA: "+gpa);
            System.out.println("Grade: "+grade);
        }
        else if((marks>=70)&&(marks<74)){
            gpa=2.67F;
            grade="B-";
            System.out.println("Displaying GPA for "+s.studentinfo[check][0]+"  "+s.studentinfo[check][1]);
            System.out.println("GPA: "+gpa);
            System.out.println("Grade: "+grade);
        }
        else if((marks>=66)&&(marks<70)){
            gpa=2.33F;
            grade="C+";
            System.out.println("Displaying GPA for "+s.studentinfo[check][0]+"  "+s.studentinfo[check][1]);
            System.out.println("GPA: "+gpa);
            System.out.println("Grade: "+grade);
        }
        else if((marks>=62)&&(marks<66)){
            gpa=2.00F;
            grade="C";
            System.out.println("Displaying GPA for "+s.studentinfo[check][0]+"  "+s.studentinfo[check][1]);
            System.out.println("GPA: "+gpa);
            System.out.println("Grade: "+grade);
        }
        else if((marks>=58)&&(marks<62)){
            gpa=1.67F;
            grade="C-";
            System.out.println("Displaying GPA for "+s.studentinfo[check][0]+"  "+s.studentinfo[check][1]);
            System.out.println("GPA: "+gpa);
            System.out.println("Grade: "+grade);
        }
        else if((marks>=54)&&(marks<58)){
            gpa=1.33F;
            grade="D+";
            System.out.println("Displaying GPA for "+s.studentinfo[check][0]+"  "+s.studentinfo[check][1]);
            System.out.println("GPA: "+gpa);
            System.out.println("Grade: "+grade);
        }
        else if((marks>=50)&&(marks<54)){
            gpa=1.00F;
            grade="D";
            System.out.println("Displaying GPA for "+s.studentinfo[check][0]+"  "+s.studentinfo[check][1]);
            System.out.println("GPA: "+gpa);
            System.out.println("Grade: "+grade);
        }
        else{
            gpa=0.00F;
            grade="F";
            System.out.println("Displaying GPA for "+s.studentinfo[check][0]+"  "+s.studentinfo[check][1]);
            System.out.println("GPA: "+gpa);
            System.out.println("Grade: "+grade);
            System.out.println("WARNING! GPA is less than 1.00, hence course is not passed.");
        }
    }
    //function for calculating cumulative gpa
    public void cumulativeGPA(Student s){
        int i, totalcredithours;
        totalcredithours=0;
        float gpa, totalgpa;
        totalgpa=0;
        for(i=0;i<5;i++){
            int marks=0;
            int credithour=0;
            marks= Integer.parseInt(s.studentinfo[i][3]);
            credithour= Integer.parseInt(s.studentinfo[i][4]);
            totalcredithours=totalcredithours+credithour;
            if((marks>=86)&&(marks<=100)){
                gpa=4.00F;
            }
            else if((marks>=82)&&(marks<86)){
                gpa=3.67F;
            }
            else if((marks>=78)&&(marks<82)){
                gpa=3.33F;
            }
            else if((marks>=74)&&(marks<78)){
                gpa=3.00F;
            }
            else if((marks>=70)&&(marks<74)){
                gpa=2.67F;
            }
            else if((marks>=66)&&(marks<70)){
                gpa=2.33F;
            }
            else if((marks>=62)&&(marks<66)){
                gpa=2.00F;
            }
            else if((marks>=58)&&(marks<62)){
                gpa=1.67F;
            }
            else if((marks>=54)&&(marks<58)){
                gpa=1.33F;
            }
            else if((marks>=50)&&(marks<54)){
                gpa=1.00F;
            }
            else{
                gpa=0.00F;
            }
            totalgpa=totalgpa+(gpa*credithour);
        }
        totalgpa=totalgpa/totalcredithours;
        System.out.println("Displaying cumulative GPA for the following courses: ");
        System.out.println("Course Code \t Course Name");
        for(i=0;i<5;i++){
            System.out.println(s.studentinfo[i][0]+" \t     "+s.studentinfo[i][1]);
        }
        System.out.printf("Semester GPA: %.2f",totalgpa);
        System.out.println("\n");
        if(totalgpa<2.00F){
            System.out.println("WARNING! GPA is less than 2.00!");
        }
    }
    //function for calculating fee structure
    public void feestructure(Student s){
        int totalcredithours, i, fees;
        totalcredithours=0;
        int feeperch=8500;
        totalcredithours= 3+3+3+2+1;
        fees=totalcredithours*feeperch;
        System.out.println("Displaying Fee Structure");
        System.out.println("Total credit hours: "+totalcredithours);
        System.out.println("Fee per credit hour: "+feeperch);
        System.out.println("Total fee amount: "+fees+" Rupees");
    }
    public int afterfunction(){
        int choice;
        System.out.println("Please choose an option to proceed: ");
        System.out.println("1 - to continue with same ID");
        System.out.println("2 - to logout");
        System.out.println("3 - EXIT");
        Scanner s=new Scanner(System.in);
        choice=s.nextInt();
        return(choice);
    }
    public int mainmenu(Student s){
        int choice;
        System.out.println("WELCOME, "+s.studentname);
        System.out.println("Please select an option to proceed: ");
        System.out.println("1 - View Registered Courses");
        System.out.println("2 - View Course Attendance");
        System.out.println("3 - View Course Marks");
        System.out.println("4 - Calculate GPA");
        System.out.println("5 - Calculate Fee Structure ");
        Scanner a=new Scanner(System.in);
        choice=a.nextInt();
        return(choice);
    }
}
public class StudentManagementSystem {
    public static void main(String[] args) {
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_RED = "\u001B[31m";

        //creating 4 student objects and storing their attendance (/35) and marks (/100)
        Student s1=new Student("22k-5167", "Rameen Rafiq", 2700);
        s1.setcourseinfo(s1);
        s1.studentinfo[0][2]= String.valueOf(32);
        s1.studentinfo[0][3]= String.valueOf(90);
        s1.studentinfo[1][2]= String.valueOf(30);
        s1.studentinfo[1][3]= String.valueOf(87);
        s1.studentinfo[2][2]= String.valueOf(29);
        s1.studentinfo[2][3]= String.valueOf(80);
        s1.studentinfo[3][2]= String.valueOf(32);
        s1.studentinfo[3][3]= String.valueOf(90);
        s1.studentinfo[4][2]= String.valueOf(30);
        s1.studentinfo[4][3]= String.valueOf(84);
        Student s2=new Student("22k-5195", "Laiba Fatima", 2800);
        s2.setcourseinfo(s2);
        s2.studentinfo[0][2]= String.valueOf(33);
        s2.studentinfo[0][3]= String.valueOf(93);
        s2.studentinfo[1][2]= String.valueOf(28);
        s2.studentinfo[1][3]= String.valueOf(70);
        s2.studentinfo[2][2]= String.valueOf(29);
        s2.studentinfo[2][3]= String.valueOf(82);
        s2.studentinfo[3][2]= String.valueOf(26);
        s2.studentinfo[3][3]= String.valueOf(92);
        s2.studentinfo[4][2]= String.valueOf(30);
        s2.studentinfo[4][3]= String.valueOf(84);
        Student s3=new Student("22k-4831", "Bharti", 2900);
        s3.setcourseinfo(s3);
        s3.studentinfo[0][2]= String.valueOf(30);
        s3.studentinfo[0][3]= String.valueOf(85);
        s3.studentinfo[1][2]= String.valueOf(20);
        s3.studentinfo[1][3]= String.valueOf(79);
        s3.studentinfo[2][2]= String.valueOf(29);
        s3.studentinfo[2][3]= String.valueOf(65);
        s3.studentinfo[3][2]= String.valueOf(27);
        s3.studentinfo[3][3]= String.valueOf(90);
        s3.studentinfo[4][2]= String.valueOf(30);
        s3.studentinfo[4][3]= String.valueOf(82);
        Student s4=new Student("22k-5161", "Hafsa Salman", 3000);
        s4.setcourseinfo(s4);
        s4.studentinfo[0][2]= String.valueOf(28);
        s4.studentinfo[0][3]= String.valueOf(80);
        s4.studentinfo[1][2]= String.valueOf(23);
        s4.studentinfo[1][3]= String.valueOf(69);
        s4.studentinfo[2][2]= String.valueOf(25);
        s4.studentinfo[2][3]= String.valueOf(75);
        s4.studentinfo[3][2]= String.valueOf(31);
        s4.studentinfo[3][3]= String.valueOf(79);
        s4.studentinfo[4][2]= String.valueOf(28);
        s4.studentinfo[4][3]= String.valueOf(78);

        //making a variable Student object
        Student s;

        //authentication of student ID and password
        Scanner input=new Scanner(System.in);
        int choice, password;
        String id;
        System.out.println("STUDENT MANAGEMENT SYSTEM");
        System.out.println("\nPlease select an option to proceed: ");
        System.out.println("1 - Login");
        System.out.println("2 - Exit");
        choice=input.nextInt();
        do{
            if (choice==1){
                System.out.println("Enter your student ID: ");
                id=input.next();
                if(id.equals(s1.studentID)){
                    s=s1;
                }
                else if(id.equals(s2.studentID)){
                    s=s2;
                }
                else if(id.equals(s3.studentID)){
                    s=s3;
                }
                else if(id.equals(s4.studentID)){
                    s=s4;
                }
                else{
                    System.out.println(ANSI_RED+"ERROR!"+ANSI_RESET);
                    System.out.println(ANSI_RED+"Invalid ID entered. Please try again!"+ANSI_RESET);
                    continue;
                }
                System.out.println("Enter your password: ");
                password=input.nextInt();
                //calling function to authenticate password
                boolean check;
                check=s.authenticationpassword(s, password);
                if(check==true){
                    //main menu with features
                    System.out.println("WELCOME, "+s.studentname);
                    System.out.println("Please select an option to proceed: ");
                    System.out.println("1 - View Registered Courses");
                    System.out.println("2 - View Course Attendance");
                    System.out.println("3 - View Course Marks");
                    System.out.println("4 - Calculate GPA");
                    System.out.println("5 - Calculate Fee Structure ");
                    System.out.println("6 - EXIT");
                    int option;
                    option=input.nextInt();
                    do{
                        int afterfunc;
                        if(option==1){
                            //feature of viewing registered courses
                            s.displayregisteredcourses(s);
                            afterfunc=s.afterfunction();
                            if(afterfunc==1){
                                option=s.mainmenu(s);
                            }
                            else if(afterfunc==2){
                                break;
                            }
                            else if(afterfunc==3){
                                option=6;
                            }
                            else{
                                System.out.println(ANSI_RED+"ERROR!");
                                System.out.println("Please choose a valid option"+ANSI_RESET);
                                continue;
                            }
                        }
                        else if(option==2){
                            //feature of viewing course attendances
                            s.displayattendance(s);
                            afterfunc=s.afterfunction();
                            if(afterfunc==1){
                                option=s.mainmenu(s);
                            }
                            else if(afterfunc==2){
                                break;
                            }
                            else if(afterfunc==3){
                                option=6;
                            }
                            else{
                                System.out.println(ANSI_RED+"ERROR!");
                                System.out.println("Please choose a valid option"+ANSI_RESET);
                                continue;
                            }
                        }
                        else if(option==3){
                            //feauture for viewing course marks
                            s.viewcoursemarks(s);
                            afterfunc=s.afterfunction();
                            if(afterfunc==1){
                                option=s.mainmenu(s);
                            }
                            else if(afterfunc==2){
                                break;
                            }
                            else if(afterfunc==3){
                                option=6;
                            }
                            else{
                                System.out.println(ANSI_RED+"ERROR!");
                                System.out.println("Please choose a valid option"+ANSI_RESET);
                                continue;
                            }
                        }
                        else if(option==4){
                            int choose;
                            System.out.println("Please select an option to proceed: ");
                            System.out.println("1 - Calculate individual subject GPA");
                            System.out.println("2 - Calculate cumulative GPA");
                            choose=input.nextInt();
                            if(choose==1){
                                //feature to view individual GPA
                                s.individualGPA(s);
                                afterfunc=s.afterfunction();
                                if(afterfunc==1){
                                    option=s.mainmenu(s);
                                }
                                else if(afterfunc==2){
                                    break;
                                }
                                else if(afterfunc==3){
                                    option=6;
                                }
                                else{
                                    System.out.println(ANSI_RED+"ERROR!");
                                    System.out.println("Please choose a valid option"+ANSI_RESET);
                                    continue;
                                }
                            }
                            else if(choose==2){
                                //feature to view cumulative GPA
                                s.cumulativeGPA(s);
                                afterfunc=s.afterfunction();
                                if(afterfunc==1){
                                    option=s.mainmenu(s);
                                }
                                else if(afterfunc==2){
                                    break;
                                }
                                else if(afterfunc==3){
                                    option=6;
                                }
                                else{
                                    System.out.println(ANSI_RED+"ERROR!");
                                    System.out.println("Please choose a valid option"+ANSI_RESET);
                                    continue;
                                }
                            }
                            else{
                                System.out.println(ANSI_RED+"ERROR!"+ANSI_RESET);
                                System.out.println(ANSI_RED+"Please choose a valid option"+ANSI_RESET);
                                continue;
                            }
                        }
                        else if(option==5){
                            //feature to view fee structure
                            s.feestructure(s);
                            afterfunc=s.afterfunction();
                            if(afterfunc==1){
                                option=s.mainmenu(s);
                            }
                            else if(afterfunc==2){
                                break;
                            }
                            else if(afterfunc==3){
                                option=6;
                            }
                            else{
                                System.out.println(ANSI_RED+"ERROR!");
                                System.out.println("Please choose a valid option"+ANSI_RESET);
                                continue;
                            }
                        }
                        else{
                            System.out.println(ANSI_RED+"ERROR!"+ANSI_RESET);
                            System.out.println(ANSI_RED+"Incorrect option entered. Please try again!"+ANSI_RESET);
                            continue;
                        }
                    }
                    while(option!=6);
                }
                else{
                    System.out.println(ANSI_RED+"ERROR!"+ANSI_RESET);
                    System.out.println(ANSI_RED+"Incorrect password entered. Please try again!"+ANSI_RESET);
                    continue;
                }
            }
            else{
                System.out.println(ANSI_RED+"ERROR!");
                System.out.println("Please choose a valid option"+ANSI_RESET);
                continue;
            }
        }
        while(choice!=2);
        System.out.println("Program has been exited!\nThankyou!");
    }
}