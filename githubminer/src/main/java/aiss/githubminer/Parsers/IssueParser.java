package aiss.githubminer.Parsers;

import aiss.githubminer.Models.GitMiner.CommentGM;
import aiss.githubminer.Models.GitMiner.IssueGM;
import aiss.githubminer.Models.GitMiner.UserGM;
import aiss.githubminer.Models.Issues.Issue;
import aiss.githubminer.Models.Issues.Label;
import aiss.githubminer.Services.IssueService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class IssueParser {


    public static List<IssueGM> parseIssue(String owner, String repo, int sinceDays) {
        // Establecer el valor por defecto de 'sinceDays' en 20 si no se pasa un valor válido
        if (sinceDays <= 0) {
            sinceDays = 20;
        }

        List<IssueGM> issues = new ArrayList<>();
        Issue[] allIssues = IssueService.getIssues(owner, repo);
        // USADO PARA DEPURAR System.out.println("Numero de Issues:" + allIssues.length);

        // Verificar si allIssues es null o vacío
        if (allIssues == null || allIssues.length == 0) {
            System.out.println("No se encontraron issues.");
            return issues;
        }

        //  fecha actual menos 'sinceDays'
        LocalDate limitDate = LocalDate.now().minusDays(sinceDays);

        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE;
        String limitDateString = limitDate.format(formatter);

        for (Issue issue : allIssues) {
            String updated_at = issue.getUpdatedAt();  // Fecha de última actualización

            // Comparar si la fecha de actualización del issue es posterior a 'limitDateString'
            if (updated_at != null && updated_at.compareTo(limitDateString) >= 0) {
                String id = issue.getNodeId();
                String title = issue.getTitle();
                String description = (issue.getBody() != null) ? issue.getBody() : "";  // Verificación para el campo 'body'
                String state = issue.getState();
                String created_at = issue.getCreatedAt();
                String closed_at = issue.getClosedAt();

                // Verificación de que las etiquetas no sean nulas o vacías
                List<String> labels = (issue.getLabels() != null)
                        ? issue.getLabels().stream().map(Label::toString).collect(Collectors.toList())
                        : new ArrayList<>();

                // Usamos el número del issue para obtener sus comentarios
                int issueNumber = issue.getNumber();
                List<CommentGM> comments = CommentParser.parseComment(owner, repo, issueNumber);
                System.out.println(comments);

                Integer votes = 1;  // CAMBIAR PARA OBTENER VOTOS DE VERDAD

                UserGM author = (issue.getUser() != null) ? UserParser.parseUser(issue.getUser()) : null;
                UserGM assignee = (issue.getAssignee() != null) ? UserParser.parseAsignee(issue.getAssignee()) : null;

                IssueGM res = new IssueGM(
                        id, title, description, state, created_at, updated_at, closed_at, labels, votes, comments, author, assignee
                );
                issues.add(res);
            }
        }

        System.out.println(issues);
        return issues;
    }




}
