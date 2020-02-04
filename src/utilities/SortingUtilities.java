package utilities;

import java.util.Random;

public class SortingUtilities {

    public static int[] genArray(int size, int min, int max){
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++){
            array[i] = min + random.nextInt(max - min + 1);
        }

        return array;
    }

    public static boolean hasInversions(int[] array){
        for (int i = 0; i < array.length - 1; i++) {
            if(array[i] > array[ i + 1 ]){
                return true;
            }

        }
        return false;
    }
}
