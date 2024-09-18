/***************************************************
Filename: MyText.java
Author: MIDN Ian Coffey (m261194)
Implement Text File for Editor
***************************************************/

// Import Exceptions
import java.util.NoSuchElementException;

/** 
 * Array Implementation of Text Editor
 */
public class MyTextArray implements Text 
{
    // Private Variales
    private char[] text;
    private int size;
    private int capacity;
    private int cursPos;
    
    // Public Constructor 
    public MyTextArray() 
    {
        // Initialize empty Text object
        capacity = 4;
        text = new char[capacity]; // Default Length of 4
        size = 0;
        cursPos = 0;
    }

    /** Function to return the element of a Text object given an Index *
     * 
     * @param index the index the user wants to retrieve
     * @return Char of Text at specified index
     */
    @Override
    public char get() throws NoSuchElementException 
    { 
        if (cursPos > size) 
            throw new NoSuchElementException("Invalid index!");
        
        return text[cursPos];
    }

    /** 
     * Method to insert a char into an Text element where the cursor is 
     */
    @Override
    public void insert(char c) 
    {
        // Double size of list if capacity is reached
        if (size == capacity) 
            this.text = doubleSize(text);

        // Insert new character
        text[cursPos] = c;
        cursPos++;
        size++;
    }

    /** Method to double the size an a given char[]
     * 
     * @param text char[] object to be doubled 
     * @return char[] of doubled size of given char[] text
     */
    private char[] doubleSize(char[] text)
    {
        int textCapacity = text.length;
        this.capacity = text.length * 2;
        char rtnText[] = new char[capacity];

        for (int i = 0; i < text.length; i++) 
            rtnText[i] = text[i];
        
        return rtnText;
    }

    /**
     * Method to delete the element of a Text object at cursor index
     */
    @Override
    public void delete() throws NoSuchElementException 
    {
        if (cursPos > size) 
            throw new NoSuchElementException("Invalid index!");
        
        text[cursPos] = ' ';
    }

    /**
     * Method to return whether the cursor can move left or not
     */
    @Override
    public boolean canMoveLeft() { return cursPos != 0; }

    /**
     * Method to move cursor to the left
     */
    @Override
    public void moveLeft() throws NoSuchElementException 
    {
        if (!canMoveLeft())
            throw new NoSuchElementException("Cannot move mouse left");
        
        cursPos--;
    }

    /**
     * Method to return whether the cursor can move right or not
     */
    @Override
    public boolean canMoveRight() { return cursPos < size + 2; }

    /**
     * Method to move cursor to the right
     */
    @Override
    public void moveRight() throws NoSuchElementException 
    {
        if (!canMoveRight())
            throw new NoSuchElementException("Cannot move mouse right");
        
        cursPos++;
    }

    /**
     * Method to print out the contents of a
     */
    @Override
    public void print() 
    {
        for (int i = 0; i < size; i++) 
        {
            System.out.print(text[i]);
        }

        System.out.println();

        for (int j = 0; j < cursPos; j++) 
        {
            System.out.print(" ");
        }

        System.out.println("^");
    }

    // Main Method to test functions
    public static void main(String [] args) 
    {
        // Create new Text object  
        Text text = new MyTextArray();

        // Insert new characters
        for (int i = 0; i < 10; i++) 
        {
            text.insert('a');
            text.moveRight();
        }
        

        text.print();

    }

}
