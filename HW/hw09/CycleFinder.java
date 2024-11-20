/****************************************
Filename: CycleFinder.java
Author: MIDN Ian Coffey (m261194)
To Determine if a Node is in a Cycle
****************************************/

import java.util.*;

public class CycleFinder 
{
    public static boolean hasCycle(Graph graph, String start) 
    {
        Set<String> visited = new HashSet<>();
        Stack fringe = new Stack();

        fringe.push(start);
        
        while (!fringe.empty()) 
        {
            String uu = fringe.pop().toString();

            if (!visited.contains(uu)) 
            {
                visited.add(uu);
                for (String vv : graph.neighbors(uu)) 
                {
                    fringe.push(vv);

                    if (vv.equals(start))
                        return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) 
    {
        // XXX you shouldn't need to change anything here
        String dotf = Stdin.input("graph file: ");
        Graph graph = DotReader.readFrom(dotf);

        while (true) 
        {
            String start = Stdin.input("starting node or 'quit': ");
            if (start == null || start.equals("quit")) break;
            if (hasCycle(graph, start))
                System.out.format("%s is in a cycle.\n", start);
            else
                System.out.format("%s is NOT in a cycle.\n", start);
        }
    }
}
