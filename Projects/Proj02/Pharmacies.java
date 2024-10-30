/**********************************************************************
Filename: Pharamcies.java
Author: MIDN 2/C Ian Coffey (m261194)
Program to read in ARCOS data and report pills sold by each pharmacy.
Should be sorted in alphabetical order by pharmacy name.
The pharmacy name is equal to the BUYER_NAME field, or, if the
BUYER_ADDL_CO_INFO field is not "null", then the pharmacy 
should be BUYER_NAME and BUYER_ADDL_CO_INFO, separated by one space.
**********************************************************************/

// Import Libraries
import java.util.List;

public class Pharmacies 
{ 
    public static void main(String[] args) 
    {
        // Read Pill name file from command line or console
        String pillsFile=null;
        if (args.length >= 1) { pillsFile = args[0]; }
        if (pillsFile == null) 
            pillsFile = System.console().readLine("pills file: ");
        TsvReader pillsLines = new TsvReader(pillsFile);

        // To print the output, use a line like this.
        // Remember the output lines should be sorted alphabetically by
        // pharmacy name.
        
        Map<String, Integer> drugCount = new TreeMap<String, Integer>();
        for (Map<String,String> aLine : pillsLines) 
        {
            String pharmacyName = aLine.get("BUYER_NAME");
            int pillCount = (int) (Double.parseDouble(aLine.get("DOSAGE_UNIT")));
            
            if (drugCount.containsKey(pharmacyName))
                drugCount.put(pharmacyName, drugCount.get(pharmacyName) + pillCount);
            else
                drugCount.put(pharmacyName, pillCount);
            

        }
        
        List<String> list = drugCount.keys();

        for (int i = 0; i < list.size(); i++)
            System.out.println(list.remove(i));

        //System.out.format("%8d %s\n", pillCount, pharmacyName); 
 

    }
}
