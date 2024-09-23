public class MyQueue {
    // Внутрішній клас для зберігання елементів черги
    private static class Node {
        Object value;
        Node next;

        Node(Object value) {
            this.value = value;
        }
    }
    private Node head;  // Голова черги (перший елемент)
    private Node tail;  // Хвіст черги (останній елемент)
    private int size;   // Розмір черги
    public void add(Object value) {
        Node newNode = new Node(value);
        if (tail != null) {
            tail.next = newNode;
        }
        tail = newNode;
        if (head == null) {
            head = tail;
        }
        size++;
    }
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }
    public int size() {
        return size;
    }
    public Object peek() {
        if (head == null) {
            return null;
        }
        return head.value;
    }
    public Object poll() {
        if (head == null) {
            return null;
        }
        Object value = head.value;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return value;
    }
}
class MyQueueTest {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();

        // Додаємо елементи в чергу
        queue.add("First");
        queue.add("Second");
        queue.add("Third");

        // Виводимо розмір черги
        System.out.println("Size: " + queue.size()); // Виведе: Size: 3

        // Переглядаємо перший елемент без видалення
        System.out.println("Peek: " + queue.peek()); // Виведе: Peek: First

        // Забираємо перший елемент з черги
        System.out.println("Poll: " + queue.poll()); // Виведе: Poll: First

        // Виводимо розмір черги після видалення
        System.out.println("Size after poll: " + queue.size()); // Виведе: Size after poll: 2

        // Очищуємо чергу
        queue.clear();
        System.out.println("Size after clear: " + queue.size()); // Виведе: Size after clear: 0
    }
}
