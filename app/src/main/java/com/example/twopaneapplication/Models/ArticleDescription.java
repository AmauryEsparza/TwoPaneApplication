package com.example.twopaneapplication.Models;

/**
 * Created by Amaury Esparza on 04/01/2015.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArticleDescription {

    @SerializedName("articles")
    @Expose
    private List<Article> articles = new ArrayList<Article>();
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("syndication_url")
    @Expose
    private String syndicationUrl;
    @SerializedName("title")
    @Expose
    private String title;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The articles
     */
    public List<Article> getArticles() {
        return articles;
    }

    /**
     *
     * @param articles
     * The articles
     */
    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    /**
     *
     * @return
     * The description
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     * The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return
     * The syndicationUrl
     */
    public String getSyndicationUrl() {
        return syndicationUrl;
    }

    /**
     *
     * @param syndicationUrl
     * The syndication_url
     */
    public void setSyndicationUrl(String syndicationUrl) {
        this.syndicationUrl = syndicationUrl;
    }

    /**
     *
     * @return
     * The title
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     * The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
