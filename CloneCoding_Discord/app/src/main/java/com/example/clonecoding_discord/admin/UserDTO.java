package com.example.clonecoding_discord.admin;

import com.example.clonecoding_discord.friend.FriendDTO;

import java.util.ArrayList;

public class UserDTO {
    private String email, password;
    private int statusImg,phone;
    private boolean nitro;
    private FriendDTO friendDTO;

    public UserDTO(String email, String password, int statusImg, int phone, boolean nitro, FriendDTO friendDTO) {
        this.email = email;
        this.password = password;
        this.statusImg = statusImg;
        this.phone = phone;
        this.nitro = nitro;
        this.friendDTO = friendDTO;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStatusImg() {
        return statusImg;
    }

    public void setStatusImg(int statusImg) {
        this.statusImg = statusImg;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public boolean isNitro() {
        return nitro;
    }

    public void setNitro(boolean nitro) {
        this.nitro = nitro;
    }

    public FriendDTO getFriendDTO() {
        return friendDTO;
    }

    public void setFriendDTO(FriendDTO friendDTO) {
        this.friendDTO = friendDTO;
    }
}
