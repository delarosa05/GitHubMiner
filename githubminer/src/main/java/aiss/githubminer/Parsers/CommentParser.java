package aiss.githubminer.Parsers;

import aiss.githubminer.Models.Comments.Comment;
import aiss.githubminer.Models.GitMiner.CommentGM;
import aiss.githubminer.Models.GitMiner.UserGM;
import aiss.githubminer.Models.Users.User;
import aiss.githubminer.Services.UserService;
import aiss.githubminer.Services.CommentService;
import java.util.ArrayList;
import java.util.List;

public class CommentParser {

    public static List<CommentGM> parseComment(String owner, String repo, int issueNumber) {
        List<CommentGM> comments = new ArrayList<>();
        Comment[] allComments = CommentService.getAllCommentsIssue(owner, repo, issueNumber);
        System.out.println("Numero de comentarios= " + allComments.length); //Aqui llega
        // Verificar si allComments es null o vacío
        if (allComments.length == 0) {
            return comments;
        }else {
            for (Comment comment : allComments) {
                String id = comment.getId().toString(); // Puedes usar comment.getNodeId() si prefieres
                String body = comment.getBody() != null ? comment.getBody() : "-";
                String created_at = comment.getCreatedAt();
                String updated_at = comment.getUpdatedAt();

                String userName = comment.getUser().getLogin();
                User user = UserService.getUser(userName);
                UserGM author = UserParser.parseUser(user);

                CommentGM res = new CommentGM(id, body, created_at, updated_at, author);
                comments.add(res);
            }
        }

        System.out.println(comments);
        return comments;
    }


}
