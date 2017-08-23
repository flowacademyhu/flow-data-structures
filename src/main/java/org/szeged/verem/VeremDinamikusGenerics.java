package org.szeged.verem;


public class VeremDinamikusGenerics<T>{


    //Belso osztaly
    class NodeGenerics<T extends Comparable<?>> {
        private Comparable<T> value;

        private NodeGenerics nextNode;

        public NodeGenerics(Comparable<T> value, NodeGenerics nextNode) {
            this.value = value;
            this.nextNode = nextNode;
        }

        public Comparable<T> getValue() {
            return value;
        }

    }

    private int size;

    private NodeGenerics head = null;

    public VeremDinamikusGenerics() {
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

    public void push(Comparable<T> value) {
        head = new NodeGenerics(value, head);
        size++;
    }

    public Comparable<T> pop() {
        if (isEmpty()) {
            System.out.println("A lista ures");
            return null;
        } else {
            Comparable<T> value = head.getValue();
            size--;
            head = head.nextNode;
            return value;
        }
    }

    public Comparable<T> top() {
        if (isEmpty()) {
            return null;
        } else {
            return head.value ;
        }
    }


    public int getSize() {
        return size;
    }

}
