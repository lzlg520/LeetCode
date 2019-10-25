package com.lzlg.q3;

import org.junit.Test;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;

        int len = s.length();
        int left = 0, right = 0;
        int max = 0;

        boolean[] used = new boolean[128];
        while (right < len) {

            if (used[s.charAt(right)]) {
                // 遇到相同的字符
                max = Math.max(max, right - left);

                // 移动left指针，直到 left指针和right指针的值相同
                while (left < right && s.charAt(right) != s.charAt(left)) {
                    used[s.charAt(left)] = false;
                    left++;
                }
                // left移动一位，right移动一位（跳过相同的字符）
                left++;
                right++;
            } else {
                // 开始遍历，遇到不同的字符，则将对应的元素设置为true
                used[s.charAt(right)] = true;
                right++;
            }
        }

        max = Math.max(max, right - left);

        return max;
    }

    @Test
    public void test() {
        int len = lengthOfLongestSubstring("pwwkew");
        System.out.println(len);
    }
}
