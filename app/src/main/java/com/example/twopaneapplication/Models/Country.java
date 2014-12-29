package com.example.twopaneapplication.Models;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Amaury Esparza on 14/12/2014.
 */

public class Country {

    @SerializedName("country_code")
    @Expose
    private String countryCode;
    @SerializedName("culture_code")
    @Expose
    private String cultureCode;
    @SerializedName("display_culture_name")
    @Expose
    private String displayCultureName;
    @SerializedName("english_culture_name")
    @Expose
    private String englishCultureName;
    @SerializedName("language_code")
    @Expose
    private String languageCode;

    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The countryCode
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     *
     * @param countryCode
     * The country_code
     */
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    /**
     *
     * @return
     * The cultureCode
     */
    public String getCultureCode() {
        return cultureCode;
    }

    /**
     *
     * @param cultureCode
     * The culture_code
     */
    public void setCultureCode(String cultureCode) {
        this.cultureCode = cultureCode;
    }

    /**
     *
     * @return
     * The displayCultureName
     */
    public String getDisplayCultureName() {
        return displayCultureName;
    }

    /**
     *
     * @param displayCultureName
     * The display_culture_name
     */
    public void setDisplayCultureName(String displayCultureName) {
        this.displayCultureName = displayCultureName;
    }

    /**
     *
     * @return
     * The englishCultureName
     */
    public String getEnglishCultureName() {
        return englishCultureName;
    }

    /**
     *
     * @param englishCultureName
     * The english_culture_name
     */
    public void setEnglishCultureName(String englishCultureName) {
        this.englishCultureName = englishCultureName;
    }

    /**
     *
     * @return
     * The languageCode
     */
    public String getLanguageCode() {
        return languageCode;
    }

    /**
     *
     * @param languageCode
     * The language_code
     */
    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
