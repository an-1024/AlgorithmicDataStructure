package com.anzhi;

public class ReverseListDemo {
    public static class Node {
        public int value;
        public Node next;
        
        public Node (int data) {
            this.value = data;
        }
    }
    
    public static class DoubleNode {
        public int value;
        public DoubleNode pre;
        public DoubleNode next;
        
        public DoubleNode (int data) {
            this.value = data;
        }
    }
}
