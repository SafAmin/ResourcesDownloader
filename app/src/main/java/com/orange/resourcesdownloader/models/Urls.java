package com.orange.resourcesdownloader.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Urls implements Parcelable {

    @SerializedName("small")
    private String small;

    @SerializedName("thumb")
    private String thumb;

    @SerializedName("raw")
    private String raw;

    @SerializedName("regular")
    private String regular;

    @SerializedName("full")
    private String full;

    public void setSmall(String small) {
        this.small = small;
    }

    public String getSmall() {
        return small;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getThumb() {
        return thumb;
    }

    public void setRaw(String raw) {
        this.raw = raw;
    }

    public String getRaw() {
        return raw;
    }

    public void setRegular(String regular) {
        this.regular = regular;
    }

    public String getRegular() {
        return regular;
    }

    public void setFull(String full) {
        this.full = full;
    }

    public String getFull() {
        return full;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.small);
        dest.writeString(this.thumb);
        dest.writeString(this.raw);
        dest.writeString(this.regular);
        dest.writeString(this.full);
    }

    public Urls() {
    }

    protected Urls(Parcel in) {
        this.small = in.readString();
        this.thumb = in.readString();
        this.raw = in.readString();
        this.regular = in.readString();
        this.full = in.readString();
    }

    public static final Creator<Urls> CREATOR = new Creator<Urls>() {
        @Override
        public Urls createFromParcel(Parcel source) {
            return new Urls(source);
        }

        @Override
        public Urls[] newArray(int size) {
            return new Urls[size];
        }
    };
}