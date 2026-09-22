package coding.dsa;

import java.util.PriorityQueue;

import static coding.dsa.MergeTwoLinkedLists.createLinkedList;

public class MergeKLinkedList {
    public static void main(String[] args) {

        MergeTwoLinkedLists.ListNode list1 = createLinkedList(new int[]{1, 4, 5});
        MergeTwoLinkedLists.ListNode list2 = createLinkedList(new int[]{1, 3, 5});
        MergeTwoLinkedLists.ListNode list3 = createLinkedList(new int[]{2, 6});
        MergeTwoLinkedLists.ListNode[] lists = new MergeTwoLinkedLists.ListNode[]{list1, list2, list3};

        // Executing the merge
        MergeTwoLinkedLists.ListNode result = mergeKLists(lists);

        System.out.print("Merged Sorted List: ");
        //printList(result);
    }

    // Merge logic using a Min-Heap
    public static MergeTwoLinkedLists.ListNode mergeKLists(MergeTwoLinkedLists.ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        // Min-Heap sorted by the value of the nodes
        PriorityQueue<MergeTwoLinkedLists.ListNode> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));

        // Add the first node of each list to the heap
        for (MergeTwoLinkedLists.ListNode root : lists) {
            if (root != null) {
                minHeap.add(root);
            }
        }

        MergeTwoLinkedLists.ListNode dummy = new MergeTwoLinkedLists.ListNode(-1);
        MergeTwoLinkedLists.ListNode current = dummy;

        // Process the heap until empty
        while (!minHeap.isEmpty()) {
            MergeTwoLinkedLists.ListNode smallestNode = minHeap.poll();
            current.next = smallestNode;
            current = current.next;

            // If there is a next node in that specific list, add it to the heap
            if (smallestNode.next != null) {
                minHeap.add(smallestNode.next);
            }
        }

        return dummy.next;
    }
}
