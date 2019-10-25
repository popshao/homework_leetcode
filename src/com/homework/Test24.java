/**
 * Copyright (c) 111.com.cn 2019 All Rights Reserved.
 */
package com.homework;

import com.homework.entity.ListNode;

/**
 *                       
 * @Filename: Test24.java
 * @Version: 1.0
 * @Author: Zhang Lei
 * @Email: zhanglei03@111.com.cn
 *
 */
public class Test24 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        
        Test24 test = new Test24();
        ListNode result = test.swapPairs(head);
        while(result != null) {
            System.out.print(result.val);
            System.out.print("->");
            result = result.next;
        }
    }
    
    public ListNode swapPairs(ListNode head) {
        ListNode result = null;
        ListNode lastIndex = null;
        if (head == null || head.next == null) {
            result = head;
        } else {
            while (head != null) {
                if (lastIndex == null) {
                    result = new ListNode(head.next.val);
                    result.next = new ListNode(head.val);
                    lastIndex = result.next;
                } else {
                    if (head.next == null) {
                        lastIndex.next = new ListNode(head.val);
                        break;
                    } else {
                        lastIndex.next = new ListNode(head.next.val);
                        lastIndex.next.next = new ListNode(head.val);
                        lastIndex = lastIndex.next.next;
                    }
                }

                head = head.next.next;
            }
        }
        
        return result;
    }
}
