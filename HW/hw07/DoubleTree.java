/****************************************
Filename: DoubleTree.java
Author: MIDN Ian Coffey (m261194)
To Implement anv AVL Tree of Doubles
****************************************/

// Import libraries
import java.util.NoSuchElementException;
import java.lang.Math.*;

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
        
        // Constructor method w/ arguements
        public Node(double d)
        {
            this.data = d;
            this.height = 0;
            this.left = null;
            this.right = null;
        }
    }

    // Private AVL Tree variables
    private Node root;
    private double max;
    
    // AVL constructor method 
    public DoubleTree() { root = null; }
    
    /**
     * Method to return the balance factor of a Node
     */
    public int balanceFact(Node curr) 
    {
        // Left child with no right child
        if (curr.left != null && curr.right == null)
            return curr.left.height + 1;

        // Right child with no left child
        if (curr.left == null && curr.right != null)
            return curr.right.height + 1;

        // Both children
        if (curr.left != null && curr.right != null)
            return Math.max(curr.left.height, curr.right.height) + 1;

        // No children (Leaf node)
        else
            return 0;
    }
    
    /**
     * Method to rebalance AVL Trees 
     */
    public Node rebalance(Node curr) 
    {
        // If AVL Tree is already balanced
        if (-1 <= balanceFact(curr) && balanceFact(curr) <= 1)
            return curr;

        // Right heavy AVL
        else if (balanceFact(curr) == -2) 
        {
            // Double rotation case
            if (balanceFact(curr.left) == 1) 
                curr.left = lRotate(curr.left);

            curr = rRotate(curr);
        }

        // Left heady AVL
        else if (balanceFact(curr) == 2) 
        {
            // Double rotation case
            if (balanceFact(curr.right) == -1)
                curr.right = rRotate(curr.right);

            curr = lRotate(curr);
        }
        
        // Update heights
        updateHeight(curr);

        return curr;
    }

    /**
     * Methods to add a double to the AVL Tree
     */
    @Override
    public void add(double x) { root = addRecursive(root, x); }

    public Node addRecursive(Node curr, double x) 
    {
        // Adding Node to AVL Tree
        if (curr == null) 
            return new Node(x);
        
        // If duplicate is found, make no changes
        if (x == curr.data)
            return curr;

        // Traverse down left side if x < curr
        else if (x < curr.data) 
            curr.left = addRecursive(curr.left, x);
        
        // Traverse down right side if x > curr
        else    
            curr.right = addRecursive(curr.right, x);
    
        // Update height of Node
        updateHeight(curr);

        // Rebalance Tree 
        curr = rebalance(curr);  
        return curr;
    }

    /**
     * Left rotation method
     */
    public Node lRotate(Node oldRoot) 
    {
        Node newRoot = oldRoot.right;
        Node middle = newRoot.left;
        newRoot.left = oldRoot;
        oldRoot.right = middle;
        return newRoot;
    }

    /**
     * Right rotation method
     */
    public Node rRotate(Node oldRoot) 
    {
        Node newRoot = oldRoot.left;
        Node middle = newRoot.right;
        newRoot.right = oldRoot;
        oldRoot.left = middle;
        return newRoot;
    }

    /**
     * Method to update heights throughout an AVL Tree
     */
    public void updateHeight(Node curr)
    {
        // Left child with no right child
        if (curr.left != null && curr.right == null)
            curr.height = curr.left.height + 1;
      
        // Right child with no left child
        else if (curr.left == null && curr.right != null)
            curr.height = curr.right.height + 1;
        
        // Both children
        else if (curr.left != null && curr.right != null)
            curr.height = Math.max(curr.left.height, curr.right.height) + 1;
        
        // No children (Leaf node)
        else
            curr.height = 0;
    }



    /**
     * Method to remove the max element from an AVL Tree
     */
    @Override 
    public double removeMax() throws NoSuchElementException 
    { 
        if (root == null)
            throw new NoSuchElementException("AVL Tree is empty!");

        root = removeRecurse(root);
        return max;
    }

    public Node removeRecurse(Node curr) throws NoSuchElementException 
    {
        if (curr.right == null) 
        {
            // Save max double
            max = curr.data;

            // Leaf Node hit
            if (curr.left == null) 
                curr = null;
            else // Left child exists
                curr = curr.left;

            return curr;
        }
        
        // Update height and rebalance before returning 
        curr = removeRecurse(curr.right);
        updateHeight(curr);
        return curr;
    }   

    /**
     * Main method for testing
     */
    public static void main(String [] args) 
    {
        DoubleTree tree = new DoubleTree();

        tree.add(1);
        tree.add(2); 
        tree.add(3); 
        tree.add(4); 
        tree.add(5); 
        tree.add(6);

        for (int i = 0; i < 5; i++)
            System.out.println(tree.removeMax());
    }
}
