package org.szeged.verem;

public class VeremDinamikus {

    //Belso osztaly
    class Node {
        private int value;

        private Node nextNode;

        public Node(int value, Node nextNode) {
            this.value = value;
            this.nextNode = nextNode;
        }
    }

    private int size;

    private Node head = null;

    public VeremDinamikus() {
        empty();
        size = 0;
    }

    public void empty() {
        head = null;
        size = 0;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public void push(int value) {
        head = new Node(value, head);
        size++;
    }

    public int pop() {
        if (isEmpty()) {
            return -1;
        } else {
            int value = head.value;
            size--;
            head = head.nextNode;
            return value;
        }
    }

    public int top() {
        if (isEmpty()) {
            return -1;
        } else {
            return head.value;
        }
    }

    public int getSize() {
        return size;
    }

}
