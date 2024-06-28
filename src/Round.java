
/**
 * Represents a round in the Flow of the Field app.
 */
public class Round {
  private final int roundId;
  private final int sessionId;
  private final int score;
  private final int startTime;
  private final int endTime;


  /**
   * Constructor for this Round.
   * @param roundId representing the given roundId
   * @param sessionId representing the given sessionId
   * @param score representing the given score
   * @param startTime representing the given startTime
   * @param endTime representing the given endTime
   */
  public Round (int roundId, int sessionId, int score, int startTime, int endTime) {
    this.roundId = roundId;
    this.sessionId = sessionId;
    this.score = score;
    this.startTime = startTime;
    this.endTime = endTime;
  }

  /**
   * Gets the roundId of this Round.
   * @return the roundId of this Round.
   */
  public int getRoundId() {
    return this.roundId;
  }

  /**
   * Gets the score of this Round.
   * @return the score of this Round.
   */
  public int getScore() {
    return this.score;
  }

  /**
   * Gets the startTime of this Round.
   * @return the startTime of this Round.
   */
  public int getStartTime() {
    return this.startTime;
  }

  /**
   * Gets the endTime of this Round.
   * @return the endTime of this Round.
   */
  public int getEndTime() {
    return this.endTime;
  }
}
