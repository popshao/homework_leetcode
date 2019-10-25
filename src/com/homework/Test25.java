/**
 * Copyright (c) 111.com.cn 2019 All Rights Reserved.
 */
package com.homework;

import com.homework.entity.ListNode;

/**
 *                       
 * @Filename: Test25.java
 * @Version: 1.0
 * @Author: Zhang Lei
 * @Email: zhanglei03@111.com.cn
 *
 */
public class Test25 {

    public static void main(String[] args) {
        
    }
    
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 0) {
            return null;
        }
        if (k == 1) {
            return head;
        }
        int count = 0;
        while (head.next != null) {
            count++;
            head = head.next;
        }
        if (k > count) {
            return null;
        }
        if (k == count) {
            return head;
        }
        ListNode result = null;
        ListNode curIndex = null;
        while(head != null) {
            if (curIndex == null) {
                result = new ListNode(head.next.val);
            }
        }
        
        return null;
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
