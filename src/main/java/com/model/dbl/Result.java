
package com.model.dbl;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "query",
    "status",
    "time",
    "completions",
    "hits"
})
public class Result {

    @JsonProperty("query")
    private String query;
    @JsonProperty("status")
    private Status status;
    @JsonProperty("time")
    private Time time;
    @JsonProperty("completions")
    private Completions completions;
    @JsonProperty("hits")
    private Hits hits;


    @JsonProperty("query")
    public String getQuery() {
        return query;
    }

    @JsonProperty("query")
    public void setQuery(String query) {
        this.query = query;
    }

    @JsonProperty("status")
    public Status getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(Status status) {
        this.status = status;
    }

    @JsonProperty("time")
    public Time getTime() {
        return time;
    }

    @JsonProperty("time")
    public void setTime(Time time) {
        this.time = time;
    }

    @JsonProperty("completions")
    public Completions getCompletions() {
        return completions;
    }

    @JsonProperty("completions")
    public void setCompletions(Completions completions) {
        this.completions = completions;
    }

    @JsonProperty("hits")
    public Hits getHits() {
        return hits;
    }

    @JsonProperty("hits")
    public void setHits(Hits hits) {
        this.hits = hits;
    }

}
