/**
 * 
 */
package com.zboot.cleancode.chapter10.first.mycleancode;

import java.util.Arrays;

/**
 * @date 创建时间:2019年6月22日下午12:45:09
 * @title 素数输出器
 * @description 描述（简要描述类的职责、实现方式、使用注意事项等）
 * @author  周祥庭
 */
public class PrimePrinter {

    public static void main(String[] args) {
        //获取想要的素数数组
        //按照需要的格式输出数组
        int num_of_prime = 1000;
        PrimeGenerator generator = new PrimeGenerator();
        int[] primes = generator.generate(num_of_prime);
        System.out.println(primes.length);
        String str_primes = Arrays.toString(primes);
        System.out.println("String:" + str_primes);
    }
}
