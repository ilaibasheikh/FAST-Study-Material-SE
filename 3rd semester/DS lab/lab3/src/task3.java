
public class task3 {
    public static void main(String[] args) {

        String[] arr = {"Laiba", "Safi", "Maaz" , "Hani"};
        System.out.println("Your array: ");
        for (int i = 0; i < arr.length; ++i) {
            System.out.print(arr[i] + " ");
        }


        for (int i = 0; i < arr.length - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < arr.length; j++){
                if (arr[j].compareToIgnoreCase(arr[index])<0){
                    index = j;
                }
            }
            String smallerString = arr[index];
            arr[index] = arr[i];
            arr[i] = smallerString;
        }
        System.out.println();
        System.out.println("Sorted:");
        for (int i = 0; i < arr.length; ++i) {
            System.out.print(arr[i] + " ");
        }
    }
}
