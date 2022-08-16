package com.anzhi.removenthfromend;

import com.anzhi.listnodeoperate.LinkedNode;
import com.anzhi.listnodeoperate.MyLinkedListNode;

public class Solution {
    public static void main(String[] args) {
        MyLinkedListNode myLinkedListNode = new MyLinkedListNode();
        for(int i=1; i<6; i++){
            myLinkedListNode.addAtTail(i);
        }
        myLinkedListNode.printMyLinkedListNode();
        myLinkedListNode.removeNthFromEnd(myLinkedListNode.virtualNode.next, 2);
        myLinkedListNode.printMyLinkedListNode();
    }
}
