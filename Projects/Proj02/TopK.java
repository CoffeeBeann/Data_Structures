/********************************************************
Filename: TopK.java
Author: MIDN 2/C Ian Coffey (m261194)
Implement a Heap to Track Top Drug Purchasors by Zip Code
*********************************************************/ 

// Import Libraries
import java.util.List;
import java.util.ArrayList;
import java.lang.IllegalStateException;
import java.lang.Math;                             

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
        elements.add(element);
        bubbleUp();
    }

    /**
     * Method to remove and return the minimum element of the elements ArrayList
     * O(logn) runtime
     */
    public T removeMin() 
    {
          // Save Min element and prepare for bubble down
          T rtn = elements.get(0);
          elements.set(0, elements.get(elements.size() - 1));
          elements.remove(elements.size() - 1);

          // Bubble down stating at the root (index 0)
          bubbleDown(0);
    }

    public void bubbleDown(int index) 
    {
        // End of heap is not hit yet
        if (index != elements.size() - 1) 
        {
            // Calculate Indexes & retreive values
            int leftIndex = (2 * index) + 1;
            int rightIndex = (2 * index) + 2;
            int swapIndex;
            T curr = elements.get(index);
            T left = elements.get(leftIndex);
            T right = elements.get(rightIndex);
            T swap;

        
                        
            }
        }            
        
    }

    /**
     * Method to bubble up the Arraylist into a min-heap
     * O(logn) runtime
     */
    public void bubbleUp() 
    {
        // Bubble Up sort Arraylist to get proper Heap
        int parentIndex;
        for (int i = elements.size() - 1; i > 0; i = parentIndex) 
        {
            // Calculate Parent Index
            parentIndex = ((i - 1) / 2);
            T parent = elements.get(parentIndex);
            T curr = elements.get(i);
            
            // Swap array positions if Index < Parent
            if (curr.compareTo(parent) < 0) 
            {
                T tmp = parent;
                elements.set(parentIndex, curr);
                elements.set(i, tmp);
            }
            
        }
        
        // Delete Min Element if size > k
        if (elements.size() > k)
            elements.removeMin();
    }

    /**
     * Retreive Top K elements from the Heap 
     */
    public List<T> getTop() throws IllegalStateException
    {
        if (elements == null)
            throw new IllegalStateException("TopK already called!");
        
        // Perform k removeMins to sort final result
        List<T> largest = new ArrayList<T>();
        for (int i = 0; i < this.k; i++) 
        {
            T next = elements.removeMin();
            largest.add(0, next);
        } 

        // Make sure getTop is not called again
        elements = null;
        return largest;
    }

    /**
     * Main method for Testing
     */
    public static void main(String [] args)
    {
        TopK<Integer> heap = new TopK<Integer>(5);

        heap.add(26);
        heap.add(94);
        heap.add(3);
        heap.add(14);
        heap.add(32);

        List<Integer> list = heap.getTop();
        for (int i = 0; i < list.size(); i++)
            System.out.print(list.get(i) + " ");
        System.out.println();
    }
}
