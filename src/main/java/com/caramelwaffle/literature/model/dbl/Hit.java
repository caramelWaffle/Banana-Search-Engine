
package com.caramelwaffle.literature.model.dbl;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "@score",
    "@id",
    "info",
    "url"
})
public class Hit {

    @JsonProperty("@score")
    private String score;
    @JsonProperty("@id")
    private String id;
    @JsonProperty("info")
    private Info info;
    @JsonProperty("url")
    private String url;


    @JsonProperty("@score")
    public String getScore() {
        return score;
    }

    @JsonProperty("@score")
    public void setScore(String score) {
        this.score = score;
    }

    @JsonProperty("@id")
    public String getId() {
        return id;
    }

    @JsonProperty("@id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("info")
    public Info getInfo() {
        return info;
    }

    @JsonProperty("info")
    public void setInfo(Info info) {
        this.info = info;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

}
