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
        public DoubleNode pre;
        public DoubleNode next;
        
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
        printNode(n1);
        System.out.print("翻转之后的单链表: ");
        Node reversalNode = reversalLinkNode(n1);
        printNode(reversalNode);
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


    public static void printNode(Node node) {
        while (node != null) {
            System.out.print(" " + node.value);
            node = node.next;
        }
        System.out.println();
    }
    
    
}
