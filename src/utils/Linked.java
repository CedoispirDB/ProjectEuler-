package utils;

import java.util.Objects;

public class Linked<T> {

    private static class Node<T> {

        T value;
        Node<T> next;
        Node<T> prev;

        public Node(T value, Node<T> prev, Node<T> next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node<T> head;
    private Node<T> last;
    // represents the last used Node
    private Node<T> current;
    private int current_index;

    private int size;

    public Linked() {
    }

    public void link_last(T value) {
        final Node<T> l = last;
        final Node<T> new_node = new Node<>(value, l, null);
        last = new_node;
        if (l == null) {
            head = new_node;
        } else {
            l.next = new_node;
        }

        size++;
    }

    public boolean search_from_current(T value) {
        int count = 0;

        if(current != null && Objects.equals(current.value, value)) {
            return true;
        }

        Node<T> curr = null;
        if (current == null) {
            curr = head;
        } else {
            curr = current.next;
            count = current_index + 1;
        }

        while (curr != null) {
            if (Objects.equals(curr.value, value)) {
                current = curr;
                current_index = count;
                return true;
            }

            curr = curr.next;
            count++;
        }

        return false;
    }

    public int index_from_current(T value) {
        int index = -1;

        int count = 0;

        Node<T> curr = null;
        if (current == null) {
            curr = head;
        } else {
            curr = current.next;
            count = current_index + 1;
        }

        while (curr != null) {
            if (Objects.equals(curr.value, value)) {
                index = count;
                current = curr;
                current_index = index;
                break;
            }

            curr = curr.next;
            count++;
        }

        return index;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }

        int count = 0;

        Node<T> curr = head;
        while (curr != null) {
            if (index == count) {
                return curr.value;
            }
            count++;
            curr = curr.next;
        }

        return null;
    }

    public T current_value() {
        if(current == null) return null;
        return current.value;
    }

    public int current_index() {
        return current_index;
    }

    public void reset_current() {
        current = null;
        current_index = 0;
    }

    public int size() {
        return size;
    }
}
