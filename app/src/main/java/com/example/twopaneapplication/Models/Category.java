package com.example.twopaneapplication.Models;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Amaury Esparza on 03/01/2015.
 */

public class Category {

    @SerializedName("category_id")
    @Expose
    private Integer categoryId;
    @SerializedName("display_category_name")
    @Expose
    private String displayCategoryName;
    @SerializedName("english_category_name")
    @Expose
    private String englishCategoryName;
    @SerializedName("url_category_name")
    @Expose
    private String urlCategoryName;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The categoryId
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     *
     * @param categoryId
     * The category_id
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    /**
     *
     * @return
     * The displayCategoryName
     */
    public String getDisplayCategoryName() {
        return displayCategoryName;
    }

    /**
     *
     * @param displayCategoryName
     * The display_category_name
     */
    public void setDisplayCategoryName(String displayCategoryName) {
        this.displayCategoryName = displayCategoryName;
    }

    /**
     *
     * @return
     * The englishCategoryName
     */
    public String getEnglishCategoryName() {
        return englishCategoryName;
    }

    /**
     *
     * @param englishCategoryName
     * The english_category_name
     */
    public void setEnglishCategoryName(String englishCategoryName) {
        this.englishCategoryName = englishCategoryName;
    }

    /**
     *
     * @return
     * The urlCategoryName
     */
    public String getUrlCategoryName() {
        return urlCategoryName;
    }

    /**
     *
     * @param urlCategoryName
     * The url_category_name
     */
    public void setUrlCategoryName(String urlCategoryName) {
        this.urlCategoryName = urlCategoryName;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
