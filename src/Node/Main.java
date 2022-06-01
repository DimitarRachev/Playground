package Node;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) {


        Node node1 = new Node();
        Node node2 = new Node();
        Node node3 = new Node();
        node1.number = 3;
        node1.next = node2;
        node2.number = 5;
        node2.next = node3;
        node3.number = 7;

       Node node4 = reverse(node1);
        Node temp = node4;
       while (temp.next != null) {
           System.out.println(temp.number);
           temp = temp.next;
       }
        System.out.println(temp.number);
     }

    private static Node reverse(Node node1) {
        Node temp = node1;
        Deque<Node> stack = new ArrayDeque<>();
        while (temp.next != null) {
            stack.push(temp);
            temp = temp.next;
        }
        stack.push(temp);
        Node returned = null;
        int in = 0;
        Node current = null;
        while (!stack.isEmpty()) {
             current = stack.pop();
            if (in++ == 0) {
                returned = current;
            }
            current.next = stack.peek();
                    }
        return returned;
    }
}
