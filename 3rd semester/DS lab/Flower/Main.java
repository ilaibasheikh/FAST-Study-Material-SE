import java.util.Arrays;
//
//public class Main /* implements Comparable<Main>*/ {
//    public static void main(String[] args) {
//
//        Flower rose = new Flower.FlowerBuilder()
//                .flowerColor("Red")
//                .flowerName("Rose")
//                .flowerPrice(25)
//                .flowerSize(70)
//                .build();
//
//        Flower wildRose = new Flower.FlowerBuilder()
//                .flowerColor(rose.getFlowerColor())
//                .flowerName(rose.getFlowerName())
//                .flowerPrice(rose.getFlowerPrice())
//                .flowerSize(rose.getFlowerSize())
//                .build();
//
//        Flower tulip = new Flower.FlowerBuilder()
//                .flowerColor("Yellow")
//                .flowerName("Tulip")
//                .flowerPrice(10)
//                .flowerSize(30)
//                .build();
//
//        Flower sunflower = new Flower.FlowerBuilder()
//                .flowerColor("Yellow")
//                .flowerName("Sunflower")
//                .flowerPrice(15)
//                .flowerSize(100)
//                .build();
//
//        Flower camomile = new Flower.FlowerBuilder()
//                .flowerColor("White")
//                .flowerName("Camomile")
//                .flowerPrice(12)
//                .flowerSize(50)
//                .build();
//
//        Flower [] bouquet1 = {rose, tulip, camomile};
//        Flower [] bouquet2 = {rose, sunflower, camomile};
//
//
//        System.out.println("\n Flower rose : " + rose.toString() + "\n hashCode: " + rose.hashCode());
//        System.out.println("\n Flower tulip : " + tulip.toString() + "\n hashCode: " + tulip.hashCode());
//        System.out.println("\n Are objects rose equal: " + rose.equals(wildRose) + "\n and have the same hash codes: " + (rose.hashCode() == wildRose.hashCode()));
//
//        Flower [] joinedArr = FlowerUtils.join(bouquet1, bouquet2);
//        Flower [] joinDistinct = FlowerUtils.joinDistinct(joinedArr);
//        Flower [] commonVal = FlowerUtils.commonVal(bouquet1,bouquet2);
//        Flower [] outerArr = FlowerUtils.outerVal(bouquet1, bouquet2);
//        Flower [] leftJoinarr = FlowerUtils.leftJoin(bouquet1,bouquet2);
//        Flower [] forTestLeftJoinArr = new Flower[] {rose, rose, tulip, camomile, camomile};
//
//
////        public int compareTo(Main forTestLeftJoinArr) {
////
////        return resultArr.compareTo(forTestLeftJoinArr);
////
//    }
//}
