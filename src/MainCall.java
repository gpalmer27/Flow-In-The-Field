import com.google.gson.Gson;
import java.io.FileReader;
import java.io.Reader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

/**
 * Class to execute the conversion to JSON and the POST call.
 */
public class MainCall {
  private static final String link = "https://challenge.sandboxnu.com/s/PMRGIYLUMERDU6ZCMVWWC2LMEI5CE4DBNRWWK4ROM5UUA3TPOJ2GQZLBON2GK4TOFZSWI5JCFQRGI5LFEI5DCNZRG44TSMJZHE4SYITDNBQWY3DFNZTWKIR2EJDGY33XEJ6SYITIMFZWQIR2EJIUQUSDHBXVAZBTGFUEW2SYIJGHURBUHURH2===";

  /**
   * Main method with the conversion to JSON and POST request.
   * @param args representing the given arguments.
   * @throws Exception if a file can't be found for the FileReader
   */
  public static void main(String[] args) throws Exception {
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(link))
            .header("accept", "application/JSON")
            .GET()
            .build();
    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

    Reader reader = new FileReader("src/example.json");
    Gson gson = new Gson();
    Initializer jsonRequest = gson.fromJson(reader, Initializer.class);
    Initializer.initialize(jsonRequest.sessions, jsonRequest.rounds, jsonRequest.participantInfo);
    Gson g = new Gson();
    List<FinalJson> values = jsonRequest.iterate();
    String j = g.toJson(values);
    System.out.println(values);

    HttpClient client1 = HttpClient.newHttpClient();
    HttpRequest request1 = HttpRequest.newBuilder()
            .uri(URI.create(link))
            .header("Content-Type", "application/JSON")
            .POST(HttpRequest.BodyPublishers.ofString(j))
            .build();
    HttpResponse<String> response1 = client1.send(request1, HttpResponse.BodyHandlers.ofString());
    System.out.println(response1.body());
  }
}
