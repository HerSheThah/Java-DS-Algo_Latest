package BLinkedlistProblems;
// Find kth node from the end

public class FindKthNode {

    private Node head;
    private Node tail;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public FindKthNode(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printAll() {
        if (head == null) {
            System.out.println("Head: null");
            System.out.println("Tail: null");
        } else {
            System.out.println("Head: " + head.value);
            System.out.println("Tail: " + tail.value);
        }
        System.out.println("\nLinked List:");
        if (head == null) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

    public void makeEmpty() {
        head = null;
        tail = null;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }
    public void reverse(){
        if(head== null)
            return;
        Node temp = head;
        head= tail;
        tail = temp;
        Node before= null;
        Node after=temp.next;
        while(temp != null){
            after=temp.next;
            temp.next=before;
            before = temp;
            temp= after;
        }
    }

//    public Node findKthFromEnd(int pos){
//        reverse();
//        Node temp=head;
//
//        for(int i=1; i<pos && temp!= null;i++){
//            temp=temp.next;
//        }
//        return temp;
//    }

    public Node findKthFromEnd(int pos){
        if(pos == 0)
            return null;
        reverse();
        Node temp=head;
        for(int i=1; i<pos; i++){
            temp=temp.next;
        }
        return temp;

    }

    public static void main(String[] args) {
        FindKthNode myLinkedList = new FindKthNode(1);
        myLinkedList.append(2);
        myLinkedList.append(3);
        myLinkedList.append(4);
        myLinkedList.append(5);

        int k = 2;
        int result = myLinkedList.findKthFromEnd(k).value;

        System.out.println(result); // Output: 4

        /*
            EXPECTED OUTPUT:
            ----------------
            4

        */

    }


}

