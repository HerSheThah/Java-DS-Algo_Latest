package YArrayProblems;

import java.util.Arrays;




public class Main {

//1. Array: Remove Element
public static int removeElement(int[] nums, int val){
    int i=0;
    for(int j=0; j< nums.length; j++){
        if(nums[j]!= val){
            nums[i]=nums[j];
            i++;
        }
    }
    return i;
}
//2. Find Min max
public static int[] findMaxMin(int[] arr){
    int[] result = new int[2];
    if(arr.length>0){
        Arrays.fill(result, arr[0]);
        for (int j : arr) {
            if (j < result[1]) {
                result[1] = j;
            } else if (j > result[0]) {
                result[0] = j;
            }
        }
    }
    return result;
}
//3. Longest string
public static String findLongestString(String[] arr){
    String res="";
    for(String s: arr){
        if(s.length() > res.length()){
            res=s;
        }
    }
    return res;
}
//4. Remove duplicate
public static int removeDuplicates(int[] arr){
    if(arr.length >0){
        int i=1;
        for(int j=1; j < arr.length; j++){
            if(arr[j]!= arr[j-1]){
                arr[i]=arr[j];
                i++;
            }
        }
                return i;
    }
    return 0;
}
//5. Max Profit
    public static int maxProfit(int[] arr){
    int maxProfit =0;
    int minval= arr[0];

    for(int i=1; i<arr.length; i++){
        int curval = arr[i];
        int curProfit= curval- minval;
        if(curProfit > maxProfit){
            maxProfit=curProfit;
        }
        if(curval< minval)
            minval= curval;
    }
    return maxProfit;
}
// 6. Array rotate
public static void rotate(int[] arr, int k){
    if(arr.length<2)
        return;
    k =arr.length -( k%arr.length);
    while (k>0){
        int last = arr[0];
        for(int i=0; i<arr.length-1; i++){
            arr[i]=arr[i+1];
        }
        arr[arr.length-1]=last;
        k--;
    }
}
//7. Max Sub Array sum
    public static int maxSubarray(int[] arr){
    if(arr.length==0)
        return 0;
    if(arr.length==1)
        return arr[0];
    int maxsum = arr[0];
    int cursum = arr[0];
    for(int i=1; i< arr.length; i++){
        if(arr[i] > cursum+arr[i]){
            cursum= arr[i];
        }else{
            cursum+= arr[i];
        }
        if(cursum > maxsum){
            maxsum= cursum;
        }
    }
    return  maxsum;

}

    public static void main(String[] args) {
//        // Test case 1
//        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
//        int val1 = 1;
//        int newLength1 = removeElement(nums1, val1);
//        System.out.println("Test case 1: Modified array: " +
//                Arrays.toString(Arrays.copyOfRange(nums1, 0, newLength1)) +
//                "\nNew length: " + newLength1);
//
//        // Test case 2
//        int[] nums2 = {1, 2, 3, 4, 5, 6};
//        int val2 = 6;
//        int newLength2 = removeElement(nums2, val2);
//        System.out.println("Test case 2: Modified array: " +
//                Arrays.toString(Arrays.copyOfRange(nums2, 0, newLength2)) +
//                "\nNew length: " + newLength2);
//
//        // Test case 3
//        int[] nums3 = {-1, -2, -3, -4, -5};
//        int val3 = -1;
//        int newLength3 = removeElement(nums3, val3);
//        System.out.println("Test case 3: Modified array: " +
//                Arrays.toString(Arrays.copyOfRange(nums3, 0, newLength3)) +
//                "\nNew length: " + newLength3);
//
//        // Test case 4
//        int[] nums4 = {};
//        int val4 = 1;
//        int newLength4 = removeElement(nums4, val4);
//        System.out.println("Test case 4: Modified array: " +
//                Arrays.toString(Arrays.copyOfRange(nums4, 0, newLength4)) +
//                "\nNew length: " + newLength4);
//
//        // Test case 5
//        int[] nums5 = {1, 1, 1, 1, 1};
//        int val5 = 1;
//        int newLength5 = removeElement(nums5, val5);
//        System.out.println("Test case 5: Modified array: " +
//                Arrays.toString(Arrays.copyOfRange(nums5, 0, newLength5)) +
//                "\nNew length: " + newLength5);

        System.out.println("**********************************************************************");

//        int[] myList1 = {5, 3, 8, 1, 6, 9};
//        int[] result1 = findMaxMin(myList1);
//        System.out.println("Test case 1: MaxMin: " + Arrays.toString(result1)); // prints "[9, 1]"
//
//        int[] myList2 = {-5, -3, -8, -1, -6, -9};
//        int[] result2 = findMaxMin(myList2);
//        System.out.println("Test case 2: MaxMin: " + Arrays.toString(result2)); // prints "[-1, -9]"
//
//        int[] myList3 = {0, 0, 0, 0, 0};
//        int[] result3 = findMaxMin(myList3);
//        System.out.println("Test case 3: MaxMin: " + Arrays.toString(result3)); // prints "[0, 0]"
//
//        int[] myList4 = {100, 200, 300, 400, 500};
//        int[] result4 = findMaxMin(myList4);
//        System.out.println("Test case 4: MaxMin: " + Arrays.toString(result4)); // prints "[500, 100]"

        /*
            EXPECTED OUTPUT:
            ----------------
            Test case 1: MaxMin: [9, 1]
            Test case 2: MaxMin: [-1, -9]
            Test case 3: MaxMin: [0, 0]
            Test case 4: MaxMin: [500, 100]
        */

        System.out.println("**********************************************************************");

        String[] stringList1 = {"apple", "banana", "kiwi", "pear"};
        String longest1 = findLongestString(stringList1);
        System.out.println("Test case 1: Longest string: " + longest1);  // prints "banana"

        String[] stringList2 = {"cat", "giraffe", "elephant", "hippopotamus"};
        String longest2 = findLongestString(stringList2);
        System.out.println("Test case 2: Longest string: " + longest2);  // prints "hippopotamus"

        String[] stringList3 = {"sun", "moon", "planet", "universe"};
        String longest3 = findLongestString(stringList3);
        System.out.println("Test case 3: Longest string: " + longest3);  // prints "universe"

        String[] stringList4 = {"java", "python", "javascript", "c"};
        String longest4 = findLongestString(stringList4);
        System.out.println("Test case 4: Longest string: " + longest4);  // prints "javascript"

        String[] stringList5 = {"", "a", "aa", "aaa"};
        String longest5 = findLongestString(stringList5);
        System.out.println("Test case 5: Longest string: " + longest5);  // prints "aaa"

        /*
            EXPECTED OUTPUT:
            ----------------
            Test case 1: Longest string: banana
            Test case 2: Longest string: hippopotamus
            Test case 3: Longest string: universe
            Test case 4: Longest string: javascript
            Test case 5: Longest string: aaa
        */
        System.out.println("**********************************************************************");

//        int[] nums1 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
//        int newLength1 = removeDuplicates(nums1);
//        System.out.println("Test case 1: New length: " + newLength1);
//        System.out.println("Test case 1: Unique values in list: " + Arrays.toString(Arrays.copyOfRange(nums1, 0, newLength1)));
//
//        int[] nums2 = {1, 1, 2};
//        int newLength2 = removeDuplicates(nums2);
//        System.out.println("Test case 2: New length: " + newLength2);
//        System.out.println("Test case 2: Unique values in list: " + Arrays.toString(Arrays.copyOfRange(nums2, 0, newLength2)));
//
//        int[] nums3 = {-1, 0, 0, 0, 3, 3};
//        int newLength3 = removeDuplicates(nums3);
//        System.out.println("Test case 3: New length: " + newLength3);
//        System.out.println("Test case 3: Unique values in list: " + Arrays.toString(Arrays.copyOfRange(nums3, 0, newLength3)));
//
//        int[] nums4 = {};
//        int newLength4 = removeDuplicates(nums4);
//        System.out.println("Test case 4: New length: " + newLength4);
//        System.out.println("Test case 4: Unique values in list: " + Arrays.toString(Arrays.copyOfRange(nums4, 0, newLength4)));
//
//        int[] nums5 = {1, 1, 1, 1, 1};
//        int newLength5 = removeDuplicates(nums5);
//        System.out.println("Test case 5: New length: " + newLength5);
//        System.out.println("Test case 5: Unique values in list: " + Arrays.toString(Arrays.copyOfRange(nums5, 0, newLength5)));
//
//        /*
//            EXPECTED OUTPUT:
//            ----------------
//            Test case 1: New length: 5
//            Test case 1: Unique values in list: [0, 1, 2, 3, 4]
//            Test case 2: New length: 2
//            Test case 2: Unique values in list: [1, 2]
//            Test case 3: New length: 3
//            Test case 3: Unique values in list: [-1, 0, 3]
//            Test case 4: New length: 0
//            Test case 4: Unique values in list: []
//            Test case 5: New length: 1
//            Test case 5: Unique values in list: [1]
//        */
        System.out.println("**********************************************************************");

        int[] prices1 = {7, 1, 5, 3, 6, 4};
        int profit1 = maxProfit(prices1);
        System.out.println("Test case 1: Maximum profit: " + profit1); // prints "Maximum profit: 5"

        int[] prices2 = {7, 6, 5, 4, 3, 2, 1};
        int profit2 = maxProfit(prices2);
        System.out.println("Test case 2: Maximum profit: " + profit2); // prints "Maximum profit: 0"

        int[] prices3 = {1, 2, 3, 4, 5, 6, 7};
        int profit3 = maxProfit(prices3);
        System.out.println("Test case 3: Maximum profit: " + profit3); // prints "Maximum profit: 6"

        int[] prices4 = {3, 2, 6, 5, 0, 3};
        int profit4 = maxProfit(prices4);
        System.out.println("Test case 4: Maximum profit: " + profit4); // prints "Maximum profit: 4"

        int[] prices5 = {2, 4, 1};
        int profit5 = maxProfit(prices5);
        System.out.println("Test case 5: Maximum profit: " + profit5); // prints "Maximum profit: 2"

        /*
            EXPECTED OUTPUT:
            ----------------
            Test case 1: Maximum profit: 5
            Test case 2: Maximum profit: 0
            Test case 3: Maximum profit: 6
            Test case 4: Maximum profit: 4
            Test case 5: Maximum profit: 2
        */

        System.out.println("**********************************************************************");

        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        int k1 = 3;
        rotate(nums1, k1);
        System.out.println("Test case 1: Rotated array: " + Arrays.toString(nums1));  // prints "Rotated array: [5, 6, 7, 1, 2, 3, 4]"

        int[] nums2 = {-1, -100, 3, 99};
        int k2 = 2;
        rotate(nums2, k2);
        System.out.println("Test case 2: Rotated array: " + Arrays.toString(nums2));  // prints "Rotated array: [3, 99, -1, -100]"

        int[] nums3 = {1, 2};
        int k3 = 3;
        rotate(nums3, k3);
        System.out.println("Test case 3: Rotated array: " + Arrays.toString(nums3));  // prints "Rotated array: [2, 1]"

        int[] nums4 = {1};
        int k4 = 0;
        rotate(nums4, k4);
        System.out.println("Test case 4: Rotated array: " + Arrays.toString(nums4));  // prints "Rotated array: [1]"

        int[] nums5 = {1, 2, 3, 4, 5, 6};
        int k5 = 6;
        rotate(nums5, k5);
        System.out.println("Test case 5: Rotated array: " + Arrays.toString(nums5));  // prints "Rotated array: [1, 2, 3, 4, 5, 6]"

        /*
            EXPECTED OUTPUT:
            ----------------
            Test case 1: Rotated array: [5, 6, 7, 1, 2, 3, 4]
            Test case 2: Rotated array: [3, 99, -1, -100]
            Test case 3: Rotated array: [2, 1]
            Test case 4: Rotated array: [1]
            Test case 5: Rotated array: [1, 2, 3, 4, 5, 6]
        */

        System.out.println("**********************************************************************");


        // Example 1: Simple case with positive and negative numbers
        int[] inputCase1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result1 = maxSubarray(inputCase1);
        System.out.println("Example 1: Input: " + Arrays.toString(inputCase1) + "\nResult: " + result1);

        // Example 2: Case with a negative number in the middle
        int[] inputCase2 = {1, 2, 3, -4, 5, 6};
        int result2 = maxSubarray(inputCase2);
        System.out.println("Example 2: Input: " + Arrays.toString(inputCase2) + "\nResult: " + result2);

        // Example 3: Case with all negative numbers
        int[] inputCase3 = {-1, -2, -3, -4, -5};
        int result3 = maxSubarray(inputCase3);
        System.out.println("Example 3: Input: " + Arrays.toString(inputCase3) + "\nResult: " + result3);

        // Example 4: Case with all positive numbers
        int[] inputCase4 = {1, 2, 3, 4, 5};
        int result4 = maxSubarray(inputCase4);
        System.out.println("Example 4: Input: " + Arrays.toString(inputCase4) + "\nResult: " + result4);

        // Example 5: Case with alternating positive and negative numbers
        int[] inputCase5 = {1, -1, 1, -1, 1};
        int result5 = maxSubarray(inputCase5);
        System.out.println("Example 5: Input: " + Arrays.toString(inputCase5) + "\nResult: " + result5);

        /*
            EXPECTED OUTPUT:
            ----------------
            Example 1: Input: [-2, 1, -3, 4, -1, 2, 1, -5, 4]
            Result: 6
            Example 2: Input: [1, 2, 3, -4, 5, 6]
            Result: 13
            Example 3: Input: [-1, -2, -3, -4, -5]
            Result: -1
            Example 4: Input: [1, 2, 3, 4, 5]
            Result: 15
            Example 5: Input: [1, -1, 1, -1, 1]
            Result: 1
        */

    }

}


