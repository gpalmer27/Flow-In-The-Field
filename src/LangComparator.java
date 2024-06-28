import java.util.Comparator;

/**
 * Comparator used to sort Languages in descending order based on their total scores.
 */
public class LangComparator implements Comparator<Language> {
  @Override
  public int compare(Language one, Language two) {
    // when this method is called, the average score represents the total score
    return Double.compare(two.getAverageScore(), one.getAverageScore());
  }
}
