package Util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class JiraClient {
    private final String jiraUrl;
    private final String authHeader;

    public JiraClient(String jiraUrl, String username, String apiToken) {
        this.jiraUrl = jiraUrl;
        String auth = username + ":" + apiToken;
        this.authHeader = "Basic " + Base64.getEncoder().encodeToString(auth.getBytes());
    }

    public void createTestCase(String projectKey, String summary, String description) throws IOException {
        String url = jiraUrl + "/rest/api/2/issue";
        Map<String, Object> fields = new HashMap<>();
        fields.put("project", Map.of("key", projectKey));
        fields.put("summary", summary);
        fields.put("description", description);
        fields.put("issuetype", Map.of("name", "Test"));

        Map<String, Object> issue = new HashMap<>();
        issue.put("fields", fields);

        postRequest(url, issue);
    }

    public void createTestResult(String issueKey, String status) throws IOException {
        String url = jiraUrl + "/rest/api/2/issue/" + issueKey + "/transitions";
        Map<String, Object> transition = new HashMap<>();
        transition.put("id", getStatusId(status));

        Map<String, Object> body = new HashMap<>();
        body.put("transition", transition);

        postRequest(url, body);
    }

    private void postRequest(String url, Map<String, Object> body) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost(url);
        post.setHeader("Authorization", authHeader);
        post.setHeader("Content-Type", "application/json");

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(body);
        post.setEntity(new StringEntity(json));

        CloseableHttpResponse response = client.execute(post);
        response.close();
        client.close();
    }

    private String getStatusId(String status) {
        switch (status.toLowerCase()) {
            case "pass":
                return "31"; // Replace with actual status ID for "Pass"
            case "fail":
                return "21"; // Replace with actual status ID for "Fail"
            default:
                return "11"; // Replace with actual status ID for "To Do"
        }
    }
}