package MHeap;

import java.util.ArrayList;
import java.util.List;

public class Heap {
    private List<Integer> heapArray;
    Heap(){
        heapArray= new ArrayList<>();
    }
    private Integer leftNode(int index){
        return (index*2)+1;
    }
    private Integer rightNode(int index){
        return (index*2)+2;
    }
    private Integer parent(int index){
        return (index-1)/2;
    }

    private void swap(int currentIndex, Integer parent) {
        int temp = heapArray.get(parent);
        heapArray.set(parent, heapArray.get(currentIndex));
        heapArray.set(currentIndex, temp);
    }

    public void print(){
        System.out.println(heapArray);
    }

    // ********************** Max Heap **********************
//    public void insert(int value){
//        if (heapArray.size() ==0){
//            heapArray.add(value);
//            return;
//        }
//        heapArray.add(value);
//        int currentIndex= heapArray.size()-1;
//        while (heapArray.get(currentIndex) > heapArray.get(parent(currentIndex)) && currentIndex>0){
//            swap(currentIndex, parent(currentIndex));
//            currentIndex= parent(currentIndex);
//        }
//    }

//    public Integer remove(){
//        if(heapArray.size()==0)
//            return null;
//        if(heapArray.size()==1)
//            return heapArray.remove(0);
//        int maxVal = heapArray.get(0);
//        heapArray.set(0, heapArray.remove(heapArray.size()-1));
//        sinkDown(0);
//        return maxVal;
//
//    }
//    private void sinkDown(int index){
//        int maxIndex = index;
//        while (true){
//            int leftIndex = leftNode(index);
//            int rightIndex= rightNode(index);
//            if(leftIndex<heapArray.size() && heapArray.get(leftIndex) > heapArray.get(maxIndex)){
//                maxIndex=leftIndex;
//            }
//            if(rightIndex<heapArray.size() &&  heapArray.get(rightIndex) > heapArray.get(maxIndex)){
//                maxIndex=rightIndex;
//            }
//            if(maxIndex != index){
//                swap(index, maxIndex);
//                index=maxIndex;
//
//            }else{
//                return;
//            }
//
//        }
//    }
    // ********************** Min Heap**********************
    public void insert(int value){
        heapArray.add(value);
        int minIndex= heapArray.size()-1;
        while (heapArray.get(minIndex)< heapArray.get(parent(minIndex)) && minIndex>0){
            swap(minIndex, parent(minIndex));
            minIndex=parent(minIndex);
        }
    }

    public Integer remove(){
        if(heapArray.size()==0)
            return null;
        if (heapArray.size()==1){
            return heapArray.remove(heapArray.size()-1);
        }
        int minHeap = heapArray.get(0);
        heapArray.set(0, heapArray.remove(heapArray.size()-1));
        sinkUp(0);
        return minHeap;
    }

    public void sinkUp(int index){
        int minHeap=index;
        while (true){
            int leftNode = leftNode(minHeap);
            int rightNode = rightNode(minHeap);
            if(leftNode < heapArray.size() && heapArray.get(index)> heapArray.get(leftNode)){
                minHeap=leftNode;
            }
            if(rightNode < heapArray.size() &&  heapArray.get(index)> heapArray.get(rightNode)){
                minHeap=rightNode;
            }
            if(index != minHeap){
                swap(index, minHeap);
                index=minHeap;

            }else{
                return;
            }
        }
    }


    public static void main(String[] args) {
        Heap h = new Heap();
        h.insert(58);
        h.insert(61);
        h.insert(72);
        h.insert(99);
        h.print();
        h.remove();
        h.print();
        h.remove();
        h.print();
        h.remove();
        h.print();
        h.remove();
        h.print();
    }

}
