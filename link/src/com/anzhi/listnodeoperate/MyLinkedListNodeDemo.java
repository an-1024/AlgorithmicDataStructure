package com.anzhi.listnodeoperate;

public class MyLinkedListNodeDemo {
    //["MyLinkedList","addAtHead","get","addAtHead","addAtHead","deleteAtIndex","addAtHead","get","get","get","addAtHead","deleteAtIndex"]
    // [[],           [4],         [1],[1],[5],[3],[7],[3],[3],[3],[1],[4]]
    public static void main(String[] args) {
        MyLinkedListNode myLinkedListNode = new MyLinkedListNode();
        myLinkedListNode.addAtHead(4);
        System.out.println(myLinkedListNode.get(1));
    }
}
