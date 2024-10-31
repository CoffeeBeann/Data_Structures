/*************************************************
Filename: Zips.java
Author: MIDN 2/C Ian Coffey (m261194)
Program to identify which zip codes had the
highest per-capity number of opioid pills sold.
*************************************************/

// Import Libraries
import java.util.Iterator;

// Zips Class
public class Zips 
{
    public static void main(String[] args) 
    {
        // Variable Declaration
        String pillsFile, zipsFile, kstring;
        
        // Read arguments from args[] or console
        if (args.length >= 1)
            pillsFile = args[0];
        else
            pillsFile = System.console().readLine("pills file: ");

        if (args.length >= 2)
            zipsFile = args[1];
        else
            zipsFile = System.console().readLine("zips file: ");

        if (args.length >= 3)
            kstring = args[2];
        else
            kstring = System.console().readLine("k: ");
        
        int k = Integer.valueOf(kstring);

        // Create TSV Readers from parsed arguments
        TsvReader pillsLines = new TsvReader(pillsFile);
        TsvReader zipsLines = new TsvReader(zipsFile);

        // Create TreeMaps to Store information from TSV Files
        TreeMap<Integer,Integer> pillMap = new TreeMap<Integer,Integer>(); // Map<zipCode, pillCount>
        TreeMap<String,Integer> cityZip = new TreeMap<String,Integer>(); // Map<zipCode, 'city & state'>
        TreeMap<String,Integer> popMap = new TreeMap<String,Integer>(); // Map<'city & state', Population>
       
        // Traverse zipFile, read, & store information to pillMap
        for (Map<String,String> aLine : pillsLines)
        {
            // Parse zip code and pill count from pillFile TSV line
            int zipCode = Integer.parseInt(aLine.get("BUYER_ZIP"));
            int pillCount = (int) Double.parseDouble(aLine.get("DOSAGE_UNIT"));
            
            // Store Unique Info into TreeMap
            if (pillMap.containsKey(zipCode))
                pillMap.put(zipCode, pillMap.get(zipCode) + pillCount);
            else
                pillMap.put(zipCode, pillCount); 
        }

        // Traverse pillFile, read, & store information to popMap
        for (Map<String,String> aLine : zipsLine)
        {
            // Parse city, state, and population info from zipFile TSV Line
            String location = aLine.get("city") + ", " + aLine.get("state_id");
            int population = Integer.parseInt(aLine.get("population"));

            // Store 
        }
        

        //XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
        // Convert Key Map to Array for Traversal
        Iterator<Integer> list = pillMap.keys().iterator();
        
        while (list.hasNext())
        {
            // Get next Key
            int zip = list.next();
            int num = pillMap.get(zip);
            System.out.format("%8d %s\n", num, zip); 
        }
        //XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX


        // The output lines should be sorted by the pills/population ratio, largest first.
        // System.out.format("%8.2f %s, %s %d\n", ratio, city, state, zipCode);
    }
}
