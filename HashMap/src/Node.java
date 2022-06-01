public class Node<K, V> {
   private int hashValue;
    private  String key;
    private V value;
   private Node<K, V> next;
   private Node<K, V> previous;

    public Node(String kay, V value , int hashValue) {
        this.key = kay;
        this.value = value;
        this.hashValue = hashValue;
    }

    public int getHashValue() {
        return hashValue;
    }

    public String getKey() {
        return key;
    }

    public Node<K, V> getPrevious() {
        return previous;
    }

        public void setPrevious(Node<K, V> previous) {
        this.previous = previous;
    }

    public Node<K, V> getNext() {
        return next;
    }

    public void setNext(Node<K, V> next) {
        this.next = next;
    }

    public V getValue() {
        return value;
    }

    public void setHashValue(int hashValue) {
        this.hashValue = hashValue;
    }
}
