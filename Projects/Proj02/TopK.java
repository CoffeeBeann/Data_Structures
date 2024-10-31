/********************************************************
Filename: TopK.java
Author: MIDN 2/C Ian Coffey (m261194)
Implement a Heap to Track Top Drug Purchasors by Zip Code
*********************************************************/ 

// Import Libraries
import java.util.List;
import java.util.ArrayList;
import java.lang.IllegalStateException;
import java.util.Collections; // FIND ALTERNATIVE
                             
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
            elements.remove(0);
    }

    /**
     * Retreive Top K elements from the Heap 
     */
    public List<T> getTop() throws IllegalStateException
    {
        if (elements == null)
            throw new IllegalStateException("TopK already called!");
        
        // Sort ArrayList from largest to Smallest
        Collections.sort(elements, Collections.reverseOrder());

        // Make sure getTop is not called again
        //elements = null;
        return elements;
    }

    /**
     * Main method for Testing
     */
    public static void main(String [] args)
    {
        TopK<Integer> heap = new TopK<Integer>(3);

        heap.add(26);
        heap.add(94);
        heap.add(3);

        List<Integer> list = heap.getTop();
        for (int i = 0; i < list.size(); i++)
            System.out.print(list.get(i) + " ");
        System.out.println();
    }
}
