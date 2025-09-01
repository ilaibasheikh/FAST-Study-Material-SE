public class student {
    public int Age;
    public String Name;
    public String Course;

    public static void main(String[] args) {
        student student = new student();
        student.Name = "Laiba";
        student.Age = 19;
        student.Course = "OOP in JAVA";

        System.out.println("My name is " + student.Name + ", I'm " + student.Age + " years old., I am studying " +student.Course);
    }
}

