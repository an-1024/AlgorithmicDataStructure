package com.anzhi.listnodeoperate;

public class MyLinkedListNodeDemo {
    public static void main(String[] args) {
        MyLinkedListNode myLinkedListNode = new MyLinkedListNode();
        myLinkedListNode.addAtHead(1);
        myLinkedListNode.addAtHead(3);
        myLinkedListNode.addAtIndex(1, 2);
        myLinkedListNode.deleteAtIndex(1);
        myLinkedListNode.printMyLinkedListNode();
    }
}
