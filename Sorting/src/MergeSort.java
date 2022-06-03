import java.util.Arrays;
import java.util.HashMap;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{45, 64, 4, 84, 584, 48, 58, 8, 7, 36, 4, 87, 6, 354};
        HashMap<String, String> map = new HashMap<>();

        mergeSort(arr, 0, arr.length - 1);

        Arrays.stream(arr).forEach(e -> System.out.print(e + " "));

    }

    private static void mergeSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        if (start > end || arr[mid] < arr[mid + 1]) {
            return;
        }

        int[] originalValues = new int[arr.length];
        for (int i = start; i <= end; i++) {
            originalValues[i] = arr[i];
        }

        int leftIndex = start;
        int rigthIndex = mid + 1;
        int i = start;
        while (i <= end) {
            if (leftIndex > mid) {
                arr[i++] = originalValues[rigthIndex++];
            } else if (rigthIndex > end) {
                arr[i++] = originalValues[leftIndex++];
            } else if (originalValues[leftIndex] < originalValues[rigthIndex]) {
                arr[i++] = originalValues[leftIndex++];
            } else if (originalValues[rigthIndex] < originalValues[leftIndex]) {
                arr[i++] = originalValues[rigthIndex++];
            } else {
                arr[i++] = originalValues[leftIndex++];
                arr[i++] = originalValues[rigthIndex++];
            }
        }
    }
}
