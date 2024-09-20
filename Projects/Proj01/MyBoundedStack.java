/***************************************************
Filename: MyBoundedStack.java
Author: MIDN Ian Coffey (m261194)
Implement Text File for Editor
***************************************************/

/**
 * Resources used:
 * Generic arrays are outright not supported in Jave. So I had to find a work around
 * to this since I need to have an unknown data type. So I found online that you can 
 * cast an array of type Object to what T is, which works
 */

// Import Exceptions
import java.util.NoSuchElementException;

/** 
 * Array Implementation of BoundedStack
 */
@SuppressWarnings("unchecked")
public class MyBoundedStack<T> implements BoundedStack<T>
{
    // Private variables
    private T[] array;
    private T[] amortizeTmp; // Extra array for amortization
    private int size;
    private int top;
    private int bottom;
    private int capacity;

    // Public constructor
    public MyBoundedStack(int capacity) 
    {
        this.capacity = capacity;
        size = 0;
        top = -1;
        bottom = 0;
        array = (T[]) new Object[capacity]; // Default Capacity of 4
    }

    @Override
    public void clear() 
    {
        array = (T[]) new Object[capacity];
        top = -1;
        bottom = 0;
        size = 0;
    }
    
    @Override
    public boolean isEmpty() { return size == 0; }

    @Override
    public T pop() throws NoSuchElementException
    {
        if (size == 0)
            throw new NoSuchElementException("Invalid index");
        
        // Grab element to return
        T rtn = array[top];
        array[top] = null;
        size--;

        if (size == 0) // Reset configuration if array is now empty
        {
            top = -1;
            bottom = 0;
        }
        else if (top == 0)
            top = size - 1;
        else
            top--;

        return rtn;
        
    }

    @Override
    public void push(T item) 
    {
        // Check if capacity has been hit
        if (size == capacity) 
        {
            // Move top
            if (top + 1 == size)
                top = 0;
            else
                top++;
            
            // Assign data
            array[top] = item;
            
            // Move bottom
            if (bottom + 1 == size)
                bottom = 0;
            else   
                bottom++;
            
        }

        // If capacity is not hit, just add to stack
        else if (top == size) 
        {
            top = 0;
            array[top] = item;
            size++;

        } else {

            array[top + 1] = item;
            top++;
            size++;
        }
        
    }

    @Override
    public void setCapacity(int newCapacity) 
    {
        if (capacity > newCapacity) 
        {
            if (top < bottom) 
            {

            } 
            else if (bottom > top) 
            {

            }
            else // if you try to set capacity on an empty array??
            


        }
        else if (capacity < newCapacity) 
        {

        }
        else
            return;
        
    }

    @Override
    public void print() 
    {
        if (top < bottom) 
        {
            System.out.print("[ ");
    
            for (int i = bottom; i < size; i++) 
                System.out.print(array[i] + " ");

            for (int j = 0; j <= top; j++) 
                System.out.print(array[j] + " ");
            
            System.out.println("]");

        } else {

            System.out.print("[ ");

            for (int k = 0; k < size; k++) 
                System.out.print(array[k] + " ");
            
            System.out.println("]");
        }
    }

    public static void main(String [] args) 
    {
        BoundedStack<Integer> array = new MyBoundedStack<Integer>(5);

        for (int i = 0; i < 9; i++)
            array.push(i);
        
        for (int i = 0; i < 5; i++) 
            array.pop();
        
        array.print();

        
        
    }
}