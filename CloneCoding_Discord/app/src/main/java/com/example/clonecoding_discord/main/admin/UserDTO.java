package com.example.clonecoding_discord.main.admin;

public class UserDTO {
    private String email, password;
    private int statusImg,phone;
    private boolean nitro;

    public UserDTO(String email, String password, int statusImg, int phone, boolean nitro) {
        this.email = email;
        this.password = password;
        this.statusImg = statusImg;
        this.phone = phone;
        this.nitro = nitro;
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

}
