package org.szeged.queue;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Random;

import static org.junit.Assert.assertEquals;

/**
 * Created by istvan on 8/16/17.
 */
public class QueueDinamicTest {

    public static void main(String[] args) {
        QueueDinamicTest test = new QueueDinamicTest();
        test.dinamikusSorIndex();
        //test.testSorOut();
    }

    public void dinamikusSorIndex() {
        long start = System.currentTimeMillis();

        QueueDinamic sor = new QueueDinamic();
        Random random = new Random();
        for (int i = 0; i < 1200000; i++) {
            sor.in(random.nextInt(1200000));
        }
        long end = System.currentTimeMillis();

        NumberFormat formatter = new DecimalFormat("#0.00000");
        System.out.print("Execution time is " + formatter.format((end - start) / 1000d) + " seconds");

    }

    public void testSorOut(){
        QueueDinamic sor = new QueueDinamic();

        for (int i = 0; i < 1200000; i++) {
            sor.in(i);
        }
        System.out.println("A sor legfelső eleme: " + sor.first());

        assertEquals(0,sor.first());

        for (int i = 0; i < 11; i++) {
            System.out.println("A sor legelső eleme: " + sor.out() + "\t a sor mérete:\t" + sor.getSize());
        }
    }

}
