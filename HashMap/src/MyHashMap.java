
public class MyHashMap<K, V> {
    Node<K, V>[] hashmap;

    public MyHashMap() {
        hashmap = new Node[26];
    }

    public boolean add(String key, V value) {
        int hash = generateHash(key);
        int index = hash - 97;
        Node<K, V> node = new Node<>(key, value, hash);
        return addToMap(node, index);
    }

    private boolean addToMap(Node< K, V> node, int index) {
        if (hashmap[index] == null) {
            Node<K, V> pointer = new Node<>("", node.getValue(), 0);
            hashmap[index] = pointer;
            pointer.setNext(node);
            node.setPrevious(pointer);
            return true;
        }
        Node<K, V> current = hashmap[index];
        while (current.getNext() != null)
            if (current.getKey().equals(node.getKey())) {
                Node<K, V> previous = current.getPrevious();
                Node<K, V> next = current.getNext();
                node.setPrevious(previous);
                node.setNext(next);
                previous.setNext(node);
                return true;
            } else {
                current = current.getNext();
            }
        if (current.getKey().equals(node.getKey())) {
            Node<K, V> previous = current.getPrevious();
            Node<K, V> next = current.getNext();
            node.setPrevious(previous);
            node.setNext(next);
            previous.setNext(node);
        }
        current.setNext(node);
        node.setPrevious(current);
        return true;
    }

    private int generateHash(String string) {
        if (string.length() == 0) {
            return 0;
        }
        return string.charAt(0);
    }
}
