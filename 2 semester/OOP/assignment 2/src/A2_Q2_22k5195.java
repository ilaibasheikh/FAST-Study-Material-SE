//22k-5195 Laiba Fatima
import java.util.Scanner;
import java.util.ArrayList;

class Courses{
    public String coursename;
    public String coursecode;
    public int credithours;

    public Courses(String name, String code, int hours){
        this.coursename=name;
       this. coursecode=code;
        this.credithours=hours;
    }
    public void printCourseInfo() {
        System.out.println("Displaying: ");
        System.out.println("Course Name: "+coursename);
        System.out.println("Course Code: "+coursecode);
        System.out.println("Credit Hours: "+credithours);
    }

    public void showcredithours() {
        System.out.println("Credit Hours: " + credithours);
    }
    public void showcoursecode() {
        System.out.println("Course Code: " + coursecode);
    }
}
class Student {
    public String studentID;
    public String studentname;
    public int enrolledcourses;
    public String coursename[];
    public String coursegrade[];
    public boolean feesPaid;

    public Student(String id, String name, int num, boolean status){
        studentID=id;
        studentname=name;
        enrolledcourses=num;
        feesPaid=status;
    }
    ArrayList<Courses> courseArrayList;

    public ArrayList<Courses> getCourseArrayList() {
        return courseArrayList;
    }

    public void setCourseArrayList(ArrayList<Courses> courseArrayList) {
        this.courseArrayList = courseArrayList;
    }

    public String[] getCoursegrade() {
        return coursegrade;
    }

    public void setCoursegrade(String[] coursegrade) {
        this.coursegrade = coursegrade;
    }
    public int credithourstaken(){
        int totalcredithours, i, j, ch;
        totalcredithours =0;
        j=courseArrayList.size();
        for(i=0;i<j;i++){
            ch =courseArrayList.get(i).credithours;
            totalcredithours = totalcredithours + ch;
        }
        return(totalcredithours);
    }


    public void  printstudentinfo() {
        System.out.println("Student ID: " + studentID);
        System.out.println("Student Name: " + studentname);
        System.out.println("Number of Courses Enrolled: " + enrolledcourses);
        System.out.println("Fees Paid: " + (feesPaid ? "Yes" : "No"));
    }



    public double calculateGPA() {
        int totalCreditHours = credithourstaken();
        double gpa = 0.0;
        for (int i = 0; i < enrolledcourses; i++) {
            String grade = coursegrade[i];
            double gradePoint = 0.0;

            if (grade.equals("A")) {
                gradePoint = 4.00;
            } else if (grade.equals("A-")) {
                gradePoint = 3.67;
            } else if (grade.equals("B+")) {
                gradePoint = 3.33;
            } else if (grade.equals("B")) {
                gradePoint = 3.00;
            } else if (grade.equals("B-")) {
                gradePoint = 2.67;
            } else if (grade.equals("C+")) {
                gradePoint = 2.33;
            } else if (grade.equals("C")) {
                gradePoint = 2.00;
            } else if (grade.equals("D")) {
                gradePoint = 1.00;
            } else if (grade.equals("F")) {
                gradePoint = 0.0;
            }
            gpa += gradePoint;
        }
        gpa /= enrolledcourses;
        return gpa;
    }

    public double calculateGPAPercentage() {
        double gpa = calculateGPA();
        return gpa * 9.5;
    }

    public double calculateSemesterFees(double perCreditFee) {
        double totalFees = 0.0;
        int totalCreditHours = credithourstaken();
        double perCreditFees = perCreditFee;
        totalFees = totalCreditHours * perCreditFees;
        if (!feesPaid) {
            perCreditFees = perCreditFees * 0.05;
            totalFees += perCreditFees;
        }

        return totalFees;
    }

    public boolean isEnrolledInCourse(String courseCode) {
        for (int i = 0; i < enrolledcourses; i++) {
            if (coursename[i].equals(courseCode)) {
                return true;
            }
        }
        return false;
    }

    public void printResultGrades(boolean feesPaid, double HourlyCreditFee) {
        System.out.println("Result Grades: ");
        if (feesPaid) {
            for (int i = 0; i < enrolledcourses; i++) {
                System.out.println("Course Name: " + coursename[i] + ", Grade: " + coursegrade[i]);
            }
            System.out.println("GPA: " + calculateGPA());
            System.out.println("GPA Percentage: " + calculateGPAPercentage() + "%");
        } else {
            System.out.println("LOCKED GRADES");
            System.out.println("GPA: N/A");
            System.out.println("Message: Grades are being held for nonpayment of Semester fees.");
            double semesterFees = calculateSemesterFees(HourlyCreditFee);
            System.out.println("Due Amount: " + semesterFees);
        }
    }
}

    public class A2_Q2_22k5195 {
        public static void main(String[] args) {
            Scanner a = new Scanner(System.in);
            System.out.println("22k-5195 Laiba Fatima");
            boolean feepaid;
            ArrayList<Courses> courseArrayList=new ArrayList<Courses>();

            System.out.println("Enter hourly credit fee");
            double credit = a.nextDouble();
            System.out.println("Enter student ID: ");
            String id=a.next();
            System.out.println("Enter student name: ");
            String name=a.next();
            System.out.println("Enter the number of courses enrolled in: ");
            int coursenum=a.nextInt();
            System.out.println("Enter fee status, either paid or not: ");
            String fee=a.next();
            if(fee.equals("paid")){
                feepaid =true;
            }
            else{
                feepaid =false;
            }

            Student s1=new Student(id, name, coursenum, feepaid);
            int i;
            String grade[]=new String[coursenum];
            for(i=0;i<coursenum;i++){
                System.out.println("Enter course name: ");
                String course=a.next();
                System.out.println("Enter course code: ");
                String code=a.next();
                System.out.println("Enter course credit hours: ");
               int credithours=a.nextInt();
                System.out.println("Enter course grade");
                grade[i]=a.next();
                Courses c=new Courses(course, code, credithours);
                courseArrayList.add(c);
            }
            s1.setCourseArrayList(courseArrayList);
            s1.setCoursegrade(grade);

            s1.printstudentinfo();
            s1.printResultGrades(feepaid, credit);

//            System.out.println("Enter your roll number: (K__-____)");
//            String rollnumber = a.next();
//
//            String batchcode = rollnumber.substring(1, 3);
//           Integer batchvalue = Integer.valueOf(batchcode);
//            int perCreditHourCharge = batchvalue / 2;
//
//            int noofstudents = Integer.valueOf(rollnumber.substring(5, 6));
//            Student[] students = new Student[noofstudents];
//
//            System.out.println("Enter tution rate per credit hour");
//            int tuitionrate = a.nextInt();
//            int totalTuitionFee = noofstudents * tuitionrate * perCreditHourCharge;
//
//
//            for (int i = 0; i < noofstudents; i++) {
//                System.out.println("Enter the data for student " + (i + 1) + ":");
//                System.out.print("ID: ");
//                String id = a.nextLine();
//                System.out.print("Name: ");
//                String name = a.nextLine();
//                System.out.println("No of courses enrolled: ");
//                int courses = a.nextInt();
//                System.out.print("Has semester fees paid (true/false): ");
//                boolean feesPaid = a.nextBoolean();
//
//                students[i] = new Student(id, name, courses, feesPaid);
//
//
//                for (int j = 0; j < courses; j++) {
//                    System.out.println("Enter details for Course " + (j + 1) + ":");
//                    System.out.print("Course Name: ");
//                    String courseName = a.next();
//
//                    System.out.print("Grade: ");
//                    String grade = a.next();
//
//                    students[i].setCourseAndGrade(j, courseName, grade);
//                }
//            }
//            for (int i = 0; i < noofstudents; i++) {
//                System.out.println("Result Grades for Student " + (i + 1) + ":");
//                students[i].printResultGrades(perCreditHourCharge, tuitionrate);
//                System.out.println();
            }
    }

