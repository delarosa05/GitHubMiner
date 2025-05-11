
package aiss.githubminer.Models.Projects;

import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)

public class SecurityAndAnalysis {

    @JsonProperty("advanced_security")
    private AdvancedSecurity advancedSecurity;
    @JsonProperty("secret_scanning")
    private SecretScanning secretScanning;
    @JsonProperty("secret_scanning_push_protection")
    private SecretScanningPushProtection secretScanningPushProtection;
    @JsonProperty("secret_scanning_non_provider_patterns")
    private SecretScanningNonProviderPatterns secretScanningNonProviderPatterns;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("advanced_security")
    public AdvancedSecurity getAdvancedSecurity() {
        return advancedSecurity;
    }

    @JsonProperty("advanced_security")
    public void setAdvancedSecurity(AdvancedSecurity advancedSecurity) {
        this.advancedSecurity = advancedSecurity;
    }

    @JsonProperty("secret_scanning")
    public SecretScanning getSecretScanning() {
        return secretScanning;
    }

    @JsonProperty("secret_scanning")
    public void setSecretScanning(SecretScanning secretScanning) {
        this.secretScanning = secretScanning;
    }

    @JsonProperty("secret_scanning_push_protection")
    public SecretScanningPushProtection getSecretScanningPushProtection() {
        return secretScanningPushProtection;
    }

    @JsonProperty("secret_scanning_push_protection")
    public void setSecretScanningPushProtection(SecretScanningPushProtection secretScanningPushProtection) {
        this.secretScanningPushProtection = secretScanningPushProtection;
    }

    @JsonProperty("secret_scanning_non_provider_patterns")
    public SecretScanningNonProviderPatterns getSecretScanningNonProviderPatterns() {
        return secretScanningNonProviderPatterns;
    }

    @JsonProperty("secret_scanning_non_provider_patterns")
    public void setSecretScanningNonProviderPatterns(SecretScanningNonProviderPatterns secretScanningNonProviderPatterns) {
        this.secretScanningNonProviderPatterns = secretScanningNonProviderPatterns;
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
        StringBuilder sb = new StringBuilder();
        sb.append(SecurityAndAnalysis.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("advancedSecurity");
        sb.append('=');
        sb.append(((this.advancedSecurity == null)?"<null>":this.advancedSecurity));
        sb.append(',');
        sb.append("secretScanning");
        sb.append('=');
        sb.append(((this.secretScanning == null)?"<null>":this.secretScanning));
        sb.append(',');
        sb.append("secretScanningPushProtection");
        sb.append('=');
        sb.append(((this.secretScanningPushProtection == null)?"<null>":this.secretScanningPushProtection));
        sb.append(',');
        sb.append("secretScanningNonProviderPatterns");
        sb.append('=');
        sb.append(((this.secretScanningNonProviderPatterns == null)?"<null>":this.secretScanningNonProviderPatterns));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
