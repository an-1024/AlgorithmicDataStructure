package com.anzhi;

public class ReverseListDemo {
    public static class Node {
        public int value;
        public Node next = null;
        
        public Node (int data) {
            this.value = data;
        }
        
        public Node (){}
    }
    
    public static class DoubleNode {
        public int value;
        public DoubleNode pre = null;
        public DoubleNode next = null;
        
        public DoubleNode (int data) {
            this.value = data;
        }
        
        public DoubleNode(){}
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        
        n1.next = n2;
        n2.next = n3;

        System.out.print("未翻转之前的单链表: ");
        printFirstNode(n1);
        System.out.print("翻转之后的单链表: ");
        Node reversalNode = reversalLinkNode(n1);
        printFirstNode(reversalNode);
        
        
        DoubleNode doubleNode1 = new DoubleNode(1);
        DoubleNode doubleNode2 = new DoubleNode(2);
        DoubleNode doubleNode3 = new DoubleNode(3);
        
        doubleNode1.next = doubleNode2;
        doubleNode2.pre = doubleNode1;
        
        doubleNode2.next = doubleNode3;
        doubleNode3.pre = doubleNode2;

        System.out.print("未翻转之前的双链表: ");
        printFirstNode(doubleNode1);
        printTailNode(doubleNode3);
        System.out.print("翻转之后的双链表: ");
        DoubleNode reversalDoubleNode = reversalDoubleLinkNode(doubleNode1);
        printFirstNode(reversalDoubleNode);
    }

    private static DoubleNode reversalDoubleLinkNode(DoubleNode doubleNode1) {
        DoubleNode pre = null;
        DoubleNode next;
        
        while (doubleNode1 != null) {
            next = doubleNode1.next;
            doubleNode1.next = pre;
            doubleNode1.pre = next;
            pre = doubleNode1;
            doubleNode1 = next;
        }
        return pre;
    }

    private static Node reversalLinkNode(Node node) {
        Node pre = null;
        Node next;
        
        while (node != null) {
            next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        
        return pre;
    }


    public static void printFirstNode(Node node) {
        while (node != null) {
            System.out.print(" " + node.value);
            node = node.next;
        }
        System.out.println();
    }

    public static void printFirstNode(DoubleNode node) {
        DoubleNode head =  node;
        while (head != null) {
            System.out.print(" " + head.value);
            head = head.next;
        }
        System.out.println();
    }

    public static void printTailNode(DoubleNode tailNode) {
        while (tailNode != null) {
            System.out.print(" " + tailNode.value);
            tailNode = tailNode.pre;
        }
        System.out.println();
    }
    
    
}
