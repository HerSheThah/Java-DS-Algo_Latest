package RTreeTraversal;

public class Main {
    public static void main(String[] args) {
        TreeTraversal bst = new TreeTraversal(47);
        bst.Insert(21);
        bst.Insert(76);
        bst.Insert(18);
        bst.Insert(27);
        bst.Insert(52);
        bst.Insert(82);
        System.out.println(bst.BFS());
        System.out.println(bst.preOrder());
        System.out.println(bst.postOrder());
        System.out.println(bst.inOrder());
    }
}
