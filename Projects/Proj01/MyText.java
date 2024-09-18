/***************************************************
Filename: MyText.java
Author: MIDN Ian Coffey (m261194)
Implement Text File for Editor
***************************************************/

/**
 * Resources used:
 * Since chars cannot handle 'null' values, I had to research the closest thing you can 
 * do to have a null pointer in a char, which is to set it to '\0'.
 * 
 * MGSP utilized to understand concept of LL for MyText.java
 */

// Import Exceptions
import java.util.NoSuchElementException;

/** 
 * Linked List Implementation of Text Editor
 */
public class MyText implements Text 
{
    /**
     * Inner private Node class
     * @param data Char data
     * @param next Node object pointing to next element
     * @param prev Node object pointing to the previous element
     */
    private class Node
    {
        // Private variable declaration
        private char data;
        private Node next;
        private Node prev;

        // Public Node constructor w/ arguments
        public Node(char data, Node next, Node prev) 
        {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }

        // Public Node constructor w/o arguments
        public Node() 
        {
            this.data = '\0';
            this.next = null;
            this.prev = null;
        }

    }

    // Private variable declarations
    private Node head; // Points to start of List
    private Node tail; // Points to end of List
    private Node cursor; // Cursor Node where cursor.next points to object
    private int cursIndex; // Represents Index that cursor is on
    private int size; // Represents size of text (ie 'hello' = 5)

    // Public constructor method with no arguments
    public MyText() 
    {
        // Create & connect Head & Tail Nodes (Cursor = Head)
        tail = new Node();
        head = new Node('\0', tail, null);
        cursor = new Node('\0', head, null);
        tail.prev = head;
        size = 0;
    }

    @Override
    public char get() throws NoSuchElementException 
    {
        if (cursor.next.data == '\0')
            throw new NoSuchElementException("Invalid index!");
        
        return cursor.next.data;
    }
    
    @Override
    public void insert(char c)
    {
        /** Insert with empty element
         * 
         * [ ]         or       [Hello ]
         *  ^                         ^
         * 
         * text.insert('x');
         */
        if (cursor.next.data == '\0')
        {
            cursor.next.data = c;
            size++;
            return;
        }

        /** Insert at a non empty element at start
         * 
         * [x]       or     [Hello]
         *  ^                   ^
         * 
         * text.insert('y');
         */ 
        if (cursor.next.data != '\0') 
        {
            cursor.next.prev = new Node(c, cursor.next, cursor.next.prev);
        }

        // Data has 2 Nodes around it
        Node newData = new Node(c, cursor.next, cursor.next.prev);
        cursor.next.prev.next = newData;
        cursor.next.prev = newData;
        cursor.next = newData; 
    }

    @Override
    public void delete() throws NoSuchElementException
    {
        throw new NoSuchElementException();
    }

    @Override
    public boolean canMoveLeft()
    {
        return false;
    }

    @Override
    public void moveLeft() throws NoSuchElementException
    {
        if (!canMoveLeft())
            throw new NoSuchElementException("Cannot move mouse left!");
        
        cursor.next = cursor.prev;
    }

    @Override
    public boolean canMoveRight()
    {
        return true;
    }

    @Override
    public void moveRight() throws NoSuchElementException
    {
        if (!canMoveRight())
            throw new NoSuchElementException("Cannot move mouse left!");
        
        cursor.next = cursor.next;
    }

    @Override
    public void print()
    {
        printHelper(head);
    }

    public void printHelper(Node head) 
    {
        // Check that node is not null
        if (head.data != '\0') 
        {
            System.out.print(head.data + " ");
        } 

        // Check if end of list has been reached
        if (head.next == null) 
            return;  
        
        // Traverse to next Node
        printHelper(head.next);

    }

    // Main Method for testing
    public static void main(String [] args) 
    {
        // Create MyText object for testing
        Text text = new MyText();

        text.insert('a');

        text.print();

    }
}
