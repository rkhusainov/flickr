package com.khusainov.rinat.flickr.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Objects;

public class Photos {
    @SerializedName("page")
    private Integer page;
    @SerializedName("pages")
    private Integer pages;
    @SerializedName("perpage")
    private Integer perpage;
    @SerializedName("total")
    private Integer total;
    @SerializedName("photo")
    private List<Photo> photo = null;

    public Photos(Integer page, Integer pages, Integer perpage, Integer total, List<Photo> photo) {
        this.page = page;
        this.pages = pages;
        this.perpage = perpage;
        this.total = total;
        this.photo = photo;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Integer getPerpage() {
        return perpage;
    }

    public void setPerpage(Integer perpage) {
        this.perpage = perpage;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<Photo> getPhoto() {
        return photo;
    }

    public void setPhoto(List<Photo> photo) {
        this.photo = photo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Photos photos = (Photos) o;
        return Objects.equals(page, photos.page) &&
                Objects.equals(pages, photos.pages) &&
                Objects.equals(perpage, photos.perpage) &&
                Objects.equals(total, photos.total) &&
                Objects.equals(photo, photos.photo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(page, pages, perpage, total, photo);
    }

    @Override
    public String toString() {
        return "Photos{" +
                "page=" + page +
                ", pages=" + pages +
                ", perpage=" + perpage +
                ", total=" + total +
                ", photo=" + photo +
                '}';
    }
}
