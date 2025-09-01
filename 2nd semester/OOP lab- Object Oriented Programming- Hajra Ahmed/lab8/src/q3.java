abstract class character{
    public int health;
    public int attackpower;
    public String name;
    abstract void specialability();
    public void attack(character obj){
        this.health = attackpower;
    }
    public void defend(character obj){
        System.out.println("defend");
    }

    public character(int health, int attackpower, String name) {
        this.health = health;
        this.attackpower = attackpower;
        this.name = name;
    }
}
class Warrior extends character{
    public Warrior(int health, int attackpower, String name) {
        super(health, attackpower, name);
    }

    public void specialability(){
        attackpower = attackpower*2;
    }
}
class mage extends character{
    public mage(int health, int attackpower, String name) {
        super(health, attackpower, name);
    }

    public void specialability(){
        attackpower = attackpower*20;
    }
}
class archer extends character{
    public archer(int health, int attackpower, String name) {

        super(health, attackpower, name);
    }

    public void specialability(){
        attackpower = attackpower*15;
    }
}
public class q3 {
    public static void main(String[] args) {
        character warrior = new Warrior(100,20,"Fatima");
        character mage = new mage(50, 28,"Laiba");
        character archer = new archer(89, 30, "Noor");
        warrior.attack(mage) ;
        System.out.println(mage.health);
        mage.defend(warrior);
        warrior.specialability();
        System.out.println(warrior.attackpower);
        archer.specialability();
        System.out.println(archer.attackpower);
        archer.attack(warrior);
        System.out.println(warrior.health);
        warrior.defend(archer);


    }
}
