package com.zboot.cleancode.chapter04;

import java.util.Arrays;

/**
 * 
 * @date 创建时间:2019年6月23日上午10:58:45
 * @title 标题（要求能简洁地表达出类的功能和职责）
 * @description 描述（简要描述类的职责、实现方式、使用注意事项等）
 * @author  周祥庭
 */
public class GeneratePrimesCleanCode {

    private static boolean[] crossedOut;
    private static int[] result;

    /**
     * 
     *@name    求素数
     *@description 求不大于输入值的素数
     *@time    创建时间:2019年5月28日下午10:30:57
     *@param maxValue
     *@return
     *@author   作者
     *@history 修订历史（历次修订内容、修订人、修订时间等）
     */
    public static int[] generatePrimes(int maxValue) {
        //素数没有小于2的
        if (maxValue < 2) {
            return new int[0];
        } else {
            uncrossIntegerUpTo(maxValue);
            crossOutMutiples();
            return result;
        }
    }

    public static void uncrossIntegerUpTo(int maxValue) {
        crossedOut = new boolean[maxValue + 1];
        int i = 0;
        for (i = 2; i < crossedOut.length; i++) {
            crossedOut[i] = false;
        }
    }

    private static void crossOutMutiples() {

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(generatePrimes(1)));
    }
}
