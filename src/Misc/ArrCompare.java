package Misc;

import java.util.Arrays;

public class ArrCompare {
    public static void main(String[] args) {
        int[] arr1 = new int[]{3, 5, 7, 9, 1, 67};
        int[] arr2 = new int[]{6, 65, 7, 1, 5, 67, 65, 65, 574};

        Arrays.sort(arr1);
        Arrays.sort(arr2);

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
}
