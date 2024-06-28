import java.util.ArrayList;
import java.util.List;

/**
 * Represents a session in the Flow of the Field app.
 */
public class Session {
  private final int participantId;
  private final int sessionId;
  private final String language;
  private final List<Integer> rounds;
  private final int startTime;
  private final int endTime;

  /**
   * Constructor for this Session.
   * @param participantId representing the given participantId
   * @param sessionId representing the given sessionId
   * @param language representing the given language
   * @param rounds representing the given number of rounds
   * @param startTime representing the given startTime
   * @param endTime representing the given endTime
   */
  public Session(int participantId, int sessionId, String language, List<Integer> rounds,
                 int startTime, int endTime) {
    this.participantId = participantId;
    this.sessionId = sessionId;
    this.language = language;
    this.rounds = rounds;
    this.startTime = startTime;
    this.endTime = endTime;
  }

  /**
   * Calculates the total score associated with this Session.
   * @return the total score associated with this Session.
   */
  public int totalScore() {
    int total = 0;
    for (Round r : Initializer.instance.rounds) {
      // only includes the total score of the rounds that are in the rounds associated
      // with this Session
      if (this.rounds.contains(r.getRoundId())) {
        total += r.getScore();
      }
    }
    return total;
  }

  /**
   * Calculates the total round duration associated with this Session.
   * @return the total round duration associated with this Session.
   */
  public int totalRoundDuration() {
    int total = 0;
    for (Round r : Initializer.instance.rounds) {
      // only includes the total duration of the rounds that are in the rounds associated
      // with this Session
      if (this.rounds.contains(r.getRoundId())) {
        int duration = r.getEndTime() - r.getStartTime();
        total += duration;
      }
    }
    return total;
  }

  /**
   * Calculates the start time of this Session.
   * @return the start time of this Session
   */
  public int getStartTime() {
    return this.startTime;
  }

  /**
   * Calculates the end time of this Session.
   * @return the end time of this Session
   */
  public int getEndTime() {
    return this.endTime;
  }

  /**
   * Finds the language associated with this Session.
   * @return the language associated with this Session.
   */
  public String getLanguage() {
    return this.language;
  }

  /**
   * Gets the sessionId of this Session.
   * @return the sessionId of this Session
   */
  public int getSessionId() {
    return this.sessionId;
  }

  /**
   * Gets the rounds corresponding to this Session. Constructs a new list to avoid
   * unwanted mutation to the original list of Rounds.
   * @return the list of rounds corresponding to this Session.
   */
  public List<Integer> getRounds() {
    return new ArrayList<>(this.rounds);
  }
}
