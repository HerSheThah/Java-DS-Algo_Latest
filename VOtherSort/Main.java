package VOtherSort;

import java.util.Arrays;

public class Main {

    public static int[] merge(int[] arr1, int[] arr2){
        int[] newArr = new int[arr1.length+ arr2.length];
        int i=0;
        int j =0;
        int k=0;
        while (i< arr1.length && j< arr2.length){
            if(arr1[i]< arr2[j]){
                newArr[k]=arr1[i];
                i++;
                k++;
            }
            else{
                newArr[k]=arr2[j];
                j++;
                k++;
            }
        }
        while(i< arr1.length){
            newArr[k]= arr1[i];
            i++;
            k++;
        }
        while (j < arr2.length){
            newArr[k]=arr2[j];
            j++;
            k++;
        }
        return newArr;
    }
    public static int[] mergeSort(int[] arr){
        if(arr.length==1)
            return arr;
        int mid = arr.length/2;
        int[] left = mergeSort(Arrays.copyOfRange(arr,0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr,mid, arr.length));
        return merge(left, right);

    }

    public static void quickSort(int[] arr){
        quickSortHelper(arr, 0, arr.length-1);
    }
    private static void quickSortHelper(int[] arr, int left, int right){
        if(left< right){
            int pivot = pivot(arr, left, right);
            quickSortHelper(arr, left, pivot-1);
            quickSortHelper(arr, pivot+1, right);
        }
    }

    private static void swap(int[] array, int firstIndex, int secondIndex) {
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }


    public static int pivot(int[] arr, int left, int right){
        int swap = left;
        for(int i=left+1; i<=right;i++){
            if(arr[i]< arr[left]){
                swap++;
                swap(arr, i, swap);
            }
        }
        swap(arr, left, swap);
        return swap;
    }

    public static void main(String[] args) {

//        int[] array1 = {1,3,7,8};
//        int[] array2 = {2,4,5,6};
//
//        System.out.println( Arrays.toString( merge(array1, array2) ) );
//
//        /*
//            EXPECTED OUTPUT:
//            ----------------
//            [1, 2, 3, 4, 5, 6, 7, 8]
//
//         */

//        int[] originalArray = {3,1,4,2};
//
//        int [] sortedArray = mergeSort(originalArray);
//
//        System.out.println( "Original Array: " + Arrays.toString( originalArray ) );
//
//        System.out.println( "\nSorted Array: " + Arrays.toString( sortedArray ) );
//
//        /*
//            EXPECTED OUTPUT:
//            ----------------
//            Original Array: [3, 1, 4, 2]
//
//            Sorted Array: [1, 2, 3, 4]
//
//         */

        int[] arr= {4, 1, 9, 10, 23, 5};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));

    }
}
