
package com.model.dbl;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "@sc",
    "@dc",
    "@oc",
    "@id",
    "text"
})
public class C {

    @JsonProperty("@sc")
    private String sc;
    @JsonProperty("@dc")
    private String dc;
    @JsonProperty("@oc")
    private String oc;
    @JsonProperty("@id")
    private String id;
    @JsonProperty("text")
    private String text;

    @JsonProperty("@sc")
    public String getSc() {
        return sc;
    }

    @JsonProperty("@sc")
    public void setSc(String sc) {
        this.sc = sc;
    }

    @JsonProperty("@dc")
    public String getDc() {
        return dc;
    }

    @JsonProperty("@dc")
    public void setDc(String dc) {
        this.dc = dc;
    }

    @JsonProperty("@oc")
    public String getOc() {
        return oc;
    }

    @JsonProperty("@oc")
    public void setOc(String oc) {
        this.oc = oc;
    }

    @JsonProperty("@id")
    public String getId() {
        return id;
    }

    @JsonProperty("@id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("text")
    public String getText() {
        return text;
    }

    @JsonProperty("text")
    public void setText(String text) {
        this.text = text;
    }


}
