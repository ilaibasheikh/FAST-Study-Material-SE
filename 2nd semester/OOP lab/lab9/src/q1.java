class Job{
    private String role;
    private int ID;
    private int salary;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

}
class Person{
    Job j;
    public Person(Job j){
        j = new Job();
        j.setSalary(1000);
        System.out.println(j.getSalary());
    }
}


public class q1 {
    public static void main(String[] args) {
        Job j = new Job();
        Person p = new Person(j);
    }
}