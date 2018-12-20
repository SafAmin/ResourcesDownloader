package com.orange.resourcesdownloader.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class User implements Parcelable {

    @SerializedName("profile_image")
    private ProfileImage profileImage;

    @SerializedName("name")
    private String name;

    @SerializedName("links")
    private Links links;

    @SerializedName("id")
    private String id;

    @SerializedName("username")
    private String username;

    public void setProfileImage(ProfileImage profileImage) {
        this.profileImage = profileImage;
    }

    public ProfileImage getProfileImage() {
        return profileImage;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
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

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.profileImage, flags);
        dest.writeString(this.name);
        dest.writeParcelable(this.links, flags);
        dest.writeString(this.id);
        dest.writeString(this.username);
    }

    public User() {
    }

    protected User(Parcel in) {
        this.profileImage = in.readParcelable(ProfileImage.class.getClassLoader());
        this.name = in.readString();
        this.links = in.readParcelable(Links.class.getClassLoader());
        this.id = in.readString();
        this.username = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}