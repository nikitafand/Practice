package coding.dsa;

public class AddTwoNumbersLinkList {

    public static ListNode createList(int[] values) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int val : values) {
            current.next = new ListNode(val);
            current = current.next;
        }
        return dummy.next;
    }
    public static void main(String[] args) {
        ListNode l1 = createList(new int[]{2, 4, 3});
        ListNode l2 = createList(new int[]{5, 6, 4});
        ListNode merged= addTwoNumbers(l1, l2);
        System.out.println(merged.val);
    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        int carry=0;
        while (l1!= null ||  l2!= null || carry != 0){

            int sum=  l1.val + l2.val + carry ;
            carry = sum /10;
            current.next= new ListNode(sum%10);
            current = current.next;
            if(l1!= null) l1= l1.next;
            if(l2!= null) l2= l2.next;

        }
        return dummyHead.next;
    }
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
