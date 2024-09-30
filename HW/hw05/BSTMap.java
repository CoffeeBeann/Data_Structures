/***************************************************
Filename: BSTMap.java
Author: MIDN Ian Coffey (m261194)
Implement a Basic BSTMap for Key Value Pairs
***************************************************/

import java.util.Deque;
import java.util.LinkedList;

public class BSTMap<K extends Comparable<K>, V> implements Map<K,V> 
{
    // Inner Node class
    private class Node 
    {
        // Private Node variables
        private V data;
        private K key;
        private Node left;
        private Node right;

        // Public Node constructor
        public Node() 
        {
            this.data = null;
            this.key = null;
            this.left = null;
            this.right = null;
        }

        // Public Node constructor with arguments
        public Node(V data, K key, Node left, Node right) 
        {
            // Variable assignments
            this.data = data;
            this.key = key;
            this.left = left;
            this.right = right;
        }
    }
        
    // Private variable declarations
    private LinkedList list;
    private Node root;

    // Public Constructor of BSTMap
    public BSTMap() 
    {
        list = new LinkedList();
        root = new Node();
    }

    @Override
    public V get(K key) 
    {
        return getHelper(root, key);
    }

    public V getHelper(Node curr, K key) 
    {
        if (curr == null) 
            return null; // Nothing was Found
        
        // Check if Current Node is less than Key
        if (curr.key.compareTo(key) < 0)
            return getHelper(curr.left, key); // Traverse Left

        // Check if Current Node is greater than Key
        if (curr.key.compareTo(key) > 0)
            return getHelper(curr.right, key); // Traverse Right
       
        // Match Found 
        return curr.data;
    }

    @Override
    public boolean containsKey(K key) 
    {
       return containsHelper(root, key);
    }
    
    public boolean containsHelper(Node curr, K key) 
    {
       if (curr == null)
            return false;

       // Check if Current Node is less than Key
        if (curr.key.compareTo(key) < 0)
            return containsHelper(curr.left, key); // Traverse Left

        // Check if Current Node is greater than Key
        if (curr.key.compareTo(key) > 0)
            return containsHelper(curr.right, key); // Traverse Right
       
        // Match Found 
        return true;
    }

    @Override
    public void put(K key, V value) 
    {
        this.root = putHelper(root, key, value);
    }

    public Node putHelper(Node curr, K key, V value) 
    {
        // Add new Node is end is Reached
        if (curr == null)
            curr = new Node(value, key, null, null);
            
        // Check if Current Node is less than Key
        if (curr.key.compareTo(key) < 0)
            return putHelper(curr.left, key, value); // Traverse Left

        // Check if Current Node is greater than Key
        if (curr.key.compareTo(key) > 0)
            return putHelper(curr.right, key, value); // Traverse Right
        
        System.out.println("No Duplicates Allowed");
        return null;
    }

    @Override
    public int size() 
    {
        return 0;
    }

    @Override
    public Deque<K> traverse() 
    {
        return null;
    }

    @Override
    public void remove(K key) 
    {
        return;
    }

    public static void main(String [] args) 
    {
        // Variable declaration
        Deque<Integer> list = new LinkedList<Integer>();

        list.put("test1", 1);
        list.put("test2", 2);
        list.put("test3", 3);
        list.put("test4", 4);
        list.put("test5", 5);
        list.put("test6", 6);


    }
    
} 
