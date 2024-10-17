package QRBSTProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

//        // Test: Convert an empty array
//        System.out.println("\n----- Test: Convert Empty Array -----\n");
//        checkBalancedAndCorrectTraversal(new int[]{}, Arrays.asList());
//
//        // Test: Convert an array with one element
//        System.out.println("\n----- Test: Convert Single Element Array -----\n");
//        checkBalancedAndCorrectTraversal(new int[]{10}, Arrays.asList(10));
//
//        // Test: Convert a sorted array with odd number of elements
//        System.out.println("\n----- Test: Convert Sorted Array with Odd Number of Elements -----\n");
//        checkBalancedAndCorrectTraversal(new int[]{1, 2, 3, 4, 5}, Arrays.asList(1, 2, 3, 4, 5));
//
//        // Test: Convert a sorted array with even number of elements
//        System.out.println("\n----- Test: Convert Sorted Array with Even Number of Elements -----\n");
//        checkBalancedAndCorrectTraversal(new int[]{1, 2, 3, 4, 5, 6}, Arrays.asList(1, 2, 3, 4, 5, 6));
//
//        // Test: Convert a large sorted array
//        System.out.println("\n----- Test: Convert Large Sorted Array -----\n");
//        checkBalancedAndCorrectTraversal(
//                Arrays.stream(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}).toArray(),
//                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15));


        testInvertBinarySearchTree();
    }


    private static void checkBalancedAndCorrectTraversal(int[] nums, List<Integer> expectedTraversal) {
        SortedArrayToBST bst = new SortedArrayToBST();
        bst.sortedArrayToBST(nums);
        boolean isBalanced = bst.isBalanced();
        List<Integer> inorder = bst.inorderTraversal();
        System.out.println("Is balanced: " + isBalanced);
        System.out.println("Inorder traversal: " + inorder);
        System.out.println("Expected traversal: " + expectedTraversal);
        if (isBalanced && inorder.equals(expectedTraversal)) {
            System.out.println("PASS: Tree is balanced and inorder traversal is correct.\n");
        } else {
            System.out.println("FAIL: Tree is either not balanced or inorder traversal is incorrect.\n");
        }
    }
    private static void performTest(String description, int[] insertValues, Integer[] expectedValues, boolean doubleInversion) {
        InvertBinaryTree bst = new InvertBinaryTree();
        for (int value : insertValues) {
            bst.insert(value);
        }
        if (doubleInversion) {
            bst.invert(); // First inversion
        }
        bst.invert(); // Perform inversion (or second inversion for the specific case)

        ArrayList<Integer> resultList = bst.BFS();

        // Use Arrays.asList for compatibility with older Java versions
        List<Integer> expectedList = new ArrayList<>(Arrays.asList(expectedValues));

        System.out.println(description + ": " + (expectedList.equals(resultList) ? "Pass" : "Fail"));
        System.out.println("Expected: " + expectedList);
        System.out.println("Actual:   " + resultList);
    }

    private static void testInvertBinarySearchTree() {
        System.out.println("--- Testing Inversion of Binary Search Tree ---");

        performTest("Invert an empty tree", new int[]{}, new Integer[]{}, false);
        performTest("Invert a tree with a single node", new int[]{1}, new Integer[]{1}, false);
        performTest("Invert a tree with only a left child", new int[]{2, 1}, new Integer[]{2, null, 1}, false);
        performTest("Invert a tree with only a right child", new int[]{1, 2}, new Integer[]{1, 2}, false);
        performTest("Invert a full binary tree", new int[]{2, 1, 3}, new Integer[]{2, 3, 1}, false);
        performTest("Invert a more complex binary tree", new int[]{4, 2, 6, 1, 3, 5, 7}, new Integer[]{4, 6, 2, 7, 5, 3, 1}, false);
        performTest("Double inversion returns original", new int[]{3, 1, 4}, new Integer[]{3, 1, 4}, true);
    }

}

