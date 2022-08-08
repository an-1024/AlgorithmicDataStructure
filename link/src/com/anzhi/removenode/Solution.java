package com.anzhi.removenode;

public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        // 建立一个虚拟节点指向给出的头节点
        ListNode virtualNode = new ListNode(0);
        virtualNode.next = head;
        ListNode currNode = head;
        while(currNode.next != null){
            if(currNode.val == val){

            }
        }
        return head;
    }
}
