package com.question;

/**
 * 两个链表相加
 * 给定两个链表的头节点 head1 和 head2，认为从左到右是某个数字从低位到高位，返回相加之后的链表
 * 如：4->3->6，2->5->3
 * 返回 6->8->9
 */
public class TwoLinkListSum {
    
    public static class ListNode {
        public int val;
        public ListNode next;
        
        public ListNode (int val) {
            this.val = val;
        }
    }
    
    public static ListNode addTwoNumbers(ListNode head1,  ListNode head2) {
        int len1 = listLength(head1);
        int len2 = listLength(head2);
        
        // 区分长短链表
        ListNode l = len1 >= len2 ? head1 : head2;
        ListNode s = l == head1 ? head2 : head1;
        
        // 长链表
        ListNode curL = l;
        // 短链表
        ListNode curS = s;
        // 记录最后节点位置，以便进位扩充节点
        ListNode last = curL;
        
        // 进位标志
        int carry = 0;
        int curNum = 0;
        
        // 先做短链表
        while (curS != null) {
            curNum = curL.val + curS.val + carry;
            curL.val = (curNum % 10);
            carry = curNum / 10;
            last = curL;
            curL = curL.next;
            curS = curS.next;
        }
        
        // 短链表计算完成，长链表进行进位计算
        while (curL != null) {
            curNum = curL.val + carry;
            curL.val = (curNum % 10);
            carry = curNum / 10;
            last = curL;
            curL = curL.next;
        }
        
        // 如果进位不为0，那么需要创建一个节点放到尾部
        if (carry != 0) {
            last.next = new ListNode(1);
        }
        return l;
    }
    
    // 求链表长度
    public static int listLength(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }
}
