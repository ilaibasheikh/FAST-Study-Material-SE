import java.util.ArrayList;
import java.util.List;

public class ArrayListOperations {
    public static void main(String[] args) {
        // Create ArrayLists for colors
        List<String> colorList1 = new ArrayList<>();
        List<String> colorList2 = new ArrayList<>();

        // Add colors to colorList1
        colorList1.add("red");
        colorList1.add("blue");
        colorList1.add("green");
        colorList1.add("yellow");

        // Add colors to colorList2
        colorList2.add("purple");
        colorList2.add("white");
        colorList2.add("blue");
        colorList2.add("pink");

        // Display the initial content of colorList1
        System.out.println("------------Color List 1:------------");
        for (String color : colorList1) {
            System.out.println(color);
        }

        // Display the initial content of colorList2
        System.out.println("------------Color List 2:------------");
        for (String color : colorList2) {
            System.out.println(color);
        }

        // Add all elements from colorList2 to colorList1
        colorList1.addAll(colorList2);

        // Display colorList1 after addAll
        System.out.println("------------Color List 1 after addAll:------------");
        for (String color : colorList1) {
            System.out.println(color);
        }

        // Remove all elements from colorList1 that are also in colorList2
        colorList1.removeAll(colorList2);

        // Display colorList1 after removeAll
        System.out.println("------------Color List 1 after removeAll:------------");
        for (String color : colorList1) {
            System.out.println(color);
        }

        // Add all elements from colorList2 to colorList1 again
        colorList1.addAll(colorList2);

        // Display colorList1 after adding elements back
        System.out.println("------------Color List 1 after adding elements back:------------");
        for (String color : colorList1) {
            System.out.println(color);
        }

        // Retain only the elements that are also in colorList2
        colorList1.retainAll(colorList2);

        // Display colorList1 after retainAll
        System.out.println("------------Color List 1 after retainAll:------------");
        for (String color : colorList1) {
            System.out.println(color);
        }
    }
}
