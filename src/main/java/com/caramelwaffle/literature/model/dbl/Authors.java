
package com.caramelwaffle.literature.model.dbl;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "author"
})
public class Authors {

    @JsonProperty("author")
    private Object author = null;

    public String getAuthor() {
        return author.toString();
    }

    public void setAuthor(Object author) {
        this.author = author;
    }
}
