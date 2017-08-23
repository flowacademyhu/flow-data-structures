package org.szeged.list;

public class LinkedListGenerics<T extends Comparable<?>> {


    private class Node<T extends Comparable<?>> {
        //a csomopont erteke
        Comparable<T> value;
        //a kovetkezo nodra mutato referencia
        Node previousNode = null;
        //az elozo nodre mutato referencia
        Node nextNode = null;


        public Node(Comparable<T> value, Node previousNode, Node nextNode) {
            this.value = value;
            this.previousNode = previousNode;
            this.nextNode = nextNode;
        }

    }

    //Head: referencia az elso elemre. null, ha üres a lista.
    private Node head = null;
    //Tail: referencia az utolsó elemre. null, ha üres a lista.
    private Node tail = null;
    //elöre-hátra mozgatható referencia, egy adott elemre a listában. Ha a lista üres akkor null az értéke
    //segítségével tudjuk a listában tárolt elemeket manipuláni: elérni, lekérdezni, megváltoztatni.

    private Node actualNode = null;

    private int size;
    /*
    head <- null
    tail <- null
    actualNode <- null
     */
    LinkedListGenerics() {
        this.head = null;
        this.tail = null;
        this.actualNode = null;
        size = 0;
    }

    //return Head==Tail==null
    public boolean isEmpty() {
        return (head == null);
    }

    //return actualNode == head
    public boolean isFirst() {
        return (actualNode == head);
    }

    //return actualNode == tail
    public boolean isLast() {
        return (actualNode == tail);
    }


    //HA actualNode !=null AKKOR return actualNode.value
    public Comparable<T> getActualValue() {
        if (isEmpty()) {
            System.out.println("A sor ures!");
            return null;
        } else {
            return actualNode.value;
        }
    }

    //HA actualNode !=null AKKOR actualNode.value = value
    public void setActualNodeValue(int newValue) {
        if (!isEmpty()) {
            this.actualNode.value = newValue;
        }
    }

    //HA actualNode !=null ÉS ¬isLast() AKKOR actualNode <- actualNode.prevoiusNode
    public void stepBackward() {
        if (!isEmpty() && !isFirst()) {
            this.actualNode = actualNode.previousNode;
        }
    }

    //HA actualNode != null ÉS ¬isFirst() AKKOR actualNode <- actualNode.nextNode
    public void stepForeward() {
        if (!isEmpty() && !isLast()) {
            this.actualNode = actualNode.nextNode;
        }
    }

    //actualNode <- tail
    public void stepLast() {
        this.actualNode = this.tail;
    }

    //actualNod <- Head
    public void stepFirst() {
        this.actualNode = this.head;
    }


    /*
    insertFirst(ertek)
        actualNode <- ujCsomopon <- ÚJ Node
        ujCsomopont.Ertek <- ertek
        ujCsomopont.Elozo <- null
        ujCsomopont.Kovetkezo <- Head
        HA isEmpty() AKKOR Head <- Tail <- ujCsomopont
        KÜLÖNBEN
        Head.Elozo <- ujCsomopont
        Head <- ujCsomopont
     */
    public void insertFirst(Comparable<T> value) {
        Node newNode = new Node(value, null, head);
        this.actualNode = newNode;
        size++;
        if (isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            head.previousNode = newNode;
            head = newNode;
        }
    }


    /*
    insertLast(ertek)
        HA isEmpty() AKKOR insertFirst(ertek)
        KÜLÖNBEN
        Akt <- ujCsomopont <- ÚJ Node
        ujCsomopont.Ertek <- ertek
        ujCsomopont.Elozo <- Tail
        ujCsomopont.Kovetkezo <- null
        Tail.Kovetkezo <- ujCsomopont
        Tail <- ujCsomopont
     */
    public void insertLast(Comparable<T> value) {
        size++;
        if (isEmpty()) {
            insertFirst(value);
        } else {
            Node newNode = new Node(value, null, head);
            this.actualNode = newNode;
            tail.nextNode = newNode;
            tail = newNode;
        }
    }


    /*
    insertBefore(ertek)
    HA isEmpty() VAGY isFirst() AKKOR insertFirst(ertek)
    KÜLÖNBEN
        ujCsomopont <- ÚJ Node
        ujCsomopont.Ertek <- ertek
        ujCsomopont.Elozo <- Akt.Elozo
        ujCsomopont.Kovetkezo <- Akt
        Akt.Elozo.Kovetkezo <- ujCsomopont
        Akt.Elozo <- ujCsomopont
        Akt <- ujCsomopont
     */
    //Aktualis elem ele valo beszuras
    public void insertBefore(Comparable<T> value) {
        size++;
        if (isEmpty() || isFirst()) {
            insertFirst(value);
        } else {
            Node newNode = new Node(value, this.actualNode.previousNode, this.actualNode);
            this.actualNode.previousNode.nextNode = newNode;
            this.actualNode.previousNode = newNode;
            this.actualNode = newNode;
        }
    }

    /*
    insertAfter(ertek)
    HA isEmpty() VAGY isLast() AKKOR insertLast(ertek)
    KÜLÖNBEN
        stepForward()
        insertBefore(ertek)
    */
    //Aktualis elem utan valo beszuras
    public void insertAfter(Comparable<T> value) {
        size++;
        if (isEmpty() || isLast()) {
            insertLast(value);
        } else {
            stepForeward();
            insertBefore(value);
        }
    }

    /*
    removeFirst()
    HA ¬isEmpty() AKKOR
        HA isFirst() AKKOR Akt <- Head.Kovetkezo
                           Head <- Head.Kovetkezo
        HA Head != null AKKOR Head.Elozo <- null
                        KÜLÖNBEN
                        Tail <- null
     */
    //Az elso elem torlese
    public void removeFirst() {
        if (!isEmpty()) {
            size--;
            if (isFirst()) {
                this.actualNode = head.nextNode;
                this.head = head.nextNode;
            } else if (this.head != null){
                this.head = head.previousNode = null;
            } else {
                this.tail = null;
            }
        } else {
            System.out.println("list is empty");
        }
    }

    /*
    removeLast()
    HA ¬isEmpty() AKKOR
        HA Tail==Head AKKOR removeFirst(); VÉGE
        HA isLast() AKKOR Akt <- Tail.Elozo
                                 Tail <- Tail.Elozo
                                 Tail.Kovetkezo <- null
     */
    //Az utolso elem torlese
    public void removeLast() {

        if (!isEmpty()) {
            size--;
            if (this.tail == this.head) {
                removeFirst();
            } else if (isLast()){
                this.actualNode = this.tail.previousNode;
                this.tail = this.tail.previousNode;
                this.tail.nextNode = null;
            }
        } else {
            System.out.println("list is empty");
        }
    }

    /*
    removeActual()
    HA ¬isEmpty() AKKOR
    HA isFirst() AKKOR removeFirst(); VÉGE
    HA isLast() AKKOR removeLast(); VÉGE
    Akt.Elozo.Kovektkezo <- Akt.Kovektezo
    Akt.Kovetkezo.Elozo <- Akt.Elozo
    Akt <- Akt.Kovetkezo
     */
    //actualis elem torlese
    public void removeActual() {
        if (!isEmpty()) {
            size--;
            if (isFirst()){
                removeFirst();
            } else if (isLast()){
                removeLast();
            } else {
                this.actualNode.previousNode.nextNode = this.actualNode.nextNode;
                this.actualNode.nextNode.previousNode = this.actualNode.previousNode;
                this.actualNode = this.actualNode.nextNode;
            }

        } else {
            System.out.println("list is empty");
        }
    }

    public int getSize() {
        return size;
    }

}
