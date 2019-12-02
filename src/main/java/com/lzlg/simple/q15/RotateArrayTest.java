package com.lzlg.simple.q15;

import org.junit.Test;

import java.util.Arrays;

/**
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 * <p>
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * 说明:
 * <p>
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 */
public class RotateArrayTest {
    /**
     * 暴力解法
     * 每次反转一个
     *
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            int temp = nums[nums.length - 1];
            for (int j = nums.length - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = temp;
        }
    }

    /**
     * 使用新数组
     *
     * @param nums
     * @param k
     */
    public void rotate2(int[] nums, int k) {
        int[] n = new int[nums.length];
        for (int i = 0; i < k; i++) {
            n[i] = nums[nums.length - k + i];
        }
        for (int i = k; i < nums.length; i++) {
            n[i] = nums[i - k];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = n[i];
        }
    }

    /**
     * 反转
     *
     * @param nums
     * @param k
     */
    public void rotate3(int[] nums, int k) {
        k %= nums.length;
        // 第一次将整个数组反转
        reverse(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
        // 将 从下标为0到k的元素反转
        reverse(nums, 0, k - 1);
        System.out.println(Arrays.toString(nums));
        // 将从下标为k到数组长度-1的元素反转
        reverse(nums, k, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    /**
     * 使用环状替换
     * 如果我们直接把每一个数字放到它最后的位置，但这样的后果是遗失原来的元素。
     * 因此，我们需要把被替换的数字保存在变量 temp 里面。
     * 然后，我们将被替换数字（temp）放到它正确的位置，并继续这个过程 n 次， n 是数组的长度。
     *
     * @param nums
     * @param k
     */
    public void rotate4(int[] nums, int k) {
        k = k % nums.length;
        // 注意count
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }

    @Test
    public void test() {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(array));
        rotate4(array, 2);
        System.out.println(Arrays.toString(array));
    }
}
