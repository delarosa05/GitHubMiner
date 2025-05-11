package aiss.githubminer.Parsers;

import aiss.githubminer.Models.GitMiner.Comment;
import aiss.githubminer.Models.GitMiner.User;
import aiss.githubminer.Services.UserService;
import aiss.githubminer.Services.CommentService;
import java.util.ArrayList;
import java.util.List;

public class CommentParser {

    public static List<Comment> parseComment(String owner, String repo, int issueNumber) {
        List<Comment> comments = new ArrayList<>();
        aiss.githubminer.Models.Comments.Comment[] allComments = CommentService.getAllCommentsIssue(owner, repo, issueNumber);
        System.out.println("Numero de comentarios= " + allComments.length); //Aqui llega
        // Verificar si allComments es null o vacío
        if (allComments.length == 0) {
            return comments;
        }else {
            for (aiss.githubminer.Models.Comments.Comment comment : allComments) {
                String id = comment.getId().toString(); // Puedes usar comment.getNodeId() si prefieres
                String body = comment.getBody() != null ? comment.getBody() : "-";
                String created_at = comment.getCreatedAt();
                String updated_at = comment.getUpdatedAt();

                String userName = comment.getUser().getLogin();
                aiss.githubminer.Models.Users.User user = UserService.getUser(userName);
                User author = UserParser.parseUser(user);

                Comment res = new Comment(id, body, author, created_at, updated_at);
                comments.add(res);
            }
        }

        System.out.println(comments);
        return comments;
    }


}
