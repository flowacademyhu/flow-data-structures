package org.szeged.queue;


//FIFO adat struktura (First In, First Out)


//Az elso elem kerul legelore, a head moge es igy tovabb
//Mindig a legelso tud kijonni, vagyis a legregebben bekerult elem

public class QueueStatic {

    private int[] elemek = null;
    private int head;
    private int tail;
    private boolean isEmpty;

    public QueueStatic() {
        new QueueStatic(10);
    }

    public QueueStatic(int size) {
        elemek = new int[size];
        head = 0;
        tail = 0;
        isEmpty = true;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public boolean isFull() {
        return ((head == tail) && !isEmpty);
    }

    //Elhelyez a sorban egy elemet
    public void in(int elem) {
        if (isFull()) {
            System.out.println("Tele van, mar nem lehet pakolni az adott sorba! A " + elem + " már nem került a sorba...");
        } else {
            isEmpty = false;
            elemek[tail] = elem;
            tail++;
            if (tail == elemek.length){
                tail = 0;
            }
        }
    }

    public int out(){
        if (isEmpty()){
            System.out.println("A list ures, nem lehet elemet kivenni belole!");
            return -1;
        } else {
            int resElem = elemek[head];
            head++;
            if (head == elemek.length){
                head = 0;
            }
            isEmpty = (head == tail);
            return resElem;
        }
    }

    public int first() {
        if (isEmpty()) {
            System.out.println("A list ures, nem lehet elemet kivenni belole!");
            return -1;
        } else {
            return elemek[head];
        }
    }

    public int getSize(){
        return this.elemek.length;
    }
}
