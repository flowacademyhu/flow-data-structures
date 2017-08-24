package org.szeged.verem;

import org.szeged.util.Util;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import static org.junit.Assert.assertEquals;

public class VeremDinamikusTest {



    public static void main(String[] args) {
        VeremDinamikusTest test = new VeremDinamikusTest();
        //test.dinamikusVeremIndex(12000L);
        //test.testVeremPop();
        test.averageRunningTime();
    }

    public void averageRunningTime(){
        Long[] runTimes = new Long[10];
        for (int i = 0; i < 10; i++) {
            runTimes[i] = dinamikusVeremIndex(120000L);
        }
        NumberFormat formatter = new DecimalFormat("#0.00000");
        Double averageRunningTime = Util.calculateAverage(runTimes);
        System.out.println("Average execution time was " + formatter.format((averageRunningTime) / 1000d) + " seconds");
    }

    public Long dinamikusVeremIndex(Long limit) {
        long start = System.currentTimeMillis();

        VeremDinamikus verem = new VeremDinamikus();

        for (int i = 0; i < limit; i++) {
            verem.push(i);
        }
        long end = System.currentTimeMillis();

        Long runningTime = end - start;
        NumberFormat formatter = new DecimalFormat("#0.00000");

        System.out.println("Execution time is " + formatter.format((runningTime) / 1000d) + " seconds");
        return runningTime;
    }

    public void testVeremPop() {
        VeremDinamikus verem = new VeremDinamikus();

        for (int i = 0; i < 12; i++) {
            verem.push(i);
        }
        System.out.println("A verem legfelső eleme: " + verem.top());

        assertEquals(11, verem.pop());


        for (int i = 0; i < 11; i++) {
            System.out.println("A verem legfelső eleme: " + verem.pop() + "\t a verem mérete:\t" + verem.getSize());
        }
    }
}
