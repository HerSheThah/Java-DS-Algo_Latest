package PRecursiveBST;


public class rBST {
    private Node root;
    class Node {
        public int value;
        public Node left;
        public Node right;

        Node(int value) {
            this.value = value;
        }
    }

    public Node getRoot() {
        return root;
    }

    public boolean insert(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            return true;
        }
        Node temp = root;
        while (true) {
            if (newNode.value == temp.value) return false;
            if (newNode.value < temp.value) {
                if (temp.left == null) {
                    temp.left = newNode;
                    return true;
                }
                temp = temp.left;
            } else {
                if (temp.right == null) {
                    temp.right = newNode;
                    return true;
                }
                temp = temp.right;
            }
        }
    }


    public boolean rContains(int value)
    {
        return rContains(root, value);
    }

    private boolean rContains(Node root, int value){
        if(root == null)
            return false;
        if(root.value == value)
            return true;
        if(value< root.value)
            return rContains(root.left, value);
        return  rContains(root.right, value);
    }
    private Node rInsert(Node root, int value){
        if(root==null)
            return new Node(value);
        if(value< root.value)
            root.left= rInsert(root.left, value);
        else {
            root.right = rInsert(root.right, value);
        }
        return root;

    }
    public Node rDelete(int value){
         return rDelete(root, value);
    }
    private Node rDelete(Node root, int value){
        if(root ==null)
            return null;
        if(value< root.value){
            root.left=rDelete(root.left, value);
        }else if (value> root.value){
            root.right=rDelete(root.right, value);
        }
        else {
            if(root.left == null && root.right == null){
               return null;
            }if(root.left== null)
                root=  root.right;
            if(root.right== null)
                root= root.left;
            else{
                int minValue = minValue(root.right);
                root.value= minValue;
                root.right= rDelete(root.right, minValue);
            }
        }
        return root;
    }

    public int minValue(Node curNode){
        while (curNode.left!=null){
            curNode=curNode.left;
        }
        return curNode.value;
    }

    public Node rInsert(int value){
        if(root== null){
            root= new Node(value);
            return root;
        }
        return rInsert(root, value);
    }

    public static void main(String[] args) {
        rBST r= new rBST();
        r.rInsert(56);
        r.rInsert(90);
        r.rInsert(4);
        r.rInsert(16);
        r.rInsert(34);
        r.rInsert(12);
//        r.rDelete(16);
        System.out.println(r.root.left.right.right.value);
        System.out.println(r.minValue(r.root.left.right.right));
    }


}


