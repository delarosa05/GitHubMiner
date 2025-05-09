package Parsers;

import Models.GitMiner.CommentGM;
import Models.GitMiner.IssueGM;
import Models.GitMiner.UserGM;
import Models.Issues.Issue;
import Models.Issues.Label;
import Services.IssueService;
import Parsers.CommentParser;
import org.apache.tomcat.util.codec.binary.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class IssueParser {

    public static List<IssueGM> parseIssue(String owner, String repo){
        List<IssueGM> issues = new ArrayList<IssueGM>();
        Issue[] allIssues = IssueService.getIssues(owner,repo);
        for (Issue issue : allIssues) {
            String id = issue.getNodeId();
            String title = issue.getTitle();
            String description = issue.getBody();
            String state = issue.getState();
            String created_at = issue.getCreatedAt();
            String updated_at = issue.getUpdatedAt();
            String closed_at = issue.getClosedAt();
            List<String> labels = issue.getLabels();
            List<CommentGM> comments = CommentParser.parse(owner,repo);
            Integer votes = 1;
            UserGM author = Parsers.UserParser.parseUser(issue.getUser());
            UserGM asignee = Parsers.UserParser.parseAsignee(issue.getAssignee());
            IssueGM res = new IssueGM(id, title, description, state, created_at, updated_at, closed_at, labels, votes, comments, author, asignee);
            issues.add(res);
        }
        return issues;
    }
}
