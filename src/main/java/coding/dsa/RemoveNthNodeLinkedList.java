package coding.dsa;

import static coding.dsa.RemoveDuplicatesLinkedList.createLinkedList;

public class RemoveNthNodeLinkedList {
    public static void main(String[] args) {
        LinkList list= createLinkedList();
        printCache(list.head);
        LinkList.Node node = removeNthNode(list.head, 5);


        printCache(node);

    }

    private static LinkList.Node removeNthNode(LinkList.Node head, int n) {
        LinkList.Node current= head;
        int i =0;
        while(current.next!=null){

            if(i == n){
              current.next=current.next.next;
            }
            i++;
            current=current.next;

        }

         return head;
    }

  public class ListNode {
        int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public static void printCache(LinkList.Node head) {

        LinkList.Node temp = head.next;
        while (temp != null) {
            System.out.printf("(%s, )->", temp.data);
            temp = temp.next;
        }
        System.out.println();
    }
}
