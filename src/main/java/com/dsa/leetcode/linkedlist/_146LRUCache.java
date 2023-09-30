package com.dsa.leetcode.linkedlist;

import java.util.HashMap;

//    https://leetcode.com/problems/lru-cache/?envType=study-plan-v2&envId=top-interview-150
//    https://www.youtube.com/watch?v=7ABFKPK2hD4
class _146LRUCache {//LeastRecentlyUsed Cache


    //    lru    [2,2]      [1,1]                      mru
    int capacity;

    HashMap<Integer, Node> cacheMap;

    Node lru;
    Node mru;

    public _146LRUCache(int capacity) {
        this.capacity = capacity;
        this.cacheMap = new HashMap<>();

        this.lru = new Node(0, 0);
        this.mru = new Node(0, 0);

        this.lru.next = this.mru;//lru[0,0] <=> mru[0,0]
        this.mru.prev = this.lru;


    }

    public int get(int key) {
        if (cacheMap.containsKey(key)) {

            //updating the DLL to make aligned to MRU
            remove(cacheMap.get(key));//will only remove from the DLL
            insertAtRight(cacheMap.get(key));//add teh same removed node to the DLL
            return cacheMap.get(key).value;//getting NODE corresponding to the key & then getting the value
        }
        return -1;
    }

    public void put(int key, int value) {
        if (cacheMap.containsKey(key)) {

            cacheMap.get(key).value = value;//updating the value of the existing Node

            //updating the DLL to make aligned to MRU
            remove(cacheMap.get(key));//will only remove from the DLL
            insertAtRight(cacheMap.get(key));//add teh same removed node to the DLL

        } else {//if the node is not existent
            Node node = new Node(key, value);//create a new node
            this.cacheMap.put(key, node);//put in out map
            insertAtRight(node);//making it mru
        }

        //After adding a new node or updating the existing node
        if (this.cacheMap.size() > this.capacity) {//eviction
            Node node = lru.next;//1. removing from DLL
            remove(node);
            this.cacheMap.remove(node.key);//remove from cacheMap;
        }

    }

//    helper fn

    void remove(Node node) {

//        prevNode <=> node <=> nextNode

        Node prevNode = node.prev;
        Node nextNode = node.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    void insertAtRight(Node node) {
        //NOTE: it will insert just before the mru node

        Node previousNodeOfMRU = this.mru.prev;

        //Relink 1
        previousNodeOfMRU.next = node;
        node.prev = previousNodeOfMRU;

        //Relink 2
        this.mru.prev = node;
        node.next = this.mru;


    }


    class Node {//Doubly LinkedList
        int key;
        int value;
        Node next;
        Node prev;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
