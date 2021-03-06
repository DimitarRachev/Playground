package Misc;

import java.util.Arrays;

public class Arr {
    public static void main(String[] args) {

        int[] arr1 = new int[]{3, 5, 7, 9, 1, 67};
        int[] arr2 = new int[]{6, 65, 7, 1, 5, 67, 65, 65, 574};

        Arrays.sort(arr1);
        Arrays.sort(arr2);

//        1 3 5 7 9 67
//        1 5 6 7 65 65 65 67 574

        //first solution

        for (int el : arr1) {
            if (isPresent(el, arr2, 0, arr2.length - 1)) {
                System.out.print(el + " ");
            }
        }

        System.out.println();

        //second solution

        int index1 = 0;
        int index2 = 0;

        while (index1 < arr1.length && index2 < arr2.length) {
            if (arr1[index1] == arr2[index2]) {
                System.out.print(arr1[index1] + " ");
                index1++;
                index2++;
            } else if (arr1[index1] < arr2[index2]) {
                index1++;
            } else {
                index2++;
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
