package p19_remove_nth_node_from_end_of_list;

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode preHead1 = new ListNode(-1);
        ListNode preHead2 = new ListNode(0);
        preHead1.next = preHead2;
        preHead2.next = head;
        ListNode beforeNode = preHead1;
        ListNode curNode = preHead1;
        int index = -1;
        while (curNode != null) {
            if (index >= n) {
                beforeNode = beforeNode.next;
            }
            curNode = curNode.next;
            index++;
        }
        beforeNode.next = beforeNode.next.next;
        return preHead2.next;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5};
        int n = 2;
        ListNode head = new ListNode(a[0]);
        ListNode cur = head;
        for (int i = 1; i < a.length; i++) {
            cur.next = new ListNode(a[i]);
            cur = cur.next;
        }
        new Solution().removeNthFromEnd(head, n);
        cur = head;
        while (cur != null) {
            System.out.print(cur.val);
            cur = cur.next;
        }
    }
}