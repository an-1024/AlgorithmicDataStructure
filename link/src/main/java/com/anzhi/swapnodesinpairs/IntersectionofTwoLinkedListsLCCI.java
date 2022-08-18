package com.anzhi.swapnodesinpairs;

import com.anzhi.listnodeoperate.MyLinkedListNode;

public class IntersectionofTwoLinkedListsLCCI {
    public static void main(String[] args) {
        MyLinkedListNode myLinkedListNode = new MyLinkedListNode();
        for(int i=1; i<5; i++){
            myLinkedListNode.addAtHead(i);
        }
        myLinkedListNode.printMyLinkedListNode();
        myLinkedListNode.swapPairs(myLinkedListNode.virtualNode.next);
        myLinkedListNode.printMyLinkedListNode();
    }
}
