/****************************************
Filename: DoubleTree.java
Author: MIDN Ian Coffey (m261194)
To Implement anv AVL Tree of Doubles
****************************************/

// Import libraries
import java.util.NoSuchElementException;

public class DoubleTree implements AddMax 
{
    // Private inner Node Class
    private class Node 
    {
        // Node variables
        private double data;
        private Node left;
        private Node right;
        private Node parent;
        
        // Constructor method w/o arguments 
        public Node() 
        {
            left = null;
            right = null;
            parent = null;
        }

        // Constructor method w/ arguements
        public Node(double d, Node l, Node r, Node p) 
        {
            this.data = d;
            this.left = l;
            this.right = r;
            this.parent = p;
        }
    }

    // Private AVL Tree variables
    private Node root;
    
    // AVL constructor method 
    public DoubleTree() { root = new Node(); }

    /**
     * Method to add a double to the AVL Tree
     */
    @Override
    public void add(double x) {}

    /**
     * Method to remove the max element from an AVL Tree
     */
    @Override 
    public double removeMax() throws NoSuchElementException 
    {
        throw new NoSuchElementException();
    }

    /**
     * Main method for testing
     */
    public static void main(String [] args) 
    {
        // AVL declaration
        DoubleTree tree = new DoubleTree();

    }
}


