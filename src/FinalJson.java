import java.util.List;

/**
 * Represents an object with all the required fields for the JSON object that will be
 * returned eventually.
 */
public class FinalJson {
  private final int id;
  private final String name;
  private final List<Language> languages;
  private final Object averageRoundScore;
  private final Object averageSessionDuration;

  /**
   * Constructor for this FinalJson.
   * @param id representing the given id
   * @param name representing the given name
   * @param languages representing the given list of languages
   * @param averageRoundScore representing the given averageRoundScore
   * @param averageSessionDuration representing the given averageSessionDuration
   */
  public FinalJson(int id, String name, List<Language> languages, double averageRoundScore,
                   double averageSessionDuration) {
    // sets the averageRoundScore and averageSessionDuration to "N/A" if
    // there were no rounds played
    if (Double.isNaN(averageRoundScore) || averageRoundScore == -1) {
      this.averageRoundScore = "N/A";
      this.averageSessionDuration = "N/A";
    } else {
      this.averageRoundScore = averageRoundScore;
      this.averageSessionDuration = averageSessionDuration;
    }
    this.id = id;
    this.name = name;
    this.languages = languages;
  }

  /**
   * Gets the name field in this FinalJson.
   * @return the name field in this FinalJson.
   */
  public String getName() {
    return this.name;
  }

  public String toString() {
    return "id: " + this.id + "name: " + this.name
            + "languages: " + this.languages + "averageRoundScore: " + this.averageRoundScore
            + "averageSessionDuration: " + this.averageSessionDuration;
  }
}
