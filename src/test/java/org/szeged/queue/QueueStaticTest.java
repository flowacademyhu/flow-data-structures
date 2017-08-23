package org.szeged.queue;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Random;

import static org.junit.Assert.assertEquals;

/**
 * Created by istvan on 8/16/17.
 */
public class QueueStaticTest {
    public static void main(String[] args) {
        QueueStaticTest test = new QueueStaticTest();
        test.testQueueOut();
    }

    public void statikusVeremIndex() {
        long start = System.currentTimeMillis();

        QueueStatic sor = new QueueStatic(10);
        Random random = new Random();
        for (int i = 0; i < 12; i++) {
            sor.in(random.nextInt(12));
        }

        long end = System.currentTimeMillis();

        NumberFormat formatter = new DecimalFormat("#0.00000");
        System.out.print("Execution time is " + formatter.format((end - start) / 1000d) + " seconds");
    }

    public void testQueueOut() {
        QueueStatic sor = new QueueStatic(10);

        for (int i = 0; i < 12; i++) {
            sor.in(i);
        }

        System.out.println("A sor legelső eleme: " + sor.first());
        System.out.println("Kivesszük sor legelső elemét: " + sor.out());

        assertEquals(1, sor.out());
    }


}
