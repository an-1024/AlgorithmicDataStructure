package com.anzhi;

import java.util.Stack;

public class BuildStackByLinkedList {
    public static class Node<V> {
        public V value;
        public Node<V> next;
        
        public Node (V value){
            this.value = value;
            next = null;
        }
    }
    
    public static class MyStack<V> {
        private Node<V> head;
        private int size;
        
        public MyStack () {
            head = null;
            size = 0;
        }

        public  boolean isEmpty() {
            return size == 0;
        }
        
        public int size() {
            return size;
        }
        
        public void push (V value) {
            Node<V> cur = new Node<>(value);
            if (head ==  null) {
                head = cur;
            } else {
                cur.next = head;
                head = cur;
            }
            size++;
        }
        
        public V pop () {
            V ans = null;
            if (head != null) {
                ans = head.value;
                head = head.next;
                size--;
            }
            return ans;
        }
        
        public V peek () {
            return head != null ? head.value : null;
        }
        
        public static void testMyStack () {
            MyStack<Integer> myStack = new MyStack<>();
            Stack<Integer> stack = new Stack<>();
            
            int testTimes = 5000000;
            int maxValue = 200000000;

            System.out.println("开始测试");
            for (int i=0; i<testTimes; i++) {
                if (myStack.isEmpty() != stack.isEmpty()) {
                    System.out.println("myStack Oops");
                }
                
                if (myStack.size() != stack.size()) {
                    System.out.println("size Oops");
                }
                
                double decide = Math.random();
                if (decide < 0.33) {
                    int num = (int) (Math.random() * maxValue);
                    myStack.push(num);
                    stack.push(num);
                } else if (decide < 0.66) {
                    if (!myStack.isEmpty()) {
                        int myStackNum = myStack.pop();
                        int stackNum = stack.pop();
                        
                        if (myStackNum != stackNum) {
                            System.out.println("pop Oops");
                        }
                    }
                } else {
                    if (!myStack.isEmpty()) {
                        int myStackNum = myStack.peek();
                        int stackNum = stack.peek();
                        
                        if (myStackNum != stackNum) {
                            System.out.println("peek Oops");
                        }
                    }
                }
                
                if (myStack.size() != stack.size()) {
                    System.out.println("size() Oops");
                }
                
                while (!myStack.isEmpty()) {
                    int myStackNum = myStack.pop();
                    int stackNum = stack.pop();
                    
                    if (myStackNum != stackNum) {
                        System.out.println("pop Oops");
                    }
                }
            }
            System.out.println("测试结束");
        }

        public static void main(String[] args) {
            testMyStack();
        }
    }
}
