package coding.dsa;


import java.util.LinkedHashMap;
import java.util.Map;

public class LinkList {
    @Override
    public String toString() {
        return "LinkList{" +
                "linkedhashmap=" + linkedhashmap +
                ", head=" + head +
                '}';
    }

    Map<Integer, String> linkedhashmap = new LinkedHashMap<>();

    public void insert(int key, String value) {

        linkedhashmap.put(key, value);
    }

    static class Node {
        int data;
        Node next;

        Node(int d) {
            this.data = d;
            this.next = null;
        }
    }

    Node head;


    private void reverse() {
        Node prev = null;
        Node curr = head;
        Node next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            display();
        }
        head = prev;
    }
    // Display the linked list

    public void display() {

        Node current = head;

        while (current != null) {

            System.out.print(current.data);

            if (current.next != null) {

                System.out.print(" -> ");

            }

            current = current.next;

        }

        System.out.println();

    }

    private boolean delete(int i) {
        if (head == null) {
            return false;
        }
        if (head.data == i) {
            head = head.next;
            return true;
        }
        Node curr = head;
        while (curr.next != null) {
            if (curr.next.data == i) {
                curr.next = curr.next.next;
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    private Integer retrieve(int index) {
        Node curr = head;
        int i = 0;
        while (curr != null) {
            if (i == index) {
                return curr.data;
            }
            curr = curr.next;
            i++;

        }
        if (curr != null) {
            return curr.data;
        } else return null;


    }

    private void insert(int i) {

        if (head == null) {
            head = new Node(i);
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(i);
    }

    public static void main(String[] args) {
        LinkList list = new LinkList();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.display();
        list.delete(2);
        list.display();


        Integer retrieve = list.retrieve(500);
        System.out.println(retrieve);


        list.reverse();
        list.display();

        LinkList linkedList = new LinkList();
        Node node1 = new Node(10);
        Node node2 = new Node(20);
        Node node3 = new Node(30);
        Node node4 = new Node(40);
        Node node5 = new Node(50);
        linkedList.head = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node3;
        linkedList.hasCycle();
        //linkedList.findMiddle();
        //System.out.println(linkedList.findMiddle());
    }

    private boolean hasCycle() {

        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = head;
                System.out.println(fast.data);
                while (slow != fast) {

                    slow = slow.next;

                    fast = fast.next;
                    System.out.println(slow.data + "+" + fast.data);
                }
                System.out.println(slow.data);
                return true;
            }


        }
        return false;
    }

    private Integer findMiddle() {

        Node slow = head;
        Node fast = head;
        while ((fast != null && fast.next != null) || fast == slow) {
            slow = slow.next;
            fast = fast.next.next;


        }
        if (slow != fast) {
            return slow.data;
        }
        return null;
    }
}
