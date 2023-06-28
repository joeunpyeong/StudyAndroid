package com.example.clonecoding_discord.friend;

import android.widget.ImageView;

public class FriendDTO {
    private String userNickName,userTag,profile, status;
    private int profileImg,profileBanner;

    public FriendDTO(String userNickName, String userTag, String profile, String status, int profileImg, int profileBanner) {
        this.userNickName = userNickName;
        this.userTag = userTag;
        this.profile = profile;
        this.status = status;
        this.profileImg = profileImg;
        this.profileBanner = profileBanner;
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

    public int getProfileBanner() {
        return profileBanner;
    }

    public void setProfileBanner(int profileBanner) {
        this.profileBanner = profileBanner;
    }
}
