/** Program to identify which zip codes had the highest per-capity
 * number of opioid pills sold.
 * Input will be two filenames (for ARCOS data and zip code data)
 * and an integer k.
 * The k zipcodes with the highest pills/population ratios should be
 * printed out.
 */
public class Zips {
  public static void main(String[] args) {
    // Read pills and zip codes filenames, as well as k value,
    // either from command line arguments or from the console.

    String pillsFile, zipsFile, kstring;

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

    // TODO you write the rest!

    // Use code like this to print the output.
    // Remember that only the top k pills/population ratios should be printed.
    // If there are fewer than k zip codes in the data set, then print all of them.
    // The output lines should be sorted by the pills/population ratio, largest first.
    // System.out.format("%8.2f %s, %s %d\n", ratio, city, state, zipCode);
  }
}
