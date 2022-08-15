package com.anzhi.reverselinked;

import com.anzhi.listnodeoperate.MyLinkedListNode;

/**
 * 反转链表
 */
public class ReverseLinkedNode {
    public static void main(String[] args) {
        MyLinkedListNode myLinkedListNode = new MyLinkedListNode();
        for(int i=1; i<7; i++){
            myLinkedListNode.addAtTail(i);
        }
        myLinkedListNode.printMyLinkedListNode();
        myLinkedListNode.reverseListNode(myLinkedListNode.virtualNode.next);
        myLinkedListNode.printMyLinkedListNode();
    }
}
