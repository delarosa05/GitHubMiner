
package Models.Commits;

import java.net.URI;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;


/**
 * Diff Entry
 * <p>
 * Diff Entry
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "sha",
    "filename",
    "status",
    "additions",
    "deletions",
    "changes",
    "blob_url",
    "raw_url",
    "contents_url",
    "patch",
    "previous_filename"
})
public class File {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("sha")
    private String sha;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("filename")
    private String filename;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("status")
    private File.Status status;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("additions")
    private Integer additions;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("deletions")
    private Integer deletions;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("changes")
    private Integer changes;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("blob_url")
    private URI blobUrl;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("raw_url")
    private URI rawUrl;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("contents_url")
    private URI contentsUrl;
    @JsonProperty("patch")
    private String patch;
    @JsonProperty("previous_filename")
    private String previousFilename;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("sha")
    public String getSha() {
        return sha;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("sha")
    public void setSha(String sha) {
        this.sha = sha;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("filename")
    public String getFilename() {
        return filename;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("filename")
    public void setFilename(String filename) {
        this.filename = filename;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("status")
    public File.Status getStatus() {
        return status;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("status")
    public void setStatus(File.Status status) {
        this.status = status;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("additions")
    public Integer getAdditions() {
        return additions;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("additions")
    public void setAdditions(Integer additions) {
        this.additions = additions;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("deletions")
    public Integer getDeletions() {
        return deletions;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("deletions")
    public void setDeletions(Integer deletions) {
        this.deletions = deletions;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("changes")
    public Integer getChanges() {
        return changes;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("changes")
    public void setChanges(Integer changes) {
        this.changes = changes;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("blob_url")
    public URI getBlobUrl() {
        return blobUrl;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("blob_url")
    public void setBlobUrl(URI blobUrl) {
        this.blobUrl = blobUrl;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("raw_url")
    public URI getRawUrl() {
        return rawUrl;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("raw_url")
    public void setRawUrl(URI rawUrl) {
        this.rawUrl = rawUrl;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("contents_url")
    public URI getContentsUrl() {
        return contentsUrl;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("contents_url")
    public void setContentsUrl(URI contentsUrl) {
        this.contentsUrl = contentsUrl;
    }

    @JsonProperty("patch")
    public String getPatch() {
        return patch;
    }

    @JsonProperty("patch")
    public void setPatch(String patch) {
        this.patch = patch;
    }

    @JsonProperty("previous_filename")
    public String getPreviousFilename() {
        return previousFilename;
    }

    @JsonProperty("previous_filename")
    public void setPreviousFilename(String previousFilename) {
        this.previousFilename = previousFilename;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public enum Status {

        ADDED("added"),
        REMOVED("removed"),
        MODIFIED("modified"),
        RENAMED("renamed"),
        COPIED("copied"),
        CHANGED("changed"),
        UNCHANGED("unchanged");
        private final String value;
        private final static Map<String, File.Status> CONSTANTS = new HashMap<String, File.Status>();

        static {
            for (File.Status c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        Status(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        @JsonValue
        public String value() {
            return this.value;
        }

        @JsonCreator
        public static File.Status fromValue(String value) {
            File.Status constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
