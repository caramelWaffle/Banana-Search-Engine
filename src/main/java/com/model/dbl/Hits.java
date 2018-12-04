
package com.model.dbl;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "@total",
    "@computed",
    "@sent",
    "@first",
    "hit"
})
public class Hits {

    @JsonProperty("@total")
    private String total;
    @JsonProperty("@computed")
    private String computed;
    @JsonProperty("@sent")
    private String sent;
    @JsonProperty("@first")
    private String first;
    @JsonProperty("hit")
    private List<Hit> hit = null;

    @JsonProperty("@total")
    public String getTotal() {
        return total;
    }

    @JsonProperty("@total")
    public void setTotal(String total) {
        this.total = total;
    }

    @JsonProperty("@computed")
    public String getComputed() {
        return computed;
    }

    @JsonProperty("@computed")
    public void setComputed(String computed) {
        this.computed = computed;
    }

    @JsonProperty("@sent")
    public String getSent() {
        return sent;
    }

    @JsonProperty("@sent")
    public void setSent(String sent) {
        this.sent = sent;
    }

    @JsonProperty("@first")
    public String getFirst() {
        return first;
    }

    @JsonProperty("@first")
    public void setFirst(String first) {
        this.first = first;
    }

    @JsonProperty("hit")
    public List<Hit> getHit() {
        return hit;
    }

    @JsonProperty("hit")
    public void setHit(List<Hit> hit) {
        this.hit = hit;
    }

}
