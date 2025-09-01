//class HashNode {
//    int key;
//    int value;
//    HashNode next;
//
//    public HashNode(int key, int value) {
//        this.key = key;
//        this.value = value;
//        this.next = null;
//    }
//}
//
//class HashMap {
//    private static final int tablesize = 10;
//    private HashNode[] table;
//
//    public HashMap() {
//        table = new HashNode[tablesize];
//        for (int i = 0; i < tablesize; i++) {
//            table[i] = null;
//        }
//    }
//
//    private int hashFunction(int key) {
//        return key % tablesize;
//    }
//
//    public void delete(int value) {
//        int index = hashFunction(value);
//        HashNode curr = table[index];
//        HashNode prev = null;
//
//        while (curr != null && curr.key != value) {
//            prev = curr;
//            curr = curr.next;
//        }
//
//        if (curr == null) {
//            System.out.println("Key " + value + " not found");
//            return;
//        }
//
//        if (prev == null) {
//            table[index] = curr.next;
//        } else {
//            prev.next = curr.next;
//        }
//
//        System.out.println("Deleted: Key=" + value);
//    }
//
//    public int find(int key) {
//        int index = hashFunction(key);
//        HashNode curr = table[index];
//
//        while (curr != null) {
//            if (curr.key == key) {
//                System.out.println("Found: Key=" + key + ", Value=" + curr.value);
//                return curr.value;
//            }
//            curr = curr.next;
//        }
//
//        System.out.println("Key " + key + " not found");
//        return -1;
//    }
//
//
//    public void insert(int key, int value) {
//        int index = hashFunction(key);
//        HashNode newNode = new HashNode(key, value);
//
//        if (table[index] == null) {
//            table[index] = newNode;
//        } else {
//            HashNode curr = table[index];
//            while (curr.next != null) {
//                curr = curr.next;
//            }
//            curr.next = newNode;
//        }
//
//        System.out.println("Inserted: Key=" + key + ", Value=" + value);
//    }
//}
//public class task1 {
//    public static void main(String[] args) {
//        HashMap hashMap = new HashMap();
//
//        hashMap.insert(20, 200);
//        hashMap.insert(34, 340);
//        hashMap.insert(45, 450);
//        hashMap.insert(70, 700);
//        hashMap.insert(56, 560);
//
//        hashMap.find(45);
//        hashMap.find(80);
//
//        hashMap.delete(34);
//        hashMap.delete(80);
//    }
//}
//
