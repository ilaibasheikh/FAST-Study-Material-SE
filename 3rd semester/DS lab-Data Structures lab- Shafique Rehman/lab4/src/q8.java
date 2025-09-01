//class task8 {
//
//    static class listNode {
//        int data;
//        listNode next;
//
//        public listNode(int data) {
//            this.data = data;
//            this.next = null;
//        }
//
//    }
//     static class LinkedList {
//         listNode head;
//
//         public void printList() {
//             listNode current = head;
//             while (current != null) {
//                 System.out.print(current.data + " ");
//                 current = current.next;
//             }
//             System.out.println();
//         }
//         public void insert(int data) {
//             listNode newNode = new listNode(data);
//             if (head == null) {
//                 head = newNode;
//             } else {
//                 listNode curr = head;
//                 while (curr.next != null) {
//                     curr = curr.next;
//                 }
//                 curr.next = newNode;
//             }
//         }
//         public void modify() {
//             if (head == null || head.next == null) {
//                 return;
//             }
//
//             listNode current = head;
//             listNode alternate = head.next;
//             listNode newHead = null;
//
//             while (current != null && alternate != null) {
//                 current.next = alternate.next;
//                 alternate.next = newHead;
//                 newHead = alternate;
//                 alternate = current.next;
//
//                 if (alternate != null) {
//                     current = alternate;
//                     alternate = current.next;
//                 }
//             }
//
//
//             current.next = newHead;
//
//         }
//     }
//
//
//
//    public static void main(String[] args) {
//        LinkedList list = new LinkedList();
//        list.insert(10);
//        list.insert(4);
//        list.insert(9);
//        list.insert(1);
//        list.insert(3);
//        list.insert(5);
//        list.insert(9);
//        list.insert(4);
//
//           System.out.println("Original Linked List:");
//        list.printList();
//
//        list.modify();
//
//        System.out.println("\nModified Linked List:");
//        list.printList();
//    }
//}

