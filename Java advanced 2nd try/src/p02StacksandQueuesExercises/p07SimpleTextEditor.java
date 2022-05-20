package p02StacksandQueuesExercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class p07SimpleTextEditor {
    static StringBuilder text = new StringBuilder();
    static ArrayDeque<String> undoStack = new ArrayDeque<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] commands = scanner.nextLine().split("\\s+");
            switch (commands[0]) {
                case "1":
                    addCommand(commands[1]);
                    break;
                case "2":
                    deleteCommand(Integer.parseInt(commands[1]));
                    break;
                case "3":
                    System.out.println(printChar(Integer.parseInt(commands[1]) - 1));
                    break;
                case "4":
                    undoLastCommand();
                    break;
            }
        }
    }

    private static void undoLastCommand() {
        String[] command = undoStack.pop().split("\\s+");
        switch (command[0]) {
            case "1":
                text.append(command[1]);
                break;
            case "2":
                int length = Integer.parseInt(command[1]);
                text.setLength(text.length() - length);
                break;
        }
    }

    private static void deleteCommand(int length) {
        String substring = text.substring(text.length() - length);
        text.setLength(text.length() - length);
        undoStack.push("1 " + substring);
    }

    private static void addCommand(String substring) {
        text.append(substring);
        undoStack.push("2 " + substring.length());
    }

    private static char printChar(int i) {
        return text.charAt(i);
    }
}
