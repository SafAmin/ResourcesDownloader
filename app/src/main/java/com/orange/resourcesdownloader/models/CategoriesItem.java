package com.orange.resourcesdownloader.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class CategoriesItem implements Parcelable {

    @SerializedName("photo_count")
    private int photoCount;

    @SerializedName("links")
    private Links links;

    @SerializedName("id")
    private int id;

    @SerializedName("title")
    private String title;

    public void setPhotoCount(int photoCount) {
        this.photoCount = photoCount;
    }

    public int getPhotoCount() {
        return photoCount;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public Links getLinks() {
        return links;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.photoCount);
        dest.writeParcelable(this.links, flags);
        dest.writeInt(this.id);
        dest.writeString(this.title);
    }

    public CategoriesItem() {
    }

    protected CategoriesItem(Parcel in) {
        this.photoCount = in.readInt();
        this.links = in.readParcelable(Links.class.getClassLoader());
        this.id = in.readInt();
        this.title = in.readString();
    }

    public static final Creator<CategoriesItem> CREATOR = new Creator<CategoriesItem>() {
        @Override
        public CategoriesItem createFromParcel(Parcel source) {
            return new CategoriesItem(source);
        }

        @Override
        public CategoriesItem[] newArray(int size) {
            return new CategoriesItem[size];
        }
    };
}