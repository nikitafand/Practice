package coding.dsa;

import java.util.PriorityQueue;

public class MergeTwoLinkedLists {

    // Definition for singly-linked list node
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }


    // Helper method to create a linked list from an array
    public static ListNode createLinkedList(int[] arr) {
        if (arr.length == 0) return null;
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        for (int val : arr) {
            current.next = new ListNode(val);
            current = current.next;
        }
        return dummy.next;
    }

    // Helper method to print the linked list
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }

    // Main execution method
    public static void main(String[] args) {
        // Constructing the specific input: [[1,4,5], [1,3,5], [2,6]]
        ListNode list1 = createLinkedList(new int[]{1, 4, 5});
        ListNode list2 = createLinkedList(new int[]{1, 3, 5});
        ListNode list3 = createLinkedList(new int[]{2, 6});

        ListNode[] lists = new ListNode[]{list1, list2, list3};

        System.out.println("Original Lists:");
        System.out.print("List 1: "); printList(list1);
        System.out.print("List 2: "); printList(list2);
        System.out.print("List 3: "); printList(list3);
        System.out.println("---------------------------------");


        ListNode res= mergeTwoLinkedList(list1, list3);
        System.out.print("Merged Sorted List: ");
        printList(res);
    }

    private static ListNode mergeTwoLinkedList(ListNode list1, ListNode list2) {

        ListNode dummy= new ListNode(0);
        ListNode current= dummy;
        System.out.print(current.val);
        while(list1!= null && list2!=null){
            if(list1.val <= list2.val){
                current.next= list1;
                list1= list1.next;
                System.out.print(current.val);
            }else {
                current.next= list2;
                list2= list2.next;
                System.out.print(current.val);
            }

            current= current.next;
            System.out.print(current.val);

        }
        if(list1!=null){
            current.next= list1;
        }
        if(list2!=null){
            current.next= list2;
        }
        return dummy.next;
    }
}
