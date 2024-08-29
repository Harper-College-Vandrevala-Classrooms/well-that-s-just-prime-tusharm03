package com.csc;

import java.util.ArrayList;
import java.util.List;

public class Factorizer {

    //to calculate prime factors and return them as list
    public List<Integer> primeFactors(int n) {
        if (n <= 1) {
            return null; 
        }
        
        List<Integer> factors = new ArrayList<>();
        
        //factor out 2s
        while (n % 2 == 0) {
            factors.add(2);
            n /= 2;
        }
        
        //factor out odd numbers from 3 upwards
        for (int i = 3; i * i <= n; i += 2) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }
        
        //if remaining number is greater than 2, is a prime factor
        if (n > 2) {
            factors.add(n);
        }
        
        return factors;
    }

    //to check if a number is prime
    public boolean isPrime(int n) {
        if (n <= 1) {
            return false; 
        }
        List<Integer> factors = primeFactors(n);
        return factors.size() == 1 && factors.get(0) == n;
    }

    //to calculate the gcd
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    //to simplify a fraction
    public String reduce(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero.");
        }
        if (numerator == 0) {
            return "0"; 
        }

        int gcd = gcd(numerator, denominator);
        
        //simplify numerator and denominator
        int simplifiedNumerator = numerator / gcd;
        int simplifiedDenominator = denominator / gcd;

        if (simplifiedDenominator == 1) {
            return String.valueOf(simplifiedNumerator);
        } else if (simplifiedNumerator == 0) {
            return "0";
        } else {
            return simplifiedNumerator + "/" + simplifiedDenominator;
        }
    }
}
