
package aiss.githubminer.Models.Commits;

import java.util.LinkedHashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Verification
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "verified",
    "reason",
    "payload",
    "signature",
    "verified_at"
})
public class Verification {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("verified")
    private Boolean verified;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("reason")
    private String reason;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("payload")
    private String payload;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("signature")
    private String signature;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("verified_at")
    private String verifiedAt;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("verified")
    public Boolean getVerified() {
        return verified;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("verified")
    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("reason")
    public String getReason() {
        return reason;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("reason")
    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("payload")
    public String getPayload() {
        return payload;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("payload")
    public void setPayload(String payload) {
        this.payload = payload;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("signature")
    public String getSignature() {
        return signature;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("signature")
    public void setSignature(String signature) {
        this.signature = signature;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("verified_at")
    public String getVerifiedAt() {
        return verifiedAt;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("verified_at")
    public void setVerifiedAt(String verifiedAt) {
        this.verifiedAt = verifiedAt;
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
