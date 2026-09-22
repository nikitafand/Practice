package coding.dsa;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    public int size;
    private int capacity;
    Map<String, Node> cacheMap;
    Node head;
    Node tail;

    class Node {
        String key;
        int value;
        Node prev;
        Node next;


        public Node(String k, int v) {
            this.key = k;
            this.value = v;
        }
    }

    public LRUCache(int capacity) {
        cacheMap = new HashMap<>();
        this.capacity = capacity;
        head = new Node("", 0);
        tail = new Node("", 0);
        head.next = tail;
        tail.prev = head;
    }

    private void addToFront(Node node) {
        Node oldHead = head.next;
        node.prev = head;
        node.next = oldHead;
        oldHead.prev = node;
        head.next = node;
    }

    public static void main(String[] args) {

        LRUCache lruCache = new LRUCache(4);
        lruCache.put("a", 1);
        lruCache.put("b", 2);
        lruCache.put("c", 3);
        lruCache.get("b");
        lruCache.put("d", 4);
        lruCache.printCache();


    }

    private Node get(String b) {
        Node node = cacheMap.get(b);
        remove(node);
        addToFront(node);
        printCache();
        return node;
    }


    private void put(String k, int v) {

        if (cacheMap.containsKey(k)) {
            Node existingNode = cacheMap.get(k);
            remove(existingNode);
            addToFront(existingNode);
        } else {
            if (size == capacity) {
                Node lastNode = tail.prev;
                remove(lastNode);
                cacheMap.remove(k);
                size--;
            }
            Node newNode = new Node(k, v);
            addToFront(newNode);
            cacheMap.put(k, newNode);
            size++;

        }
        printCache();
    }

    public void printCache() {
        System.out.println("Size : " + size);
        Node temp = head.next;
        while (temp != tail) {
            System.out.printf("(%s,%s)->", temp.key, temp.value);
            temp = temp.next;
        }
        System.out.println();
    }

    private void remove(Node node) {

        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }


}
