package BLinkedlistProblems;

public class ReverseBetween {

    private Node head;
    private int length;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public ReverseBetween(int value) {
        Node newNode = new Node(value);
        head = newNode;
        length = 1;
    }

    public Node getHead() {
        return head;
    }

    public int getLength() {
        return length;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printAll() {
        if (length == 0) {
            System.out.println("Head: null");
        } else {
            System.out.println("Head: " + head.value);
        }
        System.out.println("Length:" + length);
        System.out.println("\nLinked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

    public void makeEmpty() {
        head = null;
        length = 0;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        length++;
    }

//    public void reverseBetween(int m, int n){
//        if(head == null)
//            return;
//        Node prev= head;
//        Node dummyHead = head;
//        for(int i=0; i<m ; i++){
//            prev = dummyHead;
//            dummyHead= dummyHead.next;
//        }
//        Node tail = dummyHead;
//        for(int j =0; j<(n-m); j++)
//        {
//            tail= tail.next;
//        }
//        Node end = tail.next;
//        int length = (n-m) +1;
//        Node temp =dummyHead;
//        dummyHead = tail;
//        tail=temp;
//        Node before = null;
//        Node after = temp.next;
//        for(int i=0; i<length;i++){
//            after=temp.next;
//            temp.next=before;
//            before = temp;
//            temp= after;
//        }
//        if(m == 0){
//            head= dummyHead;
//        }else{
//            prev.next= dummyHead;
//        }
//        tail.next= end;
//    }



























    public void reverseBetween(int m, int n){
        if(head==null || head.next==null)
            return;
        if(m<0 || n>= length)
            return;
        Node dummyHead;
        Node dummyTail;
        Node before;
        Node after;
        Node cur= head;
        Node prev= null;
        int i=0;
        // Finding start and end nodes to reverse
        while(i<m){
            prev=cur;
            cur=cur.next;
            i++;
        }
        dummyHead=cur;
        before=prev;
        while (i<=n){
            prev=cur;
            cur=cur.next;
            i++;
        }
        dummyTail= prev;
        after=cur;
        dummyTail.next=null;

        // Reverse the nodes
        Node p=null;
        Node c=dummyHead;
        Node nex= dummyHead;
        while (nex!=null){
            nex=nex.next;
            c.next=p;
            p=c;
            c=nex;
        }

        // Adding reversed list to original nodes
        if(before != null){
            before.next=p;
        }
        else{
            before=p;
            head=before;
        }
        dummyHead.next=after;
    }



    public static void main(String[] args) {

        // Create a linked list with values 1, 2, 3, 4, and 5
        ReverseBetween myLinkedList = new ReverseBetween(1);
        myLinkedList.append(2);
        myLinkedList.append(3);
        myLinkedList.append(4);
        myLinkedList.append(5);

        System.out.println("Original linked list: ");
        myLinkedList.printList();

//         Reverse a sublist within the linked list
        myLinkedList.reverseBetween(1, 3);
        System.out.println("\nReversed sublist (1, 3): ");
        myLinkedList.printList();

        // Reverse another sublist within the linked list
        myLinkedList.reverseBetween(2, 4);
        System.out.println("\nReversed entire linked list: ");
        myLinkedList.printList();

        // Reverse a sublist of length 1 within the linked list
        myLinkedList.reverseBetween(2, 2);
        System.out.println("\nReversed sublist of length 1 (2, 2): ");
        myLinkedList.printList();

        // Reverse an empty linked list
        ReverseBetween emptyList = new ReverseBetween(0);
        emptyList.makeEmpty();
        emptyList.reverseBetween(0, 0);
        System.out.println("\nReversed empty linked list: ");
        emptyList.printList();

        /*
            EXPECTED OUTPUT:
            ----------------
            Original linked list:
            1
            2
            3
            4
            5

            Reversed sublist (1, 3):
            1
            4
            3
            2
            5

            Reversed entire linked list:
            5
            2
            3
            4
            1

            Reversed sublist of length 1 (2, 2):
            5
            2
            3
            4
            1

            Reversed empty linked list:

        */

    }


}
