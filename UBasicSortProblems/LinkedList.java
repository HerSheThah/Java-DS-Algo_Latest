package UBasicSortProblems;

public class LinkedList {

    private Node head;
    private Node tail;
    private int length;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public LinkedList(int value) {
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

    public void makeEmpty() {
        head = null;
        tail = null;
        length = 0;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }
    public void bubbleSort(){
        if(length<2)
            return;
        Node temp = head;
        while (temp != null){
            Node t2= temp.next;
            while (t2 != null){
                if(t2.value< temp.value){
                    int t= temp.value;
                    temp.value= t2.value;
                    t2.value= t;
                }
                t2= t2.next;
            }
            temp= temp.next;
        }
    }

    public void selectionSort(){
        if (length<2)
            return;
        Node temp =head;
        while (temp != null){
            Node minNode = temp;
            Node nex= temp.next;
            while (nex != null){
                if(nex.value< minNode.value){
                    minNode= nex;
                }
                nex=nex.next;
            }
            if(minNode != temp){
                int t = minNode.value;
                minNode.value= temp.value;
                temp.value=t;
            }
            temp= temp.next;
        }
    }
    // Insertion sort
    public void insertionSort(){
            if(length<2)
                return;
           Node sortedHead = head;
           Node unsortedHead = head.next;
           sortedHead.next=null;
           while (unsortedHead != null){
               Node cur = unsortedHead;
               unsortedHead= unsortedHead.next;
               if(cur.value< sortedHead.value){
                   cur.next= sortedHead;
                   sortedHead=cur;
               }else{
                   Node search = sortedHead;
                   while(search.next != null && cur.value> search.next.value){
                       search= search.next;
                   }
                   cur.next= search.next;
                   search.next=cur;

               }
           }
           head=sortedHead;
           Node temp = head;
           while(temp.next!=null){
               temp=temp.next;
           }
           tail=temp;
    }










//    public void bubbleSort(){
//        for(int i=0; i< length; i++){
//            Node cur= head;
//            while (cur != null && cur.next != null){
//                if(cur.value> cur.next.value){
//                    int temp = cur.value;
//                    cur.value= cur.next.value;
//                    cur.next.value= temp;
//                }
//                cur= cur.next;
//            }
//        }
//    }







}