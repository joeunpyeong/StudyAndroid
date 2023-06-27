package com.example.clonecoding_discord.friend;

import android.widget.ImageView;

public class FriendDTO {
    private String userNickName,userTag,profile, status;
    private int profileImg;

    public FriendDTO(String userTag, String userNickName, String status, String profile, int profileImg) {
        this.userNickName = userNickName;
        this.userTag = userTag;
        this.profile = profile;
        this.status = status;
        this.profileImg = profileImg;
    }

    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    public String getUserTag() {
        return userTag;
    }

    public void setUserTag(String userTag) {
        this.userTag = userTag;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getProfileImg() {
        return profileImg;
    }

    public void setProfileImg(int profileImg) {
        this.profileImg = profileImg;
    }
}
