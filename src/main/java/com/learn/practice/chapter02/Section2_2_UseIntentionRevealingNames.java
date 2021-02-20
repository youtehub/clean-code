package com.learn.practice.chapter02;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用名副其实的命名
 *
 * @author yiyh
 * @date 2021-02-20 21:10
 */
public class Section2_2_UseIntentionRevealingNames {


    // 消逝的时间，以日计
    // 没有引起时间消逝的感觉，更别说日计
    int d;

    //选择指明计量对象和计量单位的名称
    int elapsedTimeInDays;
    int daysSinceCreation;
    int daysSinceModification;
    int fileAgeInDays;


    /**
     * 原始模棱两可的方法
     *
     * @return 一个数组集合
     */
    public List<int[]> getThem() {
        List<int[]> theList = new ArrayList<>();
        List<int[]> list1 = new ArrayList<>();
        for (int[] x : theList) {
            if (x[0] == 4) {
                list1.add(x);
            }
        }
        return list1;
    }

    private static final Integer STATUS_VALUE = 0;
    private static final Integer FLAGGED = 4;
    /**
     * 获取扫雷是命中的空格
     *
     * @return 已被标记的空格
     */
    public List<int[]> getFlaggedCells() {
        List<int[]> gameBoard = new ArrayList<>();
        List<int[]> flaggedCells = new ArrayList<>();
        for (int[] cell : gameBoard) {
            if (cell[STATUS_VALUE] == FLAGGED) {
                flaggedCells.add(cell);
            }
        }
        return flaggedCells;
    }
}
