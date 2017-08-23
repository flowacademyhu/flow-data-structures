package org.szeged.tree;

import org.szeged.queue.QueueDinamic;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Random;

/**
 * Created by istvan on 8/16/17.
 */
public class TreeTest {

    public static void main(String[] args) {
        TreeTest test = new TreeTest();
        test.insertToTree();
//test.insertRandomValuesToTree();
    }

    public void insertToTree(){
        long start = System.currentTimeMillis();
        BinTreeJava tree = new BinTreeJava();
        BinTreeNode root = tree.insertNode(null,0);
        Random random = new Random();
        for (int i=1; i< 1200000; i++){
            tree.insertNode(root,random.nextInt(1200000));
        }
        long end = System.currentTimeMillis();
        tree.printTree(root);

        //tree.printTree(root);
        NumberFormat formatter = new DecimalFormat("#0.00000");
        System.out.print("Execution time is " + formatter.format((end - start) / 1000d) + " seconds");
    }

    public void insertRandomValuesToTree(){

        Random random = new Random();

        QueueDinamic sor = new QueueDinamic();

        BinTreeJava tree = new BinTreeJava();
        int value = random.nextInt(100);
        sor.in(value);
        BinTreeNode root = tree.insertNode(null,value);
        for (int i=1; i< 12; i++){
            int randomValue = random.nextInt(100);
            tree.insertNode(root,randomValue);
            sor.in(randomValue);
        }

        System.out.println(sor);
        BTreePrinter.printNode(root);
    }
}
