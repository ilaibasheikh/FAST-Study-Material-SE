import java.util.Scanner;

public class q3Main {
    public static void main(String[] args) {
        System.out.println("Laiba Fatima 22K-5195");
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter your first name: ");
                String firstName = scanner.nextLine();

                System.out.print("Enter your ID: ");
                int id = scanner.nextInt();

                id = (id / 10) % 10;

                System.out.print("Enter your birth year: ");
                int birthYear = scanner.nextInt();

                System.out.print("Enter your birth month: ");
                int birthMonth = scanner.nextInt();

                System.out.print("Enter your birth day: ");
                int birthDay = scanner.nextInt();

                HeartRates heartRates = new HeartRates(firstName, id, birthYear, birthMonth, birthDay);

                System.out.println("First Name: " + heartRates.getFirstName());
                System.out.println("Date of Birth: " + heartRates.getBirthMonth() + "/" + heartRates.getBirthDay() + "/" + heartRates.getBirthYear());
        System.out.println("Enter current year");
        int curryear;
        curryear = scanner.nextInt();
                System.out.println("Age: " + heartRates.getAge(curryear, birthYear) + " years");
                int age;
                age = heartRates.getAge(curryear, birthYear);
                System.out.println("Maximum Heart Rate: " + heartRates.getMaximumHeartRate(age));
              int maximumHeartRate = heartRates.getMaximumHeartRate(age);
                int[] targetRange = heartRates.getTargetHeartRate(maximumHeartRate);
                System.out.println("Target Heart Rate: " + targetRange[0] + " - " + targetRange[1]);
            }
}

//formula for maximum heart rate = 220 - age(years)
//target heart rate = 50-80% of max heart rate
class HeartRates {
    Scanner A = new Scanner(System.in);
    private String firstName;
    private int id;
    private int birthYear;
    private int birthMonth;
    private int birthDay;

    public HeartRates(String firstName, int id, int birthYear, int birthMonth, int birthDay) {
        this.firstName = firstName;
        this.id = id;
        this.birthYear = birthYear;
        this.birthMonth = birthMonth;
        this.birthDay = birthDay;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public int getBirthMonth() {
        return birthMonth;
    }

    public void setBirthMonth(int birthMonth) {
        this.birthMonth = birthMonth;
    }

    public int getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(int birthDay) {
        this.birthDay = birthDay;
    }

    public int getAge(int currentyear,int birthyear) {

        int age = currentyear - birthyear;
        return age;
    }

    public int getMaximumHeartRate(int a) {
        return 220 - a;
    }

    public int[] getTargetHeartRate(int m) {
        int targetMin = (int) Math.round(m * 0.5);
        int targetMax = (int) Math.round(m * 0.85);
        int[] targetRange = {targetMin, targetMax};
        return targetRange;
    }
}