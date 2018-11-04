
package com.caramelwaffle.literature.model.dbl;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "authors",
    "title",
    "venue",
    "volume",
    "number",
    "pages",
    "year",
    "type",
    "key",
    "doi",
    "ee",
    "url"
})
public class Info {

    @JsonProperty("authors")
    private Authors authors;
    @JsonProperty("title")
    private String title;
    @JsonProperty("venue")
    private Object venue;
    @JsonProperty("volume")
    private String volume;
    @JsonProperty("number")
    private String number;
    @JsonProperty("pages")
    private String pages;
    @JsonProperty("year")
    private String year;
    @JsonProperty("type")
    private String type;
    @JsonProperty("key")
    private String key;
    @JsonProperty("doi")
    private String doi;
    @JsonProperty("ee")
    private String ee;
    @JsonProperty("url")
    private String url;

    @JsonProperty("authors")
    public Authors getAuthors() {
        return authors;
    }

    @JsonProperty("authors")
    public void setAuthors(Authors authors) {
        this.authors = authors;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("venue")
    public String getVenue() {
        if (venue!=null){
            return venue.toString();
        }
        return "";
    }

    @JsonProperty("venue")
    public void setVenue(Object venue) {
        this.venue = venue;
    }

    @JsonProperty("volume")
    public String getVolume() {
        return volume;
    }

    @JsonProperty("volume")
    public void setVolume(String volume) {
        this.volume = volume;
    }

    @JsonProperty("number")
    public String getNumber() {
        return number;
    }

    @JsonProperty("number")
    public void setNumber(String number) {
        this.number = number;
    }

    @JsonProperty("pages")
    public String getPages() {
        return pages;
    }

    @JsonProperty("pages")
    public void setPages(String pages) {
        this.pages = pages;
    }

    @JsonProperty("year")
    public String getYear() {
        return year;
    }

    @JsonProperty("year")
    public void setYear(String year) {
        this.year = year;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("key")
    public String getKey() {
        return key;
    }

    @JsonProperty("key")
    public void setKey(String key) {
        this.key = key;
    }

    @JsonProperty("doi")
    public String getDoi() {
        return doi;
    }

    @JsonProperty("doi")
    public void setDoi(String doi) {
        this.doi = doi;
    }

    @JsonProperty("ee")
    public String getEe() {
        return ee;
    }

    @JsonProperty("ee")
    public void setEe(String ee) {
        this.ee = ee;
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
