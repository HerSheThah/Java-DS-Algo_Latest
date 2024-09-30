package DDoublyLinkedListProblems;

public class PalindromeChecker {

    private Node head;
    private Node tail;
    private int length;

    class Node {
        int value;
        Node next;
        Node prev;

        Node(int value) {
            this.value = value;
        }
    }

    public PalindromeChecker(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
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
            System.out.println("Tail: null");
        } else {
            System.out.println("Head: " + head.value);
            System.out.println("Tail: " + tail.value);
        }
        System.out.println("Length:" + length);
        System.out.println("\nDoubly Linked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

    public void makeEmpty() {
        head = null;
        tail = null;
        length = 0;
    }

    public void append (int value) {
        Node newNode = new Node(value);
        if(length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        length++;
    }

//    public boolean isPalindrome(){
//        if(length <= 1)
//            return true;
//        Node value1= head;
//        Node value2= tail;
//        for(int i=0; i< length /2 ; i++){
//            if(value1.value != value2.value)
//                return false;
//            value1= value1.next;
//            value2= value2.prev;
//        }
//        return true;
//    }



    public boolean isPalindrome(){
        Node t1=head;
        Node t2=tail;
        while (t1 != t2){
            if(t1.value != t2.value)
                return false;
            t1= t1.next;
            t2=t2.prev;
        }
        return true;
    }










    public static void main(String[] args) {

        PalindromeChecker myDLL1 = new PalindromeChecker(1);
        myDLL1.append(2);
        myDLL1.append(3);
        myDLL1.append(3);
        myDLL1.append(2);
        myDLL1.append(1);

        System.out.println("myDLL1 isPalindrome:");
        System.out.println( myDLL1.isPalindrome() );



        PalindromeChecker myDLL2 = new PalindromeChecker(1);
        myDLL2.append(2);
        myDLL2.append(3);

        System.out.println("\nmyDLL2 isPalindrome:");
        System.out.println( myDLL2.isPalindrome() );



        /*
       		EXPECTED OUTPUT:
        	----------------
            DLL before swap:
            1
            2
            3
            4
            5

            DLL after swap:
            5
            2
            3
            4
            1

     	*/

    }


}

