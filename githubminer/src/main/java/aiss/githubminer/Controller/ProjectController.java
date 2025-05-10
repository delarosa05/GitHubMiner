package aiss.githubminer.Controller;

import aiss.githubminer.Models.GitMiner.CommitGM;
import aiss.githubminer.Models.GitMiner.IssueGM;
import aiss.githubminer.Models.GitMiner.ProjectGM;
import aiss.githubminer.Models.Projects.Project;
import aiss.githubminer.Parsers.CommitParser;
import aiss.githubminer.Parsers.IssueParser;
import aiss.githubminer.Services.ProjectService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/github")
public class ProjectController {

    // Endpoint GET para obtener un proyecto desde GitHub y convertirlo a formato GitMiner
    @Operation(summary = "Obtiene proyecto parseado",
            description = "Devuelve un Proyecto de GitHub en formato GitMiner",
            tags = {"projects", "get"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = ProjectGM.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(), mediaType = "application/json")} ),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema(), mediaType = "application/json")} )
    })
    @GetMapping("/{owner}/{repo}")
    @ResponseStatus(HttpStatus.OK)
    public ProjectGM getProject(@PathVariable String owner,
                                @PathVariable String repo,
                                @RequestParam(defaultValue = "2") int sinceCommits,
                                @RequestParam(defaultValue = "20") int sinceIssues,
                                @RequestParam(defaultValue = "2") int maxPages) {

        Project request = ProjectService.getProject(owner, repo);
        if (request == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Project not found");
        }

        // Parsear commits a formato GitMiner
        List<CommitGM> commitGMS;
        try {
            commitGMS = CommitParser.parseCommit(owner, repo, sinceCommits);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error parsing commits", e);
        }

        // Parsear issues a formato GitMiner
        List<IssueGM> issueGMS;
        try {
            issueGMS = IssueParser.parseIssue(owner, repo, sinceIssues);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error parsing issues", e);
        }

        return ProjectGM.of(request.getId(), request.getName(), request.getUrl(), commitGMS, issueGMS);
    }

    @Operation(summary = "Publica proyecto parseado",
            description = "Envía un Proyecto parseado a la API de GitMiner",
            tags = {"projects", "post"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", content = { @Content(schema = @Schema(implementation = ProjectGM.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "400", content = { @Content(schema = @Schema(), mediaType = "application/json") })
    })
    @PostMapping("/{owner}/{repo}")
    @ResponseStatus(HttpStatus.CREATED)
    public ProjectGM postProject(@PathVariable String owner,
                                 @PathVariable String repo,
                                 @RequestParam(defaultValue = "2") int sinceCommits,
                                 @RequestParam(defaultValue = "20") int sinceIssues,
                                 @RequestParam(defaultValue = "2") int maxPages) {

        try {
            System.out.println("Posting project");
            ProjectGM request = getProject(owner, repo, sinceCommits, sinceIssues, maxPages);
            return ProjectService.postProject(request);
        } catch (Exception e) {
            // Captura cualquier error y lanza una excepción con estado 400
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error posting project", e);
        }
    }
}

