package com.lzlg.q5;

import org.junit.Test;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 *  示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseInteger {

    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int newResult = result * 10 + x % 10;
            if ((newResult - x % 10) / 10 != result) return 0;
            result = newResult;
            x /= 10;
        }
        return result;
    }

    @Test
    public void test() {
        int x = 1235678997;
        int maxValue = Integer.MAX_VALUE;
        System.out.println(maxValue);
        System.out.println(reverse(x));
    }
}
