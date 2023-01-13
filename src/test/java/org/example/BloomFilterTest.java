package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class BloomFilterTest {

    private final BloomFilter bloomFilter = new BloomFilter(1000000, 200000);

    @BeforeEach
    void setUp() {
        bloomFilter.add("1");
        bloomFilter.add("2");
        bloomFilter.add("3");
        bloomFilter.add("4");
        bloomFilter.add("5");
        bloomFilter.add("6");
        bloomFilter.add("7");
        bloomFilter.add("8");
        bloomFilter.add("9");
        bloomFilter.add("10");
    }

    @Test
    void checkTestForValidInput() {
        //Arrange

        //Act

        //Assert
        assertTrue(bloomFilter.check("5"));
        assertTrue(bloomFilter.check("8"));
        assertTrue(bloomFilter.check("1"));
    }

    @Test
    void checkTestForInvalidInput() {
        //Arrange

        //Act

        //Assert
        assertFalse(bloomFilter.check("11"));
        assertFalse(bloomFilter.check("56"));
        assertFalse(bloomFilter.check("488"));
    }
}