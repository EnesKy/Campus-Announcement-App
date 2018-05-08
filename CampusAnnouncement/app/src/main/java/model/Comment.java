package model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Comment {
    @SerializedName("id")
    private int id;

    @SerializedName("announcementID")
    private int announcementID;

    @SerializedName("authorID")
    private int authorID;

    @SerializedName("content")
    private String content;

    @SerializedName("createdAt")
    private Date createdAt;

    @SerializedName("lastUpdateAt")
    private Date lastUpdateAt;
}
