package Parsers;

import Models.Comments.Comment;
import Models.GitMiner.CommentGM;
import Models.GitMiner.IssueGM;
import Models.GitMiner.UserGM;
import Models.Users.User;
import Services.UserService;
import Services.CommentService;
import java.util.ArrayList;
import java.util.List;
import Parsers.UserParser;

public class CommentParser {

    public List<CommentGM> parse(String owner, String repo) {
        List<CommentGM> comments = new ArrayList<CommentGM>();
        Comment[] allComments = CommentService.getAllComments(owner, repo);
        for(Comment comment: allComments){
            String id = comment.getId().toString(); //.getId() o .nodeId() ????????
            String body = comment.getBody();
            String created_at = comment.getCreatedAt();
            String updated_at = comment.getUpdatedAt();
            String userName = comment.getUser().getLogin();
            User user = UserService.getUser(userName);
            UserGM userParsed = UserParser.parseUser(user);
            CommentGM res = new CommentGM(id, body, created_at, updated_at, userParsed);
            comments.add(res);
        }
        return comments;
    }
}
