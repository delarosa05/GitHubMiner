package Services;

import Models.Users.User;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class UserService {

    public static RestTemplate restTemplate = new RestTemplate();
    public static String url = "http://api.github.com/";


    public User getUser(String username) {
        return restTemplate.exchange(url + username, HttpMethod.GET, null, User.class).getBody();
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
