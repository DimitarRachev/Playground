import java.lang.reflect.Array;

public class MyHashMap<T> {
    Node[] hashmap;

    public MyHashMap() {
        hashmap = new Node[26];
    }

    public boolean add(String key, T value) {
        int hash = generateHash(key);
        int index = hash - 97;
        Node<T> node = new Node<>(key, value, hash);
        return addToMap(node, index);
    }

    private boolean addToMap(Node<T> node, int index) {
        if (hashmap[index] == null) {
            Node<T> pointer = new Node<>("", node.getValue(), 0);
            hashmap[index] = pointer;
            pointer.setNext(node);
            node.setPrevious(pointer);
            return true;
        }
        Node<T> current = hashmap[index];
        while (current.getNext() != null)
            if (current.getKey().equals(node.getKey())) {
                Node<T> previous = current.getPrevious();
                Node<T> next = current.getNext();
                node.setPrevious(previous);
                node.setNext(next);
                previous.setNext(node);
                return true;
            } else {
                current = current.getNext();
            }
        if (current.getKey().equals(node.getKey())) {
            Node<T> previous = current.getPrevious();
            Node<T> next = current.getNext();
            node.setPrevious(previous);
            node.setNext(next);
            previous.setNext(node);
        }
        current.setNext(node);
        node.setPrevious(current);
        return true;
    }

    T get(String key) {
        int hash = generateHash(key);
        int index = hash - 97;
        Node<T> node = hashmap[index];
        while (node.getNext() == null) {
            if (node.getKey().equals(key)) {
                return node.getValue();
            }
            node = node.getNext();
        }
        return null;
    }

    private int generateHash(String string) {
        if (string.length() == 0) {
            return 0;
        }
        return string.charAt(0);
    }
}
