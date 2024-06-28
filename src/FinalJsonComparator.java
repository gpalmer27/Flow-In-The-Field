import java.util.Comparator;

/**
 * Comparator used to sort FinalJsons in alphabetical order by name.
 */
public class FinalJsonComparator implements Comparator<FinalJson> {
    @Override
    public int compare(FinalJson one, FinalJson two) {
      return one.getName().compareTo(two.getName());
    }
  }

