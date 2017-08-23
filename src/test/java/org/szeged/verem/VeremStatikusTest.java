package org.szeged.verem;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class VeremStatikusTest {

    public static void main(String[] args) {
        VeremStatikusTest test = new VeremStatikusTest();
        //test.statikusVeremIndex();
        test.testVeremPop();
    }

    public void statikusVeremIndex(){
        long start = System.currentTimeMillis();

        VeremStatikus verem = new VeremStatikus(10);

        for (int i = 0; i< 12; i++) {
            verem.push(i);
        }

        long end = System.currentTimeMillis();

        NumberFormat formatter = new DecimalFormat("#0.00000");
        System.out.print("Execution time is " + formatter.format((end - start) / 1000d) + " seconds");
    }

    public void testVeremPop(){
        VeremStatikus verem = new VeremStatikus(10);

        for (int i = 0; i< 12; i++) {
            verem.push(i);
        }

        System.out.println("A verem legfelső eleme: " + verem.top());

        assertEquals(9,verem.pop());
    }
}
