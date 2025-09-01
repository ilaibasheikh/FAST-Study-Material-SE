
public class task4 {
    public static int linearSearch(String[] array, String target) {
        int steps = 0;
        for (int i = 0; i < array.length; i++) {
            steps++;
            if (array[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }
    public static int binarySearch(String[] array, String target) {
        int steps = 0;
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            steps++;
            int mid = left + (right - left) / 2;
            int comparison = array[mid].compareTo(target);

            if (comparison == 0) {
                return steps;
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        String[] namesArray = {"Ahmed", "Ali", "Basit", "Karim", "Rizwan", "Sarwar", "Tariq", "Taufiq", "Yasin", "Zulfiqar"};


        String[] namesToSearch = {"Aftab", "Rizwan", "Tariq"};


        for (String name : namesToSearch) {

            int linearSteps = linearSearch(namesArray, name);

            int binarySteps = binarySearch(namesArray, name);

            System.out.println("Name: " + name);
            System.out.println("Linear Search Steps: " + linearSteps);
            System.out.println("Binary Search Steps: " + binarySteps);
        }

    }
}
