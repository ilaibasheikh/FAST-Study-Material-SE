public class Weapons {
    public static void main(String[] args) {
        HotWeapons h = new HotWeapons();
        h.HotWeaponsDescription();
        Bombs b = new Bombs();
        b.BombsDescription();
        NuclearBombs n = new NuclearBombs();
        n.NuclearBombsDescription();
    }
}
class HotWeapons extends Weapons{

    public void HotWeaponsDescription(){
        System.out.println("Hot Weapons uses gun powder, or explode");
    }
}
class Bombs extends HotWeapons{
    public void BombsDescription(){
        System.out.println("Bombs blow up");
    }
}
class NuclearBombs extends Bombs{
    public void NuclearBombsDescription(){
        System.out.println("Nuclear Bombs blow up, and use nuclear fission and fusion.");
    }
}
