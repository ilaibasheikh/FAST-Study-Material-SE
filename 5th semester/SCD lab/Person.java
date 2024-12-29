public class Person {
    private String Name;
    private String occupation;

    public void Draw(){
        System.out.println("A person can draw in many ways");
    }

    public Person(String name, String occupation) {
        Name = name;
        this.occupation = occupation;
    }

    public static void main(String[] args) {
        Person p = new Person("hani" , "doctor");
        p.Draw();
        Artist a = new Artist("laiba");
        a.Draw();
        Gunman g = new Gunman("sabina");
        g.Draw();
    }
}
class Artist extends Person{
    public Artist(String name) {
        super(name, "Artist");
    }

    public void Draw(){
        System.out.println("An artist can draw with a paint brush");
    }
}
class Gunman extends Person{
    public Gunman(String name) {
        super(name, "Gunman");
    }

    public void Draw(){
        System.out.println("A gunman draws a gun to shoot");
    }
}
