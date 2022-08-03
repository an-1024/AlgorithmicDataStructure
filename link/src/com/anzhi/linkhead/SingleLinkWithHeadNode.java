package com.anzhi.linkhead;

/**
 * 有头节点的单列表
 */
public class SingleLinkWithHeadNode {

    private Node head = null; // 头节点

    /**
     * 链表节点
     */
    static class Node {
        Node next = null; //  节点的引用，指向下一个节点
        int data; // 节点的对象，即内容

        public Node (int data) {
            this.data = data;
        }
    }

    /**
     * 向链表中插入数据
     */
    public void addNode(int data){
        Node newNode = new Node(data); // 实例化一个节点
        if(head == null){
            head = newNode;
            return ;
        }

        Node tmp = head;
        while(head.next != null){
            tmp = tmp.next;
        }
        tmp.next = newNode;
    }

    /**
     *  计算链表长度
     */
    public int nodeLength(){
        int length = 0;
        Node tmp = head;
        while(tmp != null){
            length++;
            tmp = tmp.next;
        }
        return length;
    }

    /**
     *  删除第 index 节点
     */
    public boolean deleteNode(int index){
        if(index<1 || index>nodeLength()){
            return false;
        }
        if (index == 1){
            head = head.next;
            return true;
        }

        int i=2;
        Node preNode = head;
        Node curNode = preNode.next;

        while (curNode != null){
            if(i == index){
                preNode.next = curNode.next;
                return true;
            }

            preNode = curNode;
            curNode = curNode.next;
            i++;
        }
        return false;
    }

    /**
     *  在不知道头节点的情况下删除指定节点
     */
    public boolean deleteWithoutHeadNode(Node node){
        if (node == null){
            return false;
        }

        // 表明删除的是最后一个节点
        if (node.next == null){
            node = null;
        }

        int tmp = node.data;
        node.data = node.next.data;
        node.next.data = tmp;
        node.next = node.next.next;
        System.out.println("删除指定节点成功");
        return true;
    }

    /**
     * 打印链表
     */
    public void printNode(){
        Node tmp = head;
        while(tmp != null){
            System.out.println("SingleLinkWithHeadNode->data=" + tmp.data);
            tmp = tmp.next;
        }
    }
}
