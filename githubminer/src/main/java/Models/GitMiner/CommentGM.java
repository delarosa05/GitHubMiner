package Models.GitMiner;

public class CommentGM {
    private String id;
    private String body;
    private String created_at;
    private String updated_at;
    private UserGM author;


    public CommentGM(String id, String body, String created_at, String updated_at, UserGM author) {
        this.id = id;
        this.body = body;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.author = author;
    }
    public String getId() { return id; }
    public String getBody() { return body; }
    public String getCreated_at() { return created_at; }
    public String getUpdated_at() { return updated_at; }
    public UserGM getAuthor() { return author; }

    public void setId(String id) { this.id = id; }
    public void setBody(String body) { this.body = body; }
    public void setCreated_at(String created_at) { this.created_at = created_at; }
    public void setUpdated_at(String updated_at) { this.updated_at = updated_at; }
    public void setAuthor(UserGM author) { this.author = author; }
}
