package com.homework;

public class Test19 {

    public static void main(String[] args) {
        
    }
    
    /**
     * 思路很简单，只有两种出现的情况:
     * 1、链表的长度刚刚好等于n，也就是说删除表头节点，
     * 2、链表长度大于n，那么我们先定义两个表头，一个后移n位，然后两个链表同时后移，这时当后面的节点到达尾部时，前面的节点就是删除的节点的前一个节点。
     * 
     * @param head
     * @param n
     * @return
     * @author lei.zhang
     * @date 2018年8月27日
     */
    ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = head;
        ListNode end = head;
        for (int i = 0; i < n; i++) {
            first = first.next;
        }
        if (first == null) {
            head = head.next;
            return head;
        }
        while (first.next != null) {
            first = first.next;
            end = end.next;
        }
        end.next = end.next.next;
        return head;
    }


    public class ListNode {
        int      val;
        ListNode next;
        ListNode(int x) {
            this.val = x;
        }
    }
}

