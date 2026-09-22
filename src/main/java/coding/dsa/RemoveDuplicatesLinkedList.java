package coding.dsa;


public class RemoveDuplicatesLinkedList {
    public static void main(String[] args) {

        LinkList linkedList = createLinkedList();
        LinkList linkedList1 = removeDuplicates(linkedList);

           // System.out.println("Size : " + size);
            LinkList.Node temp = linkedList1.head;
            while (temp != null) {
                System.out.printf("%s->", temp.data);
                temp = temp.next;
            }
            System.out.println();


        System.out.println(linkedList1.toString());

    }

    private static LinkList removeDuplicates(LinkList linkedList) {
            LinkList.Node current = linkedList.head;
            while (current != null && current.next != null) {
                if(current.data== current.next.data){
                    current.next = current.next.next;
                }else {
                    current = current.next;
                }
            }
return linkedList;


    }

    public static LinkList createLinkedList() {
        LinkList linkedList = new LinkList();
        LinkList.Node node1 = new LinkList.Node(1);
        LinkList.Node node2 = new LinkList.Node(1);
        LinkList.Node node3 = new LinkList.Node(2);
        LinkList.Node node4 = new LinkList.Node(2);
        LinkList.Node node5 = new LinkList.Node(2);
        LinkList.Node node6 = new LinkList.Node(3);
        LinkList.Node node7 = new LinkList.Node(3);
        LinkList.Node node8 = new LinkList.Node(4);
        linkedList.head = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        return linkedList;
    }

}
