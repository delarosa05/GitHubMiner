
package aiss.githubminer.Models.Commits;

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
    "sha",
    "url",
    "html_url"
})
public class Parent {

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
    @JsonProperty("url")
    private URI url;
    @JsonProperty("html_url")
    private URI htmlUrl;
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

    @JsonProperty("html_url")
    public URI getHtmlUrl() {
        return htmlUrl;
    }

    @JsonProperty("html_url")
    public void setHtmlUrl(URI htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }


    @Override
    public String toString() {
        return "Parent{" +
                "sha='" + sha + '\'' +
                ", url=" + url +
                ", htmlUrl=" + htmlUrl +
                ", additionalProperties=" + additionalProperties +
                '}';
    }

}
