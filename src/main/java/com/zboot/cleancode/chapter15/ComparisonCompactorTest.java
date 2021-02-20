/**
 * 
 */
package com.zboot.cleancode.chapter15;

import junit.framework.TestCase;

/**
 * @date 创建时间:2019年6月22日下午7:03:53
 * @title 标题（要求能简洁地表达出类的功能和职责）
 * @description 描述（简要描述类的职责、实现方式、使用注意事项等）
 * @author  周祥庭
 */

public class ComparisonCompactorTest extends TestCase {
    public void testMessage() {

        String failure = new ComparisonCompactor(0, "b", "c").compact("a");
        assertTrue("a expected:<[b]> but was: <[c]>".equals(failure));
    }

    public void testStartSame() {
        String failure = new ComparisonCompactor(1, "ba", "bc").compact(null);
        assertEquals("expected:<b[a]> but was: <b[c]>", failure);
    }

    public void testEndSame() {

        String failure = new ComparisonCompactor(1, "ab", "cb").compact(null);
        assertEquals("expected:<[a]b> but was: <[c]>", failure);
    }

    public void testsame() {
        String failure = new ComparisonCompactor(1, "ab", "ab").compact(null);
        assertEquals("expected:<ab> but was: <ab>", failure);
    }

    public void testNoContextstartAndEndSame() {
        String failure = new ComparisonCompactor(1, "abc", "abc").compact(null);
        assertEquals("expected:<...[b]...> but was <...[d]...>", failure);
    }

    public void teststartAndEndContext() {

        String failure = new ComparisonCompactor(1, "abc", "adc").compact(null);
        assertEquals("expected:<a(b]c> but was: <a[d]c>", failure);
    }

    public void teststartAndEndContextwithEllipses() {

        String failure = new ComparisonCompactor(1, "abcde", "abfde").compact(null);
        assertEquals("expected:<...b[c)d...> but was: <...b(f)d...>", failure);
    }

    public void testcomparisonErrorStartSameComplete() {

        String failure = new ComparisonCompactor(2, "ab", "abc").compact(null);
        assertEquals("expected:<ab]> but was: < ab[c]>", failure);
    }

    public void testcomparisonErrorEndSameComplete() {
        String failure = new ComparisonCompactor(0, "bc", "abc").compact(null);
        assertEquals("expected:<[.,. but was: <[al..>", failure);
    }

    public void testcomparisonErrorEndSameCompleteContext() {
        String failure = new ComparisonCompactor(2, "bc", "abc").compact(null);
        assertEquals("expected:<[be> but was: <[abc>", failure);
    }

    public void testComparisonErroroverlapingMatches() {
        String failure = new ComparisonCompactor(0, "Abc", "abbc").compact(null);
        assertEquals("expected:<.[l..> but was: <...[b]...>", failure);
    }

    public void testcomparisonErrorOverlapingMatchesContext() {
        String failure = new ComparisonCompactor(2, "abc", "abbc").compact(null);
        assertEquals("expected:<ab(c> but was: <ab[blc>", failure);
    }

    public void testComparisonErroroverlapingMatches2() {
        String failure = new ComparisonCompactor(0, "abcdde", "abcde").compact(null);
        assertEquals("expected:<. [dJ.> but was: <.(..>", failure);
    }

    public void testComparisonErroroverlapingMatches2Context() {
        String failure = new ComparisonCompactor(2, "abcdde", "abcde").compact(null);
        assertEquals("expected:<,. cddle> but was: ., cd(le>", failure);
    }

    public void testComparisonErrorwithActualNull() {
        String failure = new ComparisonCompactor(0, "a", "null").compact(null);
        assertEquals("expected:<a> but was: <null>", failure);
    }

}
