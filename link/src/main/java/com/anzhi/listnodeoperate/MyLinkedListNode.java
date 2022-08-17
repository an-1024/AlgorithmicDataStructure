package com.anzhi.listnodeoperate;

import com.anzhi.removenode.ListNode;

public class MyLinkedListNode {

    public LinkedNode virtualNode;

    // 为虚拟节点赋值
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
        //如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
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
        // 当 index = 实际长度, 表明删除节点不存在
        if(index >= getNodeLength() || index < 0){
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
     * 获取某个节点的值
     *
     * @param index
     * @return
     */
    public int get(int index) {
        // 当 index = 实际长度, 表明获取节点不存在
        if(index >= getNodeLength() || index < 0){
            return -1;
        }
        LinkedNode currNode = virtualNode;
        for(int i=0; i<index; i++){
            currNode = currNode.next;
        }
        return currNode.next.val;
    }

    public LinkedNode getNode(int index) {
        // 当 index = 实际长度, 表明获取节点不存在
        if(index >= getNodeLength() || index < 0){
            return null;
        }
        LinkedNode currNode = virtualNode;
        for(int i=0; i<index; i++){
            currNode = currNode.next;
        }
        return currNode.next;
    }

    /**
     *  打印链表
     */
    public void printMyLinkedListNode(){
        LinkedNode currNode = virtualNode;
        while(currNode.next != null){
            System.out.println("MyLinkedListNode current value= " + currNode.next.val);
            currNode = currNode.next;
        }
    }

    /**
     * 获取链表长度
     *
     * @return
     */
    public int getNodeLength(){
        int length = 0;
        LinkedNode currNode = virtualNode;
        while(currNode.next != null){
            length++;
            currNode = currNode.next;
        }
        return length;
    }

    /**
     * 反转链表
     *
     * @param head
     * @return
     */
    public LinkedNode reverseListNode(LinkedNode head){
        // 创建临时节点保存剩余链表
        LinkedNode tmp;
        virtualNode.next  = head; // 当前节点指向头节点
        LinkedNode pre = null; // 前置指针为null
        LinkedNode currNode = virtualNode;

        while(currNode.next != null){
            // 首先保存下一个节点的链
            tmp = currNode.next.next;
            // 开始断链, 并反转
            currNode.next.next = pre;
            // 前置指针等于断链的节点
            pre = currNode.next;
            // 当前节点重新赋值断链
            currNode.next = tmp;
        }
        virtualNode.next = pre;
        return virtualNode;
    }

    /**
     * 两两交换链表中的节点
     *
     * @param head
     * @return
     */
    public LinkedNode swapPairs(LinkedNode head) {
        // 虚拟头节点指向实际头节点(方便操作: 节省了奇偶数判断代码, 统一操作)
        virtualNode.next = head;
        // 创建当前节点指向
        LinkedNode currNode = virtualNode;

        while(currNode.next != null && currNode.next.next != null){
            LinkedNode tmp = currNode.next; // 保存相邻第一个链表节点
            LinkedNode tmp2 = currNode.next.next.next; // 记录不相邻第一个临时节点

            currNode.next = currNode.next.next; // 相邻第一个节点指向与之不相邻的第一个节点
            currNode.next.next = tmp; // 断开相邻第一个节点链表
            currNode.next.next.next = tmp2; // 断开相邻第二个链表

            currNode = currNode.next.next; // 移动两位
        }

        return virtualNode.next;
    }

    /**
     * 删除链表倒数第 n 个节点
     *
     * @param head
     * @param n
     * @return
     */
    public LinkedNode removeNthFromEnd(LinkedNode head, int n) {
        // 虚拟头节点指向头节点
        virtualNode.next = head;
        // 创建慢指针
        LinkedNode slow = virtualNode;
        // 创建快指针
        LinkedNode fast = virtualNode;
        while( n-- >= 0 && fast != null){
            fast = fast.next;
        }

        // fast 指针再提前移动一步,因为需要让 slow 指向删除节点的上一个节点
        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return virtualNode.next;
    }

    /**
     * 判断链表是否有环
     *
     * @param head
     * @return
     */
    public LinkedNode detectCycle(LinkedNode head) {
        // 同样设置快慢指针，快指针从相遇节点出发，慢指针每次移动一个个节点
        // 只要链表有环，最终 slow =  fast
        LinkedNode slow = head;
        LinkedNode fast = head;

        while(fast!= null && fast.next != null){
            // fast 指针先移动一步
            fast = fast.next.next;
            slow = slow.next;
            // 如果 slow = fast 表明该链表有环
            if(slow == fast){
                // 开始寻找环的入口
                // 定义相遇节点
                LinkedNode contactNode = fast;
                // 定义节点重新指向头节点
                LinkedNode headNode = head;
                // 当两个节点再次相遇的时候一定是入口节点
                while (contactNode != headNode){
                    contactNode = contactNode.next;
                    headNode = headNode.next;
                }
                virtualNode.next = headNode;
                return virtualNode;
            }
        }
        virtualNode.next = null;
        return virtualNode;
    }

    /**
     * 链表相交
     *
     * @param headA
     * @param headB
     * @return
     */
    public LinkedNode getIntersectionNode(LinkedNode headA, LinkedNode headB) {
        LinkedNode currNodeA = headA;
        LinkedNode currNodeB = headB;

        int lengthA = 0;
        int lengthB = 0;

        // 计算两个链表的长度
        while(currNodeA != null){
            lengthA++;
            currNodeA = currNodeA.next;
        }

        while(currNodeB !=null){
            lengthB++;
            currNodeB = currNodeB.next;
        }

        currNodeA = headA;
        currNodeB = headB;
        // 让 currNode 为最长链表的头，lengthA 为其长度
        if (lengthB > lengthA){
            int tmpLength = lengthA;
            lengthA = lengthB;
            lengthB = lengthA;
            LinkedNode tmpNode = currNodeA;
            currNodeA = currNodeB;
            currNodeB = tmpNode;
        }

        // 求长度差：
        int gap = lengthA -lengthB;
        // 两个链表对齐
        while (gap-- > 0){
            currNodeA = currNodeA.next;
        }

        // 当 currNodeA 和 currNodeB 相等时返回
        while (currNodeA != null){
            if(currNodeA == currNodeB){
                return currNodeA;
            }
            currNodeA = currNodeA.next;
            currNodeB = currNodeB.next;
        }
        return  null;
    }
}
