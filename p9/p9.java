
class MyList<T> {
    class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
        }
    }

    Node head;
    int size = 0;

    // Insertion at end
    void insert(T data) {
        Node n = new Node(data);
        if (head == null)
            head = n;
        else {
            Node temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = n;
        }
        size++;
    }

    // Deletion by value
    void delete(T data) {
        if (head == null) return;

        if (java.util.Objects.equals(head.data, data)) {
            head = head.next;
            size--;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            if (java.util.Objects.equals(temp.next.data, data)) {
                temp.next = temp.next.next;
                size--;
                return;
            }
            temp = temp.next;
        }
    }

    boolean search(T data) {
        for (Node t = head; t != null; t = t.next)
            if (java.util.Objects.equals(t.data, data))
                return true;
        return false;
    }

    void display() {
        for (Node t = head; t != null; t = t.next)
            System.out.print(t.data + " ");
        System.out.println();
    }

    int size() { return size; }

    boolean isEmpty() { return size == 0; }
}

public class Main {
    public static void main(String[] args) {
        MyList<Integer> nums = new MyList<>();
        nums.insert(10);
        nums.insert(20);
        nums.insert(30);
        nums.delete(20);
        nums.display();
        System.out.println(nums.search(10));
        System.out.println("Size: " + nums.size());

        MyList<String> names = new MyList<>();
        names.insert("Aman");
        names.insert("Priya");
        names.display();
        System.out.println(names.search("Priya"));
        System.out.println("Empty: " + names.isEmpty());
    }
}
