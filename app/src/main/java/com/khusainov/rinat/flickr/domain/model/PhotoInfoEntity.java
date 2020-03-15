package com.khusainov.rinat.flickr.domain.model;

import com.khusainov.rinat.flickr.data.model.detail.Description;
import com.khusainov.rinat.flickr.data.model.detail.Owner;
import com.khusainov.rinat.flickr.data.model.detail.Title;

import java.util.Objects;

public class PhotoInfoEntity {
    private String id;
    private String secret;
    private String server;
    private Integer farm;
    private String dateuploaded;
    private Integer isfavorite;
    private String originalsecret;
    private String originalformat;
    private Owner owner;
    private Title title;
    private Description description;

    public PhotoInfoEntity(String id,
                           String secret,
                           String server,
                           Integer farm,
                           String dateuploaded,
                           Integer isfavorite,
                           String originalsecret,
                           String originalformat,
                           Owner owner,
                           Title title,
                           Description description) {
        this.id = id;
        this.secret = secret;
        this.server = server;
        this.farm = farm;
        this.dateuploaded = dateuploaded;
        this.isfavorite = isfavorite;
        this.originalsecret = originalsecret;
        this.originalformat = originalformat;
        this.owner = owner;
        this.title = title;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public Integer getFarm() {
        return farm;
    }

    public void setFarm(Integer farm) {
        this.farm = farm;
    }

    public String getDateuploaded() {
        return dateuploaded;
    }

    public void setDateuploaded(String dateuploaded) {
        this.dateuploaded = dateuploaded;
    }

    public Integer getIsfavorite() {
        return isfavorite;
    }

    public void setIsfavorite(Integer isfavorite) {
        this.isfavorite = isfavorite;
    }

    public String getOriginalsecret() {
        return originalsecret;
    }

    public void setOriginalsecret(String originalsecret) {
        this.originalsecret = originalsecret;
    }

    public String getOriginalformat() {
        return originalformat;
    }

    public void setOriginalformat(String originalformat) {
        this.originalformat = originalformat;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhotoInfoEntity that = (PhotoInfoEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(secret, that.secret) &&
                Objects.equals(server, that.server) &&
                Objects.equals(farm, that.farm) &&
                Objects.equals(dateuploaded, that.dateuploaded) &&
                Objects.equals(isfavorite, that.isfavorite) &&
                Objects.equals(originalsecret, that.originalsecret) &&
                Objects.equals(originalformat, that.originalformat) &&
                Objects.equals(owner, that.owner) &&
                Objects.equals(title, that.title) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, secret, server, farm, dateuploaded, isfavorite, originalsecret, originalformat, owner, title, description);
    }

    @Override
    public String toString() {
        return "PhotoInfoEntity{" +
                "id='" + id + '\'' +
                ", secret='" + secret + '\'' +
                ", server='" + server + '\'' +
                ", farm=" + farm +
                ", dateuploaded='" + dateuploaded + '\'' +
                ", isfavorite=" + isfavorite +
                ", originalsecret='" + originalsecret + '\'' +
                ", originalformat='" + originalformat + '\'' +
                ", owner=" + owner +
                ", title=" + title +
                ", description=" + description +
                '}';
    }
}
