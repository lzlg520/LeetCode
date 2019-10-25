package com.lzlg.simple.q2;

import org.junit.Test;

/**
 * 在一个「平衡字符串」中，'L' 和 'R' 字符的数量是相同的。
 *
 * 给出一个平衡字符串 s，请你将它分割成尽可能多的平衡字符串。
 *
 * 返回可以通过分割得到的平衡字符串的最大数量。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "RLRRLLRLRL"
 * 输出：4
 * 解释：s 可以分割为 "RL", "RRLL", "RL", "RL", 每个子字符串中都包含相同数量的 'L' 和 'R'。
 * 示例 2：
 *
 * 输入：s = "RLLLLRRRLR"
 * 输出：3
 * 解释：s 可以分割为 "RL", "LLLRRR", "LR", 每个子字符串中都包含相同数量的 'L' 和 'R'。
 * 示例 3：
 *
 * 输入：s = "LLLLRRRR"
 * 输出：1
 * 解释：s 只能保持原样 "LLLLRRRR".
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s[i] = 'L' 或 'R'
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/split-a-string-in-balanced-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BalancedStringSplit {
    public int balancedStringSplit(String s) {
        if(s == null || s.length() == 0) return 0;
        int l = 0;
        int r = 0;
        int result = 0;
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if(c == 'L') {
                l++;
            }
            if(c == 'R') {
                r++;
            }
            if(l == r) {
                result++;
                l = 0;
                r = 0;
            }
        }
        return result;
    }

    @Test
    public void test() {
        String s = "RLRRLLRLRL";
        System.out.println(balancedStringSplit(s));
    }
}
