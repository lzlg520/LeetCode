package com.lzlg.simple.q12;

import org.junit.Test;

/**
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * <p>
 * 输入为非空字符串且只包含数字 1 和 0。
 * <p>
 * 示例 1:
 * <p>
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 * <p>
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 */
public class AddBinaryTest {

    public String addBinary(String a, String b) {
//        long aInt = Long.parseLong(a, 2);
//        long bInt = Long.parseLong(b, 2);
//        return Long.toBinaryString(aInt + bInt);

        //转数组
        char[] aArray = a.toCharArray();
        char[] bArray = b.toCharArray();
        //取出结果数组长度
        int length = Math.max(aArray.length, bArray.length);
        //生成结果数组
        char[] rArray = new char[length];
        //进位标识符
        boolean jw = false;
        //按照最长数组循环
        for (int i = 1; i <= length; i++) {
            //重后往前获得数据。如果以到数组首位赋值为0保证计算逻辑统一
            char aChar = aArray.length - i >= 0 ? aArray[aArray.length - i] : '0';
            char bChar = bArray.length - i >= 0 ? bArray[bArray.length - i] : '0';
            char benChar = ' ';
            //计算逻辑
            if (aChar == '0' && bChar == '0') {
                benChar = jw ? '1' : '0';
                jw = false;
            } else if (aChar == '0' && bChar == '1') {
                benChar = jw ? '0' : '1';
            } else if (aChar == '1' && bChar == '0') {
                benChar = jw ? '0' : '1';
            } else if (aChar == '1' && bChar == '1') {
                benChar = jw ? '1' : '0';
                jw = true;
            }
            //赋值结果数组
            rArray[length - i] = benChar;
        }
        //返回最终结果
        return jw ? "1" + new String(rArray) : new String(rArray);
    }

    /**
     * 网友的解法
     *
     * @param a
     * @param b
     * @return
     */
    public String addBinary2(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int ca = 0; // 标记是否进位，0 否，1 是
        // 巧妙的利用 ASCII码 中 '1' 比 '0' 大 1
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int sum = ca;
            sum += i >= 0 ? a.charAt(i) - '0' : 0;
            sum += j >= 0 ? b.charAt(j) - '0' : 0;
            ans.append(sum % 2);
            ca = sum / 2;
        }
        ans.append(ca == 1 ? ca : "");
        return ans.reverse().toString();
    }

    @Test
    public void test() {
        String result = addBinary("1111", "11");
        System.out.println(result);
    }
}
