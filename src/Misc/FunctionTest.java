package Misc;

import java.util.Arrays;
import java.util.function.Function;

public class FunctionTest {
    public static void main(String[] args) {
        int[] numbers = new int[]{54, 65, 54, 4, 89, 56, 78, 45, 85};
        Function<int[], Integer> sumAllelements = a -> Arrays.stream(a).sum();
        Function<Integer, String> sumFormatter = i -> "Sum = " + i;
        System.out.println(sumAllelements.andThen(sumFormatter).apply(numbers));
        System.out.println(sumFormatter.compose(sumAllelements).apply(numbers));

        Function<String, String> removeComma = s -> s.replace(",", "");
    }

}
