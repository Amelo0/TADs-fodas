package ED1.TADsNotaveis;

public class Fila {
    private int[] queue;
    private int size;
    private int front;
    private int rear;
    private int maxSize;

    public Fila() {
        this.maxSize = 20;
        this.queue = new int[maxSize];
        this.size = 0;
        this.front = 0;
        this.rear = -1;
    }

    public Fila(int maxSize) {
        this.maxSize = maxSize;
        this.queue = new int[maxSize];
        this.size = 0;
        this.front = 0;
        this.rear = -1;
    }

    // Verifica se a fila está vazia
    public boolean isEmpty() {
        return size == 0;
    }

    // Verifica se a fila está cheia
    public boolean isFull() {
        return size == maxSize;
    }

    // Obtém o tamanho atual da fila
    public int size() {
        return size;
    }

    // Enfileira um int
    public void enqueue(int value) {
        if (!isFull()) {
            rear = (rear + 1) % maxSize;
            queue[rear] = value;
            size++;
        } else {
            System.out.println("A fila está cheia. Não é possível enfileirar.");
        }
    }

    // Desenfileira um int
    public int dequeue() {
        if (!isEmpty()) {
            int removedValue = queue[front];
            front = (front + 1) % maxSize;
            size--;
            return removedValue;
        } else {
            throw new IllegalStateException("A fila está vazia. Não é possível desenfileirar.");
        }
    }

    // pEek
    public int peek() {
        if (!isEmpty()) {
            return queue[front];
        } else {
            throw new IllegalStateException("A fila está vazia. Não há elemento para visualizar.");
        }
    }

    // Exibe todos
    public void display() {
        if (!isEmpty()) {
            System.out.print("Fila: ");
            for (int i = 0; i < size; i++) {
                int index = (front + i) % maxSize;
                System.out.print(queue[index] + " ");
            }
            System.out.println();
        } else {
            System.out.println("A fila está vazia.");
        }
    }
}