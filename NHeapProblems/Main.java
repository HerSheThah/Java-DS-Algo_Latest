package NHeapProblems;

import java.util.ArrayList;
import java.util.List;

public class Main {
//    public static int findKthSmallest(int[] nums, int k){
//        Heap h = new Heap();
//        for(int val : nums){
//            h.insert(val);
//        }
//        List<Integer> myHeap=h.getHeap();
//        while (myHeap.size()> k){
//            h.remove();
//            myHeap= h.getHeap();
//        }
//        return h.remove();
//    }

    //  Kth Smallest Element in an Array
    public static Integer findKthSmallest(int[] nums, int k){
        Heap h = new Heap();
        for(int i:nums){
            h.insert(i);
        }
        int size=h.getHeap().size();
        while((size-k)>0){
            h.remove();
            k++;
        }
        return h.remove();
    }

    // Maximum Element in a Stream
    public static List<Integer> streamMax(int[] nums){
            Heap h = new Heap();
            List<Integer> result = new ArrayList<>();
            for(int i:nums){
                h.insert(i);
                result.add(h.getHeap().get(0));
            }
            return result;
    }












    public static void main(String[] args) {
//        // Test case 1
//        int[] nums1 = {7, 10, 4, 3, 20, 15};
//        int k1 = 3;
//        System.out.println("Test case 1:");
//        System.out.println("Expected output: 7");
//        System.out.println("Actual output: " + findKthSmallest(nums1, k1));
//        System.out.println();
//
//        // Test case 2
//        int[] nums2 = {2, 1, 3, 5, 6, 4};
//        int k2 = 2;
//        System.out.println("Test case 2:");
//        System.out.println("Expected output: 2");
//        System.out.println("Actual output: " + findKthSmallest(nums2, k2));
//        System.out.println();
//
//        // Test case 3
//        int[] nums3 = {9, 3, 2, 11, 7, 10, 4, 5};
//        int k3 = 5;
//        System.out.println("Test case 3:");
//        System.out.println("Expected output: 7");
//        System.out.println("Actual output: " + findKthSmallest(nums3, k3));
//        System.out.println();
//
//        // Test case 4
//        int[] nums4 = {1, 1, 1, 1,1 ,1};
//        int k4 = 2;
//        System.out.println("Test case 4:");
//        System.out.println("Expected output: 1");
//        System.out.println("Actual output: " + findKthSmallest(nums4, k4));
//        System.out.println();
//
//
//        /*
//            EXPECTED OUTPUT:
//            ----------------
//            Test case 1:
//            Expected output: 7
//            Actual output: 7
//
//            Test case 2:
//            Expected output: 2
//            Actual output: 2
//
//            Test case 3:
//            Expected output: 7
//            Actual output: 7
//
//        */



        // Test case 1
        int[] nums1 = {1, 5, 2, 9, 3, 6, 8};
        System.out.println("Test case 1:");
        System.out.println("Input: [1, 5, 2, 9, 3, 6, 8]");
        System.out.println("Expected output: [1, 5, 5, 9, 9, 9, 9]");
        System.out.println("Actual output: " + streamMax(nums1));
        System.out.println();

        // Test case 2
        int[] nums2 = {10, 2, 5, 1, 0, 11, 6};
        System.out.println("Test case 2:");
        System.out.println("Input: [10, 2, 5, 1, 0, 11, 6]");
        System.out.println("Expected output: [10, 10, 10, 10, 10, 11, 11]");
        System.out.println("Actual output: " + streamMax(nums2));
        System.out.println();

        // Test case 3
        int[] nums3 = {3, 3, 3, 3, 3};
        System.out.println("Test case 3:");
        System.out.println("Input: [3, 3, 3, 3, 3]");
        System.out.println("Expected output: [3, 3, 3, 3, 3]");
        System.out.println("Actual output: " + streamMax(nums3));
        System.out.println();

        /*
            EXPECTED OUTPUT:
            ----------------
            Test case 1:
            Input: [1, 5, 2, 9, 3, 6, 8]
            Expected output: [1, 5, 5, 9, 9, 9, 9]
            Actual output: [1, 5, 5, 9, 9, 9, 9]

            Test case 2:
            Input: [10, 2, 5, 1, 0, 11, 6]
            Expected output: [10, 10, 10, 10, 10, 11, 11]
            Actual output: [10, 10, 10, 10, 10, 11, 11]

            Test case 3:
            Input: [3, 3, 3, 3, 3]
            Expected output: [3, 3, 3, 3, 3]
            Actual output: [3, 3, 3, 3, 3]

        */

    }

}


