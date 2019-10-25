package com.lzlg.q1;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        // 1.暴力匹配
//        for (int i = 0; i < nums.length; i++) {
//            int n = target - nums[i];
//            for (int j = i; j < nums.length; j++) {
//               if(n == nums[j]) {
//                   result[0] = i;
//                   result[1] = j;
//               }
//            }
//        }
//        return result;

        // 2.使用map
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int n = target - nums[i];
            if (map.containsKey(n)) {
                result[1] = i;
                result[0] = map.get(n);
                return result;
            } else {
                map.put(nums[i], i);
            }
        }
        return result;
    }

    @Test
    public void test() {
        int result = largestPerimeter(new int[]{ 3, 6, 2, 3});
        System.out.println(result);
    }

    public int largestPerimeter(int[] A) {
        if (A == null || A.length <= 2) return 0;

        Arrays.sort(A);

        int max = 0;
        int i = 0;
        int len = A.length;
        while (i < len - 2) {
            int base = A[i];
            int left = 1;
            int right = len - 1;

            while (left < right) {
                if (base + A[left] > A[right] && A[left] + A[right] > base) {
                    max = base + A[left] + A[right];
                    left++;
                    right--;
                } else if (base + A[left] <= A[right]) {
                    left = moveRight(A, left + 1);
                } else {
                    right = moveLeft(A, right - 1);
                }
            }
            i = moveRight(A, i + 1);
        }
        return max;
    }

    public int moveRight(int[] A, int left) {
        while (left == 0 || (left < A.length && A[left] <= A[left - 1])) {
            left++;
        }
        return left;
    }

    public int moveLeft(int[] A, int right) {
        while (right == A.length - 1 || (right >= 0 && A[right] >= A[right + 1])) {
            right--;
        }
        return right;
    }


}
