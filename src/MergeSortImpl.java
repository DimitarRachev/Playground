import javax.swing.*;

public class MergeSortImpl {
    public static void main(String[] args) {
        int[] arr = new int[]{654, 321, 54, 8478, 2, 8, 749, 5, 49, 2, 168, 48, 8, 65, 54, 65, 584, 8, 36, 351, 48, 36, 887, 9, 96, 5, 3, 96, 4};

        sort(arr, 0, arr.length);
        printArr(arr);
    }

    static void printArr(int[] arr) {
        for (int i : arr) {
            System.out.println(i + " ");
        }
    }

    static int[] sort(int[] arr, int start, int end) {
        int[] result = null;
        while (start != end) {
            int middle = (start + end) / 2;
            int[] L = sort(arr, start, middle);
            int[] R = sort(arr, middle + 1, end);
            result = merge(L, R);
        }
        return result;
    }

    private static int[] merge(int[] l, int[] r) {
        int[] temp = new int[l.length + r.length];
        int lIndex = 0, rIndex = 0, tIndex = 0;
        while (lIndex < l.length && rIndex < r.length) {
            if (l[lIndex] < r[rIndex]) {
                temp[tIndex++] = l[lIndex++];
            } else if (r[rIndex] < l[lIndex]) {
                temp[tIndex++] = r[rIndex++];
            } else {
                temp[tIndex++] = l[lIndex++];
                temp[tIndex++] = r[rIndex++];
            }
        }
        //TODO add rest
        return temp;
    }

    static void merge(int[] arr, int start, int middle, int end) {
        int[] temp = new int[end - start + 1];
        int index = 0;
        int initialStart = start;
        while (start < middle && middle < end) {
            if (arr[start] < arr[middle]) {
                temp[index++] = arr[start++];
            } else if (arr[middle] < arr[start]) {
                temp[index++] = arr[middle++];
            } else {
                temp[index++] = arr[start++];
                temp[index++] = arr[middle++];
            }
            copyRest(arr, temp, start, middle, index);


        }
        //copy temp
        for (int i = 0; i < temp.length; i++) {
            arr[initialStart++] = temp[i];
        }
    }

    private static void copyRest(int[] arr, int[] temp, int start, int middle, int index) {
        if (start == middle) {
            while (middle == arr.length) {
                temp[index++] = arr[middle++];
            }
        } else if (middle == arr.length) {
            while (start == middle) {
                temp[index++] = arr[start];
            }
        }

    }


}
