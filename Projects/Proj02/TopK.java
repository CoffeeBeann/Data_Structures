import java.util.List;
import java.util.ArrayList;

/** Collects elements and allows one-time selection of the k largest ones.
 *
 * Best implemented with a heap!
 * The current implementation (using a sorted list) should be replaced
 * with something more efficient via heap operations.
 */
public class TopK<T extends Comparable<T>> {
  /** The k value that will be used to select the top k. */
  private int k;
  /** A list to hold the inserted elements. */
  private List<T> elements = new ArrayList<>();

  /** Create a new, empty instance.
   *
   * @param k How many items to return from a later call to getTop().
   */
  public TopK(int k) {
    this.k = k;
  }

  /** Adds a new element to the collection.
   * Note that this method should not be called after getTop() has been called.
   */
  public void add(T element) {
    if (elements == null)
      throw new IllegalStateException("Can't make any other calls after the first call to getTop().");
    // NOTE: You may want to change how this works with a heap!
    elements.add(element);
  }

  /** Retrieves the k largest elements that have been added, from largest to smallest.
   * Note that this method can only be called once.
   * If fewer than k items have been added, then all of them should be returned, sorted
   * from largest to smallest.
   */
  public List<T> getTop() {
    if (elements == null)
      throw new IllegalStateException("Can't make any other calls after the first call to getTop().");
    // TODO you must change everything below to use a heap instead!
    // The current method of repeatedly removing the max is too inefficient.
    List<T> largest = new ArrayList<>();
    while (!elements.isEmpty() && largest.size() < k) {
      int maxInd = 0;
      for (int i = 0; i < elements.size(); ++i) {
        if (elements.get(i).compareTo(elements.get(maxInd)) > 0)
          maxInd = i;
      }
      largest.add(elements.remove(maxInd));
    }
    elements = null; // can't call any other methods after calling getTop()
    return largest;
  }
}
