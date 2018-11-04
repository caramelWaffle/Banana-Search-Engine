
package com.caramelwaffle.literature.model.dbl;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "@unit",
    "text"
})
public class Time {

    @JsonProperty("@unit")
    private String unit;
    @JsonProperty("text")
    private String text;

    @JsonProperty("@unit")
    public String getUnit() {
        return unit;
    }

    @JsonProperty("@unit")
    public void setUnit(String unit) {
        this.unit = unit;
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
