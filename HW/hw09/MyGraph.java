/****************************************
Filename: MyGraph.java
Author: MIDN Ian Coffey (m261194)
ADT Graph Implementation
****************************************/

// Import Libraries
import java.util.*;

// MyGraph Class
public class MyGraph implements Graph 
{
    // Private Variables
    HashMap<String, ArrayList<String>> map = new HashMap<>();

    /**
     * Method to return a list of all vetices in this graph
     */
    @Override
    public List<String> vertices() 
    {
        List<String> rtn = new ArrayList<>();
        Iterator mapIter = map.entrySet().iterator();

        while (mapIter.hasNext()) 
        {
            Map.Entry vertice = (Map.Entry) mapIter.next();
            System.out.println(vertice);
        }

        System.exit(0);
        return null;
    }

    /**
     * Method to return a list of all adjacent edges of a given node
     * @throws NoSuchElementException if source does not exist.
     */
    @Override
    public List<String> neighbors(String source) throws NoSuchElementException
    {
        // Check for No Element Exception
        if (!map.containsKey(source))
            throw new NoSuchElementException();

        // Use Iterator to Traverse through adjacency list
        List<String> edges = map.get(source);
        Iterator edgeIter = edges.iterator();
        while (edgeIter.hasNext()) 
            System.out.println(edgeIter.next());

        return edges;
    }

    /** 
     * Method to returns true if an edge from source to dest exists.
     * @throws NoSuchElementException if source or dest nodes do not exist.
     */
    @Override
    public boolean getEdge(String source, String dest) throws NoSuchElementException 
    { 
        // Check if source node exists 
    }

    /**
     * Method to add a new vertex to the graph, if it doesn't already exist.
     * No error if a vertex with that name exists already.
     */
    @Override
    public void addVertex(String label) 
    {
        if (!map.containsKey(label))
            map.put(label, new ArrayList<>());
    }

    /** 
     * Method to add or removes an edge from the graph.
     * If weight is true, the edge should be added if it doesn't already exist.
     * If weight is false, the edge should be removed if it does exist.
     * @throws NoSuchElementException if source or dest vertex names don't exist.
     */
    @Override 
    public void putEdge(String source, String dest, boolean weight) throws NoSuchElementException {}

    // Main Method for Testing 
    public static void main(String[] args) 
    {
        // Check if graph file was given in args
        String graphFile;
        if (args.length > 0) 
            graphFile = args[0];
        else
            graphFile = Stdin.input("Enter graph file: ");

        // Read graph file
        //Graph G = DotReader.readFrom(graphFile);
        
        Graph test = new MyGraph();
        
        test.addVertex("A");

        List<String> verts = test.vertices();
    }
}
