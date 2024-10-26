package RTreeTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TreeTraversal {
    Node root;
    class Node{
        int value;
        Node left;
        Node right;
        Node(int value){
            this.value=value;
        }
    }
    TreeTraversal(int value){
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

    public ArrayList<Integer> BFS(){
        Node curNode = root;
        Queue<Node> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        queue.add(curNode);
        while (queue.size()>0){
            Node temp=queue.remove();
            result.add(temp.value);
            if(temp.left != null){
                queue.add(temp.left);
            }
            if(temp.right != null){
                queue.add(temp.right);
            }
        }
        return result;
    }

    public ArrayList<Integer> preOrder(){
        ArrayList<Integer> result = new ArrayList<>();
        class Traversal{
            Traversal(Node curNode){
                result.add(curNode.value);
                if(curNode.left != null){
                    new Traversal(curNode.left);
                }
                if(curNode.right != null){
                    new Traversal(curNode.right);
                }
            }
        }
        new Traversal(root);
        return result;
    }
    public ArrayList<Integer> postOrder(){
        ArrayList<Integer> result = new ArrayList<>();
        class Traversal{
            Traversal(Node curNode){
                if(curNode.left != null){
                    new Traversal(curNode.left);
                }
                if(curNode.right != null){
                    new Traversal(curNode.right);
                }
                result.add(curNode.value);
            }
        }
        new Traversal(root);
        return result;
    }
    public ArrayList<Integer> inOrder(){
        ArrayList<Integer> result = new ArrayList<>();
        class Traversal{
            Traversal(Node curNode){
                if(curNode.left != null){
                    new Traversal(curNode.left);
                }
                result.add(curNode.value);
                if(curNode.right != null){
                    new Traversal(curNode.right);
                }
            }
        }
        new Traversal(root);
        return result;
    }


}