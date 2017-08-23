package org.szeged.verem;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class VeremDinamikusGenericsTest {

    public static void main(String[] args) {
        VeremDinamikusGenericsTest test = new VeremDinamikusGenericsTest();
        test.dinamikusVeremIndex();
    }

    public void dinamikusVeremIndex() {
        long start = System.currentTimeMillis();

        VeremDinamikusGenerics<Integer> verem = new VeremDinamikusGenerics<Integer>();

        for (int i = 0; i < 12000; i++) {
            //verem.push(UUID.randomUUID().toString().replaceAll("-", ""));
            verem.push(i);
        }
        long end = System.currentTimeMillis();

        NumberFormat formatter = new DecimalFormat("#0.00000");
        System.out.print("Execution time is " + formatter.format((end - start) / 1000d) + " seconds");

    }
}
