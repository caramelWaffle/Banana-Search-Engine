
package com.caramelwaffle.literature.model.dbl;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "@total",
    "@computed",
    "@sent",
    "c"
})
public class Completions {
//
//    @JsonProperty("@total")
//    private String total;
//    @JsonProperty("@computed")
//    private String computed;
//    @JsonProperty("@sent")
//    private String sent;
//    @JsonProperty("c")
//    private List<C> c = null;
//
//
//    @JsonProperty("@total")
//    public String getTotal() {
//        return total;
//    }
//
//    @JsonProperty("@total")
//    public void setTotal(String total) {
//        this.total = total;
//    }
//
//    @JsonProperty("@computed")
//    public String getComputed() {
//        return computed;
//    }
//
//    @JsonProperty("@computed")
//    public void setComputed(String computed) {
//        this.computed = computed;
//    }
//
//    @JsonProperty("@sent")
//    public String getSent() {
//        return sent;
//    }
//
//    @JsonProperty("@sent")
//    public void setSent(String sent) {
//        this.sent = sent;
//    }
//
//    @JsonProperty("c")
//    public List<C> getC() {
//        return c;
//    }
//
//    @JsonProperty("c")
//    public void setC(List<C> c) {
//        this.c = c;
//    }

}
