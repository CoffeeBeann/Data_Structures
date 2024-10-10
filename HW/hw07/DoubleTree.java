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
        private int height;
        private Node left;
        private Node right;
        private Node parent;
        
        // Constructor method w/o arguments 
        public Node() 
        {
            height = -1;
            left = null;
            right = null;
            parent = null;
        }

        // Constructor method w/ arguements
        public Node(double d, int h, Node l, Node r, Node p)
        {
            this.data = d;
            this.height = h;
            this.left = l;
            this.right = r;
            this.parent = p;
        }
    }

    // Private AVL Tree variables
    private Node root;
    
    // AVL constructor method 
    public DoubleTree() { root = null; }

    /**
     * Methods to add a double to the AVL Tree
     */
    @Override
    public void add(double x) { root = addRecursive(root, x); }

    public Node addRecursive(Node curr, double x) 
    {
        // Height variable for rebalance calculations
        int leftH, rightH;

        // Adding first Node to AVL Tree
        if (curr == null) 
            return new Node(x, 0, null, null, null);

        // Traverse down left side if x < curr
        else if (x < curr.data) 
        {
            if (curr.left == null) 
                curr.left =  new Node(x, curr.height++, null, null, curr);
            else
                return addRecursive(curr.left, x);
        }

        // Traverse down right side if x > curr
        else if (x > curr.data) 
        {
            if (curr.right == null) 
                curr.right = new Node(x, curr.height++, null, null, curr);
            else
                return addRecursive(curr.right, x);
        }
        
        // If duplicate is found, make no changes
        else 
            return this.root;

        // Check if tree is balanced and perform rotations as needed
        
        if (curr.left.height - curr.right.height)
        

    }

    /**
     * Method to remove the max element from an AVL Tree
     */
    @Override 
    public double removeMax() throws NoSuchElementException 
    { 
        if (root == null)
            throw new NoSuchElementException("AVL Tree is empty!");

        return removeRecurse(root); 
    }

    public double removeRecurse(Node curr) throws NoSuchElementException 
    {
        if (curr.right == null) 
        {
            // Save max double
            double max = curr.data;

            // Leaf Node hit
            if (curr.left == null) 
                curr = null;
            else // Left child exists
                curr = curr.left;
            
            return max;
        }

        return removeRecurse(curr.right);
    }
    
    /**
     * Main method for testing
     */
    public static void main(String [] args) 
    {
        // AVL declaration
        DoubleTree tree = new DoubleTree();
        tree.add(5);
        tree.add(10);
        tree.add(3);
        tree.add(7);
        tree.add(15);
        for (int i = 0; i < 5; i++)
            tree.removeMax();

        tree.removeMax();
    }
}


