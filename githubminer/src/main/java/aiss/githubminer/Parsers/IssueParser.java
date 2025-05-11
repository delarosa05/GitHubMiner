package aiss.githubminer.Parsers;

import aiss.githubminer.Models.GitMiner.Comment;
import aiss.githubminer.Models.GitMiner.Issue;
import aiss.githubminer.Models.GitMiner.User;
import aiss.githubminer.Models.Issues.Label;
import aiss.githubminer.Services.IssueService;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class IssueParser {


    public static List<Issue> parseIssue(String owner, String repo, int sinceDays, int maxPages) {

        List<Issue> issues = new ArrayList<>();
        try{
            aiss.githubminer.Models.Issues.Issue[] allIssues = IssueService.getIssues(owner, repo, maxPages);
            ZonedDateTime limite = ZonedDateTime.now(ZoneOffset.UTC).minusDays(sinceDays);  // Usamos UTC aquí

            // Verificar si allIssues es null o vacío
            if (allIssues == null || allIssues.length == 0) {
                System.out.println("No se encontraron issues.");
                return issues;
            }

            //  fecha actual menos 'sinceDays'
            LocalDate limitDate = LocalDate.now().minusDays(sinceDays);

            DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE;
            String limitDateString = limitDate.format(formatter);

            for (aiss.githubminer.Models.Issues.Issue issue : allIssues) {
                String updated_at = issue.getUpdatedAt();  // Fecha de última actualización

                ZonedDateTime updatedDate = ZonedDateTime.parse(updated_at, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
                updatedDate = updatedDate.withZoneSameInstant(ZoneOffset.UTC);  // Convertir commitDate a UTC

                System.out.println("Updated Date: " + updatedDate + " | Limit date: " + limite);

                // Filtrar commits antiguos
                if (updatedDate.isBefore(limite)) {
                    continue;  // Si el commit es anterior a la fecha límite, lo ignoramos
                }

                // Comparar si la fecha de actualización del issue es posterior a 'limitDateString'
                String id = issue.getNodeId();
                String title = issue.getTitle();
                String description = (issue.getBody() != null) ? issue.getBody() : "";  // Verificación para el campo 'body'
                String state = issue.getState();
                String created_at = issue.getCreatedAt();
                String closed_at = issue.getClosedAt();

                // Verificación de que las etiquetas no sean nulas o vacías
                List<String> labels = (issue.getLabels() != null)
                        ? issue.getLabels().stream().map(x -> x.getName()).collect(Collectors.toList())
                        : new ArrayList<>();

                // Usamos el número del issue para obtener sus comentarios
                int issueNumber = issue.getNumber();
                List<Comment> comments = CommentParser.parseComment(owner, repo, issueNumber);

                Integer votes = ParseReaction.parseReaction(owner,repo,issueNumber);  // CAMBIAR PARA OBTENER VOTOS DE VERDAD

                User author = (issue.getUser() != null) ? UserParser.parseUser(issue.getUser()) : null;
                User assignee = (issue.getAssignee() != null) ? UserParser.parseAsignee(issue.getAssignee()) : null;

                Issue res = new Issue(id, title, description, state, created_at, updated_at, closed_at, labels, author, assignee, votes, comments);
                issues.add(res);

            }

        }catch (Exception e){
            e.printStackTrace();
        }
        // USADO PARA DEPURARSystem.out.println("Numero de Issues:" + allIssues.length);
        return issues;

    }




}
