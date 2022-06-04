import java.util.List;
import java.util.Random;
import java.util.function.IntSupplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem3 {
    public static void main(String[] args) {
        String s = IntStream.rangeClosed(0, 100).boxed().map(String::valueOf).reduce((s1, s2) -> s1 + "#" + s2).get();
        System.out.println(s);
        IntSupplier suplier = () -> {
          Random random = new Random();
          return random.nextInt(30);
        };
        List<Integer> list = IntStream.generate(suplier).limit(20).boxed().collect(Collectors.toList());
        list.forEach(i -> System.out.print(i + " "));
        System.out.println();

        long count = list.stream().filter(i -> i % 5 == 0).count();
        System.out.println(count > 0);

         count = list.stream().filter(i -> i >= 15).count();
        System.out.println(!(count > 0));

        double average = list.stream().mapToInt(e -> e).average().getAsDouble();
         count = list.stream().filter(i -> i > average).count();
        System.out.println(count > 5);

    }
}
