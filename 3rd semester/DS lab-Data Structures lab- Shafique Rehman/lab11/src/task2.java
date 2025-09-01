//class HashNode {
//    int key;
//    int f;
//    HashNode next;
//
//    public HashNode(int key, int frequency) {
//        this.key = key;
//        this.f = frequency;
//        this.next = null;
//    }
//}
//public class task2 {
//    public static void main(String[] args) {
//        int[] a = {1, 5, 7, 1};
//        int K = 6;
//
//        HashMap hashMap = new HashMap();
//        int count = 0;
//        for (int num : a) {
//            int complement = K - num;
//            int complementCount = hashMap.find(complement);
//
//            if (complementCount > 0) {
//                count += complementCount;
//            }
//
//            HashNode newNode = new HashNode(num, hashMap.find(num) + 1);
//            hashMap.inserting(newNode);
//        }
//
//        System.out.println("No of pairs with sum " + K + ": " + count);
//    }
//}
//
//
//class HashMap {
//    private static final int tablesize = 10;
//    private HashNode[] htable;
//
//    public HashMap() {
//        htable = new HashNode[tablesize];
//        for (int i = 0; i < tablesize; i++) {
//            htable[i] = null;
//        }
//    }
//
//    private int hashFunction(int key) {
//        return key % tablesize;
//    }
//
//
//    public int find(int value) {
//        int index = hashFunction(value);
//        HashNode curr = htable[index];
//
//        while (curr != null) {
//            if (curr.key == value) {
//                return curr.f;
//            }
//            curr = curr.next;
//        }
//
//        return 0;
//    }
//
//    public void inserting(HashNode m) {
//        int index = hashFunction(m.key);
//        if (htable[index] == null) {
//            htable[index] = m;
//        } else {
//            HashNode curr = htable[index];
//            while (curr.next != null) {
//                curr = curr.next;
//            }
//            curr.next = m;
//        }
//    }
//}

