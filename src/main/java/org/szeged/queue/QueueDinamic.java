package org.szeged.queue;

public class QueueDinamic {

    //Belso osztaly
    class Node {
        private int value;

        private Node nextNode;
        //private Elem tail;

        public Node(int value, Node nextNode) {
            this.value = value;
            this.nextNode = nextNode;
        }
    }

    private int size;
    private Node head = null;
    private Node tail = null;


    public QueueDinamic() {
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
    public void in(int value) {
        Node ujNode = new Node(value, null);
        if (isEmpty()) {
            head = ujNode;
        } else {
            tail.nextNode = ujNode;
        }
        size++;
        tail = ujNode;
    }

    public int out() {
        if (isEmpty()) {
            System.out.println("Ures a sor!");
            return -1;
        } else {
            int result = head.value;
            head = head.nextNode;
            if (head == null) {
                tail = null;
            }
            size--;
            return result;
        }
    }

    public int first() {
        if (isEmpty()) {
            System.out.println("A sor üres. Nincs első eleme.");
            return -1;
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
