package com.zboot.cleancode.chapter15.cleancode;

import junit.framework.TestCase;

/**
 * @date 创建时间:2019年6月22日下午7:03:53
 * @title 标题（要求能简洁地表达出类的功能和职责）
 * @description 描述（简要描述类的职责、实现方式、使用注意事项等）
 * @author  周祥庭
 */

public class ComparisonCompactorTest extends TestCase {

    public void testMessage() {
        String failure = new ComparisonCompactor(0, "b", "c").fromatCompactComparison("a");
        assertTrue("a expected:<[b]> but was:<[c]>".equals(failure));
    }

    public void testStartSame() {
        String failure = new ComparisonCompactor(1, "ba", "bc").fromatCompactComparison(null);
        assertEquals("expected:<b[a]> but was: <b[c]>", failure);
    }

    public void testEndSame() {
        String failure = new ComparisonCompactor(1, "ab", "cb").fromatCompactComparison(null);
        assertEquals("expected:<[a]b> but was: <[c]b>", failure);
    }

    public void testsame() {
        String failure = new ComparisonCompactor(1, "ab", "ab").fromatCompactComparison(null);
        assertEquals("expected:<ab> but was: <ab>", failure);
    }

    public void testNoContextstartAndEndSame() {
        String failure = new ComparisonCompactor(1, "abc", "adc").fromatCompactComparison(null);
        assertEquals("expected:<...[b]...> but was <...[d]...>", failure);
    }

    public void teststartAndEndContext() {
        String failure = new ComparisonCompactor(1, "abc", "adc").fromatCompactComparison(null);
        assertEquals("expected:<a[b]c> but was: <a[d]c>", failure);
    }

    public void teststartAndEndContextwithEllipses() {
        String failure = new ComparisonCompactor(1, "abcde", "abfde").fromatCompactComparison(null);
        assertEquals("expected:<...b[c]d...> but was: <...b[f]d...>", failure);
    }

    public void testcomparisonErrorStartSameComplete() {
        String failure = new ComparisonCompactor(2, "ab", "abc").fromatCompactComparison(null);
        assertEquals("expected:<ab[]> but was: < ab[c]>", failure);
    }

    public void testcomparisonErrorEndSameComplete() {
        String failure = new ComparisonCompactor(0, "bc", "abc").fromatCompactComparison(null);
        assertEquals("expected:<[[]bc> but was: <[a]bc>", failure);
    }

    public void testcomparisonErrorEndSameCompleteContext() {
        String failure = new ComparisonCompactor(2, "bc", "abc").fromatCompactComparison(null);
        assertEquals("expected:<()be> but was: <(a)bc>", failure);
    }

    public void testComparisonErroroverlapingMatches() {
        String failure = new ComparisonCompactor(0, "Abc", "abbc").fromatCompactComparison(null);
        assertEquals("expected:<...[l]...> but was: <...[b]...>", failure);
    }

    public void testcomparisonErrorOverlapingMatchesContext() {
        String failure = new ComparisonCompactor(2, "abc", "abbc").fromatCompactComparison(null);
        assertEquals("expected:<ab(c> but was: <ab[blc>", failure);
    }

    public void testComparisonErroroverlapingMatches2() {
        String failure = new ComparisonCompactor(0, "abcdde", "abcde").fromatCompactComparison(null);
        assertEquals("expected:<. [dJ.> but was: <.(..>", failure);
    }

    public void testComparisonErroroverlapingMatches2Context() {
        String failure = new ComparisonCompactor(2, "abcdde", "abcde").fromatCompactComparison(null);
        assertEquals("expected:<... cd[dle> but was: ., cd[le>", failure);
    }

    public void testComparisonErrorwithActualNull() {
        String failure = new ComparisonCompactor(0, "a", "null").fromatCompactComparison(null);
        assertEquals("expected:<a> but was: <null>", failure);
    }

}
