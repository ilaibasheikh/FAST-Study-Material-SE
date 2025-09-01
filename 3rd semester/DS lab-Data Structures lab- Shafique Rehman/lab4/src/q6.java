//class task6 {
//
//    class listNode {
//        int data;
//        listNode next;
//
//        public listNode(int data) {
//            this.data = data;
//            this.next = null;
//        }
//    }
//    listNode head;
//
//
//    public void insertAtEnd(int data) {
//        listNode newListNode = new listNode(data);
//        if (head == null) {
//            head = newListNode;
//            newListNode.next = head;
//        } else {
//            listNode current = head;
//            while (current.next != head) {
//                current = current.next;
//            }
//            current.next = newListNode;
//            newListNode.next = head;
//        }
//    }
//
//
//    public void insertAtBeginning(int data) {
//        listNode newListNode = new listNode(data);
//        if (head == null) {
//            head = newListNode;
//            newListNode.next = head;
//        } else {
//            listNode current = head;
//            while (current.next != head) {
//                current = current.next;
//            }
//            newListNode.next = head;
//            head = newListNode;
//            current.next = head;
//        }
//    }
//
//
//    public void insertAtPosition(int data, int position) {
//        listNode newListNode = new listNode(data);
//        if (position <= 0) {
//            System.out.println("Invalid position");
//            return;
//        }
//        if (position == 1) {
//            insertAtBeginning(data);
//            return;
//        }
//        listNode current = head;
//        int count = 1;
//        while (count < position - 1 && current.next != head) {
//            current = current.next;
//            count++;
//        }
//        if (count < position - 1) {
//            System.out.println("Position is out of range");
//            return;
//        }
//        newListNode.next = current.next;
//        current.next = newListNode;
//    }
//
//
//    public void deleteNode(int data) {
//        if (head == null) {
//            System.out.println("List is empty");
//            return;
//        }
//        if (head.data == data) {
//            listNode current = head;
//            while (current.next != head) {
//                current = current.next;
//            }
//            if (head == head.next) {
//                head = null;
//            } else {
//                head = head.next;
//                current.next = head;
//            }
//            return;
//        }
//        listNode current = head;
//        listNode prev = null;
//        while (current.next != head) {
//            if (current.data == data) {
//                prev.next = current.next;
//                return;
//            }
//            prev = current;
//            current = current.next;
//        }
//        if (current.data == data) {
//            prev.next = head;
//        } else {
//            System.out.println("Node not found");
//        }
//    }
//
//
//    public void printList() {
//        if (head == null) {
//            System.out.println("List is empty");
//            return;
//        }
//        listNode current = head;
//        do {
//            System.out.print(current.data + " ");
//            current = current.next;
//        } while (current != head);
//        System.out.println();
//    }
//
//    public static void main(String[] args) {
//        task6 list = new task6();
//
//        list.insertAtEnd(1);
//        list.insertAtEnd(2);
//        list.insertAtEnd(3);
//
//        System.out.println("Original List:");
//        list.printList();
//
//        list.insertAtBeginning(0);
//        list.insertAtPosition(4, 5);
//
//        System.out.println("List after insertions:");
//        list.printList();
//
//        list.deleteNode(0);
//        list.deleteNode(3);
//
//        System.out.println("List after deletions:");
//        list.printList();
//    }
//
//}

 