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
        private K data;
        private V key;
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
        public Node(K data, V key, Node left, Node right) 
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
        return getHelper(key, root);
    }

    public V getHelper(K key, Node curr) 
    {
        if (curr == null) 
            return null;
        
        return null;
        
    }

    @Override
    public boolean containsKey(K key) 
    {
        return false;
    }

    @Override
    public void put(K key, V value) 
    {
        return;
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
        LinkedList<Integer> list = new LinkedList<Integer>();
    }
    
} 
