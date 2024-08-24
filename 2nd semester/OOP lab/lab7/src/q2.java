class person{
    String name;
    String email;
    int phone;

    public String toString(){
        return name + " " +email + " "+phone;
    }

    public person() {
    }

    public person(String name, String email, int phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }
}
class student extends person{
    int sid;
    String major;

    public int getGPA(int g){
        return g;
    }


    public student(String name, String email, int phone, int id, String major) {
        super(name, email, phone);
        this.sid = id;
        this.major = major;
    }
}
class faculty extends person{
    int fid;
    String department;

    public String getRank(String g){
        return g;
    }


    public faculty(String name, String email, int phone, int fid, String department) {
        super(name, email, phone);
        this.fid = fid;
        this.department = department;
    }
}

class staff extends person{
    int staffid;
    String job;

    public float getSalary(float g){
        return g;
    }

    public staff(String name, String email, int phone, int staffid, String job) {
        super(name, email, phone);
        this.staffid = staffid;
        this.job = job;
    }
}

public class q2 {
}
