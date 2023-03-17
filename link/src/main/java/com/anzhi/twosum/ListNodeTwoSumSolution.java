package com.anzhi.twosum;

import com.anzhi.listnodeoperate.MyLinkedListNode;
import com.anzhi.removenode.ListNode;

public class ListNodeTwoSumSolution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 设置头尾节点
        ListNode head = null;
        ListNode tail = null;

        // 设置进位
        int carry = 0;
        // 同时遍历两张表
        while (l1 != null || l2 != null) {
            // 防止两张链表长短不一致的情况
            int sum1 = l1 != null ? l1.val : 0;
            int sum2 = l2 != null ? l2.val : 0;

            int sumResult = sum1 + sum2 + carry;

            // head == null 表示第一次循环，将头尾节点指向新的节点
            if (head == null) {
                head = tail = new ListNode(sumResult % 10);
            } else {
                // 如果头节点不为空，那么尾节点的 next 指针指向下一个节点
                tail.next = new ListNode(sumResult % 10);
                // 尾节点指向下一个节点
                tail = tail.next;
            }

            // 移动l1指针
            if (l1 != null) {
                l1 = l1.next;
            }

            // 移动l2指针
            if (l2 != null) {
                l2 = l2.next;
            }

            // 判断是否需要进位
            carry = sumResult / 10;
            if (carry > 0) {
                tail.next = new ListNode(carry);
            }
        }
        return head;
    }
}
