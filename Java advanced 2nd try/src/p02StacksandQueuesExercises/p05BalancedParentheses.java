package p02StacksandQueuesExercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class p05BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Character> stack = new ArrayDeque<>();
        char[] arr = scanner.nextLine().trim().toCharArray();

        String output = isBalances(stack, arr) ? "YES" : "NO";
        System.out.println(output);
    }

    private static boolean isBalances(ArrayDeque<Character> stack, char[] arr) {
        for (char c : arr) {
            if (c == '[' || c == '{' || c == '(') {
                stack.push(c);
                continue;
            }
            if (c == ']' || c == '}' || c == ')') {
                if (stack.isEmpty() || arentPair(c, stack.pop())) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }

    private static boolean arentPair(char c, Character pop) {
        return (c ==')' && pop != '(') || (c == ']' && pop != '[') || (c == '}' && pop !='{');
    }
}
