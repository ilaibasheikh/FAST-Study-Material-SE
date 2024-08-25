//class listNode {
//    int val;
//    listNode next;
//
//    listNode(int val) {
//        this.val = val;
//    }
//}
//
//public class task5 {
//
//    static class LinkedList {
//        listNode head;
//
//
//
//        public void insert(int data) {
//            listNode newNode = new listNode((char) data);
//            if (head == null) {
//                head = newNode;
//            } else {
//                listNode curr = head;
//                while (curr.next != null) {
//                    curr = curr.next;
//                }
//                curr.next = newNode;
//            }
//        }
//
//    public boolean Palindrome() {
//        if (head == null || head.next == null) {
//            return true;
//        }
//
//
//        listNode slow = head;
//        listNode fast = head;
//
//
//        while (fast != null && fast.next != null) {
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//        listNode secondhalf = reverselist(slow);
//        listNode firsthalf = head;
//
//
//        while (secondhalf != null) {
//            if (firsthalf.val != secondhalf.val) {
//                return false;
//            }
//            firsthalf = firsthalf.next;
//            secondhalf = secondhalf.next;
//        }
//
//
//        return true;
//    }
//
//    listNode reverselist(listNode head) {
//        listNode prev = null;
//        listNode curr = head;
//        while (curr != null) {
//            listNode nextTemp = curr.next;
//            curr.next = prev;
//            prev = curr;
//            curr = nextTemp;
//        }
//        return prev;
//    }
//
//
//
//
//    }
//
//
//
//
//    public static void main(String[] args) {
//        LinkedList list1 = new LinkedList();
//        list1.insert('B');
//        list1.insert('O');
//        list1.insert('R');
//        list1.insert('R');
//        list1.insert('O');
//        list1.insert('W');
//        list1.insert('O');
//        list1.insert('R');
//        list1.insert('R');
//        list1.insert('O');
//        list1.insert('B');
//
//       boolean answer = list1.Palindrome();
//        System.out.println(answer);
//
//        LinkedList list2 = new LinkedList();
//        list2.insert('A');
//        list2.insert('B');
//        list2.insert('C');
//
//         answer= list2.Palindrome();
//        System.out.println(answer);
//    }
//}


