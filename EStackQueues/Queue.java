package EStackQueues;

public class Queue {
    class Node{
        int value;
        Node next;
        Node(int value){
            this.value= value;
        }
    }
    Node first;
    Node last;
    int length=0;
    Queue(){

    }
    Queue(int value){
        Node newNode = new Node(value);
        first=last=newNode;
        length++;
    }
    public void enqueue(int value){
        Node newNode = new Node(value);
        if(first==null){
            first=last=newNode;
            length++;
            return;
        }
        last.next=newNode;
        last=newNode;
        length++;
    }

    public Integer dequeue(){
        if(length==0)
            return null;
        if(first==last){
            first=last=null;
            length--;
            return null;
        }
        Node temp=first;
        first=first.next;
        length--;
        return temp.value;
    }

    public void print(){
        Node temp=first;
        while (temp!=null){
            System.out.print(temp.value + " => ");
            temp=temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.print();
        System.out.println(q.dequeue());
        q.print();
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        q.print();
    }
}
