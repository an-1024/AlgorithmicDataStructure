package com.question;

/**
 * K 个节点的组内逆序-LeetCode 25 题
 */
public class ReverseNodesInGroup {
    public static class ListNode {
        public int val;
        public ListNode next;
    }
    
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode start = head;
        ListNode end = getGroupEnd(start, k);
        // 如果找到的截止节点为 null，那么表示只有一个节点，直接返回
        if (end == null) {
            return head;
        }
        // 第一组节点找到, 让头节点指向第一组的尾节点
        head = end;
        revers(start, end);
        // 上一组的尾节点
        ListNode lastEnd = start;
        while (lastEnd.next != null) {
            start = lastEnd.next;
            end = getGroupEnd(start, k);
            if (end ==  null) {
                return head;
            }
            revers(start, end);
            lastEnd.next = end;
            lastEnd = start;
        }
        return head;
    }

    private static ListNode getGroupEnd(ListNode start, int k) {
        while (--k != 0 && start != null) {
            start = start.next;
        }
        return start;
    }
    
    public static void revers (ListNode start, ListNode end) {
        end = end.next;
        ListNode pre = null;
        ListNode cur = start;
        ListNode next = null;
        
        while (cur != end) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        
        start.next = end;
    }
}
