import java.util.Scanner;

public class Teacher {
    private String Name;
    private int Age;
    private String Institute;
    private String EmployeeID;
    private String Email;
    private String Phone;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getInstitute() {
        return Institute;
    }

    public void setInstitute(String institute) {
        Institute = institute;
    }

    public String getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(String employeeID) {
        EmployeeID = employeeID;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public void display(){
        System.out.println("Name: " +getName());
        System.out.println("Age:" +getAge() );
        System.out.println("Institute: " +getInstitute());
        System.out.println("Employee ID:" +getEmployeeID());
        System.out.println("Email: " +getEmail());
        System.out.println("Phone:" +getPhone());
    }

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        HumanitiesTeacher h = new HumanitiesTeacher();
        ScienceTeacher s = new ScienceTeacher();
        MathsTeacher m = new MathsTeacher();

        System.out.println("Humanities Teacher");
        System.out.println("Name: " );
        h.setName(inp.next());
        System.out.println("Age:" );
        h.setAge(inp.nextInt());
        System.out.println("Institute: " );
        h.setInstitute(inp.next());
        System.out.println("Employee ID:" );
        h.setEmployeeID(inp.next());
        System.out.println("Email: " );
        h.setEmail(inp.next());
        System.out.println("Phone:" );
        h.setPhone(inp.next());
        System.out.println("Specialization: " );
        h.setSpecialization(inp.next());
        System.out.println("Years of Experience:  " );
        h.setExperience(inp.nextInt());
        System.out.println("Research Interests:"  );
        h.setResearchInterests(inp.next());



        System.out.println("Science Teacher");
        System.out.println("Name: " );
        s.setName(inp.next());
        System.out.println("Age:" );
        s.setAge(inp.nextInt());
        System.out.println("Institute: " );
        s.setInstitute(inp.next());
        System.out.println("Employee ID:" );
        s.setEmployeeID(inp.next());
        System.out.println("Email: " );
        s.setEmail(inp.next());
        System.out.println("Phone:" );
        s.setPhone(inp.next());
        System.out.println("Specialization: " );
        s.setSpecialization(inp.next());
        System.out.println("Years of Experience:  " );
        s.setExperience(inp.nextInt());
        System.out.println("Research Interests:"  );
        s.setResearchInterests(inp.next());


        System.out.println("Maths Teacher");
        System.out.println("Name: " );
        m.setName(inp.next());
        System.out.println("Age:" );
        m.setAge(inp.nextInt());
        System.out.println("Institute: " );
        m.setInstitute(inp.next());
        System.out.println("Employee ID:" );
        m.setEmployeeID(inp.next());
        System.out.println("Email: " );
        m.setEmail(inp.next());
        System.out.println("Phone:" );
        m.setPhone(inp.next());
        System.out.println("Specialization: " );
        m.setSpecialization(inp.next());
        System.out.println("Years of Experience:  " );
        m.setExperience(inp.nextInt());
        System.out.println("Research Interests:"  );
        m.setResearchInterests(inp.next());


        System.out.println("Humanities Teacher");
        h.display();
        System.out.println("Science Teacher");
        s.display();
        System.out.println("Maths Teacher");
        m.display();
    }
}
class HumanitiesTeacher extends Teacher{
    private String Specialization;
    private int Experience;
    private String ResearchInterests;

    public String getSpecialization() {
        return Specialization;
    }

    public void setSpecialization(String specialization) {
        Specialization = specialization;
    }

    public int getExperience() {
        return Experience;
    }

    public void setExperience(int experience) {
        Experience = experience;
    }

    public String getResearchInterests() {
        return ResearchInterests;
    }

    public void setResearchInterests(String researchInterests) {
        ResearchInterests = researchInterests;
    }

    public void display(){
        super.display();
        System.out.println("Specialization: " +getSpecialization());
        System.out.println("Years of Experience:  " +getExperience());
        System.out.println("Research Interests:"  +getResearchInterests());
    }
}
class ScienceTeacher extends Teacher{
    private String Specialization;
    private int Experience;
    private String ResearchInterests;

    public String getSpecialization() {
        return Specialization;
    }

    public void setSpecialization(String specialization) {
        Specialization = specialization;
    }

    public int getExperience() {
        return Experience;
    }

    public void setExperience(int experience) {
        Experience = experience;
    }

    public String getResearchInterests() {
        return ResearchInterests;
    }

    public void setResearchInterests(String researchInterests) {
        ResearchInterests = researchInterests;
    }
    public void display(){
        super.display();
        System.out.println("Specialization: " +getSpecialization());
        System.out.println("Years of Experience:  " +getExperience());
        System.out.println("Research Interests:"  +getResearchInterests());
    }
}
class MathsTeacher extends Teacher{
    private String Specialization;
    private int Experience;
    private String ResearchInterests;

    public String getSpecialization() {
        return Specialization;
    }

    public void setSpecialization(String specialization) {
        Specialization = specialization;
    }

    public int getExperience() {
        return Experience;
    }

    public void setExperience(int experience) {
        Experience = experience;
    }

    public String getResearchInterests() {
        return ResearchInterests;
    }

    public void setResearchInterests(String researchInterests) {
        ResearchInterests = researchInterests;
    }
    public void display(){
        super.display();
        System.out.println("Specialization: " +getSpecialization());
        System.out.println("Years of Experience:  " +getExperience());
        System.out.println("Research Interests:"  +getResearchInterests());
    }


}
