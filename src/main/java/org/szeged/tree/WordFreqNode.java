package org.szeged.tree;

/**
 * Created by istvan on 8/10/17.
 */
public class WordFreqNode {

    private String word;
    private Integer freq;
    private WordFreqNode leftNode;
    private WordFreqNode righNode;

    public WordFreqNode(String word, Integer freq, WordFreqNode leftNode, WordFreqNode righNode) {
        this.word = word;
        this.freq = freq;
        this.leftNode = leftNode;
        this.righNode = righNode;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Integer getFreq() {
        return freq;
    }

    public void setFreq(Integer freq) {
        this.freq = freq;
    }

    public WordFreqNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(WordFreqNode leftNode) {
        this.leftNode = leftNode;
    }

    public WordFreqNode getRighNode() {
        return righNode;
    }

    public void setRighNode(WordFreqNode righNode) {
        this.righNode = righNode;
    }

    @Override
    public String toString() {
        return "WordFreqNode{" +
                "word='" + word + '\'' +
                ", freq=" + freq +
                ", leftNode=" + leftNode +
                ", righNode=" + righNode +
                '}';
    }
}
