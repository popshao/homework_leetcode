package com.homework;

public class Test21 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        
        
        Test21 test = new Test21();
        ListNode result = test.mergeTwoLists(l1, l2);
        while(result != null) {
            System.out.print(result.val);
            System.out.print("->");
            result = result.next;
        }
    }
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = null;
        while (l1 != null && l2 != null) {
            if (l1.val >= l2.val) {
                if (result == null) {
                    result = new ListNode(l2.val);
                } else {
                    result.next = new ListNode(l2.val);
                }
                l2 = l2.next;
            } else {
                if (result == null) {
                    result = new ListNode(l1.val);
                } else {
                    result.next = new ListNode(l1.val);
                }
                l1 = l1.next;
            }
        }
        
        while(l1 != null) {
            if (result == null) {
                result = new ListNode(l1.val);
            } else {
                result.next = new ListNode(l1.val);
            }
            l1 = l1.next;
        }
        
        while(l2 != null) {
            if (result == null) {
                result = new ListNode(l2.val);
            } else {
                result.next = new ListNode(l2.val);
            }
            l2 = l2.next;
        }

        return result;
    }
    
    public static class ListNode {
        int      val;
        ListNode next;
        ListNode(int x) {
            this.val = x;
        }
    }
}


