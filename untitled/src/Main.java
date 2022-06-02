//public class Main {
//    public static void main(String[] args) {
//        Node node1 = new Node();
//        Node node2 = new Node();
//        Node node3 = new Node();
//        node1.number = 3;
//        node1.next = node2;
//        node2.number = 5;
//        node2.next = node3;
//        node3.number = 7;
//
//        printChain(node1);
//        printChain(reverseNodeChain(node1));
////some comment
//    }
//
//    private static void printChain(Node node) {
//        while (node.next != null) {
//            System.out.print(node.number + " ");
//            node = node.next;
//        }
//        System.out.println(node.number);
//    }
//
//    private static Node reverseNodeChain(Node node1) {
//        if (node1.next == null) {
//            throw new IllegalArgumentException("there must be more that one nodes");
//        }
//        Node next = node1.next;
//        while (next.next != null) {
//            Node nextNext = next.next;
//            node1.next = null;
//            next.next = node1;
//            node1 = next;
//            next = nextNext;
//        }
//        next.next = node1;
//
//        return next;
//    }
//}
