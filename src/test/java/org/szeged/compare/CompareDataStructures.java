package org.szeged.compare;


import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;

public class CompareDataStructures {

    private static Long NUMBER_OF_ITEMS = 12000000L;

    public static void main(String[] args) {
        CompareDataStructures compare = new CompareDataStructures();

        //compare.measureCreateSet();
        compare.measureAVGcreateLinkedList();
        //compare.createLinkedList();
        //compare.measureAVGcreateArrayList();
    }

    public void measureAvgCreateSet() {
        Long runningTime = 0L;
        for (int i = 0; i < 10; i++) {
            runningTime += measureCreateSet();
        }
        System.out.println("Average time to create a hashSet was: " + (runningTime / 10) / 1000d + " seconds...");
    }

    public Long measureCreateSet() {
        long start = System.currentTimeMillis();
        HashSet<Integer> set = createHashSet(NUMBER_OF_ITEMS);
        long end = System.currentTimeMillis();
        System.out.println("size of set: \t " + set.size());
        //tree.printTree(root);
        NumberFormat formatter = new DecimalFormat("#0.00000");
        Long runningTime = end - start;
        System.out.println("to create hashset execution time is " + formatter.format((runningTime) / 1000d) + " seconds");
        return runningTime;
    }

    private HashSet<Integer> createHashSet(long numberOfItems) {
        HashSet<Integer> set = new HashSet<Integer>();

        Random random = new Random();

        for (int i = 0; i < numberOfItems; i++) {
            set.add(random.nextInt(12000000));
        }

        return set;
    }

    public void measureAVGcreateLinkedList() {
        Long runningTime = 0L;
        for (int i = 0; i < 10; i++) {
            runningTime += measureCreateLinkedList();
        }
        System.out.println("Average time to create a LinkedList was: " + runningTime / 10 / 1000 + " seconds...");
    }

    public Long measureCreateLinkedList() {
        long start = System.currentTimeMillis();
        LinkedList<Integer> linkedList = createLinkedList(NUMBER_OF_ITEMS);

        long end = System.currentTimeMillis();
        System.out.println("size of linkedList: \t " + linkedList.size());
        System.out.println("Size of linkedList: \t" + ObjectSizeCalculator.getObjectSize(linkedList));
        Long runningTime = end - start;
        NumberFormat formatter = new DecimalFormat("#0.00000");
        System.out.println("To create LinkedList execution time is " + formatter.format((runningTime) / 1000d) + " seconds");
        return runningTime;
    }

    private LinkedList<Integer> createLinkedList(long numberOfItems) {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        System.out.println("Size of empty linkedList: \t" + ObjectSizeCalculator.getObjectSize(linkedList));
        Random random = new Random();

        for (int i = 0; i < NUMBER_OF_ITEMS; i++) {
            linkedList.add(random.nextInt(10));
        }

        return linkedList;
    }

    public void measureAVGcreateArrayList() {
        Long runningTime = 0L;
        for (int i = 0; i < 10; i++) {
            runningTime += measureCreateArrayList();
        }
        System.out.println("Average time to create a ArrayList was: " + (runningTime / 10) / 1000d + " seconds...");
    }

    public Long measureCreateArrayList() {
        long start = System.currentTimeMillis();
        ArrayList<Integer> arrayList = createArrayList();

        long end = System.currentTimeMillis();
        System.out.println("Number of element in arrayList: \t " + arrayList.size());
        System.out.println("Size of arrayList: \t" + ObjectSizeCalculator.getObjectSize(arrayList));
        Long runningTime = end - start;
        NumberFormat formatter = new DecimalFormat("#0.00000");
        System.out.println("To create array list execution time is " + formatter.format((runningTime) / 1000d) + " seconds");
        return runningTime;
    }

    public ArrayList<Integer> createArrayList() {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        System.out.println("Size of empty arrayList: \t" + ObjectSizeCalculator.getObjectSize(arrayList));
        Random random = new Random();

        for (int i = 0; i < NUMBER_OF_ITEMS; i++) {
            arrayList.add(random.nextInt(10));
        }
        return arrayList;
    }


}
