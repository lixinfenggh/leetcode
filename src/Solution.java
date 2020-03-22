class ListNode {
    private int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public ListNode middleNode(ListNode head) {
        if (head == null) return null;
        ListNode oneStep = head;
        ListNode twoStep = head;
        boolean towStepForward = false;
        while (oneStep != null) {
            oneStep = oneStep.next;
            if (towStepForward) {
                twoStep = twoStep.next;
            }
            towStepForward = !towStepForward;
        }
        return twoStep;
    }

    public static void main(String[] args) {
        System.out.println(new Solution());
    }
}
