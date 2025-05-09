package aiss.githubminer.Services;

import aiss.githubminer.Models.Commits.Commit;
import aiss.githubminer.Models.Users.User;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class UserService {

    public static RestTemplate restTemplate = new RestTemplate();
    public static String url = "https://api.github.com/";


    public static User getUser(String username) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + "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");
        HttpEntity<String> request = new HttpEntity<String>(null, headers);
        ResponseEntity<User> response = restTemplate.exchange(url + username, HttpMethod.GET, request, User.class);
        System.out.println(response.getBody());
        return response.getBody();
    }

    //ESTA OPERACION NO SE SI HAY QUE INCLUIRLA
    public User getAuthenticatedUser(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer" + token);
        HttpEntity<User> request = new HttpEntity<>(null, headers);
        ResponseEntity<User> response = restTemplate.exchange(url, HttpMethod.GET, request, User.class);
        return response.getBody();
    }

    public User[] getUsers() {
        return restTemplate.exchange(url + "users", HttpMethod.GET, null, User[].class).getBody();
    }
}
