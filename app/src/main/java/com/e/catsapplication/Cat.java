package com.e.catsapplication;

import org.json.JSONException;
import org.json.JSONObject;

public class Cat {

    private String name;
    private String description;
    private String imageID;
    private String temperament;
    private String country;
    private String country_code;
    private String wikiLink;
    private Boolean downloaded = false;

    Boolean getDownloaded() {
        return downloaded;
    }

    void setDownloaded() {
        this.downloaded = true;
    }

    Cat(JSONObject jsonObject){
        try {
            if(jsonObject.has("name")){
              name = jsonObject.get("name").toString();
            }else name = "";

            if(jsonObject.has("description")){
                description = jsonObject.get("description").toString();
            }else description = "";

            if(jsonObject.has("id")){
                imageID = jsonObject.get("id").toString();
            }else imageID = "";

            if(jsonObject.has("origin")){
                country = jsonObject.get("origin").toString();
            }else country = "";

            if(jsonObject.has("country_code")){
                country_code = jsonObject.get("country_code").toString();
            }else country_code = "";

            if(jsonObject.has("temperament")){
                temperament = jsonObject.get("temperament").toString();
            }else temperament = "";

            if(jsonObject.has("wikipedia_url")){
                wikiLink = jsonObject.get("wikipedia_url").toString();
            }else wikiLink = "";

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    String getImageID() {
        return imageID;
    }

    void setImageID(String imageID) {
        this.imageID = imageID;
    }

    String getTemperament() {
        return temperament;
    }

    String getCountry() {
        return country;
    }

    String getCountry_code() {
        return country_code;
    }

    String getWikiLink() {
        return wikiLink;
    }

    public String getName() {
        return name;
    }

    String getDescription() {
        return description;
    }

}
