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
        //
    }
    // Private variable declarations
    private LinkedList list;
    private K data;
    private V key;

    // Public Constructor of BSTMap
    public BSTMap() 
    } 
        list = new LinkedList();
        data = null;
        key = null;
    }


    @Override
    public V get(K key) 
    {
              
    }

    @Override
    public boolean containsKey(K key) 
    {
        // requirement: O(height)
        throw new UnsupportedOperationException("you need to implement containsKey(k)");
    }

    @Override
    public void put(K key, V value) 
    {
        // requirement: O(height)
        throw new UnsupportedOperationException("you need to implement put(k,v)");
    }

    @Override
    public int size() 
    {
        // requirement: O(1)
        throw new UnsupportedOperationException("you need to implement size()");
    }

    @Override
    public Deque<K> traverse() 
    {
        // requirement: O(n)
        throw new UnsupportedOperationException("you need to implement traverse()");
    }

    @Override
    public void remove(K key) 
    {
        // requirement: O(height)
        throw new UnsupportedOperationException("implement remove(k) last!");
    }
} 
