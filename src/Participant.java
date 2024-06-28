import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Represents a participant in the Flow of the Field app.
 */
public class Participant {
  private final int participantId;
  private final String name;
  private final int age;
  private final List<Integer> sessions;

  /**
   * Constructor for this Participant.
   * @param participantId representing the given participantId
   * @param name representing the given name
   * @param age representing the given age
   * @param sessions representing the given list of sessions
   */
  public Participant (int participantId, String name, int age, List<Integer> sessions) {
    this.participantId = participantId;
    this.name = name;
    this.age = age;
    this.sessions = sessions;
  }

  /**
   * Calculates the average score of all the rounds that this Participant played.
   * @return the average score of all the rounds that this Participant played
   */
  public double averageRoundScore() {
    double totalRounds = 0;
    int totalScore = 0;
    for (Session s : Initializer.instance.sessions) {
      // only adds to the total score if the session is contained in the list of sessions
      // corresponding to this Participant.
      if (this.sessions.contains(s.getSessionId())) {
        totalScore += s.totalScore();
        totalRounds += s.getRounds().size();
      }
    }
    // to account for if this Participant didn't play any rounds
    if (totalRounds == 0) {
      return -1;
    }
    // so that the score is rounded to two decimal places
    return (double) Math.round((totalScore / totalRounds) * 100) / 100;
  }

  /**
   * Calculates the average session duration of all the sessions that this Participant played.
   * @return the average session duration of all the sessions that this Participant played.
   */
  public double averageSessionDuration() {
    double totalSessions = 0;
    int totalDuration = 0;
    for (Session s : Initializer.instance.sessions) {
      // only adds to the total score if the session is contained in the list of sessions
      // corresponding to this Participant.
      if (this.sessions.contains(s.getSessionId())) {
        int duration = s.getEndTime() - s.getStartTime();
        totalSessions += 1;
        totalDuration += duration;
      }
    }
    // to round to two decimal places
    return Math.round((totalDuration / totalSessions) * 100.0) / 100.0;
  }

  /**
   * Finds all the languages that this Participant used for their sessions.
   * @return a list of the languages that this Participant used for their sessions
   */
  public List<Language> languages() {
    Map<String, Integer> totalScore = new HashMap<>();
    Map<String, Integer> totalDuration = new HashMap<>();
    Map<String, Integer> numRounds = new HashMap<>();
    for (Session s : Initializer.instance.sessions) {
      // only considers the session if it's included in the list of sessions for this Participant
      if (this.sessions.contains(s.getSessionId())) {
        totalScore.put(s.getLanguage(), s.totalScore()
                + totalScore.getOrDefault(s.getLanguage(), 0));
        totalDuration.put(s.getLanguage(), s.totalRoundDuration()
                + totalDuration.getOrDefault(s.getLanguage(), 0));
        numRounds.put(s.getLanguage(), s.getRounds().size()
                + numRounds.getOrDefault(s.getLanguage(), 0));
      }
    }
    List<Language> lang = new ArrayList<>();
    // stores the number of rounds corresponding to each language
    Map<Language, Double> rounds = new HashMap<>();
    for (String s : totalScore.keySet()) {
      double totalS = totalScore.get(s);
      double totalTime = totalDuration.get(s);
      double totalRounds = numRounds.get(s);
      // averageScore field set to total score at first to make sorting easier
      Language l = new Language(s, totalS,
              (double) Math.round((totalTime / totalRounds) * 100) / 100);
      lang.add(l);
      rounds.put(l, totalRounds);
    }
    lang.sort(new LangComparator());
    for (Language l : lang) {
      double r = rounds.get(l);
      // finds the average of the score once the Languages are all sorted
      l.setAverageScore((double) Math.round((l.getAverageScore() / r) * 100) / 100);
    }
    return lang;
  }

  /**
   * Gets the name of this Participant.
   * @return the name of this Participant.
   */
  public String getName() {
    return this.name;
  }

  /**
   * Gets the participantId of this Participant.
   * @return the participantId of this Participant.
   */
  public int getParticipantId() {
    return this.participantId;
  }
}

