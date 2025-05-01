
package Models.Commits;

import java.net.URI;
import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "url",
    "author",
    "committer",
    "message",
    "comment_count",
    "tree",
    "verification"
})
public class Commit__1 {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("url")
    private URI url;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("author")
    private Object author;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("committer")
    private Object committer;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("message")
    private String message;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("comment_count")
    private Integer commentCount;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("tree")
    private Tree tree;
    /**
     * Verification
     * <p>
     * 
     * 
     */
    @JsonProperty("verification")
    private Verification verification;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("url")
    public URI getUrl() {
        return url;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("url")
    public void setUrl(URI url) {
        this.url = url;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("author")
    public Object getAuthor() {
        return author;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("author")
    public void setAuthor(Object author) {
        this.author = author;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("committer")
    public Object getCommitter() {
        return committer;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("committer")
    public void setCommitter(Object committer) {
        this.committer = committer;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("comment_count")
    public Integer getCommentCount() {
        return commentCount;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("comment_count")
    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("tree")
    public Tree getTree() {
        return tree;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("tree")
    public void setTree(Tree tree) {
        this.tree = tree;
    }

    /**
     * Verification
     * <p>
     * 
     * 
     */
    @JsonProperty("verification")
    public Verification getVerification() {
        return verification;
    }

    /**
     * Verification
     * <p>
     * 
     * 
     */
    @JsonProperty("verification")
    public void setVerification(Verification verification) {
        this.verification = verification;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
