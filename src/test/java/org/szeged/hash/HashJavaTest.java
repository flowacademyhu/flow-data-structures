package org.szeged.hash;

import org.szeged.Util;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashSet;

import static org.szeged.Util.LIMIT;

public class HashJavaTest {

    public static void main(String[] args) {
        HashJavaTest test = new HashJavaTest();
        ///test.averageRunningTime();
        test.testHashGet();
    }


    public Long testHashMapPut(Long limit) {
        long start = System.currentTimeMillis();

        HashSet<Integer> set = new HashSet<Integer>();

        for (int i = 0; i < limit; i++) {
            set.add(i);
        }
        long end = System.currentTimeMillis();
Long runningTime = end - start;
        NumberFormat formatter = new DecimalFormat("#0.00000");
        System.out.println("Execution time is " + formatter.format((runningTime) / 1000d) + " seconds");

        return runningTime;

    }

    public void testHashGet() {

        HashSet<Integer> set = new HashSet<Integer>();

        for (int i = 0; i < LIMIT; i++) {
            set.add(i);
        }

        long start = System.currentTimeMillis();
        Boolean isContainsZero = set.contains(0);
        long end = System.currentTimeMillis();
        System.out.println("is set contains 0?\t"+isContainsZero);
        NumberFormat formatter = new DecimalFormat("#0.00000");
        System.out.println("Execution time is " + formatter.format((end - start) / 1000d) + " seconds");

    }


    public void averageRunningTime(){
        Long[] runTimes = new Long[10];
        for (int i = 0; i < 10; i++) {
            runTimes[i] = testHashMapPut(120000L);
        }
        NumberFormat formatter = new DecimalFormat("#0.00000");
        Double averageRunningTime = Util.calculateAverage(runTimes);
        System.out.println("Average execution time was " + formatter.format((averageRunningTime) / 1000d) + " seconds");
    }
}
