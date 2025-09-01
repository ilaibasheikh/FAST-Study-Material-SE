public class q2Main {
    public static void main(String[] args) {
        System.out.println("Laiba Fatima 22K-5195");
        Admin admin = new Admin("laiba", "fatima", 19, "Pakistan");
        DataScientist s1 = new DataScientist("Hani", "Masood", "Montessori", 65,"Nepal");
        DataScientist s2 = new DataScientist("Umer", "Sheikh", "Matric", 56 , "Bangladesh");

        s1.AskQuestion();
        s1.AnswerProblem();
        s2.AnswerProblem();
        s2.AnswerProblem();
        s2.AnswerProblem();

       System.out.println(s1);
       System.out.println(s2);

        s1.display();
        s2.display();

        admin.TotalUser();
    }
}
class DataScientist{
    private String firstname;
    private String lastname;
    private String highesteducation;
    private  int age;
    private String country;
    private  int numOfAnswersGiven = 0 ;
    private  int numOfQuestionsAsked = 0;
    public static int uniqueID;

    public DataScientist(String firstname, String lastname, String highesteducation, int age, String country) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.highesteducation = highesteducation;
        this.age = age;
        this.country = country;
        this.numOfAnswersGiven = 0;
        this.numOfQuestionsAsked = 0;
        int studentid = 5195;
        this.uniqueID = (((5195/100)%10)*10) + (5195%10);
        uniqueID++;
    }

    void display(){
        System.out.println("First name " +firstname);
        System.out.println("Second name " +lastname);
        System.out.println("Highest education " + highesteducation);
        System.out.println("age " +age);
        System.out.println("Country " + country);
    }
    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getHighesteducation() {
        return highesteducation;
    }

    public int getAge() {
        return age;
    }

    public String getCountry() {
        return country;
    }

    public int getNumOfAnswersGiven() {
        return numOfAnswersGiven;
    }

    public int getNumOfQuestionsAsked() {
        return numOfQuestionsAsked;
    }

    public static int getUniqueID() {
        return uniqueID;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setHighesteducation(String highesteducation) {
        this.highesteducation = highesteducation;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setNumOfAnswersGiven(int numOfAnswersGiven) {
        this.numOfAnswersGiven = numOfAnswersGiven;
    }

    public void setNumOfQuestionsAsked(int numOfQuestionsAsked) {
        this.numOfQuestionsAsked = numOfQuestionsAsked;
    }

    public void AskQuestion() {
        numOfQuestionsAsked++;
    }
    public void AnswerProblem() {
        numOfAnswersGiven++;
    }
}
class Admin{
    private String firstname;
    private String lastname;
    private  int age;
    private String country;
    public static int adminID;
    int userCount;

    public Admin(String firstname, String lastname, int age, String country) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.country = country;
        this.userCount = 0;

        this.adminID =  5195;
        this.adminID = (((5195/100)%10)*10) + (5195%10);
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public int getAge() {
        return age;
    }

    public String getCountry() {
        return country;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    public void addUser() {
        userCount++;
    }

    public int TotalUser() {
        return userCount;
    }

}
