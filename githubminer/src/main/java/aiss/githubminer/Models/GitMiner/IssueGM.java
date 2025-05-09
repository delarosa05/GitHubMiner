package aiss.githubminer.Models.GitMiner;


import java.util.List;

public class IssueGM {

    private String id;
    private String title;
    private String description;
    private String state;
    private String created_at;
    private String updated_at;
    private String closed_at;
    private List<String> labels;
    private Integer votes;
    private List<CommentGM> comments;
    private UserGM author;
    private UserGM assignee;

    public IssueGM(String id, String title, String description, String state, String created_at, String updated_at, String closed_at,
                   List<String> labels, Integer votes , List<CommentGM> comments, UserGM author, UserGM assignee) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.state = state;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.closed_at = closed_at;
        this.labels = labels;
        this.votes = votes;
        this.comments = comments;
        this.author = author;
        this.assignee = assignee;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getState() { return state; }
    public String getCreated_at() { return created_at; }
    public String getUpdated_at() { return updated_at; }
    public String getClosed_at() { return closed_at; }
    public List<String> getLabels() { return labels; }
    public Integer getVotes() { return votes; }
    public List<CommentGM> getComments() { return comments; }
    public UserGM getAuthor() { return author; }
    public UserGM getAssignee() { return assignee; }

    public void setId(String id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setDescription(String description) { this.description = description; }
    public void setState(String state) { this.state = state; }
     public void setCreated_at(String created_at) { this.created_at = created_at; }
    public void setUpdated_at(String updated_at) { this.updated_at = updated_at; }
    public void setClosed_at(String closed_at) { this.closed_at = closed_at; }
    public void setLabels(List<String> labels) { this.labels = labels; }
    public void setVotes(Integer votes) { this.votes = votes; }
    public void setComments(List<CommentGM> comments) { this.comments = comments; }
    public void setAuthor(UserGM author) { this.author = author; }
    public void setAssignee(UserGM assignee) { this.assignee = assignee; }
}
