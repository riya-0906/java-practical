
class Stack {
    int[] arr = new int[3];
    int top = -1;

    void push(int x) {
        if (top == arr.length - 1)
            System.out.println("Stack Overflow");
        else
            arr[++top] = x;
    }

    int pop() {
        if (top == -1)
            throw new IllegalStateException("Stack Underflow");
        return arr[top--];
    }

    int peek() {
        if (top == -1)
            throw new IllegalStateException("Stack is Empty");
        return arr[top];
    }
}

class Queue {
    int[] arr = new int[3];
    int front = 0, rear = -1, size = 0;

    void enqueue(int x) {
        if (size == arr.length)
            System.out.println("Queue Overflow");
        else {
            rear = (rear + 1) % arr.length;
            arr[rear] = x;
            size++;
        }
    }

    int dequeue() {
        if (size == 0)
            throw new IllegalStateException("Queue Underflow");
        int x = arr[front];
        front = (front + 1) % arr.length;
        size--;
        return x;
    }

    int front() {
        if (size == 0)
            throw new IllegalStateException("Queue is Empty");
        return arr[front];
    }
}

public class Main {
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(10);
        s.push(20);
        System.out.println("Stack peek: " + s.peek());
        System.out.println("Stack pop: " + s.pop());

        Queue q = new Queue();
        q.enqueue(100);
        q.enqueue(200);
        System.out.println("Queue front: " + q.front());
        System.out.println("Queue dequeue: " + q.dequeue());
    }
}
