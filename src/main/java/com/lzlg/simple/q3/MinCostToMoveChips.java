package com.lzlg.simple.q3;

import org.junit.Test;

/**
 * 数轴上放置了一些筹码，每个筹码的位置（注意这里是位置，不是筹码的数量）存在数组 chips 当中。
 * <p>
 * 你可以对 任何筹码 执行下面两种操作之一（不限操作次数，0 次也可以）：
 * <p>
 * 将第 i 个筹码向左或者右移动 2 个单位，代价为 0。
 * 将第 i 个筹码向左或者右移动 1 个单位，代价为 1。
 * 最开始的时候，同一位置上也可能放着两个或者更多的筹码。
 * <p>
 * 返回将所有筹码移动到同一位置（任意位置）上所需要的最小代价。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：chips = [1,2,3]
 * 输出：1
 * 解释：第二个筹码移动到位置三的代价是 1，第一个筹码移动到位置三的代价是 0，总代价为 1。
 * 示例 2：
 * <p>
 * 输入：chips = [2,2,2,3,3]
 * 输出：2
 * 解释：第四和第五个筹码移动到位置二的代价都是 1，所以最小总代价为 2。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/play-with-chips
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinCostToMoveChips {
    /**
     * 特别注意：数组的值记录的是筹码的位置不是筹码的数量
     * 统计一下奇数位置和偶数位置的筹码数量，取最小的就是最小代价
     *
     * @param chips
     * @return
     */
    public int minCostToMoveChips(int[] chips) {
        // odd 奇数，even 偶数
        int odd = 0, even = 0;
        for (int chip : chips) {
            if (chip % 2 == 0) {
                even++;
            } else {
                chip++;
            }
        }
        return Math.min(odd, even);
    }

    @Test
    public void test() {
        // 位置为2的筹码数量是3个
        // 位置为3的筹码数量是2个
        int[] chips = {2, 2, 2, 3, 3};
        System.out.println(minCostToMoveChips(chips));
    }
}
