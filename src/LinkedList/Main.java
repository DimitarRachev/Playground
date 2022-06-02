package LinkedList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        //Test new linkedList with ints
        LinkedList.LinkeTList<Integer> ints = new LinkedList.LinkeTList<>();
        ints.addFirst(10);
        ints.addLast(15);
        ints.addFirst(5);
        ints.addLast(20);
        System.out.println(ints);
        System.out.println(ints.indexOf(15));
        System.out.println(ints.contains(10));
        ints.deleteFirst();
        ints.deleteLast();
        System.out.println(ints);
            //Same test with Strings
        LinkedList.LinkeTList<String> strs = new LinkedList.LinkeTList<>();
        strs.addLast("15");
        strs.addFirst("10");
        strs.addLast("20");
        strs.addFirst("5");
        System.out.println(strs);
        System.out.println(strs.indexOf("15"));
        System.out.println(strs.contains("5"));
        strs.deleteLast();
        strs.deleteFirst();
        System.out.println(strs);
    }
}
