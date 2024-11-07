package TBasicSort;


import java.util.Arrays;

public class Main {
    // Run nested for loop
    public static void bubbleSort(int[] arr){
        for(int i=0; i< arr.length; i++){
            for(int j=i+1; j < arr.length;j++){
                if(arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    // Select minvalue and swap with starting index
    public static void selectionSort(int[] arr){
        for(int i=0; i< arr.length;i++){
            int minValue = i;
            for(int j=i+1; j < arr.length;j++){
                if(arr[j]< arr[minValue]){
                    minValue=j;
                }
            }
            if(minValue != i){
                int temp = arr[minValue];
                arr[minValue]= arr[i];
                arr[i]= temp;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    // select i swap with previous all nodes less than the current ones
    public static void insertionSort(int[] arr){
        for(int i=1; i< arr.length; i++){
            int temp = arr[i];
            int j= i-1;
            while(j> 0 && arr[i]< arr[j]){
                int t = arr[i];
                arr[i]=arr[j];
                arr[j]=t;
                j--;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
            int[] arr= {2, 13, 4, 1, 9, 23, 0};
        bubbleSort(arr);
        selectionSort(arr);
        insertionSort(arr);
    }
}
