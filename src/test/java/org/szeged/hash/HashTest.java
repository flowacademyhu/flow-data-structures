package org.szeged.hash;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Random;

public class HashTest {

    public static void main(String[] args) {
        HashTest test = new HashTest();
        //test.testHashMapPut();
        test.testHashGet();
    }

    public void testHashMapPut() {
        long start = System.currentTimeMillis();

        HashMap map = new HashMap();
        Random random = new Random();
        for (int i = 0; i < 130; i++) {
            map.put(i, random.nextInt(10));
        }
        long end = System.currentTimeMillis();

        NumberFormat formatter = new DecimalFormat("#0.00000");
        System.out.print("Execution time is " + formatter.format((end - start) / 1000d) + " seconds");

    }

    public void testHashGet() {

        HashMap map = new HashMap();

        Random random = new Random();
        for (int i = 0; i < 135; i++) {
            map.put(i, random.nextInt(10));
        }


        for (int i = 0; i < 135; i++) {
            System.out.println("A map aktuális eleme a kulcshoz: " + i + "\t ertek:\t" + map.get(i));

        }
    }
}
