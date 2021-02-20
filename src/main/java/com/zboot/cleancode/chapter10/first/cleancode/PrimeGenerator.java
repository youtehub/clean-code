package com.zboot.cleancode.chapter10.first.cleancode;

import java.util.ArrayList;

public class PrimeGenerator {
    private static int[] primes;
    private static ArrayList<Integer> multiplesOfPrimeFactors;

    protected static int[] generate(int n) {
        primes = new int[n];
        multiplesOfPrimeFactors = new ArrayList<Integer>();
        set2AsFirstPrime();
        checkAddNumbersForSubsequentPrimes();
        return primes;
    }

    private static void set2AsFirstPrime() {
        primes[0] = 2;
        multiplesOfPrimeFactors.add(2);
    }

    private static void checkAddNumbersForSubsequentPrimes() {
        int primeIndex = 1;
        for (int candidate = 3; primeIndex < primes.length; candidate += 2) {
            if (isPrime(candidate))
                primes[primeIndex++] = candidate;
        }
    }

    private static boolean isPrime(int candidate) {
        if (isLeastRelevantMultipleOfNextLargerPrimeFactor(candidate)) {
            multiplesOfPrimeFactors.add(candidate);
            return false;
        }
        return isNotMultipleOfAnyPreviousPrimeFactor(candidate);
    }

    private static boolean isLeastRelevantMultipleOfNextLargerPrimeFactor(int candidate) {
        int nextLargerPrimeFactor = primes[multiplesOfPrimeFactors.size()];
        int leasstRelevantMultiple = nextLargerPrimeFactor * nextLargerPrimeFactor;
        return candidate == leasstRelevantMultiple;
    }

    private static boolean isNotMultipleOfAnyPreviousPrimeFactor(int candidate) {
        for (int n = 1; n < multiplesOfPrimeFactors.size(); n++) {
            if (isMultipleOfNthPrimeFacotr(candidate, n)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isMultipleOfNthPrimeFacotr(int canditate, int n) {
        return canditate == smallesOddNthMultipleNotLessThanCandidate(canditate, n);
    }

    private static int smallesOddNthMultipleNotLessThanCandidate(int canditate, int n) {
        int multiple = multiplesOfPrimeFactors.get(n);
        while (multiple < canditate) {
            multiple += 2 * primes[n];
        }
        multiplesOfPrimeFactors.set(n, multiple);
        return multiple;
    }
}
