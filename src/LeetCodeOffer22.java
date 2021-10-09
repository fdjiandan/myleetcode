public class LeetCodeOffer22 {

    public static void main(String[] args) {

        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        System.out.println(getKthFromEnd(node1, 5).getValue());
    }

    public static ListNode getKthFromEnd(ListNode head, int k) {
        ListNode s1 = head;
        ListNode s2 = head;
        while (k > 0 && s2 != null) {
            k--;
            s2 = s2.next;
        }
        while (s2 != null) {
            s1 = s1.next;
            s2 = s2.next;
        }
        return s1;
    }
}

class ListNode {
    int value;
    ListNode next;

    public ListNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}