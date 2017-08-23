package org.szeged.hash;

/**
 * Created by istvan on 8/10/17.
 */
public class HashEntry {
    private int key;
    private int value;

    HashEntry(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }
}
