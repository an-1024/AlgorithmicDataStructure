package com.anzhi;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 用链表实现一个队列
 */
public class BuildQueueByLinkedList {
    public static class Node<V> {
        public V value;
        public Node<V> next;

        public Node(V v) {
            this.value = v;
            this.next = null;
        }
    }

    public static class MyQueue<V> {
        private Node<V> head;
        private Node<V> tail;
        private int size;

        public MyQueue() {
            head = null;
            tail = null;
            size = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int size() {
            return size;
        }

        // 添加数据
        public void offer(V value) {
            Node<V> cur = new Node<>(value);
            if (tail == null) {
                head = cur;
                tail = cur;
            } else {
                tail.next = cur;
                tail = cur;
            }
            size++;
        }

        // 将值取出
        public V poll() {
            V ans = null;
            if (head != null) {
                ans = head.value;
                head = head.next;
                size--;
            }
            if (head == null) {
                tail = null;
            }
            return ans;
        }

        // 获取队列的值
        public V peek() {
            V ans = null;
            if (head != null) {
                ans = head.value;
            }
            return ans;
        }
    }
    
    public static void testMyQueue () {
        MyQueue<Integer> myQueueTest = new MyQueue<>();
        Queue<Integer> queueJdk = new LinkedList<>();
        
        int testTime = 5000000;
        int maxValue = 200000000;

        System.out.println("测试开始");
        for (int i=0; i<testTime; i++) {
            if (myQueueTest.isEmpty() != queueJdk.isEmpty()) {
                System.out.println("queue Oops!");
            }
            if (myQueueTest.size() != queueJdk.size()) {
                System.out.println("size Oops");
            }
            
            double decide = Math.random();
            if (decide < 0.33) {
                int num = (int) (Math.random() * maxValue);
                myQueueTest.offer(num);
                queueJdk.offer(num);
            } else if (decide < 0.66) {
                if (!myQueueTest.isEmpty()) {
                    int myQueuePollInteger = myQueueTest.poll();
                    int queueJdkPollInteger = queueJdk.poll();
                    
                    if (myQueuePollInteger != queueJdkPollInteger) {
                        System.out.println("poll num Oops!");
                    }
                }
            } else {
                if (!myQueueTest.isEmpty()) {
                    int muQueuePeekInteger = myQueueTest.peek();
                    int queueKdkPeekInteger = queueJdk.peek();
                    
                    if (muQueuePeekInteger != queueKdkPeekInteger) {
                        System.out.println("peek num Oops!");
                    }
                }
            }
            if (myQueueTest.size() != queueJdk.size()) {
                System.out.println("size Oops");
            }
            
            while (!myQueueTest.isEmpty()) {
                int myQueuePollInteger = myQueueTest.poll();
                int queueJdkPollInteger = queueJdk.poll();

                if (myQueuePollInteger != queueJdkPollInteger) {
                    System.out.println("poll num Oops!");
                }
            }
        }
        System.out.println("测试结束");
    }

    public static void main(String[] args) {
        testMyQueue();
    }
}
