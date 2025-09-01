
class HashNode {
    int key;
    int value;
    HashNode next;

    public HashNode(int key, int value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}

class HashMapWithChaining {
    private static final int tablesize = 10;
    private HashNode[] htable;



    private int hashFunction(int key) {
        return key % tablesize;
    }
    public HashMapWithChaining() {
        htable = new HashNode[tablesize];
    }


    public void sortChain() {
        for (int i = 0; i < tablesize; i++) {
            if (htable[i] != null) {
                htable[i] = sortChain(htable[i]);
            }
        }
    }
    public void print() {
        for (int i = 0; i < tablesize; i++) {
            HashNode curr = htable[i];
            System.out.print("Index " + i + ": ");
            while (curr != null) {
                System.out.print("(" + curr.key + ", " + curr.value + ") ");
                curr = curr.next;
            }
            System.out.println();
        }
    }
    public void inserting(HashNode node) {
        int index = hashFunction(node.key);

        if (htable[index] == null) {
            htable[index] = node;
        } else {
            HashNode curr = htable[index];
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = node;
        }
    }

    private HashNode sortChain(HashNode head) {
        HashNode sortedHead = null;
        HashNode curr = head;

        while (curr != null) {
            HashNode next = curr.next;

            if (sortedHead == null || curr.key < sortedHead.key) {
                curr.next = sortedHead;
                sortedHead = curr;
            } else {
                HashNode sortedCurrent = sortedHead;
                while (sortedCurrent.next != null && sortedCurrent.next.key < curr.key) {
                    sortedCurrent = sortedCurrent.next;
                }
                curr.next = sortedCurrent.next;
                sortedCurrent.next = curr;
            }

            curr = next;
        }

        return sortedHead;
    }


}
public class task3 {
    public static void main(String[] args) {
        int[] values = {3, 2, 9, 6, 11, 13, 7, 12, 23, 22, 26};
        int m = 10;

        HashMapWithChaining hashMap = new HashMapWithChaining();

        for (int value : values) {
            HashNode node = new HashNode(value, value);
            hashMap.inserting(node);
        }

        System.out.println("(x, y) = (key, value) ");
        System.out.println("Before");
        hashMap.print();

        hashMap.sortChain();

        System.out.println("\nAfter ");
        hashMap.print();
    }
}
