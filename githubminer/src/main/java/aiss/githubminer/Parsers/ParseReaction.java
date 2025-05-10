package aiss.githubminer.Parsers;

import aiss.githubminer.Models.Reactions.Comment;
import aiss.githubminer.Services.IssueService;

import java.util.Objects;

public class ParseReaction {

    public static Integer parseReaction (String owner, String repo, Integer issueId){

        Comment[] reactions = IssueService.getIssueReactions(owner, repo, issueId);
        Integer contador = 0;
        if (reactions.length == 0){
            return 0;
        }else{
            for (Comment comment : reactions){

                if (comment.getContent()== "+1"){
                    contador++;
                } else if (comment.getContent()== "-1") {
                    contador--;
                }
            }
        }
        return contador;
    }
}
