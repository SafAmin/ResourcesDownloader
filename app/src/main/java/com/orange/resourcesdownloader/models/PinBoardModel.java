package com.orange.resourcesdownloader.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class PinBoardModel implements Parcelable {

    @SerializedName("urls")
    private Urls urls;

    @SerializedName("current_user_collections")
    private List<Object> currentUserCollections;

    @SerializedName("color")
    private String color;

    @SerializedName("width")
    private int width;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("links")
    private Links links;

    @SerializedName("id")
    private String id;

    @SerializedName("categories")
    private List<CategoriesItem> categories;

    @SerializedName("liked_by_user")
    private boolean likedByUser;

    @SerializedName("user")
    private User user;

    @SerializedName("height")
    private int height;

    @SerializedName("likes")
    private int likes;

    public void setUrls(Urls urls) {
        this.urls = urls;
    }

    public Urls getUrls() {
        return urls;
    }

    public void setCurrentUserCollections(List<Object> currentUserCollections) {
        this.currentUserCollections = currentUserCollections;
    }

    public List<Object> getCurrentUserCollections() {
        return currentUserCollections;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public Links getLinks() {
        return links;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setCategories(List<CategoriesItem> categories) {
        this.categories = categories;
    }

    public List<CategoriesItem> getCategories() {
        return categories;
    }

    public void setLikedByUser(boolean likedByUser) {
        this.likedByUser = likedByUser;
    }

    public boolean isLikedByUser() {
        return likedByUser;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getLikes() {
        return likes;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.urls, flags);
        dest.writeList(this.currentUserCollections);
        dest.writeString(this.color);
        dest.writeInt(this.width);
        dest.writeString(this.createdAt);
        dest.writeParcelable(this.links, flags);
        dest.writeString(this.id);
        dest.writeTypedList(this.categories);
        dest.writeByte(this.likedByUser ? (byte) 1 : (byte) 0);
        dest.writeParcelable(this.user, flags);
        dest.writeInt(this.height);
        dest.writeInt(this.likes);
    }

    public PinBoardModel() {
    }

    protected PinBoardModel(Parcel in) {
        this.urls = in.readParcelable(Urls.class.getClassLoader());
        this.currentUserCollections = new ArrayList<Object>();
        in.readList(this.currentUserCollections, Object.class.getClassLoader());
        this.color = in.readString();
        this.width = in.readInt();
        this.createdAt = in.readString();
        this.links = in.readParcelable(Links.class.getClassLoader());
        this.id = in.readString();
        this.categories = in.createTypedArrayList(CategoriesItem.CREATOR);
        this.likedByUser = in.readByte() != 0;
        this.user = in.readParcelable(User.class.getClassLoader());
        this.height = in.readInt();
        this.likes = in.readInt();
    }

    public static final Creator<PinBoardModel> CREATOR = new Creator<PinBoardModel>() {
        @Override
        public PinBoardModel createFromParcel(Parcel source) {
            return new PinBoardModel(source);
        }

        @Override
        public PinBoardModel[] newArray(int size) {
            return new PinBoardModel[size];
        }
    };
}