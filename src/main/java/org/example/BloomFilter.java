package org.example;

public class BloomFilter {

    private final boolean[] bitMap;

    //A larger filter size means more memory is required but will decrease the false positive rate.
    private final int size;
    private final int hashCount;

    public BloomFilter(int size, int hashCount) {
        this.size = size;

        //The hashCount variable in the Bloom filter implementation is used to determine the number of times the input string should be hashed.
        this.hashCount = hashCount;
        this.bitMap = new boolean[size];
    }

    //The add method sets the appropriate indexes in the filter to true
    public void add(String item) {
        for (int i = 0; i < hashCount; i++) {
            int index = hash(item, i);
            bitMap[index] = true;
        }
    }

    //checks whether all the indexes associated with an item are true. If all the indexes are set to true, the item is considered to be in the filter, otherwise it is not.
    public boolean check(String item) {
        for (int i = 0; i < hashCount; i++) {
            int index = hash(item, i);
            if (!bitMap[index]) {
                return false;
            }
        }
        return true;
    }

    private int hash(String item, int i) {
        return (item.hashCode() + i) % size;
    }
}
