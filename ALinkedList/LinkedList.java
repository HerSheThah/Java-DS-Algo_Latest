package ALinkedList;


public class LinkedList {
    Node head;
    Node tail;
    int length=0;

    LinkedList(int value){
        append(value);
    }
    LinkedList(){}

    public void append(int value){
        System.out.println("****Append****");
        var newNode = new Node(value);
        if(length==0){
            head=tail= newNode;
            length++;
            return;
        }
        newNode.next= head;
        head= newNode;
        length++;
    }

    public void print(){
        System.out.println("****Print****");
        var temp= head;
        for(temp=head; temp!=null; temp=temp.next){
            System.out.print(temp.value + " => ");
        }
        System.out.println();
    }

    public int getLength(){
        System.out.println("****Length****");
        return length;
    }

    public Integer removeLast(){
        System.out.println("****Remove Last****");
        if(length==0){
            System.out.println("List is empty");
            return null;
        }
        if(length==1){
            var temp=head;
            head=tail=null;
            length--;
            return temp.value;
        }
        Node prev;
        Node cur;
        prev=cur=head;
        while(cur.next != null){
            prev=cur;
            cur=cur.next;
        }
        tail=prev;
        tail.next=null;
        length--;
        return prev.value;
    }

    public void prePend(int value) {
        var newNode = new Node(value);
        if(length==0){
            head=tail=newNode;
            length++;
            return;
        }
        tail.next= newNode;
        tail=newNode;
        length++;
    }

    public Integer removeFirst(){
        if(length==0) return null;
        var temp=head;
        if(length==1){
            head=tail=null;
            length--;
            return temp.value;
        }
        head=head.next;
        length--;
        return temp.value;
    }

    public void insert(int value, int pos){
        if(pos< 1 || pos> length+1)
            return;
        if(pos==1){
            append(value);
            return;
        }
        if(pos==length+1){
            prePend(value);
            return;
        }
        var newNode= new Node(value);
        Node prev;
        Node cur;
        prev=cur=head;
        for(int i=1; i<pos;i++){
            prev=cur;
            cur=cur.next;
        }
        prev.next=newNode;
        newNode.next= cur;
        length++;
    }

    public Integer remove(int pos){
        if(pos<1 || pos>length) return null;
        if(pos==1){
            return removeFirst();
        }
        if(pos==length)
        {
            return  removeLast();
        }
        Node prev;
        Node cur;
        prev=cur=head;
        for (int i=1; i<pos; i++){
            prev=cur;
            cur=cur.next;
        }
        prev.next= cur.next;
        length--;
        return cur.value;
    }
    public void reverse(){
        if(length==0 || length==1)
            return;
        Node prev=null;
        Node cur=head;
        Node nex=head;
        Node temp;
        while (nex != null){
            nex=nex.next;
            cur.next=prev;
            prev=cur;
            cur=nex;
        }
        tail=head;
        head=cur;
        tail.next=null;
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList(3);
        ll.append(12);
        ll.append(5);
        ll.print();
        System.out.println(ll.getLength());
        ll.removeLast();
        ll.print();
        ll.prePend(56);
        ll.prePend(434);
        ll.print();
        ll.removeFirst();
        ll.print();
        ll.insert(122, 3);
        ll.insert(3, 1);
        ll.insert(44, 4);
        ll.print();
//        System.out.println(ll.remove(3));
        ll.print();
        ll.reverse();
        ll.print();


    }
}


