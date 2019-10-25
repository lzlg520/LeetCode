package com.lzlg.q7;

import org.junit.Test;

/**
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * <p>
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 * <p>
 * 说明:
 * <p>
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 示例 1:
 * <p>
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 * <p>
 * 输入:
 * s = "aa"
 * p = "a*"
 * 输出: true
 * 解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * 示例 3:
 * <p>
 * 输入:
 * s = "ab"
 * p = ".*"
 * 输出: true
 * 解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 * 示例 4:
 * <p>
 * 输入:
 * s = "aab"
 * p = "c*a*b"
 * 输出: true
 * 解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 * 示例 5:
 * <p>
 * 输入:
 * s = "mississippi"
 * p = "mis*is*p*."
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/regular-expression-matching
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;

        // * 匹配前一个字符0个或多个
        // . 匹配任意一个字符
        int slen = s.length();
        int plen = p.length();
        // 动态规划算法
        // match[i][j] 表示 s的i长度字符 是否和 p的j长度的字符匹配
        boolean[][] match = new boolean[slen + 1][plen + 1];

        // 初始化match数组的值
        match[0][0] = true;

        // 初始化match数组第一个数组元素的值
        for (int i = 1; i <= plen; i++) {
            if (p.charAt(i - 1) == '*') {
                match[0][i] = match[0][i - 2];
            }
        }

        for (int i = 1; i <= slen; i++) {
            for (int j = 1; j <= plen; j++) {
                // 如果p当前字符是 . 或者匹配s当前字符，则查看match数组中左上方位置是否匹配
                if (p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i - 1)) {
                    match[i][j] = match[i - 1][j - 1];

                    // 如果p当前字符是 * ，匹配0个或多个字符
                } else if (p.charAt(j - 1) == '*') {
                    // 1.如果p的上个字符是 . 或者匹配s当前字符，则查看左边位置或 p的上上字符是否匹配
                    if (p.charAt(j - 2) == '.' || p.charAt(j - 2) == s.charAt(i - 1)) {
                        match[i][j] = match[i - 1][j] || match[i][j - 2];
                    } else {
                        // 2. p的上上字符是否匹配
                        match[i][j] = match[i][j - 2];
                    }
                }
            }
        }

        return match[slen][plen];
    }

    @Test
    public void test() {

        String s = "aa";
        String p = "a*";
        System.out.println(isMatch(s, p));
    }
}
