package com.khusainov.rinat.flickr.data.model.detail;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class Owner {
    @SerializedName("nsid")
    private String nsid;

    @SerializedName("username")
    private String username;

    @SerializedName("realname")
    private String realname;

    @SerializedName("location")
    private String location;

    @SerializedName("iconserver")
    private String iconserver;

    @SerializedName("iconfarm")
    private Integer iconfarm;

    public String getNsid() {
        return nsid;
    }

    public void setNsid(String nsid) {
        this.nsid = nsid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getIconserver() {
        return iconserver;
    }

    public void setIconserver(String iconserver) {
        this.iconserver = iconserver;
    }

    public Integer getIconfarm() {
        return iconfarm;
    }

    public void setIconfarm(Integer iconfarm) {
        this.iconfarm = iconfarm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Owner owner = (Owner) o;
        return Objects.equals(nsid, owner.nsid) &&
                Objects.equals(username, owner.username) &&
                Objects.equals(realname, owner.realname) &&
                Objects.equals(location, owner.location) &&
                Objects.equals(iconserver, owner.iconserver) &&
                Objects.equals(iconfarm, owner.iconfarm);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nsid, username, realname, location, iconserver, iconfarm);
    }

    @Override
    public String toString() {
        return "Owner{" +
                "nsid='" + nsid + '\'' +
                ", username='" + username + '\'' +
                ", realname='" + realname + '\'' +
                ", location='" + location + '\'' +
                ", iconserver='" + iconserver + '\'' +
                ", iconfarm=" + iconfarm +
                '}';
    }
}
