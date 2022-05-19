import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
   static ArrayDeque<Long> stack = new ArrayDeque<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
            stack.push(1L);
            stack.push(1L);
        System.out.println(fib(n - 1));
        StringBuilder text = new StringBuilder();
        text.append("123456789");
        int countToDelete = n;
        text.setLength(text.length() - countToDelete);
        System.out.println(text);
//        text.setLength(text.length() - countToDelete); ще ни спести цикъла при изтриването
    }

    private static long fib(int n) {
        for (int i = 0; i < n; i++) {
            long a = stack.pop();
            long b = stack.pop();
            stack.push(b);
            stack.push(a);
            stack.push(a + b);
        }
        return stack.peek();
    }
}
