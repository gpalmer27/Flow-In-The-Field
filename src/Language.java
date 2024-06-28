/**
 * Represents a language that is associated with a session in the Flow in the Field app.
 */
public class Language {
  private final String language;
  private double averageScore;
  private final double averageRoundDuration;

  /**
   * Constructor for a Language object.
   * @param language representing the given language.
   * @param averageScore representing the given average score associated with the language.
   * @param averageRoundDuration representing the given average round duration associated with
   *                             the language.
   */
  public Language(String language, double averageScore, double averageRoundDuration) {
    this.averageScore = averageScore;
    this.averageRoundDuration = averageRoundDuration;
    this.language = language;
  }

  /**
   * Gets the average score of this Language.
   * @return the average score of this Language.
   */
  public double getAverageScore() {
    return this.averageScore;
  }

  /**
   * Sets the average score of this Language to the given value.
   * @param s representing the given average score.
   */
  public void setAverageScore(double s) {
    this.averageScore = s;
  }

  public String toString() {
    return "language: " + this.language + "averageScore: " + this.averageScore
            + "averageRoundDuration: " + this.averageRoundDuration;
  }
}
