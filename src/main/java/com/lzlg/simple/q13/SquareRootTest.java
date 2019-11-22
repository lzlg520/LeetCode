package com.lzlg.simple.q13;

import org.junit.Test;

/**
 * 实现 int sqrt(int x) 函数。
 * <p>
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * <p>
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 4
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 */
public class SquareRootTest {

    public int mySqrt(int x) {
//        return (int) Math.sqrt(x);

        // 使用牛顿法
        // x ^ 2 = a;
        long a = x;
        while (a * a > x) {
            a = (a + x / a) / 2;
        }
        return (int) a;
    }

    @Test
    public void test() {
        int r = mySqrt(8);
        System.out.println(r);
    }
}
