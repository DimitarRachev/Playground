public class Node<T> {
   private int hashValue;
    private  String key;
    private T value;
   private Node<T> next;
   private Node<T> previous;

    public Node(String kay, T value , int hashValue) {
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

    public Node<T> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public void setHashValue(int hashValue) {
        this.hashValue = hashValue;
    }
}
