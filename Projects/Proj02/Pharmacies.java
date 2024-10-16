/** Program to read in ARCOS data and report how many pills were
 * sold by each pharmacy.
 * The results should be sorted in alphabetical order by pharmacy name.
 * The pharmacy name is equal to the BUYER_NAME field, or, if the
 * BUYER_ADDL_CO_INFO field is not "null", then the pharmacy name
 * should be BUYER_NAME and BUYER_ADDL_CO_INFO, separated by one space.
 */
public class Pharmacies {
  public static void main(String[] args) {
    // read the name of the pills file from command line or the console
    String pillsFile=null;
    if (args.length >= 1) pillsFile = args[0];
    if (pillsFile == null)
      pillsFile = System.console().readLine("pills file: ");

    TsvReader pillsLines = new TsvReader(pillsFile);

    // TODO you write the rest!

    // To print the output, use a line like this.
    // Remember the output lines should be sorted alphabetically by
    // pharmacy name.
    // System.out.format("%8d %s\n", pillCount, pharmacyName);
  }
}
