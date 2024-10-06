package KSetProblems;

import java.util.*;

public class Main {

    // Remove duplicate
    public static List<Integer> removeDuplicates(List<Integer> myList){
        Set<Integer> set = new HashSet<>();
        for(int a:myList){
            set.add(a);
        }
        return new ArrayList<>(set);
    }

    // Has unique character
    public static boolean hasUniqueChars(String string){
        Set<Character> set= new HashSet<>();

        for(char s: string.toCharArray()){
            set.add(s);
        }
        if(set.size() == string.length())
            return true;
        return false;
    }

//     Find pairs
    public static List<int[]> findPairs(int[] arr1, int[] arr2, int target){
        List<int[]> result = new ArrayList<>();
        Set<Integer> arr1Set= new HashSet<>();
        for (int item: arr1){
            arr1Set.add(item);
        }

        for (int item : arr2){
            if(arr1Set.contains(target-item)){
                result.add(new int[]{item, target-item});
            }
        }
        return  result;
    }

    // Longest consecutive Integer
    public static int longestConsecutiveSequence(int[] nums){
        if(nums.length==0)
            return 0;
        Set<Integer> myset= new HashSet<>();
        for(int item:nums){
            myset.add(item);
        }
        int longStreak=1;
        for(int it:myset){
            int shortSt=1;
            int i=it;
            while(myset.contains(i+1)){
                shortSt++;
                i=i+1;
            }
            if(shortSt>longStreak){
                longStreak=shortSt;
            }
        }
        return longStreak;
    }

    public static void main(String[] args) {
        List<Integer> myList = List.of(1, 2, 3, 4, 1, 2, 5, 6, 7, 3, 4, 8, 9, 5);
        List<Integer> newList = removeDuplicates(myList);
        System.out.println(newList);
        /*
            EXPECTED OUTPUT:
            ----------------
            [1, 2, 3, 4, 5, 6, 7, 8, 9]

            (Order may be different as sets are unordered)
        */
        System.out.println(hasUniqueChars("abcdefg")); // should return true
        System.out.println(hasUniqueChars("hello")); // should return false
        System.out.println(hasUniqueChars("")); // should return true
        System.out.println(hasUniqueChars("0123456789")); // should return true
        System.out.println(hasUniqueChars("abacadaeaf")); // should return false
        /*
            EXPECTED OUTPUT:
            ----------------
            true
            false
            true
            true
            false
        */

        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {2, 4, 6, 8, 10};
        int target = 7;

        List<int[]> pairs = findPairs(arr1, arr2, target);
        for (int[] pair : pairs) {
            System.out.println(Arrays.toString(pair));
        }

        /*
            EXPECTED OUTPUT:
            ----------------
            [5, 2]
            [3, 4]
            [1, 6]

        */

        testLongestConsecutiveSequence("Consecutive Integers", new int[] {1, 2, 3, 4, 5}, 5);
        testLongestConsecutiveSequence("No Sequence", new int[] {1, 3, 5, 7, 9}, 1);
        testLongestConsecutiveSequence("Duplicates", new int[] {1, 2, 2, 3, 4}, 4);
        testLongestConsecutiveSequence("Negative Numbers", new int[] {1, 0, -1, -2, -3}, 5);
        testLongestConsecutiveSequence("Empty Array", new int[] {}, 0);
        testLongestConsecutiveSequence("Multiple Sequences", new int[] {1, 2, 3, 10, 11, 12, 13}, 4);
        testLongestConsecutiveSequence("Unordered Elements", new int[] {5, 1, 3, 4, 2}, 5);
        testLongestConsecutiveSequence("Single Element", new int[] {1}, 1);
        testLongestConsecutiveSequence("All Identical Elements", new int[] {2, 2, 2, 2, 2}, 1);

    }
    /**
     * Test method for longestConsecutiveSequence.
     * @param title Title of the test
     * @param nums Input array
     * @param expected Expected result
     */
    private static void testLongestConsecutiveSequence(String title, int[] nums, int expected) {
        System.out.println("Test: " + title);
        System.out.print("Testing array: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();

        int result = longestConsecutiveSequence(nums);
        System.out.println("Expected longest streak: " + expected);
        System.out.println("Actual longest streak: " + result);

        if (result == expected) {
            System.out.println("PASS\n");
        } else {
            System.out.println("FAIL\n");
        }
    }

}
