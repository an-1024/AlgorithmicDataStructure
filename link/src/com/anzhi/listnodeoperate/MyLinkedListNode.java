package com.anzhi.listnodeoperate;

public class MyLinkedListNode {
    // 数据域
    public int val;
    // 下一个指针域
    public MyLinkedListNode next;

    // 链表长度
    public static int nodeLength = 0;

    // 初始化一个虚拟头节点
    public static MyLinkedListNode virtualNode = null;

    public MyLinkedListNode() {
        virtualNode = new MyLinkedListNode(0);
    }

    public MyLinkedListNode(int val) {
        this.val = val;
    }

    public MyLinkedListNode(int val, MyLinkedListNode next) {
        this.val = val;
        this.next = next;
    }

    public void addAtHead(int val) {
        // 创建一个插入的节点
        MyLinkedListNode insertNode = new MyLinkedListNode(val);
        // 插入节点的下一个指针域指向虚拟节点的下一个指针域
        insertNode.next = virtualNode.next;
        virtualNode.next = insertNode;
        nodeLength++;
    }
}
