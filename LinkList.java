 class Node {
    int data;
    Node prev;
    Node next;

   Node (int value ){
    prev= null;
    data = value ;
    next = null;
   }
}

class LinKlist {
    static Node head = null;
    static Node tail = null;
    static void insertAtStart (int data){
        Node temp = new Node (data);
        if (head == null){
            head = temp ;
            tail = temp;
        }
        else{
            temp.next = head ;
            head = temp ;
        }
    }

    // new function to inserrt at end 

    static void insertAtEnd (int data ){
        Node temp = new Node(data);
        if (tail == null ){
            head =temp ;
            tail = temp;
        }
        else{
            tail.next = temp;
            temp.prev = tail;
            tail = temp ;
        }
    }
    // generic insert (alias to insertAtEnd)
    static void insert(int data) {
        insertAtEnd(data);
    }
    
    // display the list from head to tail
    static void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
// new function to delete the node from given value 
    static boolean deleteByValue (int data){
        if (head == null) return false;
        Node temp = head;
        while (temp != null){
            if (temp.data == data){
                boolean removedHead = (temp == head);
                boolean removedTail = (temp == tail);

                // single node
                if (head == tail && temp == head) {
                    head = null;
                    tail = null;
                } else if (removedHead) {
                    head = head.next;
                    if (head != null) head.prev = null;
                } else if (removedTail) {
                    tail = tail.prev;
                    if (tail != null) tail.next = null;
                } else {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }

                if (removedHead && removedTail) {
                    System.out.println("Removed the only node (head and tail)");
                } else if (removedHead) {
                    System.out.println("Removed head");
                } else if (removedTail) {
                    System.out.println("Removed tail");
                } else {
                    System.out.println("Removed middle node");
                }

                return true;
            }
            temp = temp.next;
        }
        return false;
    }
    // new function to find the code 
    static void Find(int data){
        Node temp = head ;
        while (temp != null){
            if (temp.data == data){
                System.out.println("Data matched in the link list");
                return;
            }
            temp = temp.next;
        }
        System.out.println("No Data found");
    }
public static void main(String[] args) {
    // quick demo
    insert(10);
    insertAtStart(5);
    insertAtEnd(20);
    insertAtEnd(3);
    display(); // expected: 5 10 20

    deleteByValue(5); 
    deleteByValue(20); 
    display(); // expected: 10

    deleteByValue(10); 
    display(); 
}
}