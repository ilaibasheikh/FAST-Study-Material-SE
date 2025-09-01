abstract class Marks {
    abstract float getPercentage();
}

class A extends Marks {
    float sub1, sub2, sub3;
    A(float sub1, float sub2, float sub3) {
        this.sub1 = sub1;
        this.sub2 = sub2;
        this.sub3 = sub3;
    }
    float getPercentage() {
        float total_marks = sub1 + sub2 + sub3;
        float percentage = (total_marks / 300) * 100;
        return percentage;
    }
}

class B extends Marks {
    float sub1, sub2, sub3, sub4;
    B(float sub1, float sub2, float sub3, float sub4) {
        this.sub1 = sub1;
        this.sub2 = sub2;
        this.sub3 = sub3;
        this.sub4 = sub4;
    }
    float getPercentage() {
        float total_marks = sub1 + sub2 + sub3 + sub4;
        float percentage = (total_marks / 400) * 100;
        return percentage;
    }
}

public class q2 {
    public static void main(String[] args) {
        A student_a = new A(80, 85, 90);
        B student_b = new B(75, 80, 85, 90);

        System.out.println("Percentage of marks for Student A: " + student_a.getPercentage());
        System.out.println("Percentage of marks for Student B: " + student_b.getPercentage());
    }
}

