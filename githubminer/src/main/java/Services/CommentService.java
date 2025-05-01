package Services;

import Models.Comments.Comment;
import org.springframework.web.client.RestTemplate;

public class CommentService {
    public static RestTemplate restTemplate = new RestTemplate();
    public static String url ="http://api.github.com/";

    public static Comment[] getAllComments(String owner, String repo) {
        return restTemplate.getForObject(url+owner+"/"+repo+"/issues/comments", Comment[].class);
    }

    public static Comment getComment(String owner, String repo, int id) {
        return restTemplate.getForObject(url+owner+"/"+repo+"/issues/comments"+id, Comment.class);
    }
}
