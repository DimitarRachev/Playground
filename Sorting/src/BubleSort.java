import java.util.Arrays;

public class BubleSort {
    public static void main(String[] args) {
        int[] arr = new int[]{45, 64, 4, 84, 584, 48, 58, 8, 7, 36, 4, 87, 6, 354};

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        Arrays.stream(arr).forEach(e -> System.out.print(e + " "));
    }
}
