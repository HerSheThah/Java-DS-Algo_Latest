package EStackQueues;

public class Stack {
    class Node{
        int value;
        Node next;
        Node(int value){
            this.value=value;
        }
    }
    Node top;
    int height =0;
    Stack(){

    }
    Stack(int value){
        Node newNode= new Node(value);
        top=newNode;
        height++;
    }
    public void push(int value){
        Node newNode = new Node(value);
        if(top== null){
            top=newNode;
            height++;
            return;
        }
        newNode.next=top;
        top=newNode;
        height++;
    }

    public Integer pop(){
        if(top== null)
            return null;
        Node temp= top;
        top=top.next;
        height--;
        return temp.value;
    }

    public void print(){
        Node temp=top;
        while (temp!=null){
            System.out.print(temp.value + " => ");
            temp=temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        s.print();
        System.out.println(s.pop());
        s.print();

    }


}
