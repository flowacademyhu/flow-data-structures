package org.szeged.queue;

public class QueueDinamicGenerics<T> {
    //Belso osztaly
    class Node<T extends Comparable<T>> {
        private Comparable<T> value;

        private Node nextNode;
        //private Elem tail;

        public Node(Comparable<T> value, Node nextNode) {
            this.value = value;
            this.nextNode = nextNode;
        }
    }

    private int size;
    private Node head = null;
    private Node tail = null;


    public QueueDinamicGenerics() {
        empty();
    }

    public void empty() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    //public void push(int elem) {
    //    head = new Elem(elem, head);
    //}

    //Elhelyez a sorban egy elemet
    public void in(Comparable<T> value) {
        Node node = new Node(value, null);
        if (isEmpty()) {
            head = node;
        } else {
            tail.nextNode = node;
        }
        size++;
        tail = node;
    }

    public Comparable<T> out() {
        if (isEmpty()) {
            System.out.println("Ures a sor!");
            return null;
        } else {
            Comparable<T> result = head.value;
            head = head.nextNode;
            if (head == null) {
                tail = null;
            }
            size--;
            return result;
        }
    }

    public Comparable<T> first() {
        if (isEmpty()) {
            System.out.println("A sor üres. Nincs első eleme.");
            return null;
        } else {
            return head.value;
        }
    }

    public int getSize() {
        return size;
    }

    public String toString(){
        Node node = this.head;
        StringBuilder res = new StringBuilder();
        res.append("[");
        while (node.nextNode != null){
            res.append(node.value).append(", ");
            node = node.nextNode;
        }
        res.deleteCharAt(res.length()-2);
        res.append("]");
        return res.toString();
    }
}
