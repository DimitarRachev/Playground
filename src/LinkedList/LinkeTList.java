package LinkedList;

public class LinkeTList<T> {
    private Node<T> first;
    private Node<T> last;
    private int size;

    public LinkeTList() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    public void addFirst(T value) {
        Node<T> newNode = new Node<>(value);
        if (first == null) {
            first = newNode;
            last = newNode;
        } else {
            newNode.setNext(first);
            first = newNode;
        }
        size++;
    }

    public void addLast(T value) {
        Node<T> newNode = new Node<>(value);
        if (first == null) {
            first = newNode;
            last = newNode;
        } else {
            last.setNext(newNode);
            last = newNode;
        }
        size++;
    }

    public void deleteFirst() {
        assureNotEmpty();
        Node<T> temp = first;
        first = first.getNext();
        temp.setNext(null);
        size--;

    }

    public void deleteLast() {
        assureNotEmpty();
        if (first == last) {
            first = last = null;
            return;
        }
        Node<T> current = first;
        for (int i = 0; i < size; i++) {
            if (current.getNext() == last) {
                break;
            } else {
                current = current.getNext();
            }
        }

        last = current;
        last.setNext(null);
        size--;
    }

    public int indexOf(T value) {
        assureNotEmpty();
        int index = -1;
        Node<T> current = first;
        for (int i = 0; i < size; i++) {
            if (current.getValue().equals(value)) {
                index = i;
                break;
            } else {
                current = current.getNext();
            }
        }
        return index;
    }

    public boolean contains(T value) {
        return indexOf(value) != -1;
    }

    private void assureNotEmpty() {
        if (first == null) {
            throw new IllegalArgumentException("List is empty");
        }
    }

    @Override
    public String toString() {
        assureNotEmpty();
        StringBuilder out = new StringBuilder();
        Node<T> current = first;
        while (current != null) {
            out.append(current.getValue()).append(System.lineSeparator());
            current = current.getNext();
        }
        return out.toString();
    }
}
