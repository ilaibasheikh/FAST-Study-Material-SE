//22k-5195 Laiba Fatima
import java.util.ArrayList;
class GameObject{
    private final String Name ;
    private int x;
    private int y;

    public GameObject( String name, int x, int y) {
        this.Name ="22K-5195";
        this.x = x;
        this.y = y;
    }

    public String getName() {
        return Name;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void draw(){
        System.out.println("Drawing a GameObject at (" + getX() + ", " + getY() + ")");

    }
}
class Player extends GameObject{
    public int health;

    public Player(String name, int x, int y, int health) {
        super(name, x, y);
        this.health = health;
    }
    public void draw(){
        System.out.println("Player: ");
        System.out.println(getName());
        System.out.println("Drawing a GameObject at (" + getX() + ", " + getY() + ")");
        health-=10;
        System.out.println("Health: "+health);
    }
    public boolean equals(Player p) {

        return this.health == p.health;
    }
}
class Enemy extends GameObject{
    public int damage;

    public Enemy(String name, int x, int y, int damage) {
        super(name, x, y);
        this.damage = damage;
    }
    public void draw(){
        System.out.println("Enemy: ");
        System.out.println(getName());
        System.out.println("Drawing a GameObject at (" + getX() + ", " + getY() + ")");
        damage+=10;
        System.out.println("Damage: "+damage);
    }
}
class PowerUp extends GameObject{
    public String effect;

    public PowerUp(String name, int x, int y, String effect) {
        super(name, x, y);
        this.effect = effect;
    }
    public void draw(){
        System.out.println("Power Up : ");
        System.out.println(getName());
        System.out.println("Drawing a GameObject at (" + getX() + ", " + getY() + ")");
        System.out.println("Effect: "+effect);

    }
}
class Game {
    public ArrayList<GameObject> gameObjects = new ArrayList<GameObject>();

    public void addObject(GameObject g) {
        gameObjects.add(g);
    }

    public void drawAll() {
        for (GameObject g : gameObjects) {

            g.draw();
        }
    }
}
public class A2_Q4_22k5195 {
    public static void main(String[] args) {
        System.out.println("22k-5195 Laiba Fatima");
        Player p1 = new Player("Laiba", 10, 20, 100);
        Player p2 = new Player("Mustafa", 30, 40, 200);
        Player p3 =  new Player("Hani", 30, 40, 100);
        Enemy e = new Enemy("Umair", 50, 60, 50);
        PowerUp p = new PowerUp("Hafsah", 70, 80, "Increase speed");

        Game game = new Game();
        game.addObject(p1);
        game.addObject(p2);
        game.addObject(p3);
        game.addObject(e);
        game.addObject(p);

        game.drawAll();


        System.out.println(" Player 1  health equals Player 2 health? " + p1.equals(p2));
        System.out.println(" Player 1  health equals Player 3 health? " + p1.equals(p3));

    }
}

