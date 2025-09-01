public class q5 {
    public String name;
    public int rollno;
    public static String Uni;
    public static int counter=0;
    public static int setrollno(){
        counter++;
        return counter;
    }

    public q5(String name) {
        this.rollno = setrollno();
        this.name = name;

    }
    public static void setUni(String name){
        Uni=name;
    }
    public void display(){
        System.out.println("Roll no: "+rollno);
        System.out.println("Student Name: "+ name);

        System.out.println("University: "+ Uni);
    }
    public static void main(String[] args){
        String a="Fast University";
        q5.setUni(a);
        q5 ob1=new q5("Laiba");
        q5 ob2=new q5("Fatima");
        q5 ob3=new q5("Sheikh");
        ob1.display();
        ob2.display();
        ob3.display();
    }
}