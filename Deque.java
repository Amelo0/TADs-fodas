package ED1.TADsNotaveis;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Deque<T> {
    private Node<T> front;
    private Node<T> rear;

    private class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        public Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public Deque() {
        front = null;
        rear = null;
    }

    public void push(T element) {
        Node<T> newNode = new Node<>(element);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            newNode.next = front;
            front.prev = newNode;
            front = newNode;
        }
    }

    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }
        T element = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        } else {
            front.prev = null;
        }
        return element;
    }

    public void inject(T element) {
        Node<T> newNode = new Node<>(element);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            newNode.prev = rear;
            rear.next = newNode;
            rear = newNode;
        }
    }

    public T eject() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }
        T element = rear.data;
        rear = rear.prev;
        if (rear == null) {
            front = null;
        } else {
            rear.next = null;
        }
        return element;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public boolean isFull() {
        return false; // Neste caso, o Deque nunca fica cheio
    }

    public void printDeque() {
        Node<T> current = front;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}