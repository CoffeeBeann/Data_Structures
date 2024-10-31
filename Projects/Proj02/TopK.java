/********************************************************
Filename: TopK.java
Author: MIDN 2/C Ian Coffey (m261194)
Implement a Heap to Track Top Drug Purchasors by Zip Code
*********************************************************/ 

// Import Libraries
import java.util.List;
import java.util.ArrayList;
import java.lang.IllegalStateException;

// TopK Class
public class TopK<T extends Comparable<T>> 
{
    // Private Variable Declarations
    private List<T> elements = new ArrayList<T>();
    private int k;
    
    // Public TopK Constructor
    public TopK(int k) { this.k = k; }
    
    /**
     * Method to return the size of the heap
     */
    public int size() { return elements.size(); }
    
    /**
     * Method to retreive element at a given index
     */
    public T get(int index) { return elements.get(index); }

    /**
     * Method to Add new Element to the collection 
     * Do not call after getTop() has been called.
     */
    public void add(T element) throws IllegalStateException 
    {
        // Check if TopK was called
        if (elements == null)
            throw new IllegalStateException("TopK already called!");
        
        // Add element to Heap
        elements.addInOrder(element, 0, (int) ((elements.size() - 1)/2), elements.size() - 1);
    }

    /**
     * Method to Recursively add an element in order to the element ArrayList
     * O(logn) runtime
     */
    public void addInOrder(T val, int small, int mid, int large) 
    {
        // Base case
        if (ele
        else if (large - small <= 1)
            elements.add(large, val);
        
        // Traverse right of array
        else if (val.compareTo(elements.get(mid)) < 0)
            addInOrder(mid, (int) ((large + mid) / 2), large);
        
        // Traverse left of array
        else if (val.compareTo(elements.get(mid)) > 0)
            addInOrder(small, (int) ((mid + small) / 2), mid);

        // Duplicate is found (do nothing for now)
    }

    /**
     * Retreive Top K elements from the Heap 
     */
    public List<T> getTop() throws IllegalStateException
    {
        if (elements == null)
            throw new IllegalStateException("TopK already called!");
        
        // Bubble Down sort Arraylist to get proper Heap
        for (int i = elements.size() - 1; i > 0; i--) 
        {
            // Calculate Parent Index
            int parentIndex = (int) ((i - 1) / 2);
            T parent = elements.get(parentIndex);
            T curr = elements.get(i);
            
            // Swap array positions if Index > Parent
            if (curr.compareTo(parent) > 0) 
            {
                T tmp = parent;
                elements.set(parentIndex, curr);
                elements.set(i, tmp);
            }
        }

        // Grab Top K elements
        List<T> largest = new ArrayList<T>();
        
        // Determine how many elements to copy
        int top;
        if (elements.size() < k)
            top = elements.size();
        else
            top = k;

        // Copy K largest values
        for (int i = 0; i < top; i++) 
            largest(elements.get(i));

        // Make sure getTop is not called again
        elements = null;
        return largest;
    }

    /**
     * Main method for Testing
     */
    public static void main(String [] args)
    {
        TopK<Integer> heap = new TopK<Integer>(3);

        for (int i = 0; i < 5; i++)
            heap.add(i);

        List<Integer> list = heap.getTop();
        for (int i = 0; i < list.size(); i++)
            System.out.print(list.get(i) + " ");
        System.out.println();
    }
}
