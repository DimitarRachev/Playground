import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Problem2 {
    public static void main(String[] args) {
        String[] arr = new String[] {"aBc", "d", "ef", "123456"};
        List<String> list = Arrays.stream(arr).map(e -> e.toUpperCase()).sorted().collect(Collectors.toList());
        list.stream().forEach(s -> System.out.print(s + " "));
    }
}
