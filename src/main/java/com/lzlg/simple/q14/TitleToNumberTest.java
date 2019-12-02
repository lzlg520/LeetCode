package com.lzlg.simple.q14;

import org.junit.Test;

/**
 * 给定一个Excel表格中的列名称，返回其相应的列序号。
 * <p>
 * 例如，
 * <p>
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 * 示例 1:
 * <p>
 * 输入: "A"
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: "AB"
 * 输出: 28
 * 示例 3:
 * <p>
 * 输入: "ZY"
 * 输出: 701
 */
public class TitleToNumberTest {
    /**
     * 正序变量解法
     *
     * @param s
     * @return
     */
    public int titleToNumber(String s) {
        char[] c = s.toCharArray();
        int res = 0;
        for (int i = 0; i < c.length; i++) {
            res = res * 26 + (c[i] - 'A' + 1);
        }
        return res;
    }

    /**
     * 倒序遍历解法
     *
     * @param s
     * @return
     */
    public int titleToNumber2(String s) {
        char[] c = s.toCharArray();
        int res = 0;
        int m = 1;
        for (int i = c.length - 1; i >= 0; i--) {
            res = res + m * (c[i] - 'A' + 1);
            m *= 26;
        }
        return res;
    }

    @Test
    public void test() {
        String s = "ZYZ";
        int v = titleToNumber(s);
        System.out.println(v);
    }
}
