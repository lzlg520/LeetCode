package com.lzlg.simple.q11;

import org.junit.Test;

import java.util.Arrays;

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 * <p>
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 */
public class PlusOneTest {
    /**
     * 自己做的答案
     *
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) return new int[]{};
        int len = digits.length;
        int[] result = Arrays.copyOf(digits, len);
        if (result[len - 1] + 1 == 10) {
            for (int i = len - 1; i >= 0; i--) {
                if (result[len - 1] + 1 == 10 || result[i] == 10) {
                    if (i == 0) {
                        result = new int[len + 1];
                        result[0] = 1;
                    } else {
                        result[i - 1] = result[i - 1] + 1;
                        result[i] = 0;
                    }
                }
            }
        } else {
            result[len - 1] = result[len - 1] + 1;
        }
        return result;
    }

    /**
     * 网友的答案
     *
     * @param digits
     * @return
     */
    public int[] plusOne2(int[] digits) {
        int len = digits.length;
        for (int i = len - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] %= 10;
            if (digits[i] != 0)
                return digits;
        }
        digits = new int[len + 1];
        digits[0] = 1;
        return digits;
    }

    @Test
    public void test() {
        int[] digits = {4, 3, 2, 9};
        // int[] result = Arrays.copyOf(digits, digits.length);
        int[] result = plusOne(digits);
        System.out.println(Arrays.toString(result));
    }
}
