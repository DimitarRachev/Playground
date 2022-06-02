import java.util.Objects;

public class MyHashMap<K extends Comparable<K>, V> {
    Node<K, V>[] hashmap;

    public MyHashMap() {
        hashmap = new Node[26];
    }

    public boolean add(K key, V value) {
        int hash = generateHash(key);
        int index = hash % hashmap.length;
        Node<K, V> node = new Node<>(key, value, hash);
        return addToMap(node, index);
    }

    private boolean addToMap(Node<K, V> node, int index) {
        if (hashmap[index] == null) {
            hashmap[index] = node;
            return true;
        }

        Node<K, V> current = hashmap[index];
        while (true) {
            if (current.getKey().equals(node.getKey())) {
                current.setValue(node.getValue());
                return true;
            } else if (current.getNext() == null) {
                current.setNext(node);
                node.setPrevious(current);
                return true;
            }
            current = current.getNext();
        }

    }

    V get(K key) {
        int hash = generateHash(key);
        int index = hash % hashmap.length;
        Node<K, V> node = hashmap[index];
        if (node == null) {
            return null;
        }
        if (key.equals(node.getKey())) {
            return node.getValue();
        }
        while (node.getNext() != null) {
            node = node.getNext();
            if (node.getKey().equals(key)) {
                return node.getValue();
            }
        }
        return null;
    }

    public boolean remove(K key) {
        int index = generateHash(key) % hashmap.length;
        Node node = hashmap[index];
        if (node == null) {
            return false;
        }
        if (node.getKey().equals(key)) {
            Node<K, V> next = node.getNext();
            if (next == null) {
                hashmap[index] = null;
                return true;
            }
            next.setPrevious(null);
            hashmap[index] = next;
            return true;
        }
        while (node.getNext() != null) {
            node = node.getNext();
            if (node.getKey().equals(key)) {
                Node previous = node.getPrevious();
                Node next = node.getNext();
                previous.setNext(next);
                if (next != null) {
                    next.setPrevious(previous);
                }
            }
        }

        return false;
    }

    private int generateHash(K key) {
        return key.hashCode();
    }
}
