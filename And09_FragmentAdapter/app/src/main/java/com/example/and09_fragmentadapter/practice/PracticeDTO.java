package com.example.and09_fragmentadapter.practice;

public class PracticeDTO {
    private int imges,lank;
    private String name,singer;

    public PracticeDTO(int imges, int lank, String name, String singer) {
        this.imges = imges;
        this.lank = lank;
        this.name = name;
        this.singer = singer;
    }

    public int getImges() {
        return imges;
    }

    public void setImges(int imges) {
        this.imges = imges;
    }

    public int getLank() {
        return lank;
    }

    public void setLank(int lank) {
        this.lank = lank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }
}
