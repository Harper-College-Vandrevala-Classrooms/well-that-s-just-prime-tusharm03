package com.csc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestFactorizer {

    Factorizer factorizer;

    @BeforeEach
    void setUp() {
        factorizer = new Factorizer();
    }

    @Test
    public void testPrimeFactorsLessThanOrEqualToOne() {
        //test numbers less than or equal to 1
        assertNull(factorizer.primeFactors(0));
        assertNull(factorizer.primeFactors(1));
    }

    @Test
    public void testPrimeFactorsOfPrimeNumbers() {
        //test prime numbers
        assertEquals(List.of(2), factorizer.primeFactors(2));
        assertEquals(List.of(3), factorizer.primeFactors(3));
        assertEquals(List.of(5), factorizer.primeFactors(5));
        assertEquals(List.of(7), factorizer.primeFactors(7));
        assertEquals(List.of(29), factorizer.primeFactors(29));
    }

    @Test
    public void testPrimeFactorsOfCompositeNumbers() {
        //test composite numbers
        assertEquals(List.of(2, 2), factorizer.primeFactors(4)); 
        assertEquals(List.of(2, 2, 3), factorizer.primeFactors(12)); 
        assertEquals(List.of(2, 2, 7), factorizer.primeFactors(28)); 
        assertEquals(List.of(2, 2, 3, 5), factorizer.primeFactors(60)); 
        assertEquals(List.of(2, 2, 2, 5, 5), factorizer.primeFactors(200)); 
    }


    @Test
    public void testIsPrime() {
        //test for prime numbers
        assertTrue(factorizer.isPrime(2));
        assertTrue(factorizer.isPrime(3));
        assertTrue(factorizer.isPrime(5));
        assertTrue(factorizer.isPrime(7));
        assertTrue(factorizer.isPrime(29));
        
        //test non-prime numbers
        assertFalse(factorizer.isPrime(4));
        assertFalse(factorizer.isPrime(6));
        assertFalse(factorizer.isPrime(8));
        assertFalse(factorizer.isPrime(9));
        assertFalse(factorizer.isPrime(12));
        
        //test numbers less than or equal to 1
        assertFalse(factorizer.isPrime(0));
        assertFalse(factorizer.isPrime(1));
    }

    @Test
    public void testReduce() {
        //test fractions that can be simplified
        assertEquals("3", factorizer.reduce(36, 12)); 
        assertEquals("6/7", factorizer.reduce(12, 14)); 
        assertEquals("1/2", factorizer.reduce(8, 16)); 
        
        //test fractions that are in their simplest form
        assertEquals("5/7", factorizer.reduce(5, 7)); 
        assertEquals("12/37", factorizer.reduce(12, 37)); 
        
        //test special cases
        assertEquals("0", factorizer.reduce(0, 10)); 
        assertEquals("1", factorizer.reduce(10, 10)); 
        assertEquals("6/13", factorizer.reduce(12, 26)); 
    }
}
