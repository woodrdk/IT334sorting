package divideandconquer;

import jdk.nashorn.api.tree.SpreadTree;
import utilities.SortingUtilities;

import java.util.Arrays;

public class MergeSort {

    private static int[] aux;
    public static void main(String[] args){

        int[] testArray = {10,13,1,2,4,18,22,-10};
        testArray = SortingUtilities.genArray(1000,1,100);

        mergeSort(testArray);
        System.out.println(Arrays.toString(testArray));
        System.out.println("Inversions? " + SortingUtilities.hasInversions(testArray));
    }

    public static void mergeSort(int[] array){

        // precondition
        if(array.length <= 1){
            return; // already sorted
        }

        // create the secondary array to help with merge()
        aux = new int[array.length];

        // recursively sort the array
        mergeSort(array,0,array.length-1);
    }

    // recursively sorts the elements from the index low to high (inclusive)
    private static void mergeSort(int[] array, int low, int high){
        // base case
        if(high - low <= 0){
            return; // a sub-array of length 1 or 0 is sorted
        }

        // recursively sort the left and right sub-array
        int mid = (high + low) / 2;
        mergeSort(array, low, mid);
        mergeSort(array, mid+1, high);

        merge(array, low, high );

    }

    private static void merge(int[] array, int low, int high) {
        // find my midpoint and set the left and right pointers (references)
        int mid = ( high + low ) / 2;
        int left = low;
        int right = mid + 1;
        int numToMerge = ( high - low ) + 1;

        for (int i = 0; i < numToMerge; i++) {
            // check first whether we have exhausted either sub-array
            if(left > mid){
                aux[ i] = array[right++];
            }
            else if(right > high){
                aux[i] = array[left++];
            }

            // check for the smaller element of the two sub-arrays
            else if(array[left] < array[right]){
                aux[i] = array[left++];
            }
            else{ //if(array[right] <= array[left]){
                aux[i] = array[right++];
            }
        }

        // copy our merged ub-arrays from the aux array back to the original
        for (int i = 0; i < numToMerge; i++) {
            array[low + i] = aux[i];
        }
    }
}
