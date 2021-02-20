package com.zboot.cleancode.chapter15.cleancode;

import junit.framework.Assert;

/**
 * @date 创建时间:2019年6月22日下午7:07:39
 * @title 标题（要求能简洁地表达出类的功能和职责）
 * @description 描述（简要描述类的职责、实现方式、使用注意事项等）
 * @author  周祥庭
 */
public class ComparisonCompactor {

    private static final String ELLIPSIS = "...";
    private static final String DELTA_END = "]";
    private static final String DELTA_START = "[";

    private int contextLength;
    private String expected;
    private String compactExpected;
    private String compactActual;
    private String actual;
    private int prefixLength;
    private int suffixLength;

    public ComparisonCompactor(int contextLength, String expected, String actual) {
        this.contextLength = contextLength;
        this.expected = expected;
        this.actual = actual;
    }

    @SuppressWarnings("deprecation")
    public String fromatCompactComparison(String message) {
        compactExpected = expected;
        compactActual = actual;
        if (canBeCompact()) {
            //找到前面几个字母相同
            compactExpAndActual();
        }
        return Assert.format(message, compactExpected, compactActual);

    }

    private boolean canBeCompact() {
        return expected == null || actual == null || areStringEqual();
    }

    private void compactExpAndActual() {
        prefixLength = findCommonPrefix();
        //找到后面有几个字母xiangtong
        suffixLength = findCommonSuffix(prefixLength);
        compactExpected = compactString(this.expected);
        compactActual = compactString(this.actual);
    }

    private String compactString(String source) {
        String result = DELTA_START + source.substring(prefixLength, source.length() - suffixLength + 1) + DELTA_END;
        if (prefixLength > 0) {
            result = computeCommonprefixLength() + result;
        }
        if (suffixLength > 0) {
            result = result + computeCommonsuffixLength();
        }
        return result;
    }

    private int findCommonPrefix() {
        prefixLength = 0;
        int end = Math.min(expected.length(), actual.length());
        for (; prefixLength < end; prefixLength++) {

            if (expected.charAt(prefixLength) != actual.charAt(prefixLength))
                break;
        }
        return prefixLength;
    }

    private int findCommonSuffix(int prefixLength) {
        int expectedsuffixLength = expected.length() - 1;
        int actualsuffixLength = actual.length() - 1;
        for (; actualsuffixLength > prefixLength && expectedsuffixLength >= prefixLength; actualsuffixLength--, expectedsuffixLength--) {
            if (expected.charAt(expectedsuffixLength) != actual.charAt(actualsuffixLength))
                break;
        }
        return expected.length() - expectedsuffixLength;

    }

    private String computeCommonprefixLength() {
        return (prefixLength > contextLength ? ELLIPSIS : "") + expected.substring(Math.max(0, prefixLength - contextLength), prefixLength);
    }

    private String computeCommonsuffixLength() {
        int end = Math.min(expected.length() - suffixLength + 1 + contextLength, expected.length());
        return expected.substring(expected.length() - suffixLength + 1, end) + (expected.length() - suffixLength + 1 < expected.length() - contextLength ? ELLIPSIS : "");
    }

    private boolean areStringEqual() {
        return expected.equals(actual);
    }
}
