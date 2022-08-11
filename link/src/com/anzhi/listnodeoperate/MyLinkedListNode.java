package com.anzhi.listnodeoperate;

import com.anzhi.removenode.ListNode;

public class MyLinkedListNode {

    public LinkedNode virtualNode;

    public MyLinkedListNode() {
         virtualNode = new LinkedNode(0);
    }

    /**
     * 插入链表节点-头插法
     *
     * @param val
     */
    public void addAtHead(int val) {
        // 创建一个插入的节点
        LinkedNode insertNode = new LinkedNode(val);
        // 插入节点的下一个指针域指向虚拟节点的下一个指针域
        insertNode.next = virtualNode.next;
        virtualNode.next = insertNode;
    }


    /**
     * 插入链表节点-尾插法
     *
     * @param val
     */
    public void addAtTail(int val){
        // 创建一个插入的节点
        LinkedNode insertNode = new LinkedNode(val);
        LinkedNode currNode = virtualNode;
        while (currNode.next != null){
            currNode = currNode.next;
        }
        currNode.next = insertNode;
    }

    /**
     * 插入指定位置节点
     *
     * @param index
     * @param val
     */
    public void addAtIndex(int index, int val) {
        if(index > getNodeLength() || index < 0){
            return;
        }
        // 创建新的节点
        LinkedNode insertNode = new LinkedNode(val);
        LinkedNode currNode = virtualNode;
        for(int i=0; i<index; i++){
            currNode = currNode.next;
        }
        insertNode.next = currNode.next;
        currNode.next = insertNode;
    }

    /**
     * 删除第 index 个节点
     *
     * @param index
     */
    public void deleteAtIndex(int index) {
        if(index > getNodeLength() || index < 0){
            return;
        }

        LinkedNode currNode = virtualNode;
        for(int i=0; i<index; i++){
            currNode = currNode.next;
        }
        // 记录删除节点的下一个节点
        currNode.next = currNode.next.next;
    }

    /**
     * 获取某个节点
     *
     * @param index
     * @return
     */
    public int get(int index) {
        if(index > getNodeLength() || index < 0){
            return -1;
        }

        LinkedNode currNode = virtualNode;
        for(int i=0; i<index; i++){
            currNode = currNode.next;
        }
        return currNode.val;
    }

    public void printMyLinkedListNode(){
        LinkedNode currNode = virtualNode;
        while(currNode.next != null){
            System.out.println("MyLinkedListNode current value= " + currNode.next.val);
            currNode = currNode.next;
        }
    }

    public int getNodeLength(){
        int length = 0;
        LinkedNode currNode = virtualNode;
        while(currNode.next != null){
            length++;
            currNode = currNode.next;
        }
        return length;
    }
}
