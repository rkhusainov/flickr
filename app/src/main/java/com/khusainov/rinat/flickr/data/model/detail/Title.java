package com.khusainov.rinat.flickr.data.model.detail;

import com.google.gson.annotations.SerializedName;

public class Title {
    @SerializedName("_content")
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
