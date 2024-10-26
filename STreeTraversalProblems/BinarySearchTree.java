package STreeTraversalProblems;


import java.util.ArrayList;


public class BinarySearchTree {

    public Node root;

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        private Node(int value) {
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

    public ArrayList<Integer> DFSInOrder() {
        ArrayList<Integer> results = new ArrayList<>();

        class Traverse {
            Traverse(Node currentNode) {
                if (currentNode.left != null) {
                    new Traverse(currentNode.left);
                }
                results.add(currentNode.value);
                if (currentNode.right != null) {
                    new Traverse(currentNode.right);
                }
            }
        }

        new Traverse(root);
        return results;
    }
    // Valid BST
    public boolean isValidBST(){
        ArrayList<Integer> sortedList = DFSInOrder();
        for(int i=1; i< sortedList.size();i++){
            if(sortedList.get(i)< sortedList.get(i-1))
                return false;
        }
        return true;
    }
    // Kth smallest
    public Integer kthSmallest(int k){

        ArrayList<Integer> res = DFSInOrder();
        if(k <= 0 || k > res.size()){
            return null;
        }
        return res.get(k-1);
    }


}