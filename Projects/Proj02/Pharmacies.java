/**********************************************************************
Filename: Pharamcies.java
Author: MIDN 2/C Ian Coffey (m261194)
Program to read in ARCOS data and report pills sold by each pharmacy.
Should be sorted in alphabetical order by pharmacy name.
The pharmacy name is equal to the BUYER_NAME field, or, if the
BUYER_ADDL_CO_INFO field is not "null", then the pharmacy 
should be BUYER_NAME and BUYER_ADDL_CO_INFO, separated by one space.
**********************************************************************/

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
        // System.out.format("%8d %s\n", pillCount, pharmacyName);
    }
}
