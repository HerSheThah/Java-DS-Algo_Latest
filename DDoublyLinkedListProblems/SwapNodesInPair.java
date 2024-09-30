package DDoublyLinkedListProblems;

public class SwapNodesInPair {

    private Node head;
    private int length;

    class Node {
        int value;
        Node next;
        Node prev;

        Node(int value) {
            this.value = value;
        }
    }

    public SwapNodesInPair(int value) {
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
        StringBuilder output = new StringBuilder();
        Node temp = head;
        Node tail=null;
        while (temp != null) {
            output.append(temp.value);
            if (temp.next != null) {
                output.append(" <-> ");
            }else{
                tail=temp;
            }
            temp = temp.next;
        }
        System.out.println(output.toString());

        StringBuilder output2 = new StringBuilder();

        while (tail != null) {
            output2.append(tail.value);
            if (tail.prev != null) {
                output2.append(" <-> ");
            }
            tail = tail.prev;
        }
        System.out.println(output2.toString());
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
            newNode.prev = current;
        }
        length++;
    }

//    public void swapPairs(){
//        if(length <= 1)
//            return;
//        Node dummy = new Node(0);
//        dummy.next=head;
//        Node prev= dummy;
//        while(head != null && head.next != null)
//        {
//            Node first = head;
//            Node second = head.next;
//            prev.next= second;
//            first.next= second.next;
//            second.next= first;
//            second.prev= prev;
//            first.prev=second;
//            if(first.next != null)
//                first.next.prev=first;
//            head= first.next;
//            prev=first;
//
//        }
//        head=dummy.next;
//        head.prev=null;
//    }
    public void swapPairs(){
        if(length<2)
            return;
        Node dummy=new Node(0);
        dummy.next=head.next;
        Node cur=head;
        while(cur != null && cur.next != null){
            Node first=cur;
            Node second=cur.next;
            first.next= second.next;
            Node dummyP = first.prev;

            first.prev= second;
            second.prev= dummyP;
            second.next=first;
            if(dummyP != null){
                dummyP.next=second;
            }
            if(first.next != null){
                first.next.prev=first;
            }
            cur= first.next;
        }
        head=dummy.next;
    }
    public static void main(String[] args) {

        SwapNodesInPair myDll = new SwapNodesInPair(1);
        myDll.append(2);
        myDll.append(3);

        System.out.println("myDll before swapPairs:");
        myDll.printList();

        myDll.swapPairs();

        System.out.println("\nmyDll after swapPairs:");
        myDll.printList();

        /*
            EXPECTED OUTPUT:
            ----------------
            myDll before swapPairs:
            1 <-> 2 <-> 3 <-> 4

            myDll after swapPairs:
            2 <-> 1 <-> 4 <-> 3

        */

    }

}

