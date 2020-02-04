package otherSorts;

import java.util.Arrays;
import java.util.Random;

public class HeapSort {
    public static void main(String[] args){
        // int[] testArray = {7, 5, 9, 11, 30, 21, 16, 3, 25, 10, 2, 1};
        int[] testArray = genArray(10000, 1, 10000);
        System.out.println("Before: " + Arrays.toString(testArray));
        sort(testArray);
        System.out.println("After: " + Arrays.toString(testArray));
        System.out.println("Is sorted inversions = " + hasInversions(testArray));
    }

    public static void sort(int[] array){

        // assemble heap from our input
        // (array.length -1 / 2 is the last node with child)
        for (int i = (array.length -1 ) / 2; i >= 0 ; i--) {
            sink(array, i, array.length - 1);
        }

        // delete the max repeatedly to sort the array
        int size = array.length - 1;
        while (size > 0){
            swap(array, 0, size);
            size--; // shrinks the size of the "array" for heap work as past this size is sorted
            if(size > 0){
                sink(array, 0, size);
            }
        }
    }

    private static void sink(int[] array, int index, int size){
        // loop as long as current element has children
        while (index <= size / 2) {
            int left = index * 2 + 1;
            int right = index * 2 + 2;
            // search for the larger child
            int largest = left;
            if (right <= size && array[right] > (array[left]) ) {
                largest = right;
            }

            // is the current index smaller than the largest child
            if (array[index] < (array[largest])) {
                swap(array, index, largest);
                index = largest; // move current index to larger child
            }
            else {
                break;
            }
        }
    }

    private static void swap(int[] array, int first, int second) {
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    private static int[] genArray(int size, int min, int max){
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++){
            array[i] = min + random.nextInt(max - min + 1);
        }

        return array;
    }

    private static boolean hasInversions(int[] array){
        for (int i = 0; i < array.length - 1; i++) {
            if(array[i] > array[ i + 1 ]){
                return true;
            }

        }
        return false;
    }
}
