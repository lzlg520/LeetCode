package com.lzlg.simple.q10;

import org.junit.Test;

/**
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 * <p>
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 * <p>
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
 * <p>
 * 注意：整数顺序将表示为一个字符串。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1
 * 输出: "1"
 * 示例 2:
 * <p>
 * 输入: 4
 * 输出: "1211"
 */
public class CountAndSayTest {

    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        } else {
            String s = countAndSay(n - 1);
            char[] chars = s.toCharArray();
            StringBuilder sb = new StringBuilder();
            // 两个指针，一个用来记录相同元素的数量
            // 一个用来遍历char数组
            for (int i = 0; i < chars.length; i++) {
                char t = chars[i];
                int count = 1;
                for (int j = i + 1; j < chars.length; j++) {
                    if (chars[j] == t) {
                        count++;
                        i++;
                    } else {
                        break;
                    }
                }
                sb.append(count).append(t);
            }
            return sb.toString();
        }
    }

    @Test
    public void test() {
        String result = countAndSay(7);
        System.out.println(result);
    }

    public int lengthOfLastWord(String s) {
        if (s == null || "".equals(s)) return 0;
        char[] chars = s.toCharArray();
        int len = 0;
        boolean flag = chars[0] == ' ';
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == ' ') {
                if (!flag) {
                    break;
                }
            } else {
                flag = false;
                len++;
            }
        }
        return len;
    }
}
