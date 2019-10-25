package com.lzlg.simple.q1;

import org.junit.Test;

import java.util.Arrays;

/**
 * 有一个同学在学习分式。他需要将一个连分数化成最简分数，你能帮助他吗？
 * <p>
 * <p>
 * <p>
 * 连分数是形如上图的分式。在本题中，所有系数都是大于等于0的整数。
 * <p>
 *  
 * <p>
 * 输入的cont代表连分数的系数（cont[0]代表上图的a0，以此类推）。返回一个长度为2的数组[n, m]，使得连分数的值等于n / m，且n, m最大公约数为1。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：cont = [3, 2, 0, 2]
 * 输出：[13, 4]
 * 解释：原连分数等价于3 + (1 / (2 + (1 / (0 + 1 / 2))))。注意[26, 8], [-13, -4]都不是正确答案。
 * 示例 2：
 * <p>
 * 输入：cont = [0, 0, 3]
 * 输出：[3, 1]
 * 解释：如果答案是整数，令分母为1即可。
 * 限制：
 * <p>
 * cont[i] >= 0
 * 1 <= cont的长度 <= 10
 * cont最后一个元素不等于0
 * 答案的n, m的取值都能被32位int整型存下（即不超过2 ^ 31 - 1）。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/deep-dark-fraction
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Fraction {
    public int[] fraction(int[] cont) {
        int[] result = new int[2];
        if (cont == null) return result;

        int len = cont.length;
        result[0] = cont[len - 1];
        result[1] = 1;
        for (int i = len - 2; i >= 0; i--) {
            int temp = result[0];
            result[0] = result[0] * cont[i] + result[1];
            result[1] = temp;

        }
        return result;
    }

    @Test
    public void test() {
        int[] cont = {4, 1, 2};
        int[] result = fraction(cont);
        System.out.println(Arrays.toString(result));
    }
}
