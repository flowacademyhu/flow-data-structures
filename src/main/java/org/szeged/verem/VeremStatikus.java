package org.szeged.verem;

public class VeremStatikus {
    //a verem tetejere mutat
    private int head;

    //a verem megvalositasa egy tombbel
    private int[] elemek = null;


    //Konstruktor max 10 elemmel
    public VeremStatikus() {
        empty();
    }

    public VeremStatikus(int veremMeret) {
        head = 0;
        elemek = new int[veremMeret];
    }

    public void empty() {
        head = 0;
        elemek = new int[10];
    }

    public boolean isEmpty(){
        return (head == 0);
    }

    public boolean isFull(){
        return (head == elemek.length);
    }

    //egy elem hozzaadasa a veremhez
    //az elem a verem tetejere kerul
    public void push(int elem){
        if (!isFull()) {
            elemek[head] = elem;
            head++;
        } else {
            System.out.println("Nem fer el tobb elem a veremben. A " + elem + " nem sikerült a vermbe tenni.");
        }
    }

    public int pop(){
        if (isEmpty()){
            System.out.println("A veremben nincsenek elemek");
            return -1;
        } else {
            //a verem teteje eggyel lejjebb kerul
            head--;
            return elemek[head];
        }
    }

    //elkerjuk a legfelso elemet a verembol
    public int top(){
        if (isEmpty()){
            System.out.println("A veremben nincsenek elemek");
            return -1;
        } else {
            return elemek[head -1];
        }
    }

    public int getSize(){
        return this.elemek.length;
    }


    public static void main(String[] args) {
        System.out.println("Lamer");
    }
}
