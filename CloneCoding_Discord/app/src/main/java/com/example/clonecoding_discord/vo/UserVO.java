package com.example.clonecoding_discord.vo;

import java.sql.Date;

public class UserVO {
	private int user_code;
	private String user_id, user_pw, nick_name, user_tag, status, user_profile, profile_banner, profile_img, status_color, email, phone, nitro;
	private Date createTime;

	public UserVO(int user_code, String user_id, String user_pw, String nick_name, String user_tag, String status, String user_profile, String profile_banner, String profile_img, String status_color, String email, String phone, String nitro, Date createTime) {
		this.user_code = user_code;
		this.user_id = user_id;
		this.user_pw = user_pw;
		this.nick_name = nick_name;
		this.user_tag = user_tag;
		this.status = status;
		this.user_profile = user_profile;
		this.profile_banner = profile_banner;
		this.profile_img = profile_img;
		this.status_color = status_color;
		this.email = email;
		this.phone = phone;
		this.nitro = nitro;
		this.createTime = createTime;
	}

	public UserVO() {

	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public int getUser_code() {
		return user_code;
	}

	public void setUser_codeode(int user_code) {
		this.user_code = user_code;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_pw() {
		return user_pw;
	}

	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}

	public String getNick_name() {
		return nick_name;
	}

	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}

	public String getUser_tag() {
		return user_tag;
	}

	public void setUser_tag(String user_tag) {
		this.user_tag = user_tag;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUser_profile() {
		return user_profile;
	}

	public void setUser_profile(String user_profile) {
		this.user_profile = user_profile;
	}

	public String getProfile_banner() {
		return profile_banner;
	}

	public void setProfile_banner(String profile_banner) {
		this.profile_banner = profile_banner;
	}

	public String getProfile_img() {
		return profile_img;
	}

	public void setProfile_img(String profile_img) {
		this.profile_img = profile_img;
	}

	public String getStatus_color() {
		return status_color;
	}

	public void setStatus_color(String status_color) {
		this.status_color = status_color;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getNitro() {
		return nitro;
	}

	public void setNitro(String nitro) {
		this.nitro = nitro;
	}

	
}
