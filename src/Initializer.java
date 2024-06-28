import java.util.ArrayList;
import java.util.List;

/**
 * Used to set a static field that can be used across classes to access all the
 * sessions, rounds, and participants that were given in the json file.
 */
public class Initializer {
  static Initializer instance;
  protected List<Session> sessions;
  protected List<Round> rounds;
  protected List<Participant> participantInfo;

  /**
   * Constructor for this Initializer.
   * @param sessions representing the given list of sessions
   * @param rounds representing the given list of rounds
   * @param participantInfo representing the given list of participants
   */
  public Initializer(List<Session> sessions, List<Round> rounds,
                     List<Participant> participantInfo) {
    this.sessions = sessions;
    this.rounds = rounds;
    this.participantInfo = participantInfo;
  }

  /**
   * Sets the static field in this class.
   * @param sessions representing the given list of sessions
   * @param rounds representing the given list of rounds
   * @param participantInfo representing the given list of participants
   */
  public static void initialize(List<Session> sessions, List<Round> rounds,
                                List<Participant> participantInfo) {
    if (instance == null) {
      instance = new Initializer(sessions, rounds, participantInfo);
    } else {
      instance.sessions = sessions;
      instance.rounds = rounds;
      instance.participantInfo = participantInfo;
    }
  }

  /**
   * Converts all the participants in the static field to FinalJsons that will
   * be converted to JSONs.
   * @return a list of final objects that should be converted to JSONs
   */
  public List<FinalJson> iterate() {
    List<FinalJson> acc = new ArrayList<>();
    // adds FinalJson objects representing all the participants with their corresponding name,
    // languages, averageRoundScore, and averageSessionDuration
    for (Participant p : Initializer.instance.participantInfo) {
      acc.add(new FinalJson(p.getParticipantId(), p.getName(), p.languages(),
              p.averageRoundScore(), p.averageSessionDuration()));
    }
    // sorts the list based on participant first names
    acc.sort(new FinalJsonComparator());
    return acc;
  }
}
