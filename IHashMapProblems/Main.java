package IHashMapProblems;

import java.util.*;

public class Main {
//     Item common in 2 arrays
    public static boolean itemInCommon(int[] arr1, int[] arr2){
        HashMap<Integer, Boolean>hashMap=new HashMap<>();
        for (int i: arr1){
            hashMap.put(i, true);
        }
        for (int j : arr2){
            if(hashMap.get(j) != null){
                return true;
            }
        }
        return false;
    }

    // Duplicate value
    public static List<Integer> findDuplicates(int[] nums){
        HashMap<Integer, Integer> hashmap= new HashMap<>();
        for(int i:nums){
            Integer value=hashmap.get(i);
            if(value==null){
                hashmap.put(i, 1);
            }else{
                hashmap.put(i, ++value);
            }
        }
        ArrayList<Integer> output = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry: hashmap.entrySet()){
            int key=entry.getKey();
            int value=entry.getValue();
            if(value>1){
                output.add(key);
            }
        }
        return output;
    }

    // First non-repeating character
    public static Character firstNonRepeatingChar(String input){
        HashMap<Character, Integer> hashmap= new HashMap<>();
        for (char s : input.toCharArray()){
            Integer value = hashmap.get(s);
            if(value==null){
                hashmap.put(s, 1);
            }else{
                hashmap.put(s, ++value);
            }
        }
        for(char s: input.toCharArray()){
            if(hashmap.get(s)==1)
                return s;
        }
        return null;
    }

    // Grouping anagram together
    public static List<List<String>> groupAnagrams(String[] strings){
        HashMap<String, List<String>> hash=new HashMap<>();

        for (String s: strings){
            char[] charArr=s.toCharArray();
            Arrays.sort(charArr);
            var newkey =new String(charArr);
           List<String> hashValue = hash.get(newkey);
            if(hashValue != null){
                hashValue.add(s);
            }else{
                List<String> list = new ArrayList<String>();
                list.add(s);
                hash.put(newkey, list);
            }
        }
        return new ArrayList<>(hash.values());

    }

    // Two sum
    public static int[] twoSum(int[] nums, int target){
        HashMap<Integer, Integer> hashMap= new HashMap<>();
        for(int i=0; i< nums.length; i++){
            int remains = target- nums[i];
            Integer remainsValue=hashMap.get(remains);
            if(remainsValue !=null && remainsValue!=i){
                return new int[]{remainsValue, i};
            }else{
                hashMap.put(nums[i], i);

            }
        }
        return new int[]{};
    }
    // Sub arraysum [DOUBT STILL NOT CLEAR]
    public static int[] subarraySum(int[] nums, int target) {
        Map<Integer, Integer> sumIndex = new HashMap<>();
        sumIndex.put(0, -1);
        int currentSum = 0;

        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            if (sumIndex.containsKey(currentSum - target)) {
                return new int[]{sumIndex.get(currentSum - target) + 1, i};
            }
            sumIndex.put(currentSum, i);
        }

        return new int[]{};
    }


    public static void main(String[] args) {

        int[] array1 = {1, 3, 5};
        int[] array2 = {1};

        System.out.println(itemInCommon(array1, array2));

        /*
            EXPECTED OUTPUT:
            ----------------
            true

        */

        int[] nums = {1, 2, 3, 1, 0};
        List<Integer> duplicates = findDuplicates(nums);
        System.out.println(duplicates);

        /*
            EXPECTED OUTPUT:
            ----------------
			[1, 2, 4]

        */
        System.out.println(firstNonRepeatingChar("leetcode"));
        System.out.println(firstNonRepeatingChar("hello"));
        System.out.println(firstNonRepeatingChar("aabbcc"));

        /*
            EXPECTED OUTPUT:
            ----------------
            l
            h
            null

        */
        System.out.println("1st set:");
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));

        System.out.println("\n2nd set:");
        System.out.println(groupAnagrams(new String[]{"abc", "cba", "bac", "foo", "bar"}));

        System.out.println("\n3rd set:");
        System.out.println(groupAnagrams(new String[]{"listen", "silent", "triangle", "integral", "garden", "ranged"}));
        /*
            EXPECTED OUTPUT:
            ----------------
            1st set:
            [[eat, tea, ate], [tan, nat], [bat]]

            2nd set:
            [[abc, cba, bac], [foo], [bar]]

            3rd set:
            [[listen, silent], [triangle, integral], [garden, ranged]]

        */

        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 3}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 3, 4, 5}, 10)));
        System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 3, 4, 5}, 7)));
        System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 3, 4, 5}, 3)));
        System.out.println(Arrays.toString(twoSum(new int[]{}, 0)));

        /*
            EXPECTED OUTPUT:
            ----------------
            [0, 1]
            [1, 2]
            [0, 1]
            []
            [2, 3]
            [0, 1]
            []

        */

    }
}
