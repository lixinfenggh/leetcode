package p2_add_two_numbers;

import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    @Override
    public String toString() {
        return val + " -> " + (this.next != null ? this.next.toString() : "");
    }
}

class Solution {
    public void addTwoNumbers(ListNode l1, ListNode l2, ListNode result) {
        if (result == null)
            result = new ListNode(0);

        l1 = l1 == null ? new ListNode(0) : l1;
        l2 = l2 == null ? new ListNode(0) : l2;
        int sum = l1.val + l2.val + result.val;
        if (sum > 9) {
            result.val = sum - 10;
            result.next = new ListNode(1);
        } else {
            result.val = sum;
        }
        if (l1.next == null && l2.next == null)
            return;
        if (sum <= 9)
            result.next = new ListNode(0);

        System.out.println(result.val);
        this.addTwoNumbers(l1.next, l2.next, result.next);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        this.addTwoNumbers(l1, l2, result);
        return result;
    }

    public static void main(String[] args) {
        ListNode n2 = new ListNode(9);
        ListNode n4 = new ListNode(1);
        ListNode n3 = new ListNode(6);
        ListNode n5 = new ListNode(0);
        ListNode n6 = new ListNode(6);
        ListNode n4_2 = new ListNode(4);
        n2.next = n4;
        n4.next = n3;
//        n5.next = n6;
//        n6.next = n4_2;
        Solution solution = new Solution();
        ListNode result = solution.addTwoNumbers(n2, n5);
        System.out.println(result);
    }
}