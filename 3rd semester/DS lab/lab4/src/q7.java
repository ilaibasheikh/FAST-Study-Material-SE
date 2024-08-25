//class node {
//    int data;
//    node next;
//    node prev;
//
//    public node(int data) {
//        this.data = data;
//        this.next = null;
//        this.prev = null;
//    }
//}
//
//class task7 {
//
//    node head;
//    node tail;
//
//
//    public task7() {
//        this.head = null;
//        this.tail = null;
//    }
//
//
//    public static task7 concatenate(task7 L, task7 M) {
//
//        if (L == null || L.head == null) {
//            return M;
//        }
//        if (M == null || M.head == null) {
//            return L;
//        }
//
//
//        L.tail.next = M.head;
//        M.head.prev = L.tail;
//
//
//        L.tail = M.tail;
//        M.head = null;
//
//        return L;
//    }
//
//
//    public void display() {
//        node current = head;
//        while (current != null) {
//            System.out.print(current.data + " <-> ");
//            current = current.next;
//        }
//        System.out.println("null");
//    }
//
//    public static void main(String[] args) {
//        task7 L = new task7();
//        task7 M = new task7();
//
//
//        L.head = new node(1);
//        L.head.next = new node(2);
//        L.tail = L.head.next;
//
//        System.out.println("List 1");
//        L.display();
//
//        M.head = new node(3);
//        M.head.next = new node(4);
//        M.tail = M.head.next;
//
//        System.out.println("List 2");
//        M.display();
//
//        task7 concatenatedList = task7.concatenate(L, M);
//        System.out.println("concatenated");
//
//        concatenatedList.display();
//    }
//}