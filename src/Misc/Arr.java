package Misc;

import java.util.Arrays;

public class Arr {
    public static void main(String[] args) {

        int[] arr1 = new int[]{3, 5, 7, 9, 1, 67};
        int[] arr2 = new int[]{6, 65, 7, 1, 5, 67, 65, 65, 574};

//        1 3 5 7 9 67
//        1 6 7 65 65 65 67 574

        Arrays.sort(arr1);
        Arrays.sort(arr2);
        for (int i = 0; i < arr1.length; i++) {
            int el = arr1[i];
            if (isPresent(el, arr2, 0, arr2.length - 1)) {
                System.out.println(el);
            }
        }
    }

    private static boolean isPresent(int el, int[] arr2, int start, int end) {
        if (start == end) {
            return el == arr2[start];
        }
        int middle = (end + start) / 2;
        if (el > arr2[middle]) {
            return isPresent(el, arr2, middle + 1, end);
        } else if (el < arr2[middle]) {
            return isPresent(el, arr2, start, middle - 1);
        } else {
            return true;
        }
    }

}
