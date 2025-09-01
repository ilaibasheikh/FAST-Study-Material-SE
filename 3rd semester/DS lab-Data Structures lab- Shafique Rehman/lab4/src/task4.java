//class listNode {
//    int val;
//    listNode next;
//
//    listNode(int val) {
//        this.val = val;
//    }
//}
//
//
//public class task4 {
//
//    static class LinkedList {
//        listNode head;
//        public  void modifyLinkedList() {
//
//
//            if (head == null || head.next == null) {
//                return ;
//            }
//
//            listNode evenHead = null;
//            listNode oddHead = null;
//            listNode evenTail = null;
//            listNode oddTail = null;
//
//            listNode current = head;
//
//            while (current != null) {
//                if (current.val % 2 == 0) {
//                    evenTail.next = current;
//                    evenTail = evenTail.next;
//                } else {
//                    oddTail.next = current;
//                    oddTail = oddTail.next;
//                }
//                current = current.next;
//            }
//
//            if (evenHead != null) {
//                evenTail.next = oddHead;
//                head = evenHead;
//            }
//
//
//
//        }
//
//        public void insertAtLast(int data) {
//            listNode newNode = new listNode(data);
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
//        public  void printLinkedList() {
//            listNode current = head;
//            while (current != null) {
//                System.out.print(current.val + " -> ");
//                current = current.next;
//            }
//            System.out.println("NULL");
//        }
//
//    }
//
//
//    public static void main(String[] args) {
//        LinkedList list = new LinkedList();
//        list.insertAtLast(17);
//        list.insertAtLast(15);
//        list.insertAtLast(8);
//        list.insertAtLast(12);
//        list.insertAtLast(10);
//        list.insertAtLast(5);
//        list.insertAtLast(4);
//        list.insertAtLast(1);
//        list.insertAtLast(7);
//        list.insertAtLast(6);
//        System.out.println("Original Linked List:");
//        list.printLinkedList();
//
//        list.modifyLinkedList();
//        System.out.println("Modified Linked List:");
//        list.printLinkedList();
//
//    }
//
//
//}

