package CDoublyLinkedList;

public class DoublyLinkedList {
    int length;
    Node head;
    Node tail;

    class Node{
        int value;
        Node prev;
        Node next;
        Node(int value){
            this.value=value;
        }
    }
    public DoublyLinkedList(){

    }
    public DoublyLinkedList(int value){
        var newNode = new Node(value);
        head=tail=newNode;
        length++;
    }

    public void print(){
        Node temp = head;
        while (temp!=null){
            System.out.print(temp.value + " => ");
            temp=temp.next;
        }
        System.out.println();
    }

    public void append(int value){
        Node newNode = new Node(value);
        if(head==null){
            head=tail=newNode;
            length++;
            return;
        }
        tail.next= newNode;
        newNode.prev= tail;
        tail=newNode;
        length++;
    }

    public Integer removeLast(){
        if(length==0){
            return null;
        }
        int temp = tail.value;
        if(length==1){
            head=tail=null;
        }else{
            tail.prev.next=null;
            tail=tail.prev;
        }
        length--;
        return temp;
    }

    public void prepend(int value){
        Node newNode = new Node(value);
        if(head==null){
            head=tail=newNode;
            length++;
            return;
        }
        head.prev=newNode;
        newNode.next=head;
        head=newNode;
        length++;
    }
    public Integer removeFirst(){
        if(length==0)
            return null;
        int temp = head.value;
        if(length==1)
            head=tail=null;
        else{
            head.next.prev=null;
            head=head.next;
        }
        length--;
        return temp;
    }

    public Integer get(int index){
        if(index< 0 || index>=length)
            return  null;
        Node temp = head;
        for(int i=0; i<index;i++){
            temp=temp.next;
        }
        return temp.value;
    }

    public void set(int index, int value){
        if(index< 0 || index>= length)
            return;
        Node temp = head;
        for(int i=0;i<index;i++){
            temp=temp.next;
        }
        temp.value= value;

    }

    public void insert(int index, int value){
        if(index<0 || index>length)
            return;
        if(index==0){
            prepend(value);
            return;
        }
        if(index==length){
            append(value);
            return;
        }
        Node newNode = new Node(value);
        Node cur= head;
        Node prev= cur;
        for(int i=0; i< index; i++){
            prev=cur;
            cur=cur.next;
        }
        prev.next= newNode;
        cur.prev= newNode;
        newNode.prev=prev;
        newNode.next=cur;
        length++;
    }
    
    public Integer remove(int index){
        if(index<0 || index>=length)
            return null;
        if(index==0){
         return removeFirst();
        }
        if(index==length-1)
            return removeLast();
        Node cur=head;
        Node prev=cur;
        for(int i=0; i<index;i++){
            prev=cur;
            cur=cur.next;
        }
        prev.next=cur.next;
        cur.next.prev=prev;
        length--;
        return cur.value;
    }


    public static void main(String[] args) {
//        DoublyLinkedList ll = new DoublyLinkedList(5);
        DoublyLinkedList ll = new DoublyLinkedList();
        ll.print();
        ll.append(4);
        ll.append(3);
        ll.append(34);
        ll.print();
        System.out.println(ll.removeLast());
        System.out.println(ll.removeLast());
        ll.print();
        ll.prepend(23);
        ll.prepend(5);
        ll.prepend(90);
        ll.print();
        System.out.println(ll.removeFirst());
        ll.print();
        System.out.println(ll.get(2));
        ll.set(-1, 322);
        ll.print();
        ll.insert(1, 234);
        ll.insert(2, 34);
        ll.print();
        System.out.println(ll.remove(0));
        System.out.println(ll.remove(2));
        System.out.println(ll.remove(3));
        ll.print();
    }
}
