package com.lzlg.q9;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 * <p>
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "III"
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: "IV"
 * 输出: 4
 * 示例 3:
 * <p>
 * 输入: "IX"
 * 输出: 9
 * 示例 4:
 * <p>
 * 输入: "LVIII"
 * 输出: 58
 * 解释: L = 50, V= 5, III = 3.
 * 示例 5:
 * <p>
 * 输入: "MCMXCIV"
 * 输出: 1994
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/roman-to-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RomanToInteger {

    public int romanToInt(String s) {
        if (s == null || s.length() == 0) return 0;

        int result = 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if ((i + 1 < chars.length) && map.get(chars[i]) < map.get(chars[i + 1])) {
                result -= map.get(chars[i]);
            } else {
                result += map.get(chars[i]);
            }
        }

        return result;
    }

    public int romanToInt2(String s) {
        if (s == null || s.length() == 0) return 0;

        int result = 0;
        if (s.contains("CM")) result -= 200;
        if (s.contains("CD")) result -= 200;
        if (s.contains("XC")) result -= 20;
        if (s.contains("XL")) result -= 20;
        if (s.contains("IX")) result -= 2;
        if (s.contains("IV")) result -= 2;

        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == 'M') result += 1000;
            else if (c == 'D') result += 500;
            else if (c == 'C') result += 100;
            else if (c == 'L') result += 50;
            else if (c == 'X') result += 10;
            else if (c == 'V') result += 5;
            else if (c == 'I') result += 1;
        }

        return result;
    }

    @Test
    public void test() {
        String s = "MCMXCIV";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1000000; i++) {
            sb.append(s);
        }

//        System.out.println(romanToInt(sb.toString()));
        System.out.println(romanToInt2(sb.toString()));
    }

}
