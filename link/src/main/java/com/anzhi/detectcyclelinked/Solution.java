package com.anzhi.detectcyclelinked;

import com.anzhi.listnodeoperate.LinkedNode;
import com.anzhi.listnodeoperate.MyLinkedListNode;

public class Solution {
    public static void main(String[] args) {
        MyLinkedListNode myLinkedListNode = new MyLinkedListNode();
        myLinkedListNode.addAtTail(3);
        myLinkedListNode.addAtTail(2);
        myLinkedListNode.addAtTail(0);
        myLinkedListNode.addAtTail(4);

        // 构建一个有环链表
        myLinkedListNode.getNode(3).next = myLinkedListNode.getNode(1);
        LinkedNode linkedNode = myLinkedListNode.detectCycle(myLinkedListNode.virtualNode.next);
        System.out.println(linkedNode.next.val);
    }
}
