 class student {
    int rollno;
    String name;
    static String college = "new college";
    static void change(){
        college = "IT college";
    }

    student(int r, String n){
        rollno = r;
        name = n;
    }
    void display(){
        System.out.println(rollno+ " "+name+ " "+college);
    }
}
public class Test1{
    public static void main(String[] args) {
        student.change();
        student s1 = new student (1,"Laiba");
        student s2 = new student(2,"Fatima");

        s1.display();
        s2.display();
    }
}
