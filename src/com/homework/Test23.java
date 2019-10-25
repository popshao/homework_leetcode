package com.homework;

import java.util.Comparator;
import java.util.PriorityQueue;

import com.homework.entity.ListNode;

/**
 *                       
 * @Filename: Test24.java
 * @Version: 1.0
 * @Author: Zhang Lei
 * @Email: zhanglei03@111.com.cn
 *
 */
public class Test23 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(5);
        
        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(3);
        node2.next.next = new ListNode(4);
        
        ListNode node3 = new ListNode(2);
        node3.next = new ListNode(6);
        
        ListNode[] lists = new ListNode[] {node1, node2, node3};
        Test23 test = new Test23();
        ListNode result = test.mergeKLists(lists);
        
        while(result != null) {
            System.out.print(result.val);
            System.out.print("->");
            result = result.next;
        }
    }
    
    /**
     * 使用最小堆
     * 
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        int len = 0;
        if((len=lists.length)==0 || lists == null) return null;
        ListNode preHead = new ListNode(-1);
        ListNode preNode = preHead;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(len, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (ListNode node : lists) {
            if(node!=null) queue.add(node);
        }
        while(!queue.isEmpty()){
            ListNode small = queue.poll();
            preNode.next = small;
            if(small.next!=null) queue.add(small.next);
            preNode = preNode.next;
        }
        return preHead.next;
    }
    
}
