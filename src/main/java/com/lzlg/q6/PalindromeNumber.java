package com.lzlg.q6;

import org.junit.Test;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 121
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 * <p>
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        // 获取最高位 123321 -> 100000
        int div = 1, num = x;
        while (num / div >= 10) {
            div *= 10;
        }

        while (num != 0) {
            // 判断最高位和最低位是否相同
            int high = num / div;
            int low = num % 10;
            if (high != low) return false;

            // 123321 -> 2332
            num = (num - high * div) / 10;
            div /= 100;
        }

        return true;
    }

    @Test
    public void test() {
        int n = 123321;
        System.out.println(isPalindrome(n));
    }
}
