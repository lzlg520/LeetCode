package com.lzlg.q2;

import com.lzlg.ListNode;
import org.junit.Test;

import java.util.List;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;
//        while (l1 != null && l2 != null) {
//            int sum = l1.value + l2.value + carry;
//            carry = sum / 10;
//            int val = sum % 10;
//            current.next = new ListNode(val);
//            current = current.next;
//
//            l1 = l1.next;
//            l2 = l2.next;
//        }
//
//        while (l1 != null) {
//            int sum = l1.value + carry;
//            carry = sum / 10;
//            int val = sum % 10;
//            current.next = new ListNode(val);
//            current = current.next;
//
//            l1 = l1.next;
//        }
//
//        while (l2 != null) {
//
//            int sum = l2.value + carry;
//            carry = sum / 10;
//            int val = sum % 10;
//            current.next = new ListNode(val);
//            current = current.next;
//
//            l2 = l2.next;
//        }
//
//        if (carry > 0) {
//            current.next = new ListNode(carry);
//        }

        while (l1 != null || l2 != null || carry != 0) {
            ListNode cur = new ListNode(0);
            int sum = (l1 == null ? 0 : l1.value) + (l2 == null ? 0 : l2.value) + carry;
            carry = sum / 10;
            cur.value = sum % 10;
            current.next = cur;
            current = current.next;

            l1 = l1 == null ? l1 : l1.next;
            l2 = l2 == null ? l2 : l2.next;
        }

        return dummy.next;
    }

    @Test
    public void test() {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode l = addTwoNumbers(l1, l2);
        ListNode help = l;
        while (help != null) {
            System.out.println(help.value);
            help = help.next;
        }
    }
}
