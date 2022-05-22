package p02StacksandQueuesExercises;

import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        String c = "(";
        Enum s = Arrays.stream(Operators.values()).
                filter(o -> o.name.equals(c))
                .findFirst().get();
        System.out.println(s);
    }

    private enum Operators {

        OPEN_BRACKET("(", 1),
        CLOSE_BRACKET(")", 1),
        ADD("+", 2),
        SUBTRACT("-", 2),
        MULTIPLY("*", 3),
        DIVISION("-", 3),
        POWER("^", 4);

        public final String name;
        public final int power;

        private Operators(String name, int power) {
            this.name = name;
            this.power = power;
        }
    }
}
