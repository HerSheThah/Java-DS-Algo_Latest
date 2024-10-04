package GBinarySearchTree;
public class BST {
    Node root;
    class Node{
        int value;
        Node left;
        Node right;
        Node(int value){
            this.value=value;
        }
    }
    BST(int value){
        Node newNode = new Node(value);
        root=newNode;
    }

    public void Insert(int value){
        Node newNode = new Node(value);
        if(root== null){
            newNode=root;
            return;
        }
        Node temp = root;
        while (true){
            if(value < temp.value){
                if(temp.left == null){
                    temp.left=newNode;
                    return;
                }
                temp= temp.left;
            }else{
                if(temp.right == null){
                    temp.right=newNode;
                    return;
                }
                temp=temp.right;
            }
        }
    }

    public boolean Contains(int value){
        if(root== null)
            return false;
        Node temp = root;
        while (temp!=null){
            if(value< temp.value){
                temp= temp.left;
            }else if(value>temp.value){
                temp=temp.right;
            }
            else if(value== temp.value)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        BST b= new BST(47);
        b.Insert(21);
        b.Insert(76);
        b.Insert(18);
        b.Insert(52);
        b.Insert(82);
        b.Insert(27);

        System.out.println(b.root.right.left.value);
        System.out.println(b.Contains(27));
        System.out.println(b.Contains(54));
    }
}
