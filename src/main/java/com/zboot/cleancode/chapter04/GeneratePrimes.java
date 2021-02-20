package com.zboot.cleancode.chapter04;

import java.util.Arrays;

/**
 * 
 * @date 创建时间:2019年6月23日上午10:58:39
 * @title 标题（要求能简洁地表达出类的功能和职责）
 * @description 描述（简要描述类的职责、实现方式、使用注意事项等）
 * @author  周祥庭
 */
public class GeneratePrimes {

    public static int[] generatePrimes(int maxValue) {
        if (maxValue >= 2) {
            int s = maxValue + 1;
            boolean[] f = new boolean[s];

            int i = 0;
            for (i = 0; i < s; i++) {
                f[i] = true;
                f[0] = f[1] = false;
            }
            int j = 0;
            for (i = 2; i < Math.sqrt(s) + 1; i++) {
                if (f[i]) {
                    for (j = 2 * i; j < s; j += i) {
                        f[j] = false;
                    }
                }
            }
            int count = 0;
            for (i = 0; i < s; i++) {
                if (f[i]) {
                    count++;
                }
            }
            int[] primes = new int[count];

            for (i = 0, j = 0; i < s; i++) {
                if (f[i]) {
                    primes[j++] = i;
                }
            }
            return primes;
        } else {
            return new int[0];
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(generatePrimes(2)));
    }
}
