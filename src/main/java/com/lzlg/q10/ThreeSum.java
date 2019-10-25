package com.lzlg.q10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length <= 2) return result;

        Arrays.sort(nums);


        int len = nums.length;
        int i = 0;
        while (i < len - 2) {
            int base = nums[i];
            int left = i + 1;
            int right = len - 1;

            while (left < right) {
                int sum = base + nums[left] + nums[right];
                if (sum == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(base);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    result.add(list);

                    left = moveRight(nums, left + 1);
                    right = moveLeft(nums, right - 1);

                } else if (sum > 0) {
                    right = moveLeft(nums, right - 1);
                } else {
                    left = moveRight(nums, left + 1);
                }

            }
            i = moveRight(nums, i + 1);
        }

        return result;
    }

    public int moveLeft(int[] nums, int right) {
        while (right == nums.length - 1 || (right >= 0 && nums[right] == nums[right + 1])) {
            right--;
        }
        return right;
    }

    public int moveRight(int[] nums, int left) {
        while (left == 0 || (left < nums.length && nums[left] == nums[left - 1])) {
            left++;
        }
        return left;
    }
}
