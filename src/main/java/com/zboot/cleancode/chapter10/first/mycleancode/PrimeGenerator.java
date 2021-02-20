package com.zboot.cleancode.chapter10.first.mycleancode;

/**
 * 
 * @date 创建时间:2019年6月23日上午10:59:48
 * @title 标题（要求能简洁地表达出类的功能和职责）
 * @description 描述（简要描述类的职责、实现方式、使用注意事项等）
 * @author  周祥庭
 */
public class PrimeGenerator {

    private int[] primes;

    public int[] generate(int num_of_prime) {
        primes = new int[num_of_prime];
        set2AsFirstPrime();
        checkOddNumbersForSubsequentPrimes();
        return primes;
    }

    private void set2AsFirstPrime() {
        primes[0] = 2;
    }

    private void checkOddNumbersForSubsequentPrimes() {
        int primeIndex = 1;
        for (int oddNum = 3; primeIndex < primes.length; oddNum += 2) {
            if (isPrime(oddNum)) {
                primes[primeIndex] = oddNum;
                primeIndex++;
            }
        }
    }

    private boolean isPrime(int oddNum) {
        return true;
    }

}
