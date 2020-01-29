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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        int up = 0;
        ListNode cur = result;
        while (l1 != null || l2 != null) {
            int l1Val = l1 == null ? 0 : l1.val;
            int l2Val = l2 == null ? 0 : l2.val;
            int sum = l1Val + l2Val + up;
            if (sum < 10) {
                up = 0;
            } else {
                sum = sum - 10;
                up = 1;
            }
            cur.next = new ListNode(sum);
            cur = cur.next;
            if (up > 0)
                cur.next = new ListNode(up);

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return result.next;
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