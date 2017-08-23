package org.szeged.tree;

/**
 * Created by istvan on 8/10/17.
 */
public class BinTreeNode {


    private int value;
    private BinTreeNode rightNode;
    private BinTreeNode leftNode;

    public BinTreeNode(int value, BinTreeNode rightNode, BinTreeNode leftNode) {
        this.value = value;
        this.rightNode = rightNode;
        this.leftNode = leftNode;
    }


    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public BinTreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(BinTreeNode rightNode) {
        this.rightNode = rightNode;
    }

    public BinTreeNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(BinTreeNode leftNode) {
        this.leftNode = leftNode;
    }

    @Override
    public String toString() {
        return "BinTreeNode{" +
                "value=" + value +
                ", rightNode=" + rightNode +
                ", leftNode=" + leftNode +
                '}';
    }
}
