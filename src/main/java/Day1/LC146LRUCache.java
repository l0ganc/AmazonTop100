package Day1;

import java.util.HashMap;
import java.util.Map;

public class LC146LRUCache {
    /**
     * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
     *
     * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
     * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
     *
     * The cache is initialized with a positive capacity.
     *
     * Follow up:
     * Could you do both operations in O(1) time complexity?
     *
     * Example:
     *
     * LRUCache cache = new LRUCache(2);  // 2 is the capacity
     *
     *  cache.put(1,1);
     *  cache.put(2,2);
     *  cache.get(1);       // returns 1
     *  cache.put(3,3);    // evicts key 2
     *  cache.get(2);       // returns -1 (not found)
     *  cache.put(4,4);    // evicts key 1
     *  cache.get(1);       // returns -1 (not found)
     *  cache.get(3);       // returns 3
     *  cache.get(4);       // returns 4
     *
     *  time = O(1) for both get and put method
     *  space = O(N) and n is the capacity
     */

    /**
     * The problem can be solved with a hashtable that keeps track of the keys and its values in the double linked list.
     * One interesting property about double linked list is that the node can remove itself without other reference.
     * In addition, it takes constant time to add and remove nodes from the head or tail.
     *
     * One particularity about the double linked list that I implemented is that
     *      I create a pseudo head and tail to mark the boundary, so that we don't need to check the NULL node during the update.
     *      This makes the code more concise and clean, and also it is good for the performance.
     */



    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
    }

    private Map<Integer, DLinkedNode> cache;
    private int count;
    private int capacity;
    private DLinkedNode head;
    private DLinkedNode tail;

    public LC146LRUCache(int capacity) {
        this.cache = new HashMap<>();
        this.count = 0;
        this.capacity = capacity;

        head = new DLinkedNode();
        head.prev = null;

        tail = new DLinkedNode();
        tail.next = null;

        head.next = tail;
        tail.prev = head;
    }

    private int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;  // should raise exception here
        }

        // move node into head because it has been accessed now
        moveToHead(node);

        return node.value;
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addNode(node);
    }

    /**
     * Remove an existing node from the linked list.
     */
    private void removeNode(DLinkedNode node) {
        DLinkedNode prev = node.prev;
        DLinkedNode next = node.next;

        prev.next = next;
        next.prev = prev;

    }

    /**
     * Always add the new node right after head;
     */
    private void addNode(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);

        if (node == null) {
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;

            cache.put(key, newNode);
            addNode(newNode);

            count++;
            if (count > capacity) {
                // pop the tail
                DLinkedNode tail = popTail();
                cache.remove(tail.key);
                count--;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    // pop the current tail
    private DLinkedNode popTail() {
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }






}
